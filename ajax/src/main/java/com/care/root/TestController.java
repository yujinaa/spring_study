package com.care.root;

import java.lang.ProcessHandle.Info;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//요청돼는 방식을 살펴보자

@RestController//페이지가아니라 데이터를 돌려주는 방식(자동적으로 @ResponseeBody가 생략되있다)
public class TestController {
	static int cnt = 0; //db가 연결돼 있다는 가정 하에 만든 코드
	static Map<String, InfoDTO> DBMap = new HashMap<String, InfoDTO>();
	@GetMapping(value = "rest",produces = "application/json;charset=utf-8")
	public ArrayList<InfoDTO> users(){
		ArrayList<InfoDTO> list = new ArrayList<InfoDTO>();
		for(int i =cnt; i<cnt+10;i++) {
			InfoDTO info = new InfoDTO();
			info.setName("홍길동" + i);
			info.setAge(10 +i);
			list.add(info);
			DBMap.put("홍길동" + i, info);
		}
		cnt += 10;
		return list;
	}
	
	
	@GetMapping(value = "rest",produces = "application/json;charset=utf-8")
	public String get() {
		return "{\"execute\" : \"get 데이터 요청할 떄 사용\"}"; //키와 값
	}
	@PostMapping(value = "rest",produces = "application/json;charset=utf-8")
	public String post() {
		return "{\"execute\" : \"post 데이터 추가할 떄 사용\"}";
	}
	@PutMapping(value = "rest",produces = "application/json;charset=utf-8")
	public String put() {
		return "{\"execute\" : \"put 데이터 수정할 떄 사용\"}";
	}
	@DeleteMapping(value = "rest",produces = "application/json;charset=utf-8")
	public String delete() {
		return "{\"execute\" : \"delete 데이터 삭제할 떄 사용\"}";
	}

}
