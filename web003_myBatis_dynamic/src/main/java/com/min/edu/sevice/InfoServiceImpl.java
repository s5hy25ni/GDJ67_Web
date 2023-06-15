package com.min.edu.sevice;

import com.min.edu.dto.Info_DTO;
import com.min.edu.model.IInfoSelectKey;
import com.min.edu.model.InfoSelectKeyImpl;

public class InfoServiceImpl {
	
	private IInfoSelectKey dao;
	
	public InfoServiceImpl() {
		dao = new InfoSelectKeyImpl();
	}
	
	public Info_DTO insertAfterSelect(Info_DTO dto) {
		Info_DTO rDto = null;
		System.out.println("원본 DTO : "+dto);
		int n = dao.insertInfo(dto);
		System.out.println("Info Insert 결과 : "+n);
		System.out.println("입력 후 DTO : "+dto);
		rDto = dao.selectOneInfo(dto);
		
		return rDto;
	}
}
