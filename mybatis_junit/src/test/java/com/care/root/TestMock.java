package com.care.root;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)//@RunWith :테스트 동작 , SpringRunner : 이걸로 동작시키겠다
@ContextConfiguration(locations={"classpath:TestMember.xml",
									"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class TestMock {
	@Before//test실행전 먼저 처리(초기화 하고자하는 용도로사용=생성자느낌)
	public void setUp() {
		System.out.println("test 실행전");
	}
	@Test
	public void testIndex() {
		System.out.println("test코드 실행");
	}

}
