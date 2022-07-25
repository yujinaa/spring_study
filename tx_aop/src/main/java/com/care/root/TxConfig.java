package com.care.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class TxConfig {
	@Autowired HikariDataSource ds;
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager txMgr = new DataSourceTransactionManager();
		txMgr.setDataSource(ds);
		return txMgr;
	}
}
//이코드와 위의 코드는 같다
//<bean name="txMgr" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
//<property name="dataSource" ref="ds" />
//</bean>
