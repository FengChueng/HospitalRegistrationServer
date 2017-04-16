package com.zyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zyl.service.AccountService;
import com.zyl.service.impl.AccountServiceImpl;

@SpringBootApplication
@ComponentScan(basePackages = { "com.zyl" })
@EntityScan(basePackages = { "com.zyl.domain" })
@EnableJpaRepositories(basePackages = { "com.zyl.jpa" })
@EnableTransactionManagement
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringbootdemoApplication.class);
		application.setAddCommandLineProperties(false);//屏蔽命令行访问属性
		application.run(args);
	}
//	@Bean
//	public AccountService accountService(){
//		return new AccountServiceImpl();
//	}
	
}
