package kr.co.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import kr.co.vo.SampleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class VoTest {
	@Autowired
	//Oprivate WebApplicationContext ctx;
	
	
	

	
	@Test
	public void testVO() throws Exception {
		SampleVO sv = new SampleVO();
		sv.setNum(7);
		sv.setFirstName("철수");
		sv.setLastName("김");
		System.out.println(sv.toString());
		
		//fail("Not yet implemented");
		
	}

}