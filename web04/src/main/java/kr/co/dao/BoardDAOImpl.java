package kr.co.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.BoardVO;
import kr.co.vo.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSession sql;
	
	//게시물 작성	sql.boardInsert(boardVO)
	@Override
	public void boardInsert(BoardVO boardVO) throws Exception {
		sql.insert("boardMapper.boardInsert", boardVO);
	}
	
	//게시물 목록	sql.boardList(sc) boardVO
	@Override
	public List<BoardVO> boardList(SearchCriteria scri) throws Exception {
		return sql.selectList("boardMapper.boardList", scri);
	}
	
	//게시물 총 개수		sql.boardCount(sc) count
	@Override
	public int boardCount(SearchCriteria scri) throws Exception {
		return sql.selectOne("boardMapper.boardCount", scri);
	}
	
	//게시물 조회	sql.boardRead(bno) boardVO
	@Override
	public BoardVO boardRead(int bno) throws Exception {
		return sql.selectOne("boardMapper.boardRead", bno);
	}
	
	//게시글 수정	sql.boardUpdate(boardVO)
	@Override
	public void boardUpdate(BoardVO boardVO) throws Exception {
		sql.update("boardMapper.boardUpdate", boardVO);
	}

	//게시글 삭제	 sql.boardDelete(bno)
	@Override
	public void boardDelete(int bno) throws Exception {
		sql.delete("boardMapper.boardDelete", bno);
	}
	
	//첨부파일 업로드	sql.fileInsert(hashMap)
	@Override
	public void fileInsert(Map<String, Object> map) throws Exception {
		sql.insert("boardMapper.fileInsert", map);
	}
	
	//첨부파일 조회		sql.fileRead(bno), hashMap
	@Override
	public List<Map<String, Object>> fileRead(int bno) throws Exception {
		return sql.selectOne("boardMapper.fileRead", bno);
	}
	
	//첨부파일 다운로드	sql.fileDown(hashMap), hashMap
	@Override
	public Map<String, Object> fileDown(Map<String, Object> map) throws Exception {
		return sql.selectOne("boardMapper.fileDown", map);
	}
	
	//첨부파일 수정		sql.fileUpdate(hashMap)
	@Override
	public void fileUpdate(Map<String, Object> map) throws Exception {
		sql.update("boardMapper.fileUpdate", map);
	}
	
	//게시글 조회수 증가	sql.boardHit(bno)
	@Override
	public void boardHit(int bno) throws Exception {
		sql.update("boardMapper.boardHit", bno);
	}
	
}
