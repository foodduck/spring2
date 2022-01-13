package kr.co.dao;

import java.util.List;
import java.util.Map;

import kr.co.vo.BoardVO;
import kr.co.vo.SearchCriteria;

public interface BoardDAO {
	
	//게시물 작성	sql.boardInsert(boardVO)
	public void boardInsert(BoardVO boardVO) throws Exception;
	
	//게시물 목록	sql.boardList(sc) boardVO
	public List<BoardVO> boardList(SearchCriteria scri) throws Exception;
	
	//게시물 총 개수		sql.boardCount(sc) count
	public int boardCount (SearchCriteria scri) throws Exception;
	
	//게시물 조회	sql.boardRead(bno) boardVO
	public BoardVO boardRead(int bno) throws Exception;
	
	//게시글 수정	sql.boardUpdate(boardVO)
	public void boardUpdate(BoardVO boardVO) throws Exception;
	
	//게시글 삭제	 sql.boardDelete(bno)
	public void boardDelete(int bno) throws Exception;
	
	//첨부파일 업로드	sql.fileInsert(hashMap)
	public void fileInsert (Map<String, Object> map ) throws Exception;
	
	//첨부파일 조회		sql.fileRead(bno), hashMap
	public List<Map<String, Object>> fileRead(int bno) throws Exception;
	
	//첨부파일 다운로드	sql.fileDown(hashMap), hashMap
	public Map<String, Object> fileDown (Map<String, Object> map ) throws Exception;
	
	//첨부파일 수정		sql.fileUpdate(hashMap)
	public void fileUpdate (Map<String, Object> map ) throws Exception;
	
	//게시글 조회수 증가	sql.boardHit(bno)
	public void boardHit(int bno) throws Exception;
}
