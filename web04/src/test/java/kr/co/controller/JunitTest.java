package kr.co.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.vo.BoardVO;
import kr.co.vo.MemberVO;

public class JunitTest {
	private static final Logger logger = LoggerFactory.getLogger(JunitTest.class);
	
//	@Autowired
//	MemberVO member;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.info("@BeforeClass 실행");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.info("@AfterClass 실행");
	}

	@Before
	public void setUp() throws Exception {
		logger.info("@Before 실행");
//		member.setUserid("kks");
//		member.setUserpass("1234");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("@After 실행");
	}

	@Test(expected=RuntimeException.class)	//예외 발생 클래스 지정
	public void test1() {
		logger.info("@Test 단위테스트 케이스 실행 예외 처리");
		throw new RuntimeException();
	}
	
	@Test(timeout=1000)	//1초 내에 처리 실패 시 실패 처리
	public void test2() {
		logger.info("@Test 단위테스트 케이스 실행");
		MemberVO member = new MemberVO();
		logger.info("member의 아이디:"+member.getUserid());
		logger.info("member의 비밀번호:"+member.getUserpass());
		BoardVO board = new BoardVO();
		logger.info("board의 제목:"+board.getTitle());
		logger.info("board의 내용:"+board.getContent());
	}
	
//	@Test(timeout=1000)	//1초 내에 처리 실패 시 실패 처리
//	public void test3() {
//		logger.info("@Test 단위테스트 케이스 실행");
//		member.getUserid();
//		member.getUserpass();
//	}

//	@Test
//	public void test4() {
//		logger.info("@Test 단위테스트 케이스 실행");
//		MemberVO member = new MemberVO();
//		Assert.assertEquals("관리자", "admin",member.getUserid());
//		Assert.assertEquals("비밀번호 일치", "4321",member.getUserpass());
//		
//		//assertTrue(첫번째>두번째) : 현재 파라미터의 값이 참인지
//		//assertTrue("메시지", 첫번째>두번째) : 현재 파라미터의 값이 참인지
//		//assertEquals("메시지", 첫번째, 두번째) : 두 개의 데이터가 일치하는지
//		//assertNull("메시지", 객체명) : 객체나 변수가 null 인지
//		//assertSame("메시지" 첫번째, 두번째) : 두 개의 데이터가 일치하는지
//		//assertNotSame("메시지" 첫번째, 두번째) : 두 개의 데이터가 불일치하는지
//	}
}
