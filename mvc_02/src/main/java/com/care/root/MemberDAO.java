package com.care.root;

public class MemberDAO {
	public int insert() {//사용자로부터 넘겨받은 데이터를 db에 저장
		System.out.println("db에 저장되었습니다");
		return 1; //성공하면 1, 실패하면 0 반환
	}
}
