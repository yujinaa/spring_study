package com.care.root.member.service;

import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public int userCheck(String id,String pw); //컨트롤러에서 int로 넘겼으니 반환값도 int로 작성
	public void memberInfo(Model model); //리턴값 없으니 void
	public void info(Model model,String id);
	public int register(MemberDTO dto);

}
