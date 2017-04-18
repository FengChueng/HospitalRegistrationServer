package com.zyl.utils;

/**
 * 常量类
 * @author Administrator
 *
 */
public class Constant {
	//客户端相应结果码
	public static final int SUCCESS = 1000;//客户端请求成功
	public static final int FIAL = 1001;//客户端请求失败
	
	//预约状态 未处理,正在处理中,已处理,超时未处理,已取消预约
	public static final int APPOINT_UN_HANDLE = 2000;//未处理
	public static final int APPOINT_HANDLE_ING = 2001;//正在处理中
	public static final int APPOINT_COMPLETED = 2002;//已处理
	public static final int APPOINT_TIMEOUT = 2003;//超时未处理
	public static final int APPOINT_CANCEL = 2004;//已被取消
	
	//医生工作安排状态
	public static final int DOCTOR_SCHEDULE_FULL = 3000;//预约已满,不可预约;
	public static final int DOCTOR_SCHEDULE_POSSIBLE = 3001;//可以被预约
	public static final int DOCTOR_SCHEDULE_REST = 3002;//休息,不可预约
	
	//医生级别
	public static final int DOCTOR_NORMAL = 4000;//普通
	public static final int DOCTOR_PROFESSOR = 4001;//专家
	
	//医院级别
	public static final int HOSPITAL_LEVEL_1_C = 5000; 
	public static final int HOSPITAL_LEVEL_1_B = 5001;
	public static final int HOSPITAL_LEVEL_1_A = 5002;
	public static final int HOSPITAL_LEVEL_2_C = 5003;
	public static final int HOSPITAL_LEVEL_2_B = 5004;
	public static final int HOSPITAL_LEVEL_2_A = 5005;
	public static final int HOSPITAL_LEVEL_3_C = 5006;
	public static final int HOSPITAL_LEVEL_3_B = 5007;
	public static final int HOSPITAL_LEVEL_3_A = 5008;
	
	//性别
	public static final int SEX_MALE = 60000;
	public static final int SEX_FEMALE = 60001;
	
	//角色
	public static final int DOCTOR = 7000;//病人
	public static final int PATIENT = 70001;//医生
		
}
