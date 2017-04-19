package com.zyl.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Hospital;

/**
 * 操作Hospital表的DAO层
 * @author Administrator
 *
 */
@Transactional(rollbackFor=Exception.class)
public interface HospitalDAO extends JpaRepository<Hospital, String>{
	
	/**
	 * 通过hospitalName查找
	 * @param hospitalName
	 * @return
	 */
	Hospital findByHospitalName(String hospitalName);

	/**
	 * 通过创建时间查询
	 * @param date
	 * @param pageable	分页参数
	 * @return
	 */
	Page<Hospital> findByCreateDate(long date, Pageable pageable);

//	Page<Hospital> findByLocation(String location, Pageable pageable);
	
	/**
	 * 通过level查询
	 * @param level
	 * @param pageable
	 * @return
	 */
	Page<Hospital> findByLevel(int level, Pageable pageable);
	
	/**
	 * 通过定位查询
	 * @param location
	 * @param pageable
	 * @return
	 */
	Page<Hospital> findByLocationLike(String location, Pageable pageable);
	
}
