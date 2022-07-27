package com.care.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;

import com.care.root.mapper.TestMapper;

@Service
public class TestServiceImpl {
	@Autowired TestMapper mapper;
	
	@Transactional
	public void buy(Model model, int num) {
		System.out.println("buy 서비스 실행");
		int[] result = {0,0};
		try {
			result[0] = mapper.userInsert(num);
			result[1] = mapper.systemInsert(num);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//db저장시 문제생기면 데이터를 원래대로 롤백하겠다
			e.printStackTrace();
		}
		model.addAttribute("result",result);
	}
    public void dbResult(Model model) {
    	System.out.println("dbResult 서비스 실행");
        model.addAttribute("user",mapper.userDbResult());
        model.addAttribute("system",mapper.systemDbResult());
}
}
