package com.zyl.service;

import java.util.List;

import com.zyl.domain.DoctorSchedule;
import com.zyl.exception.ValidException;

public interface DoctorScheduleService {
	
	
	void addScheduleByDoctorAccount(String doctorAccount);
	
	void updateScheduleByDoctorAccount(String doctorAccount);
	
	List<DoctorSchedule> queryAllScheduleByDoctorAccount(String doctorAccount) throws ValidException;
	
	DoctorSchedule queryScheduleById(String doctorScheduleId) throws ValidException;
	
}
