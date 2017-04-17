package com.zyl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.domain.Account;
import com.zyl.exception.ValidException;
import com.zyl.service.AccountService;

@RestController
@RequestMapping(value = "/account")
public class HelloWorldController {

	@Autowired
	private AccountService accountService;

	@RequestMapping("/hello")
	public String index() {
		return "Hello World!";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public Account login(@RequestParam(value = "account", required = true) String name,
			@RequestParam(value = "pwd", required = true) String pwd) {
		Account account = null;
		try {
			account = accountService.loginAccount(name, pwd);
		} catch (ValidException e) {
			e.printStackTrace();
		}
		return account;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public void register(@RequestParam(value = "account", required = true) String name,
			@RequestParam(value = "pwd", required = true) String pwd) {
		
	}
}
