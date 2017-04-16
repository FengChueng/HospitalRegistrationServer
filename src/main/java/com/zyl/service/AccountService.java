package com.zyl.service;

import com.zyl.domain.Account;
import com.zyl.exception.ValidException;

public interface AccountService {
	/**
	 * 用户注册
	 * @param mobilePhone
	 * @param password
	 * @param role
	 * @throws ValidException 
	 */
	void registerAccount(String mobilePhone,String password,int role) throws ValidException;
	
	/**
	 * 根据旧密码修改新密码
	 * @param mobilePhone
	 * @param oldPwd
	 * @param newPwd
	 * @throws ValidException
	 */
	void updatePwd(String mobilePhone,String oldPwd,String newPwd) throws ValidException;
	
	/**
	 * 重置密码
	 * @param mobilePhone
	 * @param newPwd
	 * @throws ValidException 
	 */
	void updatePwd(String mobilePhone,String newPwd) throws ValidException;
	
	/**
	 * 登录
	 * @param mobilePhone
	 * @param password
	 */
	Account loginAccount(String mobilePhone,String password) throws ValidException;
	
	void deleteAccount(String mobilePhone) throws ValidException;
	
	/**
	 * 
	 * @param mobilePhone
	 * @return
	 */
	Account queryAccountByMobilePhone(String mobilePhone) throws ValidException;
}	
