package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@ : 어노테이션은 서버쪽에서 알아볼 수 있게 해주는 것
@Controller //컨트롤러 어노테이션이 있어야지만 컨트롤러로 인식한다!!!
public class MyController {
	@RequestMapping(value="index")//index요청이 들어오면 이곳에서 받겠다 (web서버와 맵핑으로 url경로)
	public String memberIndex() { //받은 메소드 실행
		return "member/index";    //member폴더의 index를 요청  (views와 맵핑으로 파일 경로)
	}
	
	//방벙1.
	@RequestMapping("logout") //값이 한개만 들어가면 value 생략가능
	public String memberLogout(Model model) {//model 객체를 자동 주입
		model.addAttribute("key","로그아웃 되었습니다");//model에 키와 값을 넣고 저장값 받아온다
		return "member/logout"; 
	}
	//방법2.
	@RequestMapping("/login")
	public ModelAndView memberLogin() {//model과 다르게 ()에 매개변수를 적지 않는다
		ModelAndView mv = new ModelAndView(); //그래서 객체를 직접 만들고
		mv.addObject("login","로그인 성공!");   //전달할 값(= addAttribute)
		mv.setViewName("member/login");      //modelandview에 경로를 저장해서
		return mv;                           //보내준다
	}

}
