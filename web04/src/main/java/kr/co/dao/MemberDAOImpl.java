package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import kr.co.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession sql;
	
	//회원목록 조회	sql.memberList() MemberVO
	@Override
	public List<MemberVO> memberList() throws Exception {
		return sql.selectList("memberMapper.memberList");
	}
	
	//상세회원 조회(관리자)	sql.adminMemberView(String userid) MemberVO
	@Override
	public MemberVO adminMemberView(String userid) throws Exception {
		return sql.selectOne("memberMapper.adminMemberView", userid);
	}

	//상세회원 조회(회원)	sql.memberView()
	@Override
	public void memberView() throws Exception {
		sql.selectOne("memberMapper.memberView");
	}
	
	//회원 등록	sql.memberInsert()
	@Override
	public void memberInsert() throws Exception {
		sql.insert("memberMapper.memberInsert");
	}
	
	//회원정보 수정	sql.memberUpdate()
	@Override
	public void memberUpdate() throws Exception {
		sql.update("memberMapper.memberUpdate");
	}
	
	//회원 탈퇴(회원)	sql.memberDelete()
	@Override
	public void memberDelete() throws Exception {
		sql.delete("memberMapper.memberDelete");
	}

	//회원 삭제(관리자)	sql.adminMemberDelete()
	@Override
	public void adminMemberDelete(String userid) throws Exception {
		sql.delete("memberMapper.adminMemberDelete", userid);
		
	}
	
	//로그인	sql.memberLogin()
	@Override
	public void memberLogin(MemberVO memberVO) throws Exception {
		sql.selectOne("memberMapper.memberLogin", memberVO);
		
	}

	//패스워드 체크	sql.memberCheckPw()
	@Override
	public int memberCheckPw() throws Exception {
		return sql.selectOne("memberMapper.memberCheckPw");
	}

	//아이디 중복 체크	sql.memberCheckID()
	@Override
	public int memberCheckId() throws Exception {
		return sql.selectOne("memberMapper.memberCheckId");
	}
}