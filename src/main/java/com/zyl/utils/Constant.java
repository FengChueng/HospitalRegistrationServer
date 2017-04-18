package com.zyl.utils;

/**
 * 常量类
 * @author Administrator
 *
 */
public class Constant {
	public static final int SUCCESS = 1000;//客户端请求成功
	public static final int FIAL = 1001;//客户端请求失败
	
	//预约状态 未处理,正在处理中,已处理,超时未处理,已取消预约
	public static final int APPOINT_UN_HANDLE = 2001;
	public static final int APPOINT_HANDLE_ING = 2002;
	public static final int APPOINT_COMPLETED = 2003;
	public static final int APPOINT_TIMEOUT = 2004;//超时未处理
	public static final int APPOINT_CANCEL = 2005;//已被取消
	
	public static final int DOCTOR_SCHEDULE_FULL = 3001;//预约已满,不可预约;
	public static final int DOCTOR_SCHEDULE_POSSIBLE = 3002;//可以被预约
	public static final int DOCTOR_SCHEDULE_REST = 3003;//休息,不可预约

}
