package com.care.root.servicce;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.ShoesDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService {
	@Autowired FileMapper fm;

	public void fileProcess(MultipartHttpServletRequest mul) {
		ShoesDTO dto =new ShoesDTO();
		dto.setId(mul.getParameter("id"));
		dto.setName(mul.getParameter("name"));

		MultipartFile file = mul.getFile("file");
		if(file.getSize() != 0) {// !file.isEmpty() 이렇게 표현 가능
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-"); //이미지 이름이 같으면 현재 시간 부여되게해야 덮어쓰지 않는다
			Calendar calendar = Calendar.getInstance();

			String sysFileName = format.format(calendar.getTime()) + file.getOriginalFilename();
			sysFileName += file.getOriginalFilename(); 
			//2022111512-파일이름 
			
			//파일 선택했을 때 변경된 이름
			dto.setImgName(sysFileName);//dto에 파일 이미지 넣기

			File saveFile = new File(IMAGE_REPO+"/" + sysFileName);

			try {
				file.transferTo(saveFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} //if문이 try,catch까지 묶여야 된다
		else {dto.setImgName("nan");//파일 선택하지 않았을 때 비어있는 이름
		}
		fm.saveData(dto); //데이터 넘기기
	}
}