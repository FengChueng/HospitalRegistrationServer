package com.zyl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;
import com.zyl.service.PatientService;

@RestController
@RequestMapping(value = "/account")
public class HelloWorldController {

	@Autowired
	private PatientService patientService;

	@RequestMapping("/hello")
	public String index() {
		return "Hello World!";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public Patient patientLogin(@RequestParam(value = "account", required = true) String name,
			@RequestParam(value = "pwd", required = true) String pwd) {
		Patient patient = null;
		/*try {
			patientService.
		} catch (ValidException e) {
			e.printStackTrace();
		}*/
		return patient;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public void register(@RequestParam(value = "account", required = true) String name,
			@RequestParam(value = "pwd", required = true) String pwd) {
		
	}
}
