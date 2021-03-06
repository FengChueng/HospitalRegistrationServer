package com.zyl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Doctor;

/**
 * 操作Doctor表的DAO层
 * @author Administrator
 *
 */
@Transactional(rollbackFor=Exception.class)
public interface DoctorDAO extends JpaRepository<Doctor, String>{

	Doctor findByRealName(String name);

	List<Doctor> findByRealNameLike(String name);

	Doctor findByMobilePhone(String mobilePhone);

}
