package com.care.root;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}
	@RequestMapping("index")
	public String index() {
		return "re/index";
	}
	@RequestMapping("result")
	public String result(HttpServletRequest request,Model model,RedirectAttributes rs) {//redirect로 값 바로 전달시 써야한다
		String id = request.getParameter("id");
		if(id.equals("abc")) {//인증성공시
			//model.addAttribute("result","로그인 성공!");//model에 값 저장
			rs.addFlashAttribute("result","리다이렉트 값 전달");
			return "redirect:rsOK";//인증성공시 여기로
		}else {
			return "redirect:rsNO";//인증실패시 여기로

		}
	}
	@RequestMapping("rsOK")
	public String rsOK() {
		return "re/rsOK";
	}
	@RequestMapping("rsNO")
	public String rsNO() {
		return "re/rsNO";
	}
}
