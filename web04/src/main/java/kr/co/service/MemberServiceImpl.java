package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.MemberDAO;
import kr.co.vo.MemberVO;

@Service
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
		public MemberVO adminMemberView(MemberVO vo) throws Exception {
			return dao.adminMemberView(vo);
		}

		//상세회원 조회(회원)	dao.memberView()
		@Override
		public void memberView() throws Exception {
			dao.memberView();
		}
		
		//회원 등록	dao.memberInsert()
		@Override
		public void memberInsert(MemberVO vo) throws Exception {
			dao.memberInsert(vo);
		}
		
		//회원정보 수정(회원)	dao.memberUpdate()
		@Override
		public void memberUpdate() throws Exception {
			dao.memberUpdate();
		}

		//회원정보 수정(관리자)	dao.memberUpdate()
		@Override
		public void adminMemberUpdate(MemberVO vo) throws Exception {
			dao.adminMemberUpdate(vo);
		}
		
		//회원 탈퇴(회원)	dao.memberDelete()
		@Override
		public void memberDelete() throws Exception {
			dao.memberDelete();
		}

		//회원 삭제(관리자)	dao.adminMemberDelete()
		@Override
		public void adminMemberDelete(MemberVO vo) throws Exception {
			dao.adminMemberDelete(vo);
			
		}
		
		//로그인	dao.memberLogin()
		@Override
		public MemberVO memberLogin(MemberVO vo) throws Exception {
			return dao.memberLogin(vo);
			
		}

		//패스워드 체크	dao.memberCheckPW()
		@Override
		public int memberCheckPW(MemberVO vo) throws Exception {
			return dao.memberCheckPW(vo);
		}

		//아이디 중복 체크	dao.memberCheckID()
		@Override
		public int memberCheckID(MemberVO vo) throws Exception {
			return dao.memberCheckID(vo);
		}
}
