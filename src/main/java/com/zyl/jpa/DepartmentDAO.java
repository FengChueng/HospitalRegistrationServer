package com.zyl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Department;

/**
 * 操作Department表的DAO层
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
public interface DepartmentDAO extends JpaRepository<Department, String> {
	
	/**
	 * 通过deptName查找
	 * @param deptName
	 * @return
	 */
	Department findByDeptName(String deptName);

}
