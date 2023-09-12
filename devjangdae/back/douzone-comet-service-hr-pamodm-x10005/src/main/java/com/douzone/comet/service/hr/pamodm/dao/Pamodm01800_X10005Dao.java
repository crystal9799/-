package com.douzone.comet.service.hr.pamodm.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
import com.douzone.comet.service.hr.pamodm.models.Pamodm01800_X10005Model;

/**
 * @description : 행사참가직원등록_DAO
 * @Since : 2023-09-12
 * @Author : 서장대
 * @History : 개발시작
 */
@Repository
public class Pamodm01800_X10005Dao {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public Pamodm01800_X10005Dao(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	/**
	 * 복수 데이터 목록 전체 조회
	 * @param Pamodm01800_X10005Model
	 * @return List<Pamodm01800_X10005Model>
	 */
	public List<Pamodm01800_X10005Model> selectPamodm01800_AllDtModelList(Pamodm01800_X10005Model Pamodm01800_X10005Model) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".selectPamodm01800_AllDtModelList", Pamodm01800_X10005Model);
	}

	/**
	 * 복수 데이터 목록 조건 조회
	 * @param HashMap<String, Object> parameters
	 * @return List<Pamodm01800_X10005Model>
	 */
	public List<Pamodm01800_X10005Model> pamodm01800_listMaster(HashMap<String, Object> parameters) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".pamodm01800_listMaster", parameters);
	}

	/**
	 * 단일 데이터 목록 조회 (사원번호로 회사코드 추출하기)
	 * @param String string
	 * @return String
	 */
	public String selectCompanyCd(String string) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectCompanyCd", string);
	}

	/**
	 * 복수 데이터 삭제 처리
	 * @param List<Pamodm01800_X10005Model> parameters
	 * @return void
	 */
	public void deleteBatch(List<Pamodm01800_X10005Model> parameters) throws Exception {
		this.mybatisSupport.deleteBatch(this.getClass().getName() + ".deleteBatch", parameters);
	}

	/**
	 * 단일 데이터 입력 처리
	 * @param Pamodm01800_X10005Model parameters
	 * @return void
	 */
	public void insert(Pamodm01800_X10005Model parameters) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".insert", parameters);
	}

	/**
	 * 복수 데이터 수정 처리
	 * @param List<Pamodm01800_X10005Model> parameters
	 * @return void
	 */
	public void updateBatch(List<Pamodm01800_X10005Model> parameters) throws Exception {
		this.mybatisSupport.updateBatch(this.getClass().getName() + ".updateBatch", parameters);
	}

	/**
	 * 중복 데이터 조회
	 * @param Pamodm01800_X10005Model parameters
	 * @return Integer
	 */
	public Integer selectPK(Pamodm01800_X10005Model parameters) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectPK", parameters);
	}

}
