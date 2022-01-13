package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import kr.co.vo.ReplyVO;

public class ReplyDAOImpl implements ReplyDAO {
	@Inject
	private SqlSession sql;
	
	//댓글 목록	sql.replyList() replyVO
	@Override
	public List<ReplyVO> replyList() throws Exception {
		return sql.selectList("replyMapper.replyList");
	}
	
	//댓글 상세보기	sql.replyRead() replyVO
	@Override
	public ReplyVO replyRead() throws Exception {
		return sql.selectOne("replyMapper.replyRead");
	}
	
	//댓글 추가	sql.replyInsert(replyVO)
	@Override
	public void replyInsert(ReplyVO replyVO) throws Exception {
		sql.insert("replyMapper.replyInsert", replyVO);
	}
	
	//댓글 수정	sql.replyUpdate(replyVO)
	@Override
	public void replyUpdate(ReplyVO replyVO) throws Exception {
		sql.update("replyMapper.replyUpdate", replyVO);
	}
	
	//댓글 삭제	sql.replyDelete(replyVO)
	@Override
	public void replyDelete(ReplyVO replyVO) throws Exception {
		sql.delete("replyMapper.replyDelete", replyVO);
	}
	
}
