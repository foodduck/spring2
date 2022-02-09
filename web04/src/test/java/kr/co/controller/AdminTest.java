package kr.co.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminTest {
	
	MemberVO member;
	
	@Test
	public void testVO() {
		member.setUserid("admin");
		if(member.getUserid().equals("admin")) {
			System.out.println("관리자 확인");
		}  else {
			System.out.println("인증 실패");
		}
	}

}
