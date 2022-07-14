package com.care.root.servicce;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FileServiceImpl implements FileService {
	public void fileProcess(MultipartHttpServletRequest mul) {
		MultipartFile file = mul.getFile("file");
		
		File saveFile = new File(IMAGE_REPO+"/" + file.getOriginalFilename());
		
		try {
			file.transferTo(saveFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
