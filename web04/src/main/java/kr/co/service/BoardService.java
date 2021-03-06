package kr.co.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.vo.BoardVO;
import kr.co.vo.SearchCriteria;

public interface BoardService {
	//게시물 작성	dao.boardInsert(boardVO)
	public void boardInsert(BoardVO boardVO, MultipartHttpServletRequest mpRequest) throws Exception;
	
	//게시물 목록	dao.boardList(sc) boardVO
	public List<BoardVO> boardList(SearchCriteria scri) throws Exception;
	
	//게시물 총 개수		dao.boardCount(sc) count
	public int boardCount (SearchCriteria scri) throws Exception;
	
	//게시물 조회	dao.boardRead(bno) boardVO
	public BoardVO boardRead(int bno) throws Exception;
	
	//게시글 수정	dao.boardUpdate(boardVO)
	public void boardUpdate(BoardVO boardVO, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception;
	
	//게시글 삭제	 dao.boardDelete(bno)
	public void boardDelete(int bno) throws Exception;
	
	//첨부파일 업로드	dao.fileInsert(hashMap)
	public void fileInsert (Map<String, Object> map ) throws Exception;
	
	//첨부파일 조회		dao.fileRead(bno), hashMap
	public List<Map<String, Object>> fileRead(int bno) throws Exception;
	
	//첨부파일 다운로드	dao.fileDown(hashMap), hashMap
	public Map<String, Object> fileDown (Map<String, Object> map ) throws Exception;
	
	//첨부파일 수정		dao.fileUpdate(hashMap)
	public void fileUpdate (Map<String, Object> map ) throws Exception;
	
	//게시글 조회수 증가	dao.boardHit(bno)
	public void boardHit(int bno) throws Exception;	
}
