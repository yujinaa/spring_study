package com.care.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileUploadController {
	@RequestMapping("form")
	public String form() {
		return "uploadForm";
	}

}
