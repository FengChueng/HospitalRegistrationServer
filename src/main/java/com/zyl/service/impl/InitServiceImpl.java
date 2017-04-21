package com.zyl.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.zyl.domain.Department;
import com.zyl.domain.Doctor;
import com.zyl.domain.DoctorSchedule;
import com.zyl.domain.Hospital;
import com.zyl.exception.ValidException;
import com.zyl.service.AppointmentService;
import com.zyl.service.DepartmentService;
import com.zyl.service.DoctorService;
import com.zyl.service.HospitalService;
import com.zyl.service.InitService;
import com.zyl.service.PatientService;
import com.zyl.utils.Constant;
import com.zyl.utils.DateUtil;

@Repository
public class InitServiceImpl implements InitService {
	private static final Logger LOGGER = LoggerFactory.getLogger(InitService.class);
	@Autowired
	private HospitalService hospitalService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private AppointmentService appointmentService;

	@Value("${file.userportraint-path}")
	private String path;
	@Autowired
	public InitServiceImpl() {
	}

	@PostConstruct
	@Override
	public void init() {

		LOGGER.info("正在进行系统数据初始化...");
		initHospital();
		initPatient();
		modifyAccount();
		//makeAppointment();
		LOGGER.info("系统数据初始化完成...");
	}

	public void initHospital() {
		try {
			// 科室
			Set<Department> departments = new HashSet<>();
			for (int i = 0; i < 10; i++) {
				Department department = new Department();
				department.setCreateDate(DateUtil.StrToDate("2010-10-20 00:00:00").getTime());
				department.setDeptName("科室" + i);
				department.setInfo("科室" + i + "简介");
				// 医生
				Set<Doctor> doctors = new HashSet<>();
				for (int j = 0; j < 5; j++) {
					String birthday = "198" + i + "-" + j + "-1 00:00:00";
					int age = DateUtil.getAge(birthday);// 根据出生日期计算年龄
					Date date = DateUtil.StrToDate(birthday);
					long birthDay = date == null ? 0 : date.getTime();

					Set<DoctorSchedule> doctorSchedules = new HashSet<>();
					for (int k = 1; k <= 3; k++) {
						Calendar calendar = Calendar.getInstance();
						calendar.set(Calendar.YEAR, 2017 + i);
						calendar.set(Calendar.MONTH, 4 + j);
						calendar.set(Calendar.DAY_OF_MONTH, 19 + k);
						calendar.set(Calendar.HOUR_OF_DAY, 0);
						calendar.set(Calendar.MINUTE, 0);
						calendar.set(Calendar.SECOND, 0);
						long scheduleDate = calendar.getTimeInMillis();

						// 初始化
						DoctorSchedule doctorSchedule = new DoctorSchedule();
						doctorSchedule.setScheduleDate(scheduleDate);
						doctorSchedule.setStatus(Constant.DOCTOR_SCHEDULE_POSSIBLE);
						doctorSchedule.setMaxAppointmentCount(30);
						// 添加
						doctorSchedules.add(doctorSchedule);
					}
					// 初始化
					Doctor doctor = new Doctor();
					doctor.setDoctorAccount("100000000" + i + "" + j);
					doctor.setPassword("123456");
					doctor.setAge(age);
					doctor.setBirthDay(birthDay);
					doctor.setLevel(j % 2 == 0 ? Constant.DOCTOR_NORMAL : Constant.DOCTOR_PROFESSOR);
					doctor.setMobilePhone("100000000" + i + "" + j);
					doctor.setInfo("doctor" + j + "简介");
					doctor.setRealName("doctor" + j);
					doctor.setOrderCount(100 * j + 1);
					doctor.setSex(j % 2 == 0 ? Constant.SEX_MALE : Constant.SEX_FEMALE);
					doctor.setPortraint(path + "code.png");
					doctor.setDoctorSchedules(doctorSchedules);
					// 添加
					doctors.add(doctor);
				}
				department.setDoctors(doctors);
				// 初始化
				departments.add(department);
			}

			Hospital hospital = new Hospital();
			hospital.setHospitalName("绵阳精神病院");
			hospital.setLatitude(30.123f);
			hospital.setLongitude(10.123f);
			hospital.setLocation("四川成都");
			hospital.setInfo("hello word");
			hospital.setLevel(Constant.HOSPITAL_LEVEL_3_A);
			long createDate = DateUtil.StrToDate("2010-10-20 00:00:00").getTime();
			hospital.setCreateDate(createDate);
			hospital.setDepartments(departments);
			// 插入
			hospitalService.insertHospital(hospital);
		} catch (ValidException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	public void initPatient() {
		String mobilePhone = "18380586504";
		String password = "123456";
		try {
			patientService.register(mobilePhone, password);
		} catch (ValidException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	public void modifyAccount(){
		String mobilePhone = "18380586504";
		Date birthDay = DateUtil.parseStrToDate("1995-09-27");
		String realName = "张应龙";
		String portraint = path + "code.png";
		try {
			patientService.modifyPatientInfo(mobilePhone, realName, Constant.SEX_MALE, birthDay.getTime(), portraint, mobilePhone);
		} catch (ValidException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	public void makeAppointment() {
		String patientId = "18380586504";
		try {
			
			String doctorId = "";
			String scheduleId = "";
			long clicDate = 0;
			Set<Department> departments = hospitalService.queryByHospitalName("绵阳精神病院").getDepartments();
			for (Department department : departments) {
				Set<Doctor> doctors = department.getDoctors();
				for (Doctor doctor : doctors) {
					doctorId = doctor.getDoctorAccount();
					Set<DoctorSchedule> doctorSchedules = doctor.getDoctorSchedules();
					for (DoctorSchedule doctorSchedule : doctorSchedules) {
						scheduleId = doctorSchedule.getDoctorScheduleId();
						clicDate = doctorSchedule.getScheduleDate();
						break;
					}
					break;
				}
				break;
			}
			appointmentService.makeAppointment(patientId, doctorId, scheduleId, 100, clicDate, new Date().getTime(),
					"1231231");
		} catch (ValidException e) {
			e.printStackTrace();
		}
	}
}
