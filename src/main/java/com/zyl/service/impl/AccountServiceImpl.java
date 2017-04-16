package com.zyl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Account;
import com.zyl.exception.ValidException;
import com.zyl.jpa.AccountDAO;
import com.zyl.service.AccountService;

@Repository
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void registerAccount(String mobilePhone, String password, int role) throws ValidException {
		Account account = accountDAO.findByMobilePhone(mobilePhone);
		if(account!=null){//账号存在
			throw new ValidException("account","账号已存在");
		}else{
			accountDAO.saveAndFlush(new Account(mobilePhone,password,role));
		}
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void updatePwd(String mobilePhone, String oldPwd, String newPwd) throws ValidException{
		Account account = accountDAO.findByMobilePhone(mobilePhone);
		if(account==null){//账号不存在
			throw new ValidException("account","账号不存在");
		}else{
			String currentPwd = account.getPassword();
			if(oldPwd.equals(currentPwd)){//两次密码一致
				account.setPassword(newPwd);
				accountDAO.saveAndFlush(account);
			}else{//验证失败
				throw new ValidException("account", "密码验证有误,修改失败");
			}
		}
	}
	
	@Override
	public void updatePwd(String mobilePhone, String newPwd) throws ValidException {
		Account account = accountDAO.findByMobilePhone(mobilePhone);
		if(account==null){//账号不存在
			throw new ValidException("account","账号不存在");
		}else{
			account.setPassword(newPwd);
			accountDAO.saveAndFlush(account);
		}
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Account loginAccount(String mobilePhone, String password) throws ValidException{
		Account account = accountDAO.findByMobilePhone(mobilePhone);
		if(account==null){//账号不存在
			throw new ValidException("account","账号不存在");
		}
		return account;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void deleteAccount(String mobilePhone) throws ValidException{
		Account account = accountDAO.findByMobilePhone(mobilePhone);
		if(account==null){//账号不存在
			throw new ValidException("account","账号不存在");
		}else{
			accountDAO.delete(account);
		}
	}

	@Override
	public Account queryAccountByMobilePhone(String mobilePhone) throws ValidException{
		Account account = accountDAO.findByMobilePhone(mobilePhone);
		if(account==null){//账号不存在
			throw new ValidException("account","账号不存在");
		}
		return account;
	}

}
