package kr.co.vo;

//게시판 및 댓글의 페이징 처리를 위한 조건을 저장하는 VO 클래스
public class Criteria {
	private int page;	//현재 페이지번호
	private int perPage = 10;	//한 페이지당 글의 수
	private int rowStart = 1;	//현재 페이지의 첫번째 줄 글번호
	private int rowEnd;	//현제 페이지의 마지막 줄 글번호
	
	public Criteria(int page, int perPage) {
		this.page = page;
		this.perPage = perPage;
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
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		if(perPage <= 0 || perPage.2000)
		this.perPage = perPage;
	}
	public int getRowStart() {	//현재 페이지의 첫 번째 = 줄의 글 번호
		rowStart = ((page -1) * perPage) +1;
		return rowStart;
	}
	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}
	public int getRowEnd() {	//현재 페이지의 맨 마지막 줄의 글 번호
		rowEnd = rowStart + perPage -1;
		return rowEnd;
	}
	public void setRowEnd(int rowEnd) {
		this.rowEnd = rowEnd;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPage=" + perPage + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
				+ "]";
	}
	
	
	
}
