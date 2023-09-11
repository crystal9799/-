package com.douzone.comet.service.hr.pamprg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
import com.douzone.comet.service.hr.pamprg.models.PAMPRG00100_Model;
/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
@Repository
public class PAMPRG00100_Dao  {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public PAMPRG00100_Dao(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	/**
	 * 복수 데이터 목록 조회
	 * @param pAMPRG00100_Model
	 * @return List<PAMPRG00100_Model>
	 */
	public List<PAMPRG00100_Model> selectPAMPRG00100_ModelList(PAMPRG00100_Model pAMPRG00100_Model) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".selectPAMPRG00100_ModelList", pAMPRG00100_Model);
	}

	/**
	 * 단일 데이터 조회
	 * @param pAMPRG00100_Model
	 * @return List<PAMPRG00100_Model>
	 */
	public PAMPRG00100_Model selectPAMPRG00100_Model(PAMPRG00100_Model pAMPRG00100_Model) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectPAMPRG00100_Model", pAMPRG00100_Model);
	}

	/**
	 * 단일 데이터 입력 처리
	 * @param pAMPRG00100_Model
	 */
	public void insertPAMPRG00100_Model(PAMPRG00100_Model pAMPRG00100_Model) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".insertPAMPRG00100_Model", pAMPRG00100_Model);
	}

	/**
	 * 단일 데이터 수정 처리
	 * @param pAMPRG00100_Model
	 */
	public void updatePAMPRG00100_Model(PAMPRG00100_Model pAMPRG00100_Model) throws Exception {
		this.mybatisSupport.update(this.getClass().getName() + ".updatePAMPRG00100_Model", pAMPRG00100_Model);
	}

	/**
	 * 단일 데이터 삭제 처리
	 * @param pAMPRG00100_Model
	 */
	public void deletePAMPRG00100_Model(PAMPRG00100_Model pAMPRG00100_Model) throws Exception {
		this.mybatisSupport.delete(this.getClass().getName() + ".deletePAMPRG00100_Model", pAMPRG00100_Model);
	}

}
