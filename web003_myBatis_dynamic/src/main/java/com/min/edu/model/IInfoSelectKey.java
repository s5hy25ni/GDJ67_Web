package com.min.edu.model;

import com.min.edu.dto.Info_DTO;

/**
 * insert 후 생성된 pk를 사용하여 select를 실행하는 것
 */
public interface IInfoSelectKey {
	
	/**
	 * info 테이블에 name과 phone을 입력하는 기능
	 * @param dto String name, String phone
	 * @return 성공한 row의 갯수
	 */
	public int insertInfo(Info_DTO dto);
	
	/**
	 * info 테이블에서 insert 된 후의 새로 생성된 seq값을 dto에 입력 받아 select 실행
	 * @param dto 새로 생성된 seq를 가지고 있는 dto
	 * @return seq에 해당하는 row
	 */
	public Info_DTO selectOneInfo(Info_DTO dto);
}
