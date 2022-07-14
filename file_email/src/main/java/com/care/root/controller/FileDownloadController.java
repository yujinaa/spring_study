package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.servicce.FileService;

@Controller
public class FileDownloadController {
	@GetMapping("download")
	public void download(@RequestParam("file") String fileName, 
			HttpServletResponse response) throws Exception{

		/*
	 Content-disposition : 파일 다운로드 하겠다는 의미
	 attachment : 파일을 다운로드하여 브라우저로 표현하겠다
	 fileName : 다운로드 될 파일이름 설정
		 */
		
		response.addHeader("Content-disposition", "attachment; fileName=" +fileName); //이게 있어야 파일다운가능.사용자한테 응답한느 방식을 설정한다
				File file = new File(FileService.IMAGE_REPO + "/" + fileName); //파일 경로
		FileInputStream in = new FileInputStream(file); //데이터를 가져오겠다
		FileCopyUtils.copy(in, response.getOutputStream()); //input으로 가져온 값을 output으로 보내라
		in.close();
	}
}
