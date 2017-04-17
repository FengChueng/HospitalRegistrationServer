package com.zyl.utils;

/**
 * 常量类
 * @author Administrator
 *
 */
public class Constant {
	public static final int SUCCESS = 1000;//客户端请求成功
	public static final int FIAL = 10001;//客户端请求失败
	
	//预约状态 未处理,正在处理中,已处理,超时未处理,已取消预约
	public static final int APPOINT_UN_HANDLE = 20001;
	public static final int APPOINT_HANDLE_ING = 20002;
	public static final int APPOINT_HANDLED = 20003;
	public static final int APPOINT_TIMEOUT = 20004;//超时未处理
	public static final int APPOINT_CANCEL = 20005;//已被取消

}
