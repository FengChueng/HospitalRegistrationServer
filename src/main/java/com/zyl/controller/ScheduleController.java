package com.zyl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.bean.ResponseEntity;
import com.zyl.domain.DoctorSchedule;
import com.zyl.exception.ValidException;
import com.zyl.service.DoctorScheduleService;
import com.zyl.utils.Constant;

@RestController
public class ScheduleController {
	
	@Autowired
	private DoctorScheduleService doctorScheduleService;
	
	@RequestMapping("/schedule")
	public String index() {
		return "schedule";
	}

	/**
	 * doctorId查询预约
	 * @param hospitalId
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/schedule/queryAllScheduleByDoctorAccount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DoctorSchedule>> queryAllScheduleByDoctorAccount(
			@RequestParam(value = "doctorAccount", required = true) String doctorAccount) {
		ResponseEntity<List<DoctorSchedule>> responseEntity = new ResponseEntity<>();
		
		try {
			List<DoctorSchedule> doctorSchedules = doctorScheduleService.queryAllScheduleByDoctorAccount(doctorAccount);
			responseEntity.setData(doctorSchedules);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
	
	
	@RequestMapping(value = "/schedule/queryScheduleById", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<DoctorSchedule> queryScheduleById(
			@RequestParam(value = "doctorScheduleId", required = true) String doctorScheduleId) {
		ResponseEntity<DoctorSchedule> responseEntity = new ResponseEntity<>();
		try {
			DoctorSchedule  doctorSchedule = doctorScheduleService.queryScheduleById(doctorScheduleId);
			responseEntity.setData(doctorSchedule);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/schedule/addScheduleByDoctorAccount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<DoctorSchedule> addScheduleByDoctorAccount(@RequestParam(value = "doctorAccount", required = true) String doctorAccount,
			@RequestParam(value = "status", required = true) int status,
			@RequestParam(value = "maxAppointmentCount", required = true) int maxAppointmentCount,
			@RequestParam(value = "scheduleDate", required = true) long scheduleDate){
		ResponseEntity<DoctorSchedule> responseEntity = new ResponseEntity<>();
		try {
			doctorScheduleService.addScheduleByDoctorAccount(doctorAccount, status, maxAppointmentCount, scheduleDate);
			responseEntity.setData(null);
			responseEntity.setMsg("添加工作日程成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
}
