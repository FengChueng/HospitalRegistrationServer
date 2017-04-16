package com.zyl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Doctor;
@Transactional(rollbackFor=Exception.class)
public interface DoctorDAO extends JpaRepository<Doctor, String>{

	Doctor findByRealName(String name);

}
