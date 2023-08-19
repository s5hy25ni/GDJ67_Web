package com.min.edu.vo;

public class PageVo {
	private int curPage; // 현재 페이지
	
	private int totalReply; // 총 댓글 개수
	private int cntReply; // 한 페이지 댓글 개수
	
	private int totalPage; // 총 페이지 개수
	private int cntPage; // 화면에 보이는 페이지 개수
	
	private int startPage;
	private int endPage;

	@Override
	public String toString() {
		return "PageVo [curPage=" + curPage + ", totalReply=" + totalReply + ", cntReply=" + cntReply + ", totalPage="
				+ totalPage + ", cntPage=" + cntPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		if(curPage<1) {
			this.curPage = 1;			
		} else if(curPage>totalPage) {
			this.curPage = totalPage;						
		} else {			
			this.curPage = curPage;			
		}
	}

	public int getTotalReply() {
		return totalReply;
	}

	public void setTotalReply(int totalReply) {
		this.totalReply = totalReply;
	}

	public int getCntReply() {
		return cntReply;
	}

	public void setCntReply(int cntReply) {
		this.cntReply = cntReply;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		int totalPageResult = totalReply/cntReply;
		if(totalPageResult == 0 && totalReply%cntReply == 0) {
			this.totalPage = 1;
		} else {			
			this.totalPage = (totalReply%cntReply!=0)?totalPageResult+1:totalPageResult;
		}
	}

	public int getCntPage() {
		return cntPage;
	}

	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = ((curPage-1)/cntPage)*cntPage+1;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = (startPage+cntPage-1)>totalPage?totalPage:(startPage+cntPage-1);
	}
	
}
