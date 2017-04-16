package com.zyl.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Hospital;
@Transactional(rollbackFor=Exception.class)
public interface HospitalDAO extends JpaRepository<Hospital, String>{

	Hospital findByHospitalName(String hospitalName);

	Page<Hospital> findByCreateDate(long date, Pageable pageable);

	Page<Hospital> findByLevelAndGrade(int level, String grade, Pageable pageable);

	Page<Hospital> findByLocation(String location, Pageable pageable);
	
}
