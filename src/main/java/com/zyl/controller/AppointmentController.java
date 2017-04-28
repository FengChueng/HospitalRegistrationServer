package com.zyl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.bean.AppointmentDetail;
import com.zyl.bean.ResponseEntity;
import com.zyl.domain.Appointment;
import com.zyl.exception.ValidException;
import com.zyl.service.AppointmentService;
import com.zyl.utils.Constant;

@RestController
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	@RequestMapping("/appointment")
	public String index() {
		return "appointment";
	}
	
	
	/**
	 * 完成预约
	 * @param appointId
	 * @return
	 */
	@RequestMapping(value = "/appointment/completeAppointment", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Appointment> completeAppointment(
			@RequestParam(value = "appointId", required = true) String appointId,
			@RequestParam(value = "doctorAdvice", required = true) String doctorAdvice) {
		ResponseEntity<Appointment> responseEntity = new ResponseEntity<>();
		try {
			appointmentService.completeAppointment(appointId, doctorAdvice);
			responseEntity.setData(null);
			responseEntity.setMsg("就诊结束");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
	
	
	@RequestMapping(value = "/appointment/cancelAppointment", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Appointment> cancelAppointment(
			@RequestParam(value = "appointId", required = true) String appointId) {
		ResponseEntity<Appointment> responseEntity = new ResponseEntity<>();
		try {
			appointmentService.cancelAppointment(appointId);
			responseEntity.setData(null);
			responseEntity.setMsg("取消成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/appointment/makeappointment", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Appointment> makeAppointment(
			@RequestParam(value = "hospitalId", required = true) String hospitalId,
			@RequestParam(value = "deptId", required = true) String deptId,
			@RequestParam(value = "patientId", required = true) String patientId,
			@RequestParam(value = "doctorId", required = true) String doctorId,
			@RequestParam(value = "doctorScheduleId", required = true) String doctorScheduleId) {
		ResponseEntity<Appointment> responseEntity = new ResponseEntity<>();
		try {
			appointmentService.makeAppointment(hospitalId,deptId,patientId, doctorId, doctorScheduleId);
			responseEntity.setData(null);
			responseEntity.setMsg("预约成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	/**
	 * appointId查询预约
	 * @param appointId
	 * @return
	 */
	@RequestMapping(value = "/appointment/queryByAppointId", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<AppointmentDetail> queryByAppointId(
			@RequestParam(value = "appointId", required = true) String appointId) {
		ResponseEntity<AppointmentDetail> responseEntity = new ResponseEntity<>();
		try {
			AppointmentDetail appointment = appointmentService.queryByAppointId(appointId);
			responseEntity.setData(appointment);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
	
	/**
	 * 按DoctorId查询医生所有预约
	 * @param doctorId
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/appointment/queryByDoctorId", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Appointment>> queryByDoctorId(
			@RequestParam(value = "doctorId", required = true) String doctorId,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "30") int size) {
		ResponseEntity<List<Appointment>> responseEntity = new ResponseEntity<>();
		List<Appointment> appointments = null;
		try {
			appointments = appointmentService.queryByDoctorId(doctorId);
			responseEntity.setData(appointments);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
	
	/**
	 * 按状态查询医生的预约
	 * @param doctorId
	 * @param status
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/appointment/queryByDoctorIdAndStatus", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Appointment>> queryByDoctorIdAndStatus(
			@RequestParam(value = "doctorId", required = true) String doctorId,
			@RequestParam(value = "status", required = true) int status,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "30") int size) {
		ResponseEntity<List<Appointment>> responseEntity = new ResponseEntity<>();
		List<Appointment> appointments = null;
		try {
			appointments = appointmentService.queryByDoctorIdAndStatus(doctorId, status);
			responseEntity.setData(appointments);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
	
	
	
	/**
	 * 查询病人的所有预约
	 * @param patientId
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/appointment/queryByPatientId", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Appointment>> queryByPatientId(
			@RequestParam(value = "patientId", required = true) String patientId,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "30") int size) {
		ResponseEntity<List<Appointment>> responseEntity = new ResponseEntity<>();
		List<Appointment> appointments = null;
		try {
			appointments = appointmentService.queryByPatientId(patientId);
			responseEntity.setData(appointments);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
	
	/**
	 * 按状态查询病人的预约
	 * @param patientId
	 * @param status
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/appointment/queryByPatientIdAndStatus", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Appointment>> queryByPatientIdAndStatus(
			@RequestParam(value = "patientId", required = true) String patientId,
			@RequestParam(value = "status", required = true) int status,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "30") int size) {
		ResponseEntity<List<Appointment>> responseEntity = new ResponseEntity<>();
		List<Appointment> appointments = null;
		try {
			appointments = appointmentService.queryByPatientIdAndStatus(patientId, status);
			responseEntity.setData(appointments);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
	
}
