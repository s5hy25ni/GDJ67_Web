

ALTER TABLE STADIUM ADD CONSTRAINT STADIUM_PK PRIMARY KEY(STADIUM_ID);
ALTER TABLE TEAM ADD CONSTRAINT TEAM_PK PRIMARY KEY(TEAM_ID);
ALTER TABLE PLAYER ADD CONSTRAINT PLAYER_PK PRIMARY KEY(PLAYER_ID);
ALTER TABLE SCHEDULE ADD CONSTRAINT SCHEDULE_PK PRIMARY KEY (STADIUM_ID, SCHE_DATE);
ALTER TABLE TEAM MODIFY ORIG_YYYY DEFAULT TO_CHAR(SYSDATE, 'YYYY');
ALTER TABLE SCHEDULE MODIFY GUBUN DEFAULT 'N';

SELECT 
	RANK() OVER(ORDER BY ((VICTORY*3)+(TIE)) DESC) RANK,
	TEAM_ID, 
	(VICTORY*3)+(TIE) AS SCORE,
	VICTORY, TIE, LOSE, GAIN, LOSS, DIFF
	FROM (SELECT
		HOMETEAM_ID AS TEAM_ID,
		COUNT(*) AS NUMBER_OF_GAMES,
		COUNT(CASE WHEN HOME_SCORE > AWAY_SCORE THEN 1 END) AS VICTORY,
		COUNT(CASE WHEN HOME_SCORE = AWAY_SCORE THEN 1 END) AS TIE,
		COUNT(CASE WHEN HOME_SCORE < AWAY_SCORE THEN 1 END) AS LOSE,
		SUM(HOME_SCORE) AS GAIN,
		SUM(AWAY_SCORE) AS LOSS,
		SUM(HOME_SCORE)-SUM(AWAY_SCORE) AS DIFF
		FROM SCHEDULE
		WHERE GUBUN='Y'
		GROUP BY HOMETEAM_ID);
	
CREATE VIEW GAME_RESULT AS(
	SELECT 
		RANK() OVER(ORDER BY ((VICTORY*3)+(TIE)) DESC) RANK,
		TEAM_ID, 
		(VICTORY*3)+(TIE) AS SCORE,
		VICTORY, TIE, LOSE, GAIN, LOSS, DIFF
		FROM (SELECT
			HOMETEAM_ID AS TEAM_ID,
			COUNT(*) AS NUMBER_OF_GAMES,
			COUNT(CASE WHEN HOME_SCORE > AWAY_SCORE THEN 1 END) AS VICTORY,
			COUNT(CASE WHEN HOME_SCORE = AWAY_SCORE THEN 1 END) AS TIE,
			COUNT(CASE WHEN HOME_SCORE < AWAY_SCORE THEN 1 END) AS LOSE,
			SUM(HOME_SCORE) AS GAIN,
			SUM(AWAY_SCORE) AS LOSS,
			SUM(HOME_SCORE)-SUM(AWAY_SCORE) AS DIFF
			FROM SCHEDULE
			WHERE GUBUN='Y'
			GROUP BY HOMETEAM_ID)
);

CREATE TABLE PLAYER_HISTORY(
	SEQ NUMBER CONSTRAINT PLAYER_HISTORY_PK PRIMARY KEY,
	TRADE_DATE DATE DEFAULT SYSDATE NOT NULL,
	PlAYER_ID CHAR(7) NOT NULL,
	OLD_TEAM CHAR(3),
	NEW_TEAM CHAR(3),
	ACTIVE CHAR(1) DEFAULT 'Y'
);

DROP TRIGGER PLAYER_HISTORY_TRI;
DROP SEQUENCE PLAYER_HISTORY_SEQ;
DROP TABLE PLAYER_HISTORY;

CREATE SEQUENCE PLAYER_HISTORY_SEQ START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER PLAYER_INSERT
	AFTER 
		INSERT ON PLAYER
	FOR EACH ROW
	BEGIN
		INSERT INTO PLAYER_HISTORY(SEQ, PLAYER_ID, NEW_TEAM)
			VALUES(PLAYER_HISTORY_SEQ.NEXTVAL, :NEW.PLAYER_ID, :NEW.TEAM_ID)	;
	END;

CREATE OR REPLACE TRIGGER PLAYER_UPDATE
	AFTER 
		UPDATE OF TEAM_ID ON PLAYER
	FOR EACH ROW
	BEGIN
		INSERT INTO PLAYER_HISTORY(SEQ, PLAYER_ID, OLD_TEAM, NEW_TEAM)
			VALUES(PLAYER_HISTORY_SEQ.NEXTVAL, :OLD.PLAYER_ID, :OLD.TEAM_ID, :NEW.TEAM_ID)	;
	END;

CREATE OR REPLACE TRIGGER PLAYER_DELETE
	AFTER 
		DELETE ON PLAYER
	FOR EACH ROW
	BEGIN
		INSERT INTO PLAYER_HISTORY(SEQ, PLAYER_ID, OLD_TEAM, ACTIVE)
			VALUES(PLAYER_HISTORY_SEQ.NEXTVAL, :OLD.PLAYER_ID, :OLD.TEAM_ID, 'N')	;
	END;

