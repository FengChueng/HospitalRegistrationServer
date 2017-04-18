package com.zyl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Patient;
@Transactional(rollbackFor=Exception.class)
public interface PatientDAO extends JpaRepository<Patient, String>{
}
