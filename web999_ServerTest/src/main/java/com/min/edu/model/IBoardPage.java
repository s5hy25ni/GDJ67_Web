package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.FileVo;
import com.min.edu.vo.PageVo;
import com.min.edu.vo.ReplyVo;
import com.min.edu.vo.RootVo;

public interface IBoardPage {
	public List<RootVo> getDetail(Map<String, Object> map);
	public PageVo getReplyCnt(String ref);
	public boolean insertRoot(RootVo rtVo, FileVo fVo);
	public FileVo getFname(String bSeq);
}
