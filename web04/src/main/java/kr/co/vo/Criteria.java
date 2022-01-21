package kr.co.vo;

//게시판 및 댓글의 페이징 처리를 위한 조건을 저장하는 VO 클래스
public class Criteria {
	private int page;	//현재 페이지번호
	private int perPageNum = 10;	//한 페이지당 글의 수
	private int rowStart = 1;	//현재 페이지의 첫번째 줄 글번호
	private int rowEnd;	//현제 페이지의 마지막 줄 글번호
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	public int getperPageNum() {
		return this.perPageNum;
	}
	public void setperPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	public int getRowStart() {	//현재 페이지의 첫 번째 = 줄의 글 번호
		rowStart = ((page -1) * perPageNum) +1;
		return rowStart;
	}
	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}
	public int getRowEnd() {	//현재 페이지의 맨 마지막 줄의 글 번호
		rowEnd = rowStart + perPageNum -1;
		return rowEnd;
	}
	public void setRowEnd(int rowEnd) {
		this.rowEnd = rowEnd;
	}
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
				+ "]";
	}	
	
}
