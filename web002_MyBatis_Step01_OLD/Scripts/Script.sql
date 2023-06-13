-- JOBS 테이블 복사
CREATE TABLE JOB AS SELECT * FROM HR.JOBS;

SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY
	FROM JOB;
	
-- select01
-- job_id 입력 max_salary 출력
SELECT MAX_SALARY
	FROM JOB
	WHERE JOB_ID='AD_PRES';
	
-- select02
-- job_id 입력 전체 컬럼의 값을 출력
SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY
	FROM JOB
	WHERE JOB_ID='AD_PRES';
	
-- select03
SELECT FIRST_NAME, LAST_NAME, EMPLOYEE_ID, SALARY
	FROM EMPLOYEES
	WHERE EMPLOYEE_ID='113';
	
-- select05
SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY
	FROM JOB
	WHERE JOB_ID='AD_PRES'
		AND JOB_TITLE='President';
		
-- select06
CREATE TABLE PLAYER AS SELECT PLAYER_ID, PLAYER_NAME, BACK_NO, TEAM_ID 
																FROM sqld.PLAYER;
																
SELECT PLAYER_NAME || '(' || BACK_NO || ')' AS ID, 
					TEAM_ID TITLE
	FROM PLAYER
	WHERE PLAYER_ID='2012001';
	
SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY
	FROM JOB
	WHERE MIN_SALARY < 3000;