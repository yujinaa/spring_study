package com.care.root.member.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.root.member.dto.MemberDTO;

@Repository
public class MemberDAO {
	ArrayList<MemberDTO> list;
	public MemberDAO() {
		System.out.println("dao 생성자 실행");
		list = new ArrayList<MemberDTO>();
	}
	public void register(MemberDTO dto) {
		list.add(dto);//dto저장
	}

}
