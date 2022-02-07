package kr.co.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.co.service.MemberService;
import kr.co.vo.MemberVO;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class VOTest {
	private static final Logger logger = LoggerFactory.getLogger(VOTest.class);
	
	@Autowired
	MemberVO member;
	
	@Autowired
	MemberService service;
	
	@Before
	public void voSetData() {
		member.setUserid("kks1234");
	}
	
	@Test
	public void testVO() throws Exception {
		this.voSetData();
		logger.trace("trace : "+member.getUserid());
		
	}

}
