package com.care.root.member.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.common.MemberSessionName;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("member")//공통경로라 한번에 적음
public class MemberController implements MemberSessionName{//공통모듈인 로그인세션 상속받아 사용하기
	@Autowired MemberService ms; //넘어갈 서비스 연결
	@GetMapping("/login")
	public String login() {
		System.out.println("멤버 로그인 연결");
		return "member/login";
	}
	@PostMapping("/user_check")
	public String userCheck(@RequestParam String id, @RequestParam String pw, //사용자로부터 id,pwd넘어오면
							@RequestParam(required = false) String autoLogin,//값이 없으면 null값 처리
							RedirectAttributes rs) {
		int result = ms.userCheck(id, pw);//service로 id,pw넘긴다
		System.out.println("autoLogin : " + autoLogin);
		if(result == 0) {//로그인 성공시
			rs.addAttribute("id",id);//jsp까지 연동, 컨트롤러까지만 연결할거면 model도 사용가능
			rs.addAttribute("autoLogin",autoLogin);
			return "redirect:successLogin";
		}else {//로그인 실패시
			return "redirect:login";
		}		
	}
	@GetMapping("/successLogin")
	public String successLogin(@RequestParam String id, 
								@RequestParam(required = false) String autoLogin,
								HttpSession session, 
								HttpServletResponse response) {
		System.out.println("id :" + id);
		System.out.println("autoLogin :" + autoLogin);
		session.setAttribute(LOGIN, id);// =loginUser(로그인한 사용자)
		if(autoLogin != null) {//사용자가 체크박스를 체크했다면
			int limitTime = 60*60*24*90;//90일
			Cookie loginCookie = new Cookie("loginCookie",session.getId());//session.getId() :거의 유일한 값
			loginCookie.setPath("/");
			loginCookie.setMaxAge(limitTime);
			response.addCookie(loginCookie);
			
			Calendar cal = Calendar.getInstance();//캘린더를 이용해야 시간 이용 가능
			cal.setTime(new Date());//캘린더 형태로 시간 변환
			cal.add(Calendar.MONTH, 3);//현재시간에서 3개월 후 설정
			
			java.sql.Date limitDate = new java.sql.Date(cal.getTimeInMillis());//자바 현재시간을 sql로 변환 
			ms.keepLogin(session.getId(), limitDate, id);
		}
		return "member/successLogin";
	}
	@GetMapping("logout")
	public String logout(HttpSession session,
						HttpServletResponse response,
						@CookieValue(value="loginCookie",required = false) Cookie loginCookie) {
		//자동로그아웃
		if(session.getAttribute(LOGIN) !=null){//세션이 있는 사용자라면
			if(loginCookie != null) {
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				ms.keepLogin("nan", new java.sql.Date(System.currentTimeMillis()), (String)session.getAttribute(LOGIN));//nan:원래 쿠키값, date:시간설정, LOGIN:비교할 아이디
			}
	}
			session.invalidate();//세션 종료
			return "redirect:/index";//인덱스 페이지로 이동
	}
	@GetMapping("memberInfo")
	public String memberInfo(Model model, HttpSession session) {
//		if(session.getAttribute(LOGIN)!=null) {//로그인이 되어있다면
			ms.memberInfo(model);//ms로 값 넘기기, 여기 model은 모든정보
			return "member/memberInfo";			
//		}
//		return "redirect:login";//로그인 안되있을경우
	}
	@GetMapping("info")
	public String info(@RequestParam String id, Model model) {
		ms.info(model, id);//ms로 model, id 넘기기, 여기서의 model은 한사람 정보
		return "member/info";
	}
	@GetMapping("register_form")
	public String registerForm() {
		return "member/register";
	}
	@PostMapping("register")
	public String register(MemberDTO dto) {
		int result = ms.register(dto);
		if(result == 1)//성공
			return "redirect:login";
		return "redirect:register_form"; //실패
	}
}
