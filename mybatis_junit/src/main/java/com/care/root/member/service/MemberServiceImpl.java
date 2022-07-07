package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;

@Service
public class MemberServiceImpl  implements MemberService {

	@Autowired MemberDAO mapper; //db쪽으로 연결만 하기 때문에 보통 mapper라고 짓는다
	public void insertMember(MemberDTO dto) {
		mapper.insertMember(dto);
	}
	public void memberView(Model model) {
		model.addAttribute("lsit", mapper.memberView());
	}
}
