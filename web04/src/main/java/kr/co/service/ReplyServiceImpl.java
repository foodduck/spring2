package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.ReplyDAO;
import kr.co.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Inject
	private ReplyDAO dao;
	
	//댓글 목록	dao.replyList() replyVO
	@Override
	public List<ReplyVO> replyList(int rno) throws Exception {
		return dao.replyList(rno);
	}
	
	//댓글 상세보기	dao.replyRead() replyVO
	@Override
	public ReplyVO replyRead(int rno) throws Exception {
		return dao.replyRead(rno);
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
