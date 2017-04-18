package com.zyl.service;

import java.util.List;

import com.zyl.domain.DoctorSchedule;
import com.zyl.exception.ValidException;

public interface DoctorScheduleService {
	
	List<DoctorSchedule> queryAllScheduleByDoctorAccount(String doctorAccount) throws ValidException;
	
	DoctorSchedule queryScheduleById(String doctorScheduleId) throws ValidException;

	void addScheduleByDoctorAccount(String doctorAccount, int status, int maxAppointmentCount, long scheduleDate)
			throws ValidException;

	void updateScheduleById(String scheduleId, int status, long scheduleDate) throws ValidException;
	
}
