package com.care.root;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class MemberDAO {
	public MemberDAO() {
		System.out.println("DAO 생성자 실행");
	}
	public int insert() {//사용자로부터 넘겨받은 데이터를 db에 저장
		System.out.println("db에 저장되었습니다");
		return 1; //성공하면 1, 실패하면 0 반환
	}
}
