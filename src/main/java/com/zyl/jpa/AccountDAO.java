package com.zyl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Account;
@Transactional(rollbackFor=Exception.class)
public interface AccountDAO extends JpaRepository<Account, String>{
	Account findByMobilePhone(String mobilePhone);
}
