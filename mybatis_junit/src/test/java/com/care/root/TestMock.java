package com.care.root;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ExecutorBeanDefinitionParser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.care.root.member.controller.MemberController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.concurrent.ExecutionException;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)//@RunWith :테스트 동작 , SpringRunner : 이걸로 동작시키겠다
@ContextConfiguration(locations={"classpath:TestMember.xml",
									"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class TestMock {
	@Autowired MemberController mc;
	MockMvc mock;//contoller정보를 mock에 넣어준다.그리고 초기화는 mc로 한다
	
	@Before//test실행전 먼저 처리(초기화 하고자하는 용도로사용=생성자느낌)
	public void setUp() {
		System.out.println("test 실행전");
		mock = MockMvcBuilders.standaloneSetup(mc).build();//mock객체 실행하게끔 컨트롤러 연결, build  : 실행
	}
	@Test
	public void testIndex() throws Exception{
		System.out.println("test코드 실행");
		mock.perform(get("/index")) //get방식으로 컨트롤러의 index페이지 요청 //경로앞에 무조건 /들어와야한다
		.andDo(print())//연결된 상태를 보여준다(계속 기능 추가 가능)
		.andExpect(status().isOk())//상태가 200이면 성공
		.andExpect(forwardedUrl("member/index")); //리턴경로가 member/index가 맞는지
	}
	@Test
	@Transactional(transactionManager = "txMgr") //롤백기능으로 되돌리기
	public void testInsert() throws Exception{
		mock.perform(post("/insert").param("id", "123").param("name", " 무야호"))
		.andDo(print())
		.andExpect(status().is3xxRedirection());//상태가 redirect면 성공
	}
	@Test
	public void testMemberview() throws Exception {
		mock.perform(get("/memberview")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("member/memberview"))
		.andExpect(model().attributeExists("list"));  //model에 데이터 중 list가 있냐
	}
}
