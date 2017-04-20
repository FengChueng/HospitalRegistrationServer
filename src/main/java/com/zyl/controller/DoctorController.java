package com.zyl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.bean.DoctorBean;
import com.zyl.bean.ResponseEntity;
import com.zyl.domain.Doctor;
import com.zyl.exception.ValidException;
import com.zyl.service.DoctorService;
import com.zyl.utils.Constant;

/**
 * 医生Controller(http请求)
 * 
 * @author Administrator
 *
 */
@RestController
//@RequestMapping(value = "/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping("/doctor")
	public String index() {
		return "doctorlogin";
	}
	
	/**
	 * 医生登录
	 * 
	 * @param account
	 * @param pwd
	 * @return
	 */
	@RequestMapping(value = "/doctor/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<DoctorBean> doctorLogin(@RequestParam(value = "account", required = true) String account,
			@RequestParam(value = "pwd", required = true) String pwd) {
		ResponseEntity<DoctorBean> responseEntity = new ResponseEntity<>();
		try {
			Doctor doctor = doctorService.login(account, pwd);
			/*List<DoctorSchedule> doctorSchedules = null;
			if (CollectionUtils.isEmpty(doctor.getDoctorSchedules())) {
				doctorSchedules = new ArrayList<>(doctor.getDoctorSchedules());
			}
			List<Appointment> appointments = null;
			if (CollectionUtils.isEmpty(doctor.getAppointments())) {
				appointments = new ArrayList<>(doctor.getAppointments());
			}*/
			DoctorBean doctorBean = new DoctorBean(doctor.getDoctorAccount(), doctor.getRealName(), doctor.getAge(),
					doctor.getSex(), doctor.getBirthDay(), doctor.getMobilePhone(), doctor.getPortraint(),
					doctor.getInfo(), doctor.getLevel(), doctor.getOrderCount());
			responseEntity.setData(doctorBean);
			responseEntity.setMsg("登录成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	/**
	 * 通过旧密码修改密码
	 * @param account
	 * @param pwd
	 * @param newPwd
	 * @return
	 */
	@RequestMapping(value = "/doctor/modifyPwd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<DoctorBean> modifyPwd(@RequestParam(value = "account", required = true) String account,
			@RequestParam(value = "pwd", required = true) String pwd,
			@RequestParam(value = "newPwd", required = true) String newPwd) {
		ResponseEntity<DoctorBean> responseEntity = new ResponseEntity<>();
		try {
			doctorService.modifyDoctorPwd(account, pwd, newPwd);
			responseEntity.setData(null);
			responseEntity.setMsg("修改成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	/**
	 * 重置密码
	 * @param account
	 * @param newPwd
	 * @return
	 */
	@RequestMapping(value = "/doctor/resetPwd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<DoctorBean> resetPwd(@RequestParam(value = "account", required = true) String account,
			@RequestParam(value = "newPwd", required = true) String newPwd) {
		ResponseEntity<DoctorBean> responseEntity = new ResponseEntity<>();
		try {
			doctorService.resetDoctorPwd(account, newPwd);
			responseEntity.setData(null);
			responseEntity.setMsg("修改成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/doctor/updateInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<DoctorBean> updateDoctorInfo(@RequestParam(value = "account", required = true) String account,
			@RequestParam(value = "realName") String realName, @RequestParam(value = "sex") int sex,
			@RequestParam(value = "realName") long birthDay, @RequestParam(value = "realName") String portraint,
			@RequestParam(value = "realName") String mobilePhone, @RequestParam(value = "realName") String info,
			@RequestParam(value = "realName") int level) {
		ResponseEntity<DoctorBean> responseEntity = new ResponseEntity<>();
		try {
			doctorService.modifyDoctorInfo(account, realName, sex, birthDay, portraint, mobilePhone, info, level);
			responseEntity.setMsg("修改成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/doctor/queryDoctorByDoctorAccount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<DoctorBean> queryByAccountId(
			@RequestParam(value = "account", required = true) String account) {
		ResponseEntity<DoctorBean> responseEntity = new ResponseEntity<>();
		try {
			Doctor doctor = doctorService.queryDoctorByDoctorAccount(account);
			//List<DoctorSchedule> doctorSchedules = null;
//			if (CollectionUtils.isEmpty(doctor.getDoctorSchedules())) {
//				doctorSchedules = new ArrayList<>(doctor.getDoctorSchedules());
//			}
//			List<Appointment> appointments = null;
//			if (CollectionUtils.isEmpty(doctor.getAppointments())) {
//				appointments = new ArrayList<>(doctor.getAppointments());
//			}
			DoctorBean doctorBean = new DoctorBean(doctor.getDoctorAccount(), doctor.getRealName(), doctor.getAge(),
					doctor.getSex(), doctor.getBirthDay(), doctor.getMobilePhone(), doctor.getPortraint(),
					doctor.getInfo(), doctor.getLevel(), doctor.getOrderCount());
			responseEntity.setData(doctorBean);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/doctor/queryByDeptIdAndName", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<DoctorBean> queryByAccountId(@RequestParam(value = "deptId", required = true) String deptId,
			@RequestParam(value = "doctorName", required = true) String doctorName) {
		ResponseEntity<DoctorBean> responseEntity = new ResponseEntity<>();
		try {
			Doctor doctor = doctorService.queryByDeptIdAndName(deptId, doctorName);
//			List<DoctorSchedule> doctorSchedules = null;
//			if (CollectionUtils.isEmpty(doctor.getDoctorSchedules())) {
//				doctorSchedules = new ArrayList<>(doctor.getDoctorSchedules());
//			}
//			List<Appointment> appointments = null;
//			if (CollectionUtils.isEmpty(doctor.getAppointments())) {
//				appointments = new ArrayList<>(doctor.getAppointments());
//			}
			DoctorBean doctorBean = new DoctorBean(doctor.getDoctorAccount(), doctor.getRealName(), doctor.getAge(),
					doctor.getSex(), doctor.getBirthDay(), doctor.getMobilePhone(), doctor.getPortraint(),
					doctor.getInfo(), doctor.getLevel(), doctor.getOrderCount());
			responseEntity.setData(doctorBean);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/doctor/queryDoctorsByDeptId", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DoctorBean>> queryByDeptId(
			@RequestParam(value = "deptId", required = true) String deptId) {
		ResponseEntity<List<DoctorBean>> responseEntity = new ResponseEntity<>();
		List<DoctorBean> doctorBeans = new ArrayList<>();
		try {
			List<Doctor> doctors = doctorService.queryDoctorsByDeptId(deptId);
			for (Doctor doctor : doctors) {
				//List<DoctorSchedule> doctorSchedules = null;
//				if (CollectionUtils.isEmpty(doctor.getDoctorSchedules())) {
//					doctorSchedules = new ArrayList<>(doctor.getDoctorSchedules());
//				}
//				List<Appointment> appointments = null;
//				if (CollectionUtils.isEmpty(doctor.getAppointments())) {
//					appointments = new ArrayList<>(doctor.getAppointments());
//				}
				DoctorBean doctorBean = new DoctorBean(doctor.getDoctorAccount(), doctor.getRealName(), doctor.getAge(),
						doctor.getSex(), doctor.getBirthDay(), doctor.getMobilePhone(), doctor.getPortraint(),
						doctor.getInfo(), doctor.getLevel(), doctor.getOrderCount());
				doctorBeans.add(doctorBean);
			}

			responseEntity.setData(doctorBeans);
			responseEntity.setMsg("查询成功");

		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/doctor/queryByNameLike", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DoctorBean>> queryByNameLike(
			@RequestParam(value = "doctorName", required = true) String doctorName) {
		ResponseEntity<List<DoctorBean>> responseEntity = new ResponseEntity<>();
		List<DoctorBean> doctorBeans = new ArrayList<>();
		try {
			List<Doctor> doctors = doctorService.queryDoctorLikeName(doctorName);
			for (Doctor doctor : doctors) {
//				List<DoctorSchedule> doctorSchedules = null;
//				if (CollectionUtils.isEmpty(doctor.getDoctorSchedules())) {
//					doctorSchedules = new ArrayList<>(doctor.getDoctorSchedules());
//				}
//				List<Appointment> appointments = null;
//				if (CollectionUtils.isEmpty(doctor.getAppointments())) {
//					appointments = new ArrayList<>(doctor.getAppointments());
//				}
				DoctorBean doctorBean = new DoctorBean(doctor.getDoctorAccount(), doctor.getRealName(), doctor.getAge(),
						doctor.getSex(), doctor.getBirthDay(), doctor.getMobilePhone(), doctor.getPortraint(),
						doctor.getInfo(), doctor.getLevel(), doctor.getOrderCount());
				doctorBeans.add(doctorBean);
			}
			responseEntity.setData(doctorBeans);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

}
