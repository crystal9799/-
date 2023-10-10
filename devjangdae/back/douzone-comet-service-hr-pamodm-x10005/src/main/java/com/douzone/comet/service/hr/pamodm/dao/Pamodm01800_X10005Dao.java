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
	 * 복수 데이터 목록 전체 조회 selectList
	 * @param Pamodm01800_X10005Model
	 * @return List<Pamodm01800_X10005Model>
	 */
	public List<Pamodm01800_X10005Model> HRPamodm01800_X10005Service_test(Pamodm01800_X10005Model Pamodm01800_X10005Model) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".HRPamodm01800_X10005Service_test", Pamodm01800_X10005Model);
	}

	/**
	 * 복수 데이터 목록 조건 조회 selectList
	 * @param HashMap<String, Object> parameters
	 * @return List<Pamodm01800_X10005Model>
	 */
	public List<Pamodm01800_X10005Model> list_HR_STRK_INFO_X10005MST(HashMap<String, Object> parameters) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".list_HR_STRK_INFO_X10005MST", parameters);
	}

	/**
	 * 단일 데이터 목록 조회 (사원번호로 회사코드 추출하기) selectOne
	 * @param String emp_no
	 * @return String
	 */
	public String getCompanyCode(String emp_no) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".getCompanyCode", emp_no);
	}

	/**
	 * 복수 데이터 삭제 처리 deleteBatch
	 * @param List<Pamodm01800_X10005Model> parameters
	 * @return void
	 */
	public void delete_HR_STRK_INFO_X10005MST(List<Pamodm01800_X10005Model> parameters) throws Exception {
		this.mybatisSupport.deleteBatch(this.getClass().getName() + ".delete_HR_STRK_INFO_X10005MST", parameters);
	}
	
	/**
	 * 복수 데이터 수정 처리 updateBatch
	 * @param List<Pamodm01800_X10005Model> parameters
	 * @return void
	 */
	public void update_HR_STRK_INFO_X10005MST(Pamodm01800_X10005Model parameters) throws Exception {
		this.mybatisSupport.update(this.getClass().getName() + ".update_HR_STRK_INFO_X10005MST", parameters);
	}
	
	/**
	 * 단일 데이터 입력 처리 insert
	 * @param Pamodm01800_X10005Model parameters
	 * @return void
	 */
	public void insert_HR_STRK_INFO_X10005MST(Pamodm01800_X10005Model parameters) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".insert_HR_STRK_INFO_X10005MST", parameters);
	}

	/**
	 * 중복 데이터 조회 selectOne
	 * @param Pamodm01800_X10005Model parameters
	 * @return Integer
	 */
	public Integer hasContainPrimaryKey(Pamodm01800_X10005Model parameters) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".hasContainPrimaryKey", parameters);
	}

}
