package com.min.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.min.edu.comm.DataBase;
import com.min.edu.dto.Emp_Dto;

public class EmpDaoImpl extends DataBase implements IEmpDao {

	@Override
	public List<Emp_Dto> getAllEmp() {
		List<Emp_Dto> lists = new ArrayList<Emp_Dto>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT EMPNO, ENAME , JOB , TO_CHAR(HIREDATE, 'YYYY-MM-DD') HIREDATE"
				+ "	FROM EMP e";
		try {
			conn = getConnection();
			System.out.println("2단계 커넥션 연결 성공");
			
			stmt = conn.prepareStatement(sql);
			System.out.println("3단계 쿼리 준비 성공");
			
			rs = stmt.executeQuery();
			System.out.println("4단게 쿼리 실행 성공");
			
			while(rs.next()) {
				//EMPNO, ENAME , JOB , HIREDATE
				Emp_Dto dto = new Emp_Dto();
				dto.setEmpno(rs.getInt(1));
				dto.setEname(rs.getString(2));
				dto.setJob(rs.getString(3));
				dto.setHiredate(rs.getString(4));
				lists.add(dto);			
			}
			System.out.println("5단계 결과 값 받기 성공");
			
			
		} catch (SQLException e) {
			System.out.println("getAllEmp 실패");
			e.printStackTrace();
		} finally {
			closed(rs, stmt, conn);
		}
		
		return lists;
	}

	@Override
	public Emp_Dto getOneEmp(int empno) {
		return null;
	}

}
