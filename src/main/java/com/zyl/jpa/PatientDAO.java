package com.zyl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Patient;

/**
 * 操作Patient表的DAO层
 * @author Administrator
 *
 */
@Transactional(rollbackFor=Exception.class)
public interface PatientDAO extends JpaRepository<Patient, String>{
}
