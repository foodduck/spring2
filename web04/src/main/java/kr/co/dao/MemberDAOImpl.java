package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.MemberVO;

@Repository
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
	public MemberVO adminMemberView(MemberVO vo) throws Exception {
		return sql.selectOne("memberMapper.adminMemberView", vo);
	}

	//상세회원 조회(회원)	sql.memberView()
	@Override
	public void memberView() throws Exception {
		sql.selectOne("memberMapper.memberView");
	}
	
	//회원 등록	sql.memberInsert()
	@Override
	public void memberInsert(MemberVO vo) throws Exception {
		sql.insert("memberMapper.memberInsert", vo);
	}
	
	//회원정보 수정(회원)	sql.memberUpdate()
	@Override
	public void memberUpdate() throws Exception {
		sql.update("memberMapper.memberUpdate");
	}

	//회원정보 수정(관리자)	sql.memberUpdate()
	@Override
	public void adminMemberUpdate(MemberVO vo) throws Exception {
		sql.update("memberMapper.memberUpdate", vo);
	}
	
	//회원 탈퇴(회원)	sql.memberDelete()
	@Override
	public void memberDelete() throws Exception {
		sql.delete("memberMapper.memberDelete");
	}

	//회원 삭제(관리자)	sql.adminMemberDelete()
	@Override
	public void adminMemberDelete(MemberVO vo) throws Exception {
		sql.delete("memberMapper.adminMemberDelete", vo);
		
	}
	
	//로그인	sql.memberLogin()
	@Override
	public MemberVO memberLogin(MemberVO vo) throws Exception {
		return sql.selectOne("memberMapper.memberLogin", vo);
	}

	//패스워드 체크	sql.memberCheckPW()
	@Override
	public int memberCheckPW(MemberVO vo) throws Exception {
		return sql.selectOne("memberMapper.memberCheckPW",vo);
	}

	//아이디 중복 체크	sql.memberCheckID()
	@Override
	public int memberCheckID(MemberVO vo) throws Exception {
		return sql.selectOne("memberMapper.memberCheckID", vo);
	}
}
