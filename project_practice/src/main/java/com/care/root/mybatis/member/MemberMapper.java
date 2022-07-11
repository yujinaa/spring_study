package com.care.root.mybatis.member;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public MemberDTO userCheck(String id);//dto값 전달
	public ArrayList<MemberDTO> memberInfo();
	public int register(MemberDTO dto);
}
