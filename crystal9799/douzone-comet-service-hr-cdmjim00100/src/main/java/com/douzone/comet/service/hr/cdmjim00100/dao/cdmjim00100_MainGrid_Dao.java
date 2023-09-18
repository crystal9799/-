package com.douzone.comet.service.hr.cdmjim00100.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
import com.douzone.comet.service.hr.cdmjim00100.models.cdmjim00100_maingrid;
/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
@Repository
public class cdmjim00100_MainGrid_Dao  {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public cdmjim00100_MainGrid_Dao(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	/**
	 * 복수 데이터 목록 조회
	 * @param cdmjim00100_maingrid
	 * @return List<cdmjim00100_maingrid>
	 */
	public List<cdmjim00100_maingrid> selectcdmjim00100_maingridList(Map<String, Object> cdmjim00100_maingrid) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".selectcdmjim00100_maingridList", cdmjim00100_maingrid);
	}

	/**
	 * 단일 데이터 조회
	 * @param cdmjim00100_maingrid
	 * @return List<cdmjim00100_maingrid>
	 */
	public cdmjim00100_maingrid selectcdmjim00100_maingrid(cdmjim00100_maingrid cdmjim00100_maingrid) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectcdmjim00100_maingrid", cdmjim00100_maingrid);
	}

	/**
	 * 단일 데이터 입력 처리
	 * @param cdmjim00100_maingrid
	 */
	public void insertcdmjim00100_maingrid(cdmjim00100_maingrid cdmjim00100_maingrid) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".insertcdmjim00100_maingrid", cdmjim00100_maingrid);
	}

	/**
	 * 단일 데이터 수정 처리
	 * @param cdmjim00100_maingrid
	 */
	public void updatecdmjim00100_maingrid(cdmjim00100_maingrid cdmjim00100_maingrid) throws Exception {
		this.mybatisSupport.update(this.getClass().getName() + ".updatecdmjim00100_maingrid", cdmjim00100_maingrid);
	}

	/**
	 * 단일 데이터 삭제 처리
	 * @param cdmjim00100_maingrid
	 */
	public void deletecdmjim00100_maingrid(cdmjim00100_maingrid cdmjim00100_maingrid) throws Exception {
		this.mybatisSupport.delete(this.getClass().getName() + ".deletecdmjim00100_maingrid", cdmjim00100_maingrid);
	}

}
