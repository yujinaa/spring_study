package com.care.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller      //연결 기능만 한다
public class MemberController {
	@Autowired //빈 자동주입(자료형보고 빈주입)
	MemberService ms; //controller는 service로 연결

	@RequestMapping("insert") //데이터를 추가한다는 가정
	public String insert(Model model) {//해당 메소드 실행 후 service로 연결 (사용자로부터 데이터를 받는다)
		//ms = new MemberService();//new라는 연산으로 객체만들기
		int result = ms.insert(); //MemberService로 넘어가서 insert만들기
		System.out.println("ms : " +ms);
		model.addAttribute("result",result); //addAttribute로 결과값을 받아와서 model에 저장
		return "di/index";//model에 저장된 값은 di의 index로 전달
	}
}
