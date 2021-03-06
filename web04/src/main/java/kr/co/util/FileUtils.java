package kr.co.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.vo.BoardVO;

//@Component: 어디서든 하나의 클래스로 여겨지고 호출될 수 있다.
@Component("fileUtils")
public class FileUtils {
	//경로를 변경하세요
	private static final String filePath = "D:\\ssj\\spring2\\uploadedfile";
	
	//파일 추가
	//Map<파일경로, 파일속성들>
	public List<Map<String, Object>> parseInsertFileInfo(BoardVO boardVO, MultipartHttpServletRequest mpRequest) {
		/*
		Iterator은 데이터들의 집합체에서 컬렉션으로부터 정보를 얻어올 수 있는 인터페이스입니다.
		List나 배열은 순차적으로 데이터의 접근이 가능하지만, Map등의 클래스들은 순차적으로 접근할 수가 없습니다.
		Iterator을 이용하여 Map에 있는 데이터들을 while문을 이용하여 순차적으로 접근합니다.
		 */
		
		Iterator<String> iterator = mpRequest.getFileNames();
		MultipartFile multipartFile = null;	//원본파일자체
		String originalFileName = null;	//파일이름만
		String originalFileExtension = null;	//확장자만
		String storedFileName = null;	//경로를 포함한 파일명
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> listMap = null;
		
		int bno = boardVO.getBno();
		File file = new File(filePath);
		if(file.exists() == false) {	//mkdir: 하나의 폴더만 만들기, mkdirs: 여러폴더 만들기
			file.mkdirs();	
		}
		while(iterator.hasNext()) {
			multipartFile = mpRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = getRandomString() + originalFileExtension;
				file = new File(filePath + storedFileName);
				try {
					multipartFile.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				listMap = new HashMap<String, Object>();
				listMap.put("BNO", bno);
				System.out.println(bno);
				listMap.put("ORG_FILE_NAME", originalFileName);
				System.out.println(originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				System.out.println(storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				System.out.println(multipartFile.getSize());
				list.add(listMap);
				System.out.println(listMap);
			}
		}
		return list;
	}
	
	//파일 갱신
	public List<Map<String, Object>> parseUpdateFileInfo(BoardVO boardVO, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) {
		Iterator<String> iterator = mpRequest.getFileNames();
		MultipartFile multipartFile = null;	//원본파일자체
		String originalFileName = null;	//파일이름만
		String originalFileExtension = null;	//확장자만
		String storedFileName = null;	//경로를 포함한 파일명
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> listMap = null;
		
		int bno = boardVO.getBno();
//		File file = new File(filePath);
//		if(file.exists() == false) {	//mkdir: 하나의 폴더만 만들기, mkdirs: 여러폴더 만들기
//			file.mkdirs();	
//		}
		while(iterator.hasNext()) {
			multipartFile = mpRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = getRandomString() + originalFileExtension;
				
				try {
					multipartFile.transferTo(new File(filePath + storedFileName));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				listMap = new HashMap<String, Object>();
				listMap.put("IS_NEW", "Y");
				listMap.put("BNO", bno);
				listMap.put("ORG_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				list.add(listMap);
			}
		}
		if(files != null && fileNames != null) {	//기존 파일이 있고 파일명 있을때
			for(int i=0; i<fileNames.length; i++) {
				listMap = new HashMap<String, Object>();
				listMap.put("FILE_NO", files[i]);
				list.add(listMap);
			}
		}
		return list;
	}
	
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
