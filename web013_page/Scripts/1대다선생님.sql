/*
 *	1:n의 관계에서 mybatis & 객체
 *	1) 쿼리에서 left join을 통해서 작업
 *	2) 쿼리결과와 객체가 담겨 있는 형태가 다르다
 *	3) 조회의 실행 selectList -> List
 *				selectOne -> Object
 *				selectMap -> Map
 *				selectCursor -> Map 
 */

/*	
 * 	하나의 ROOT글에 DEPTH가 1인 답글을 작성할 수 있다.
 * 	장점 : ROOT글이 사라지면 답글을 전혀 볼 수 없게 만들거나 삭제할 수 있음
 * 	단점 : 쿼리작성(1:N), 답글의 답글을 작성할 수 없음
 */

CREATE TABLE ROOTBOARD(
	SEQ NUMBER PRIMARY KEY,
	ID VARCHAR2(30) NOT NULL,
	TITLE VARCHAR2(100) NOT NULL,
	CONTENT VARCHAR2(1000) NOT NULL,
	REGDATE DATE NOT NULL
);

CREATE TABLE REPLYBOARD(
	SEQ CHAR(3) PRIMARY KEY,
	REF NUMBER,
	TITLE VARCHAR2(100) NOT NULL,
	REGDATE DATE NOT NULL
);

ALTER TABLE REPLYBOARD ADD CONSTRAINT REPLYBOARD_FK FOREIGN KEY(REF) REFERENCES ROOTBOARD(SEQ);

INSERT INTO ROOTBOARD(SEQ, ID, TITLE, CONTENT, REGDATE)
	VALUES((SELECT NVL(MAX(SEQ),0)+1 FROM ROOTBOARD r ), 'D01', 'ROOT글 작성', '부모의 콘텐츠 내용글', SYSDATE);
	
SELECT 'R'||LPAD(1, 3, '0') FROM DUAL;

SELECT SUBSTR('R001', 1) FROM DUAL;

SELECT NVL(MAX(SUBSTR('R001', 2)),0)+1 FROM DUAL;

INSERT INTO REPLYBOARD(SEQ, "REF", TITLE, REGDATE)
	VALUES('R'||LPAD((SELECT NVL(MAX(SUBSTR(SEQ, 2)),0)+1 FROM REPLYBOARD), 2, '0'),
			1, '답글 3이 작성합니다',SYSDATE)	;
			
		
SELECT r.SEQ, r.TITLE, r.CONTENT, r.REGDATE, 
		r2.SEQ, r2.TITLE, r2.REGDATE
	FROM ROOTBOARD r LEFT JOIN REPLYBOARD r2 
	ON r.SEQ = r2."REF" ;
	
/*
 * RootBoard(seq=1, id=D01, title=ROOT글 작성, content=부모의 콘텐츠 내용글, regdate=2023-07-27 10:20:47, 
 * 	reply=[	ReplyBoard(seq=R01, ref=0, title=답글 1이 작성합니다, regdate=2023-07-27 10:26:02), 
 * 			ReplyBoard(seq=R02, ref=0, title=답글 2이 작성합니다, regdate=2023-07-27 10:26:27), 
 * 			ReplyBoard(seq=R03, ref=0, title=답글 3이 작성합니다, regdate=2023-07-27 10:26:28)])
 */