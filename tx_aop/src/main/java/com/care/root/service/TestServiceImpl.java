package com.care.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.mapper.TestMapper;

@Service
public class TestServiceImpl {
	@Autowired TestMapper mapper;
	public void buy(Model model, int num) {
		int[] result = {0,0};
		try {
			result[0] = mapper.userInsert(num);
			result[1] = mapper.systemInsert(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("result",result);
	}
    public void dbResult(Model model) {
        model.addAttribute("user",mapper.userDbResult());
        model.addAttribute("system",mapper.systemDbResult());
}
}
