package com.care.root.servicce;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	public static final String IMAGE_REPO = "C:/spring/image_repo"; //이미지 저장소(이 경로에 파일 저장하겠다)
	public void fileProcess(MultipartHttpServletRequest mul); 

}
