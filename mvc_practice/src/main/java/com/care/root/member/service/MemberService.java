package com.care.root.member.service;

import org.springframework.ui.Model;

//interface는 @어노테이션 쓰지 않는다
public interface MemberService {
	public void test();
	public void register(String id, String pwd, String name);
	public void memberList(Model model);

}
