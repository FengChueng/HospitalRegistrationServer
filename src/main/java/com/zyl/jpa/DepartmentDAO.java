package com.zyl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Department;

@Transactional(rollbackFor = Exception.class)
public interface DepartmentDAO extends JpaRepository<Department, String> {

	Department findByDeptName(String deptName);

}
