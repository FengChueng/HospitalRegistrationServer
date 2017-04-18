package com.zyl.test;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.BaseTest;
import com.zyl.domain.Appointment;
import com.zyl.domain.Doctor;
import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;
import com.zyl.service.AppointmentService;
import com.zyl.service.DoctorService;
import com.zyl.service.PatientService;
import com.zyl.utils.Constant;
import com.zyl.utils.DateUtil;

public class PatientTest extends BaseTest {

	@Autowired
	private PatientService patientService;

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private DoctorService doctorService;

	@Value("${file.userportraint-path}")
	private String path;

	@Test
	@Transactional
	public void addAccount() {
		String mobilePhone = "18380586504";
		String password = "123456";
		Date birthDay = DateUtil.parseStrToDate("1995-09-27");
		String realName = "张应龙";
		String portraint = path + "code.png";
		try {
			patientService.register(mobilePhone, password);
			patientService.modifyPatientInfo(mobilePhone, realName, Constant.SEX_MALE, birthDay.getTime(), portraint,
					mobilePhone);
		} catch (ValidException e) {
			e.printStackTrace();
		}
	}

	@Test @Ignore// 预约
	public void addAppointment() {
		String patientId = "18380586504";
		String doctorId = "1000";
		String doctorScheduleId = "";
		try {
			appointmentService.makeAppointment(patientId, doctorId, doctorScheduleId, 100, new Date().getTime(), new Date().getTime(),
					"1231231");
		} catch (ValidException e) {
			e.printStackTrace();
		}
	}
}
