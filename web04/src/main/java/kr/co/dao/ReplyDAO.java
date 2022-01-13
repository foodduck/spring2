package kr.co.dao;

import java.util.List;

import kr.co.vo.ReplyVO;

public interface ReplyDAO {
	
	//댓글 목록	sql.replyList() replyVO
	public List<ReplyVO> replyList() throws Exception;
	
	//댓글 상세보기	sql.replyRead() replyVO
	public ReplyVO replyRead() throws Exception;
	
	//댓글 추가	sql.replyInsert(replyVO)
	public void replyInsert(ReplyVO replyVO) throws Exception;
	
	//댓글 수정	sql.replyUpdate(replyVO)
	public void replyUpdate(ReplyVO replyVO) throws Exception;
	
	//댓글 삭제	sql.replyDelete(replyVO)
	public void replyDelete(ReplyVO replyVO) throws Exception;
}
