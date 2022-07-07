package com.care.root.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;


@Controller
public class MemberController {
	@Autowired MemberService ms;
	@GetMapping("index")
	public String index() {
		return "member/index";
	}
	@GetMapping("insertview")
	public String insertView() {
		return "member/inserview";
	}
	@PostMapping("insert")
	public String insert(MemberDTO dto) {
		ms.insertMember(dto);
		return "redirect:index";
	}
	@GetMapping("memberview")
	public String memberview(Model model) {//데이터 가져오기위해 model
		ms.memberView(model);
			return "member/memberview";
		}
}
