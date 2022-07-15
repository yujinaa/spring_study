package com.care.root.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
//스케줄러 : 특정 시간, 특정 분, 특정 날짜에 해당하는 메소드를 실행해라(패치를 의미)
@Configuration
@EnableScheduling
public class MyScheduler {
	@Scheduled(cron="*/10 * * * * *")//*/10 : 초, * : 분, *:시, *:일, *:월 : *:년 
	public void testSc() {
		System.out.println("10초에 한번씩 실행");
	}

}
