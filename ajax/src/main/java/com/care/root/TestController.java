package com.care.root;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//요청돼는 방식을 살펴보자

@RestController//페이지가아니라 데이터를 돌려주는 방식(자동적으로 @ResponseeBody가 생략되있다)
public class TestController {
	@GetMapping(value = "rest",produces = "application/json;charset=utf-8")
	public String get() {
		return "{\"execute\" : \"get 데이터 요청할 떄 사용\"}";
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
