package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import kr.co.dao.MemberDAO;
import kr.co.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO dao;
	
	//회원목록 조회	dao.memberList() MemberVO
	@Override
	public List<MemberVO> memberList() throws Exception {
		return dao.memberList();
	}
	
	//상세회원 조회(관리자)	dao.adminMemberView(String userid) MemberVO
	@Override
	public MemberVO adminMemberView(String userid) throws Exception {
		return dao.adminMemberView(userid);
	}

	//상세회원 조회(회원)	dao.memberView()
	@Override
	public void memberView() throws Exception {
		dao.memberView();
	}
	
	//회원 등록	dao.memberInsert()
	@Override
	public void memberInsert() throws Exception {
		dao.memberInsert();
	}
	
	//회원정보 수정	dao.memberUpdate()
	@Override
	public void memberUpdate() throws Exception {
		dao.memberUpdate();
	}
	
	//회원 탈퇴(회원)	dao.memberDelete()
	@Override
	public void memberDelete() throws Exception {
		dao.memberDelete();
	}

	//회원 삭제(관리자)	dao.adminMemberDelete()
	@Override
	public void adminMemberDelete(String userid) throws Exception {
		dao.adminMemberDelete(userid);
		
	}
	
	//로그인	dao.memberLogin()
	@Override
	public void memberLogin(MemberVO memberVO) throws Exception {
		dao.memberLogin(memberVO);
		
	}

	//패스워드 체크	dao.memberCheckPw()
	@Override
	public int memberCheckPw() throws Exception {
		return dao.memberCheckPw();
	}

	//아이디 중복 체크	dao.memberCheckID()
	@Override
	public int memberCheckId() throws Exception {
		return dao.memberCheckId();
	}
}
