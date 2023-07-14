CREATE TABLE SEOULBIKE(
	NEW_ADDR VARCHAR2(100),
	CONTENT_ID NUMBER,
	ADDR_GU VARCHAR2(100),
	LONGITUDE NUMBER,
	CRADLE_COUNT NUMBER,
	LATITUDE NUMBER,
	CONTENT_NM VARCHAR2(100)
);

COMMENT ON COLUMN SEOULBIKE.NEW_ADDR IS '대여소 주소';
COMMENT ON COLUMN SEOULBIKE.CONTENT_ID IS '대여소 번호';
COMMENT ON COLUMN SEOULBIKE.ADDR_GU IS '구분';
COMMENT ON COLUMN SEOULBIKE.LONGITUDE IS '경도';
COMMENT ON COLUMN SEOULBIKE.CRADLE_COUNT IS '거치대수';
COMMENT ON COLUMN SEOULBIKE.LATITUDE IS '위도';
COMMENT ON COLUMN SEOULBIKE.CONTENT_NM IS '대여소명';