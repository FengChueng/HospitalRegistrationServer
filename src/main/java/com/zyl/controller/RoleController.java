package com.zyl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.service.DoctorService;
import com.zyl.service.PatientService;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
	
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<Account> login(@RequestParam(value = "account", required = true) String name,
//			@RequestParam(value = "pwd", required = true) String pwd) {
//		ResponseEntity<Account> responseEntity = new ResponseEntity<>();
//		Account account = null;
//		try {
//			account = accountService.loginAccount(name, pwd);
//			responseEntity.setData(account);
//			responseEntity.setMsg("登录成功");
//		} catch (ValidException e) {
//			responseEntity.setStatus(Constant.FIAL);
//			responseEntity.setMsg(e.getMessage());
//		}
//		return responseEntity;
//	}
//
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<Account> register(@RequestParam(value = "account", required = true) String name,
//			@RequestParam(value = "pwd", required = true) String pwd) {
//		ResponseEntity<Account> responseEntity = new ResponseEntity<>();
//		Account account = null;
//		try {
//			account = accountService.loginAccount(name, pwd);
//			responseEntity.setData(account);
//			responseEntity.setMsg("登录成功");
//		} catch (ValidException e) {
//			responseEntity.setStatus(Constant.FIAL);
//			responseEntity.setMsg(e.getMessage());
//		}
//		return responseEntity;
//	}
}
