package com.douzone.comet.service.hr.pamprg.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
import com.douzone.comet.service.hr.pamprg.models.Pamprg00100_X10005Model;
/** 
  * @description : 승급관리기준표_Dao
  * @Since   : 23.09.12 화요일 작성
  * @Author  : minaci
  * @History : 
  */
@Repository
public class Pamprg00100_X10005Dao  {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public Pamprg00100_X10005Dao(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	/**
	 * 복수 데이터 목록 조회
	 * @param Pamprg00100_X10005Model
	 * @return List<Pamprg00100_X10005Model>
	 */
	public List<Pamprg00100_X10005Model> selectPamprg00100_X10005ModelList(HashMap<String,Object> parameters) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".selectPamprg00100_X10005ModelList", parameters);
	}

	/**
	 * 단일 데이터 조회
	 * @param Pamprg00100_X10005Model
	 * @return List<Pamprg00100_X10005Model>
	 */
	public Pamprg00100_X10005Model selectPAMPRG00100_Model(Pamprg00100_X10005Model pamprg00100_X10005Model) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectPAMPRG00100_Model", pamprg00100_X10005Model);
	}

	/**
	 * 단일 데이터 입력 처리
	 * @param Pamprg00100_X10005Model
	 */
	public void insertPAMPRG00100_Model(Pamprg00100_X10005Model pamprg00100_X10005Model) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".insertPAMPRG00100_Model", pamprg00100_X10005Model);
	}

	/**
	 * 단일 데이터 수정 처리
	 * @param Pamprg00100_X10005Model
	 */
	public void updatePAMPRG00100_Model(Pamprg00100_X10005Model pamprg00100_X10005Model) throws Exception {
		this.mybatisSupport.update(this.getClass().getName() + ".updatePAMPRG00100_Model", pamprg00100_X10005Model);
	}

	/**
	 * 단일 데이터 삭제 처리
	 * @param Pamprg00100_X10005Model
	 */
	public void deletePAMPRG00100_Model(Pamprg00100_X10005Model pamprg00100_X10005Model) throws Exception {
		this.mybatisSupport.delete(this.getClass().getName() + ".deletePAMPRG00100_Model", pamprg00100_X10005Model);
	}

}
