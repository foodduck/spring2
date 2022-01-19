package kr.co.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.service.MemberService;
import kr.co.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private final static Logger logger = LoggerFactory.getLogger(MemberController.class);    
	@Inject
	private MemberService service;
	
	@Inject
	BCryptPasswordEncoder pwdEncoder;
	
	//회원가입 페이지로 이동
	@RequestMapping(value="/memberJoinView", method = RequestMethod.GET)
	public void memberJoinView() throws Exception {
		logger.info("memberJoinView");
	}
	//회원가입 처리
	@RequestMapping(value = "/registery", method = RequestMethod.POST)
	public String postRegister(MemberVO vo) throws Exception {
		logger.info("post register");
		//int result = service.idChk(vo);
		System.out.println(vo.getUserid());
		System.out.println(vo.getUserpass());
		System.out.println(vo.getEmail());
		System.out.println(vo.getUsername());
		try {
/*			if(result == 1) {
				return "/member/register";
			} else if(result == 0) {*/
				String inputPass = vo.getUserpass();
				String pwd = pwdEncoder.encode(inputPass);
				vo.setUserpass(pwd);
				
				service.memberInsert(vo);
				/* } */
			// 요기에서~ 입력된 아이디가 존재한다면 -> 다시 회원가입 페이지로 돌아가기 
			// 존재하지 않는다면 -> register
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return "redirect:/";
	}
	//로그인 화면으로 이동
	@RequestMapping(value="/memberLoginView", method=RequestMethod.GET)
	public void memberLoginView() throws Exception {
		logger.info("memberLoginView");
	}
	//로그인 처리
	@RequestMapping(value = "/memberLogin", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception {
		logger.info("post login");
		
		session.getAttribute("member");
		MemberVO login = service.memberLogin(vo);
		
		boolean pwdMatch;
		if(login != null) {
			pwdMatch = pwdEncoder.matches(vo.getUserpass(), login.getUserpass());
		} else {
			pwdMatch = false;
		}
		
		if(login != null && pwdMatch == true) {
			session.setAttribute("member", login);
			rttr.addFlashAttribute("msg", "로그인 성공");
			return "redirect:/";
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", "아이디 또는 비밀번호가 올바르지 않습니다.");
			return "redirect:/member/memberLoginView";
		}
	}
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();		
		return "redirect:/";
	}
	//회원정보 수정 페이지로 이동
	@RequestMapping(value="/memberUpdateView", method = RequestMethod.GET)
	public String registerUpdateView() throws Exception {
		return "member/memberUpdateView";
	}
	//회원정보 수정 처리
	@RequestMapping(value="/memberUpdate", method = RequestMethod.POST)
	public String registerUpdate(MemberVO vo, HttpSession session) throws Exception{
		
/*		MemberVO login = service.login(vo);
		
		boolean pwdMatch = pwdEncoder.matches(vo.getUserPass(), login.getUserPass());
		if(pwdMatch) {
			service.memberUpdate(vo);
			session.invalidate();
		}else {
			return "member/memberUpdateView";
		}*/
		service.adminMemberUpdate(vo);
		session.invalidate();
		return "redirect:/";
	}
	//회원탈퇴 페이지 이동
	@RequestMapping(value="/memberDeleteView", method = RequestMethod.GET)
	public String memberDeleteView() throws Exception{
		return "member/memberDeleteView";
	}
	//회원 탈퇴
	@RequestMapping(value="/memberDelete", method = RequestMethod.POST)
	public String memberDelete(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		
		service.adminMemberDelete(vo);
		session.invalidate();
		
		return "redirect:/";
	}
	//패스워드 체크
	@ResponseBody
	@RequestMapping(value="/memberCheckPW", method = RequestMethod.POST)
	public boolean passChk(MemberVO vo) throws Exception {

		MemberVO login = service.memberLogin(vo);
		boolean pwdChk = pwdEncoder.matches(vo.getUserpass(), login.getUserpass());
		return pwdChk;
	}
	
	int result = 0;
	//아이디 중복 확인
	@ResponseBody
	@RequestMapping(value="/memberCheckID", method = RequestMethod.GET)
	public int idChk2(@RequestParam("userid") String userid, HttpSession ses) throws Exception {
		MemberVO mem = new MemberVO(); 
		mem.setUserid(userid);
		result = (int) service.memberCheckID(mem);
		System.out.println("결과 : "+result);
		if(result==0) {
			ses.setAttribute("msg", "ok");
		} else {
			ses.setAttribute("msg", "no");
		}
		return result;
	}
}
