INSERT INTO HR.EMPLOYEES
	(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID)
VALUES(, '', '', '', '', '', '', 0, 0, 0, 0);

INSERT INTO USERINFO (ID, NAME, PASSWORD, 
								EMAIL, AUTH, DELFLAG,
								JOIND)
			VALUES('sdfasdf', '소현', '1234', 
					'sd@gmail.omc', 'U', 'N',
					SYSDATE);
					
SELECT ID, NAME, EMAIL, AUTH, DELFLAG, JOINDATE
	FROM USERINFO u
	WHERE ID = 'hello' AND PASSWORD = '1234';
	