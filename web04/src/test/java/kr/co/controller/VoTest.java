package kr.co.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.co.vo.BoardVO;
import kr.co.vo.MemberVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class VOTest {
	@Autowired
	MemberVO member;
	@Autowired
	BoardVO board;
	
	@Before
	public void voSetData() {
		member.setUserid("kks");
		member.setUserpass("1234");
		board.setTitle("제목");
		board.setContent("내용");
	}
	
	@Test
	public void voTest1() {
		//애자일 방법
		if(member.getUserid().equals("kks")) {
			System.out.println("입력하신 데이터가 일치합니다.");
		} else {
			System.out.println("입력하신 데이터가 일치하지 않습니다.");
		}
		System.out.println("프로그램이 정상 작동중입니다.");
	}
	@Test
	public void voTest2() {
		//애자일 방법
		if(board.getTitle().equals("제목")) {
			System.out.println("입력하신 데이터가 일치합니다.");
		} else {
			System.out.println("입력하신 데이터가 일치하지 않습니다.");
		}
		System.out.println("프로그램이 정상 작동중입니다.");
	}
	
	
}
