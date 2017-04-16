package com.zyl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.domain.Account;
import com.zyl.exception.ValidException;
import com.zyl.service.AccountService;

@RestController
public class HelloWorldController {

	@Autowired
	private AccountService accountService;
	
    @RequestMapping("/hello")
    public String index() {
        return "Hello World!";
    }
    
    @RequestMapping("/login")
    @ResponseBody
    public Account login(){
    	Account account = null;
    	try {
			account = accountService.loginAccount("18380586504", "123456");
		} catch (ValidException e) {
			e.printStackTrace();
		}
    	return account;
    }
}
