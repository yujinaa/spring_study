package com.care.get_post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	public MyController() {
		System.out.println("MyController 생성자 실행");//생성자 호출이 안되는데 해당 클래스가 빈이 등록되지 않았기 때문이다
		                                    //(경로가 root까지만 지정돼있기 때문에 get_post엔 어떤걸 써도 빈으로 등록 x)
		                                    //그렇기에 servlet-context.xml에 root대신 get_post로 바꾸거나 여러개 작성도 가능
	}
	//get방식
	@RequestMapping(value = "my/index", method = RequestMethod.GET)//get방식으로 오는 것만 받겠다
	public String index() {
		return "/get_post/index";
	}
	
	//get방식
	@GetMapping("my/result")    //@RequestMapping(value = "my/index", method = RequestMethod.GET)와 같다
	public String result_get(HttpServletRequest request, Model model) {//사용자 입력값은 전부 request객체에 저장
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("get방식으로 들어왔습니다");
		System.out.println("name : " + name );
		System.out.println("age  : " + age );
		
		model.addAttribute("method", request.getMethod()); //method방식 알려준다
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "/get_post/result";
	}
	
	//post방식
	//@PostMapping("my/result")
	@RequestMapping(value = "my/result", method = RequestMethod.POST)//post방식으로 오는 것만 받겠다
	public String result_post() {
		System.out.println("post방식으로 들어왔습니다");
		return "/get_post/result";
	}
}
