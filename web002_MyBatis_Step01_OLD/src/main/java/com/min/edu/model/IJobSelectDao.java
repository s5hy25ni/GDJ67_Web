package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.JobVo;

/**
 * myBatis에서 작동되는 Select의 기능에 상세
 */
public interface IJobSelectDao {
	
	/*
	 * parameter의 전송방식 : Primitive Type
	 * result의 전송방식 : Integer
	 * myBatis에서 전송받은 값의 입력 방식 (preparedStatement) jdbc : ? , myBatis : #,$ 바인딩 문법 사용
	 */
	public Integer select01(String id);
	
	/*
	 * parameter의 전송방식 : Primitive Type
	 * 결과는 전체 컬럼과 Mapping 되어 있는 JobVo를 통해서 전달 받는다.
	 * 쿼리에서 공집합이 나오면 null이 반환
	 * Mapping이기 때문에 getter/setter의 이름이 맞춰있어야 함
	 */
	public JobVo select02(String job_id);
	
	/*
	 * Parameter Type : Primitive Type
	 * Result Type : DTO/VO - JobVo
	 */
	public JobVo select03(String job_id);
	
	/*
	 * 결과를 {특정컬럼 : DTO/VO} <=> JSON
	 */
	public Map<String, JobVo> select04();
	
	/*
	 * 결과를 한 개만 받음
	 * NullPointException 방지를 위해 selectList()로 처리하고
	 * 여러 개의 Arguments를 필요로 함
	 * 하지만 myBatis에서는 여러 개의 Arguments를 받는 문법은 없음
	 * 따라서 DTO/VO 혹은 Map을 통해서 전달해야 함 
	 */
	public List<JobVo> select05(JobVo vo);
	
	/*
	 * Map 객체를 통해서 여러 개의 값을 DTO/VO 없이 arguments를 전송한다.
	 * DTO/VO는 getter/setter의 이름이 정해져 있음
	 * Map은 Key를 정해줘야 함 -> 로그/설계도 반드시 적어둬야 함
	 */
	public JobVo select06(Map<String, Object> map);
	
	public List<JobVo> select07(Object obj);
}
