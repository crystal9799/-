package com.douzone.comet.service.hr.cdmjim00100.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
@Repository
public class cdmjim00100_Modal  {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public cdmjim00100_Modal(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	/**
	 * 복수 데이터 목록 조회
	 * @param Map<String, Object>
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String,Object>> selectFgList(Map<String, Object> parameters) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".selectFgList", parameters);
	}

	/**
	 * 단일 데이터 조회
	 * @param object
	 * @return List<Object>
	 */
	public Object selectObject(Object object) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectObject", object);
	}

	/**
	 * 단일 데이터 입력 처리
	 * @param object
	 */
	public void insertObject(Object object) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".insertObject", object);
	}

	/**
	 * 단일 데이터 수정 처리
	 * @param object
	 */
	public void updateObject(Object object) throws Exception {
		this.mybatisSupport.update(this.getClass().getName() + ".updateObject", object);
	}

	/**
	 * 단일 데이터 삭제 처리
	 * @param object
	 */
	public void deleteObject(Object object) throws Exception {
		this.mybatisSupport.delete(this.getClass().getName() + ".deleteObject", object);
	}

}
