package kr.co.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


//페이지내이션에서 한 페이지당 글을 저장하고 다루기 위한 VO 클래스
public class PageMaker {
	private int totalCount;	//전체 글의 수
	private int startPage=1;	//현재 클립에서 시작 페이지 번호
	private int endPage;	//현재 클립에서 끝 페이지 번호
	private boolean prev;	//이전 페이지 번호(이전 클립에서의 마지막 페이지 번호)
	private boolean next;	//다음 페이지 번호(다음 클립에서의 시작 페이지 번호)
	private int displayPageNum = 10;	//현재 화면에 출력되는 페이지 글의 개수
	private Criteria cri;	
	//현재 페이지 번호, 한 페이지당 글의 수, 현재 페이지의 첫번째 줄 글번호, 현재 페이지의 마지막 글번호 등을 전달하거나 전달받기 위한 객체
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
	private void calcData() {	//시작페이지, 끝페이지, 전체페이지 수, 이전/다음페이지 존재 계산
		endPage = (int) (Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
	  
		int tempEndPage = (int) (Math.ceil(totalCount / (double)cri.getperPageNum()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getperPageNum() >= totalCount ? false : true;
	}
	public String makeQuery(int page) {	//입력된 검색어에 따른 계산된 페이지의 파라미터를 URI로 전달하는 메서드
		UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
						    .queryParam("page", page)
							.queryParam("perPageNum", cri.getperPageNum())
							.build();
		   
		return uriComponents.toUriString();
				
	}
	public String makeSearch(int page) {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
		    .queryParam("page", page)
		    .queryParam("perPageNum", cri.getperPageNum())
		    .queryParam("searchType", ((SearchCriteria)cri).getSearchType())
		    .queryParam("keyword", encoding(((SearchCriteria)cri).getKeyword()))
		    .build(); 
		return uriComponents.toUriString();  
	}
	
	private String encoding(String keyword) {
		if(keyword == null || keyword.trim().length() == 0) { 
			return "";
		}
		 
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		} catch(UnsupportedEncodingException e) { 
			return ""; 
		}
	}
}	
