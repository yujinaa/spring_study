package com.care.root.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration //설정하는 값,내용(설정하는 값을 빈으로 만들어준다, xml에서 만든 것을 자바 코드로 만드는 방식)
public class FileConfig {
	//파일 업로드 빈 만들기
	@Bean //파일 업로드할땐 무조건 빈을 만들어줘야 처리 가능
	public CommonsMultipartResolver multipartResolver() {//CommonsMultipartResolver :자료형을 return 으로 돌려주겟다
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		mr.setMaxUploadSize(52428800); //50MB , 업로드 파일 크기 설정
		mr.setDefaultEncoding("utf-8"); //한글설정
		return mr;
	}
}
