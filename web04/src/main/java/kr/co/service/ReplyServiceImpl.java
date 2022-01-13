package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import kr.co.dao.ReplyDAO;
import kr.co.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	@Inject
	private ReplyDAO dao;
	
	//댓글 목록	dao.replyList() replyVO
	@Override
	public List<ReplyVO> replyList() throws Exception {
		return dao.replyList();
	}
	
	//댓글 상세보기	dao.replyRead() replyVO
	@Override
	public ReplyVO replyRead() throws Exception {
		return dao.replyRead();
	}
	
	//댓글 추가	dao.replyInsert(replyVO)
	@Override
	public void replyInsert(ReplyVO replyVO) throws Exception {
		dao.replyInsert(replyVO);
	}
	
	//댓글 수정	dao.replyUpdate(replyVO)
	@Override
	public void replyUpdate(ReplyVO replyVO) throws Exception {
		dao.replyUpdate(replyVO);
	}
	
	//댓글 삭제	dao.replyDelete(replyVO)
	@Override
	public void replyDelete(ReplyVO replyVO) throws Exception {
		dao.replyDelete(replyVO);
	}
}
