package com.care.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.servicce.FileService;

@Controller
public class FileUploadController {
	@Autowired FileService fs;
	
	@RequestMapping("form")
	public String form() {
		return "uploadForm";
	}
	@PostMapping("upload")
	public String upload(MultipartHttpServletRequest mul) {
//		String id = mul.getParameter("id");
//		String name = mul.getParameter("name");
//		
//		//파일 가져오기
//		MultipartFile file = mul.getFile("file");
//		String originalName = file.getOriginalFilename();//실질적 파일 이름이 들어온다
//		System.out.println("id : " + id);
//		System.out.println("name : " + name);
//		System.out.println("originalName : " + originalName);
		fs.fileProcess(mul);
		return "redirect:form";
	}
	@GetMapping("views")
	public String view(Model model) {
		fs.getShoesImage(model);//서비스로 넘기기
		return "result";
	}

}
