package com.min.edu.comm;

public class PhotoBean {

	
	private int depth;
	
	public void setDepth(int depth) { this.depth = depth; }
	
	public String getPhoto() {
		String str="";
		String blank = "&nbsp;&nbsp;&nbsp;&nbsp;";
		String pin="<img alt=\"reply\" src=\"./img/reply.png\">";
		
		for(int i=0; i<depth; i++) {
			str += blank;
		}
		
		return depth>0?str+pin:str;
	}
}