SELECT * FROM PLAYER WHERE PLAYER_ID='2023001';

-- CRUD01(관리자 경기장 CRUD)
SELECT *
	FROM STADIUM
	WHERE STADIUM_ID='E01';

-- AD001(경기장 조회) stadium_sel
--SELECT STADIUM_ID, STADIUM_NAME, HOMETEAM_ID,SEAT_COUNT,
--	ZIP_CODE1, ZIP_CODE2, ADDRESS, DDD, TEL, FAX
--	FROM STADIUM;

-- AD002(경기장 등록) stadium_in
INSERT INTO STADIUM(STADIUM_ID, STADIUM_NAME, SEAT_COUNT, ADDRESS)
	VALUES('E01', '한화이글스파크', 15000, '대전광역시 동구');

-- AD003(경기장 TEAM 수정) stadium_team_up
UPDATE STADIUM SET HOMETEAM_ID='K99'
	WHERE STADIUM_ID='E01';

-- AD004(경기장 수정) stadium_up
UPDATE STADIUM SET ZIP_CODE1='', ZIP_CODE2='', DDD='', TEL='101-1121', FAX='314-1516'
	WHERE STADIUM_ID='E01';

-- AD005(경기장 삭제) stadium_del
DELETE FROM STADIUM
	WHERE STADIUM_ID='E01';

-- CRUD02(관리자 팀 CRUD)
SELECT *
	FROM TEAM t ;

-- AD006(팀 조회) team_sel
--SELECT TEAM_ID, REGION_NAME, TEAM_NAME, ORIG_YYYY, STADIUM_ID, HOMEPAGE
--	FROM TEAM;

-- AD007(팀 등록) team_in
INSERT INTO TEAM(TEAM_ID, REGION_NAME, TEAM_NAME, ORIG_YYYY, STADIUM_ID)
	VALUES('K99', '대전', '한화이글스', '', 'E01');
INSERT INTO TEAM(TEAM_ID, REGION_NAME, TEAM_NAME, STADIUM_ID)
	VALUES('K88', '서울', '두산베어스', 'E03');

-- AD008(팀 STADIUM 수정) team_stadium_up
UPDATE TEAM SET STADIUM_ID='E02'
	WHERE TEAM_ID='K99';

-- AD009(팀 수정) team_up
UPDATE TEAM SET HOMEPAGE='https://www.hanwhaeagles.co.kr'
	WHERE TEAM_ID='K99';

-- AD010(팀 삭제) team_del
DELETE FROM TEAM
	WHERE TEAM_ID='K88';

-- CRUD03(관리자 선수 CRUD)
-- AD011(선수 조회) player_sel
--SELECT PLAYER_ID, PLAYER_NAME, E_PLAYER_NAME, TEAM_ID, "POSITION", BACK_NO, NATION, BIRTH_DATE, HEIGHT, WEIGHT
--	FROM PLAYER;

-- AD012(선수 등록) player_in
INSERT INTO PLAYER(PLAYER_ID, PLAYER_NAME, TEAM_ID, "POSITION", BACK_NO)
	VALUES('2023001', '문동주', 'K99', 'DF', 1);

-- AD013(선수 TEAM 수정) player_team_up
UPDATE PLAYER SET TEAM_ID='K98'
	WHERE PLAYER_ID='2023001';

-- AD014(선수 수정) player_up
UPDATE PLAYER SET E_PLAYER_NAME='', BACK_NO='', NATION='', BIRTH_DATE='', HEIGHT='', WEIGHT=''
	WHERE PLAYER_ID='2023001';

-- AD015(선수 삭제) player_del
DELETE FROM PLAYER 
	WHERE PLAYER_ID='2023001';
	
-- AD016(선수 히스토리 조회) player_his_sel
--SELECT SEQ, TRADE_DATE, PLAYER_ID, OLD_TEAM, NEW_TEAM, ACTIVE
--	FROM PLAYER_HISTORY;

-- CRUD04(관리자 경기 CRUD) 
SELECT *
	FROM SCHEDULE s ;

-- AD017(경기 조회) sche_sel
--SELECT STADIUM_ID, SCHE_DATE, GUBUN, HOMETEAM_ID, AWAYTEAM_ID, HOME_SCORE, AWAY_SCORE
--	FROM SCHEDULE;

-- AD018(경기 등록) sche_in
INSERT INTO SCHEDULE(STADIUM_ID, SCHE_DATE, HOMETEAM_ID, AWAYTEAM_ID)
	VALUES('E01', '20121231', 'K01', 'A05');

-- AD019(경기 수정) sche_up
UPDATE SCHEDULE SET GUBUN='Y', HOME_SCORE=3, AWAY_SCORE=1
	WHERE STADIUM_ID='E01'
		AND SCHE_DATE='20121231';

