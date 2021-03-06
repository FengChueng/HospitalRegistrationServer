package com.zyl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.bean.PatientBean;
import com.zyl.bean.ResponseEntity;
import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;
import com.zyl.service.PatientService;
import com.zyl.utils.Constant;

/**
 * 病人Controller(http请求)
 * 
 * @author Administrator
 *
 */
@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping("/loginPage")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/registerpage")
	public String registerPage() {
		return "register";
	}

	// 病人controller
	@RequestMapping(value = "/patient/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PatientBean> register(@RequestParam(value = "account", required = true) String account,
			@RequestParam(value = "pwd", required = true) String pwd) {
		ResponseEntity<PatientBean> responseEntity = new ResponseEntity<>();
		try {
			patientService.register(account, pwd);
			// List<Appointment> appointments = null;
			// if (CollectionUtils.isEmpty(patient.getAppointments())) {
			// appointments = new ArrayList<>(patient.getAppointments());
			// }
			// PatientBean patientBean = new
			// PatientBean(patient.getPatientAccount(), patient.getRealName(),
			// patient.getAge(), patient.getSex(), patient.getBirthDay(),
			// patient.getMobilePhone(),
			// patient.getPortraint(), appointments);
			responseEntity.setData(new PatientBean(account, account));
			responseEntity.setMsg("注册成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/patient/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PatientBean> login(@RequestParam(value = "account", required = true) String account,
			@RequestParam(value = "pwd", required = true) String pwd) {
		ResponseEntity<PatientBean> responseEntity = new ResponseEntity<>();
		try {
			Patient patient = patientService.login(account, pwd);
			/*List<Appointment> appointments = null;
			if (CollectionUtils.isEmpty(patient.getAppointments())) {
				appointments = new ArrayList<>(patient.getAppointments());
			}*/
//			PatientBean patientBean = new PatientBean(patient.getPatientAccount(), patient.getRealName(),
//					patient.getAge(), patient.getSex(), patient.getBirthDay(), patient.getMobilePhone(),
//					patient.getPortraint(), appointments);
			PatientBean patientBean = new PatientBean(patient.getPatientAccount(), patient.getRealName(),
					patient.getAge(), patient.getSex(), patient.getBirthDay(), patient.getMobilePhone(),
					patient.getPortraint());
			responseEntity.setData(patientBean);
			responseEntity.setMsg("登录成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/patient/queryByPatientId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PatientBean> queryByPatientId(
			@RequestParam(value = "account", required = true) String account) {
		ResponseEntity<PatientBean> responseEntity = new ResponseEntity<>();
		try {
			Patient patient = patientService.queryByPatientId(account);
//			List<Appointment> appointments = null;
//			if (CollectionUtils.isEmpty(patient.getAppointments())) {
//				appointments = new ArrayList<>(patient.getAppointments());
//			}
			PatientBean patientBean = new PatientBean(patient.getPatientAccount(), patient.getRealName(),
					patient.getAge(), patient.getSex(), patient.getBirthDay(), patient.getMobilePhone(),
					patient.getPortraint());
			responseEntity.setData(patientBean);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/patient/modifyPwd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PatientBean> modifyPwd(@RequestParam(value = "account", required = true) String account,
			@RequestParam(value = "account", required = true) String oldPwd,
			@RequestParam(value = "account", required = true) String newPwd) {
		ResponseEntity<PatientBean> responseEntity = new ResponseEntity<>();
		try {
			patientService.modifyPatientPwd(account, oldPwd, newPwd);
			responseEntity.setData(null);
			responseEntity.setMsg("修改成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/patient/resetPwd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PatientBean> resetPwd(@RequestParam(value = "account", required = true) String account,
			@RequestParam(value = "account", required = true) String newPwd) {
		ResponseEntity<PatientBean> responseEntity = new ResponseEntity<>();
		try {
			patientService.resetPatientPwd(account, newPwd);
			responseEntity.setData(null);
			responseEntity.setMsg("修改成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/patient/modifyPatientInfo", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public ResponseEntity<PatientBean> modifyPatientInfo(
			@RequestParam(value = "account", required = true) String account,
			@RequestParam(value = "oldPwd", required = false) String oldPwd,
			@RequestParam(value = "newPwd", required = false) String newPwd, 
			@RequestParam(value = "realName", required = false) String realName,
			@RequestParam(value = "sex", required = false) Integer sex,
			@RequestParam(value = "birthDay", required = false) Long birthDay,
			@RequestParam(value = "portraint", required = false) String portraint, 
			@RequestParam(value = "mobilePhone", required = false) String mobilePhone) {
		ResponseEntity<PatientBean> responseEntity = new ResponseEntity<>();
		try {
			patientService.modifyPatientInfo(account, realName, sex, birthDay, portraint, mobilePhone);
			Patient patient = patientService.queryByPatientId(account);
//			List<Appointment> appointments = null;
//			if (CollectionUtils.isEmpty(patient.getAppointments())) {
//				appointments = new ArrayList<>(patient.getAppointments());
//			}
			PatientBean patientBean = new PatientBean(patient.getPatientAccount(), patient.getRealName(),
					patient.getAge(), patient.getSex(), patient.getBirthDay(), patient.getMobilePhone(),
					patient.getPortraint());
			responseEntity.setData(patientBean);
			responseEntity.setMsg("修改成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
}
