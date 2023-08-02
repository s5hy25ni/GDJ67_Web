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
	ID VARCHAR2(30) NOT NULL,
	TITLE VARCHAR2(100) NOT NULL,
	REGDATE DATE NOT NULL
);

CREATE TABLE FILEBOARD(
	F_SEQ NUMBER PRIMARY KEY,
	B_SEQ NUMBER NOT NULL,
	ID VARCHAR2(30) NOT NULL,
	ORIGIN_FNAME VARCHAR2(1000) NOT NULL,
	STORED_FNAME VARCHAR2(1000) NOT NULL,
	FILE_SIZE NUMBER NOT NULL,
	F_REGDATE DATE DEFAULT SYSDATE NOT NULL,
	F_DELFLAG CHAR(1) DEFAULT 'N' NOT NULL
);



-- 쿼리테스트
-- 글 입력
INSERT INTO ROOTBOARD(SEQ, ID, TITLE, CONTENT, REGDATE)
		VALUES((SELECT MAX(NVL(SEQ, 0))+1
				FROM ROOTBOARD), 'TEST', 'TEST TITLE', 
				'TEST CONTENT', SYSDATE);

-- 글 상세 조회
-- 댓글 입력
INSERT INTO REPLYBOARD(SEQ, "REF", TITLE, REGDATE)
	VALUES('R'||LPAD((SELECT NVL(MAX(SUBSTR(SEQ, 2)),0)+1 FROM REPLYBOARD), 2, '0'),
			1, 'REPLY TEST',SYSDATE);