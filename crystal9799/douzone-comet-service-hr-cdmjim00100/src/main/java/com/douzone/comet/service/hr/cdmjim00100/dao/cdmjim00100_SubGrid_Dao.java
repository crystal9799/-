package com.douzone.comet.service.hr.cdmjim00100.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
import com.douzone.comet.service.hr.cdmjim00100.models.cdmjim00100_left_grid;
/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
@Repository
public class cdmjim00100_SubGrid_Dao  {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public cdmjim00100_SubGrid_Dao(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	/**
	 * 복수 데이터 목록 조회
	 * @param cdmjim00100_left_grid
	 * @return List<cdmjim00100_left_grid>
	 */
	public List<cdmjim00100_left_grid> selectcdmjim00100_left_gridList(cdmjim00100_left_grid cdmjim00100_left_grid) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".selectcdmjim00100_left_gridList", cdmjim00100_left_grid);
	}

	/**
	 * 단일 데이터 조회
	 * @param cdmjim00100_left_grid
	 * @return List<cdmjim00100_left_grid>
	 */
	public cdmjim00100_left_grid selectcdmjim00100_left_grid(cdmjim00100_left_grid cdmjim00100_left_grid) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectcdmjim00100_left_grid", cdmjim00100_left_grid);
	}

	/**
	 * 단일 데이터 입력 처리
	 * @param cdmjim00100_left_grid
	 */
	public void insertcdmjim00100_left_grid(cdmjim00100_left_grid cdmjim00100_left_grid) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".insertcdmjim00100_left_grid", cdmjim00100_left_grid);
	}

	/**
	 * 단일 데이터 수정 처리
	 * @param cdmjim00100_left_grid
	 */
	public void updatecdmjim00100_left_grid(cdmjim00100_left_grid cdmjim00100_left_grid) throws Exception {
		this.mybatisSupport.update(this.getClass().getName() + ".updatecdmjim00100_left_grid", cdmjim00100_left_grid);
	}

	/**
	 * 단일 데이터 삭제 처리
	 * @param cdmjim00100_left_grid
	 */
	public void deletecdmjim00100_left_grid(cdmjim00100_left_grid cdmjim00100_left_grid) throws Exception {
		this.mybatisSupport.delete(this.getClass().getName() + ".deletecdmjim00100_left_grid", cdmjim00100_left_grid);
	}

}
