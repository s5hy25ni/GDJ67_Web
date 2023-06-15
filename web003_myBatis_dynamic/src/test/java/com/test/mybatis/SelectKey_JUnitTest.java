package com.test.mybatis;

import static org.junit.Assert.*;

import org.junit.Test;

import com.min.edu.dto.Info_DTO;
import com.min.edu.sevice.InfoServiceImpl;

public class SelectKey_JUnitTest {

	/*
	 * 1) insertInfo(Info_DTO)에 신규 값을 입력 -> 생성된 SEQ Parameter의 Info_DTO 객체에 담음
	 * 2) insertInfo의 DTO(pass by reference)를 이용하여 selectOneInfo에 Parameter로 전달 selectOneInfo(Info_DTO)
	 */
	@Test
	public void selectKey() {
		InfoServiceImpl service = new InfoServiceImpl();
		Info_DTO iDto = new Info_DTO(0, "판콜", "00100", null, null);
		Info_DTO rDto = service.insertAfterSelect(iDto);
		System.out.println("입력된 객체 확인 : "+rDto);
		assertNotNull(rDto);
	}

}
