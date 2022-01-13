package kr.co.service;

import java.util.List;

import kr.co.vo.MemberVO;

public interface MemberService {
	
	//회원목록 조회	sql.memberList() MemberVO
	public List<MemberVO> memberList() throws Exception;
	
	//상세회원 조회(관리자)	sql.adminMemberView(String userid) MemberVO
	public MemberVO adminMemberView(String userid) throws Exception;
	
	//상세회원 조회(회원)	sql.memberView()
	public void memberView() throws Exception;
	
	//회원 등록	sql.memberInsert()
	public void memberInsert() throws Exception;
	
	//회원정보 수정	sql.memberUpdate()
	public void memberUpdate() throws Exception;
	
	//회원 탈퇴(회원)	sql.memberDelete()
	public void memberDelete() throws Exception;
	
	//회원 삭제(관리자)	sql.adminMemberDelete()
	public void adminMemberDelete(String userid) throws Exception;
	
	//로그인	sql.memberLogin()
	public void memberLogin(MemberVO memberVO) throws Exception;
	
	//패스워드 체크	sql.memberCheckPw()
	public int memberCheckPw() throws Exception;
	
	//아이디 중복 체크	sql.memberCheckID()
	public int memberCheckId() throws Exception;
}
