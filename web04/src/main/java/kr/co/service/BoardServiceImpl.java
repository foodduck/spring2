package kr.co.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.dao.BoardDAO;
import kr.co.util.FileUtils;
import kr.co.vo.BoardVO;
import kr.co.vo.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService {
	@Resource(name= "fileUtils")
	private FileUtils fileUtils;
	
	@Inject
	private BoardDAO dao;
	
	//게시물 작성	dao.boardInsert(boardVO)
		@Override
		public void boardInsert(BoardVO boardVO, MultipartHttpServletRequest mpRequest) throws Exception {
			dao.boardInsert(boardVO);
			
			List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(boardVO, mpRequest);
			int size = list.size();
			for(int i=0; i<size; i++) {
				dao.fileInsert(list.get(i));
			}
		}
		
		//게시물 목록	dao.boardList(sc) boardVO
		@Override
		public List<BoardVO> boardList(SearchCriteria scri) throws Exception {
			return dao.boardList(scri);
		}
		
		//게시물 총 개수		dao.boardCount(sc) count
		@Override
		public int boardCount(SearchCriteria scri) throws Exception {
			return dao.boardCount(scri);
		}
		
		//게시물 조회	dao.boardRead(bno) boardVO
		@Override
		public BoardVO boardRead(int bno) throws Exception {
			return dao.boardRead(bno);
		}
		
		//게시글 수정	dao.boardUpdate(boardVO)
		@Override
		public void boardUpdate(BoardVO boardVO, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception {
			dao.boardUpdate(boardVO);
			
			List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(boardVO, files, fileNames, mpRequest);
			Map<String, Object> tempMap = null;
			int size = list.size();
			for(int i=0; i<size; i++) {
				tempMap = list.get(i);
				if(tempMap.get("IS_NEW").equals("Y")) {
					dao.fileInsert(tempMap);
				} else {
					dao.fileUpdate(tempMap);
				}
				
			}
		}

		//게시글 삭제	 dao.boardDelete(bno)
		@Override
		public void boardDelete(int bno) throws Exception {
			dao.boardDelete(bno);
		}
		
		//첨부파일 업로드	dao.fileInsert(hashMap)
		@Override
		public void fileInsert(Map<String, Object> map) throws Exception {
			dao.fileInsert(map);
		}
		
		//첨부파일 조회		dao.fileRead(bno), hashMap
		@Override
		public List<Map<String, Object>> fileRead(int bno) throws Exception {
			return dao.fileRead(bno);
		}
		
		//첨부파일 다운로드	dao.fileDown(hashMap), hashMap
		@Override
		public Map<String, Object> fileDown(Map<String, Object> map) throws Exception {
			return dao.fileDown(map);
		}
		
		//첨부파일 수정		dao.fileUpdate(hashMap)
		@Override
		public void fileUpdate(Map<String, Object> map) throws Exception {
			dao.fileUpdate(map);
		}
		
		//게시글 조회수 증가	dao.boardHit(bno)
		@Override
		public void boardHit(int bno) throws Exception {
			dao.boardHit(bno);
		}
}
