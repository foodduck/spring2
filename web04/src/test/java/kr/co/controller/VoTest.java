package kr.co.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.vo.BoardVO;
import kr.co.vo.MemberVO;


public class VOTest {
	private static final Logger logger = LoggerFactory.getLogger(JunitTest.class);
	@Test
	public void test2() {
		logger.info("@Test 단위테스트 케이스 실행");
		MemberVO member = new MemberVO();
		logger.info("member의 아이디:"+member.getUserid());
		logger.info("member의 비밀번호:"+member.getUserpass());
		BoardVO board = new BoardVO();
		logger.info("board의 제목:"+board.getTitle());
		logger.info("board의 내용:"+board.getContent());
	}
	
}
