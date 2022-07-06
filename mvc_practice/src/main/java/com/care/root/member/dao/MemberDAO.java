package com.care.root.member.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.dto.UserCheckDTO;

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
	public ArrayList<MemberDTO> memberList(){
		return list;
	}
	public UserCheckDTO check(String id, String pwd) {
		UserCheckDTO dto = new UserCheckDTO();
		if(list.size() != 0) {
			for(MemberDTO m : list) {
				if(id.equals(m.getId())) {
					if(pwd.equals(m.getPwd())) {
						dto.setChk(0);//로그인성공
						dto.setName(m.getName());//로그인 성공시 이름 저장
						return dto;
					}
					dto.setChk(1);//비번 틀림
				}
			}
		}
		if(dto.getChk() ==0) dto.setChk(-1);//아이디없음
		return dto;
	}
	public MemberDTO memberInfo(String id) {//가져온 id값이
		for(MemberDTO dto : list) {//list에 저장되있는 id와
			if(dto.getId().equals(id)) { //같은값을 찾고
				return dto;//결과값을 dto에 돌려주고
			}
		}
		return null;//결과값이 없다면 null값을 돌려준다
	}
}