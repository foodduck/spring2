package kr.co.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.service.BoardService;
import kr.co.service.ReplyService;
import kr.co.vo.BoardVO;
import kr.co.vo.PageMaker;
import kr.co.vo.SearchCriteria;

@Controller
@RequestMapping("/board/*")
public class BoardController extends HttpServlet {
	//해당 내용을 처리하고, 콘솔 창에 메시지를 띄운다.
	private final static Logger logger = LoggerFactory.getLogger(BoardController.class);
   
	@Inject
	private BoardService service;
	
	@Inject
	private ReplyService replyService;
	
	//게시판 글작성 화면으로 이동
	@RequestMapping(value="/boardWriteView", method=RequestMethod.GET)
	public void boardWriteView() throws Exception {
		logger.info("boardWriteView");
	}
	
	//게시판 글쓰기 처리
	@RequestMapping(value="/boardInsert", method=RequestMethod.POST)
	public String boardInsert(BoardVO boardVO, MultipartHttpServletRequest mpRequest) throws Exception {
		logger.info("boardInsert");
		service.boardInsert(boardVO, mpRequest);
		return "redirect:/bord/boardList";	//Dispatcher, forward, sendredirect 모두 합쳐진 형태
		//데이터까지 같이 넘기게 된다.
		//return "board/list";	데이터를 넘기지 않는다.
	}
	
	//게시판 글 목록		
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
		logger.info("boardlist");
		//model객체: getter가 필요없는 application 객체
		model.addAttribute("boardlist", service.boardList(scri));
		PageMaker pageMaker = new PageMaker();
		//pageMaker. setCri(scri);
		pageMaker.setTotalCount(service.boardCount(scri));
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/list";	
	}
	
	//게시판 글 보기
	@RequestMapping(value="", method=RequestMethod.GET)
	public String read
	//게시판 수정페이지로 이동
	
	
	
}
