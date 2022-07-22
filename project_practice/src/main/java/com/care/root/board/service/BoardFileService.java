package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface BoardFileService {
	public String getMessage(int num, HttpServletRequest request);
	public static final String IMAGE_REPO = "C:/spring/image_repo";
	public String saveFile(MultipartFile file);
}
