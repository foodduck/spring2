package kr.co.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.service.BoardService;
import kr.co.service.ReplyService;
import kr.co.vo.BoardVO;
import kr.co.vo.PageMaker;
import kr.co.vo.ReplyVO;
import kr.co.vo.SearchCriteria;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	//해당 내용을 처리하고, 콘솔 창에 메시지를 띄운다.
	private final static Logger logger = LoggerFactory.getLogger(BoardController.class);
   
	@Inject
	BoardService service;
	
	@Inject
	ReplyService replyService;
	
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
		return "redirect:/board/boardList";	//Dispatcher, forward, sendredirect 모두 합쳐진 형태
		//데이터까지 같이 넘기게 된다.
		//return "board/boardList";	데이터를 넘기지 않는다.
	}
	
	//게시판 글 목록		
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String boardList(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
		logger.info("boardList");
		//model객체: getter가 필요없는 application 객체
		model.addAttribute("boardList", service.boardList(scri));
		PageMaker pageMaker = new PageMaker();
		pageMaker. setCri(scri);
		pageMaker.setTotalCount(service.boardCount(scri));
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/boardList";	
	}
	
	//게시판 글 보기
	@RequestMapping(value="boardReadView", method=RequestMethod.GET)
	public String boardRead(BoardVO boardVO, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		logger.info("boardReadView");
		
		model.addAttribute("boardRead", service.boardRead(boardVO.getBno()));
		model.addAttribute("scri", scri);

		List<ReplyVO> replyList = replyService.replyList(boardVO.getBno());
		model.addAttribute("replyList", replyList);

		List<Map<String, Object>> fileList = service.fileRead(boardVO.getBno());
		model.addAttribute("file", fileList);
		
		service.boardHit(boardVO.getBno());
		
		return "board/boardReadView";
	}
	//글 수정페이지로 이동
	@RequestMapping(value = "/boardUpdateView", method = RequestMethod.GET)
	public String boardUpdateView(BoardVO boardVO, @ModelAttribute("scri") SearchCriteria scri, Model model)
			throws Exception {
		logger.info("boardUpdateView");

		model.addAttribute("update", service.boardRead(boardVO.getBno()));
		model.addAttribute("scri", scri);

		List<Map<String, Object>> fileList = service.fileRead(boardVO.getBno());
		model.addAttribute("file", fileList);
		return "board/boardUpdateView";
	}
	//글 수정
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String update(BoardVO boardVO, 
						 @ModelAttribute("scri") SearchCriteria scri, 
						 RedirectAttributes rttr,
						 @RequestParam(value="fileNoDel[]") String[] files,
						 @RequestParam(value="fileNameDel[]") String[] fileNames,
						 MultipartHttpServletRequest mpRequest) throws Exception {
		logger.info("boardUpdate");
		service.boardUpdate(boardVO, files, fileNames, mpRequest);

		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getperPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());

		return "redirect:/board/boardList";
	}
	//글 삭제
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public String boardDelete(BoardVO boardVO, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr)
			throws Exception {
		logger.info("boardDelete");

		service.boardDelete(boardVO.getBno());

		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getperPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());

		return "redirect:/board/boardList";
	}
	//댓글 작성
	@RequestMapping(value = "/replyInsert", method = RequestMethod.POST)
	public String replyInsert(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		logger.info("reply Insert");

		replyService.replyInsert(vo);

		rttr.addAttribute("bno", vo.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getperPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());

		return "redirect:/board/boardReadView";
	}
	//댓글 수정 페이지로 이동
	@RequestMapping(value = "/replyUpdateView", method = RequestMethod.GET)
	public String replyUpdateView(ReplyVO vo, SearchCriteria scri, Model model) throws Exception {
		logger.info("reply UpdateView");

		model.addAttribute("replyUpdate", replyService.replyRead(vo.getRno()));
		model.addAttribute("scri", scri);

		return "board/replyUpdateView";
	}
	//댓글 수정
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.POST)
	public String replyUpdate(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		logger.info("reply Update");

		replyService.replyUpdate(vo);

		rttr.addAttribute("bno", vo.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getperPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());

		return "redirect:/board/boardReadView";
	}
	//댓글 삭제 페이지로 이동
	@RequestMapping(value = "/replyDeleteView", method = RequestMethod.GET)
	public String replyDeleteView(ReplyVO vo, SearchCriteria scri, Model model) throws Exception {
		logger.info("reply InsertView");
		
		System.out.println("글번호:"+vo.getBno());
		System.out.println("댓글번호:"+vo.getRno());
		System.out.println("이 글의 페이지:"+scri.getPage());
		System.out.println("표시하는 페이지번호:"+scri.getperPageNum());
		System.out.println("검색 카테고리:"+scri.getSearchType());
		System.out.println("검색어:"+scri.getKeyword());
		
		model.addAttribute("replyDelete", replyService.replyRead(vo.getRno()));
		model.addAttribute("scri", scri);

		return "board/replyDeleteView";
	}
	// 댓글 삭제
		@RequestMapping(value = "/replyDelete", method = RequestMethod.POST)
		public String replyDelete(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			logger.info("reply Delete");
		
			replyService.replyDelete(vo);
			
			rttr.addAttribute("bno", vo.getBno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getperPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());

			return "redirect:/board/boardReadView";
		}

		@RequestMapping(value = "/fileDown")
		public void fileDown(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception {
			logger.info("file Down");
			Map<String, Object> resultMap = service.fileDown(map);
			String storedFileName = (String) resultMap.get("STORED_FILE_NAME");
			String originalFileName = (String) resultMap.get("ORG_FILE_NAME");

			// 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
			byte fileByte[] = org.apache.commons.io.FileUtils
					.readFileToByteArray(new File("D:\\project4_receive_files\\" + storedFileName));

			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length);
			response.setHeader("Content-Disposition",
					"attachment; fileName=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\";");
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();

		}
}