-- CRUD05(사용자 선수 조회)
-- US001(전체 요약 조회_팀명, 등번호, 선수이름, 영어이름) user_p_summary
--SELECT TEAM_NAME, BACK_NO, PLAYER_NAME, E_PLAYER_NAME
--	FROM PLAYER JOIN TEAM
--	USING(TEAM_ID);

-- US002(팀별 요약 조회_팀명, 등번호, 선수이름, 영어이름) user_p_summary_t
--SELECT TEAM_NAME, BACK_NO, PLAYER_NAME, E_PLAYER_NAME
--	FROM PLAYER JOIN TEAM
--	USING(TEAM_ID)
--	WHERE TEAM_ID='K99'
--	ORDER BY TEAM_ID, BACK_NO;

-- US003(포지션별 요약 조회_팀명, 등번호, 선수이름, 영어이름) user_p_summary_p
--SELECT TEAM_NAME, BACK_NO, PLAYER_NAME, E_PLAYER_NAME
--	FROM PLAYER JOIN TEAM
--	USING(TEAM_ID)
--	WHERE "POSITION"='DF'
--	ORDER BY TEAM_ID, BACK_NO, PLAYER_NAME;

-- US004(이름 또는 백넘버 검색 요약 조회_팀명, 등번호, 선수이름, 영어이름) user_p_summary_s
--SELECT TEAM_NAME, BACK_NO, PLAYER_NAME, E_PLAYER_NAME
--	FROM PLAYER JOIN TEAM
--	USING(TEAM_ID)
--	WHERE PLAYER_NAME LIKE '%동주%'
--		OR BACK_NO LIKE '%동주%'
--	ORDER BY TEAM_ID, BACK_NO, PLAYER_NAME;

-- US005(상세 조회_팀명, 등번호, 선수이름, 영어이름, 포지션, 생년월일, 키, 몸무게, 국적) user_p_detail
--SELECT TEAM_NAME, BACK_NO, PLAYER_NAME, E_PLAYER_NAME, "POSITION", BIRTH_DATE, WEIGHT, HEIGHT, NATION
--	FROM PLAYER JOIN TEAM
--	USING(TEAM_ID)
--	WHERE PLAYER_ID='2023001';

-- CRUD06(사용자 팀 조회)
-- US006(연고지역, 팀이름, 출범연도, 홈페이지, 경기장이름, 좌석수, 주소, 지역번호, 전화번호, 팩스) user_t_detail
--SELECT REGION_NAME, TEAM_NAME, ORIG_YYYY, HOMEPAGE, STADIUM_NAME, SEAT_COUNT, ADDRESS, DDD, TEL, FAX
--	FROM TEAM FULL OUTER JOIN STADIUM
--	ON TEAM.TEAM_ID = STADIUM.HOMETEAM_ID
--	WHERE TEAM_NAME LIKE '%한화%'
--		OR STADIUM_NAME LIKE '%포항%';

-- CRUD07(사용자 경기 조회) 
-- US007(일자별 경기 일정 조회_경기일자, 경기장이름, 홈팀이름, 홈팀점수, 원정팀이름, 원정팀점수) user_s_detail_d
--SELECT SCHE_DATE, STADIUM_NAME, t1.TEAM_NAME AS HOMETEAM_NAME, HOME_SCORE, 
--	t2.TEAM_NAME AS AWAYTEAM_NAME, AWAY_SCORE
--	FROM SCHEDULE sc JOIN STADIUM st
--		USING(STADIUM_ID) JOIN TEAM t1
--		ON sc.HOMETEAM_ID = t1.TEAM_ID JOIN TEAM t2
--		ON sc.AWAYTEAM_ID = t2.TEAM_ID 
--	WHERE SCHE_DATE='20120904';
	
-- US007(팀별 경기 일정 조회_경기일자, 경기장이름, 홈팀이름, 홈팀점수, 원정팀이름, 원정팀점수) user_s_detail_t
--SELECT SCHE_DATE, STADIUM_NAME, t1.TEAM_NAME AS HOMETEAM_NAME, HOME_SCORE, 
--	t2.TEAM_NAME AS AWAYTEAM_NAME, AWAY_SCORE
--	FROM SCHEDULE sc JOIN STADIUM st
--		USING(STADIUM_ID) JOIN TEAM t1
--		ON sc.HOMETEAM_ID = t1.TEAM_ID JOIN TEAM t2
--		ON sc.AWAYTEAM_ID = t2.TEAM_ID 
--	WHERE t1.TEAM_NAME LIKE '%울산%'
--		OR t2.TEAM_NAME LIKE '%울산%';	

-- CRUD08(사용자 순위 조회)
-- US009 순위 조회(순위, 팀, 경기수, 승점, 승, 무, 패, 득점, 실점, 득실차) user_rank
SELECT "RANK", TEAM_NAME, SCORE, VICTORY, TIE, LOSE, GAIN, LOSS, DIFF
	FROM GAME_RESULT JOIN TEAM
	USING(TEAM_ID);