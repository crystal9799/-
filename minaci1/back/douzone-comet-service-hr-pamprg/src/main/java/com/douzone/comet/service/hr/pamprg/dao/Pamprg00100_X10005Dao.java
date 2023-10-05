package com.douzone.comet.service.hr.pamprg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
import com.douzone.comet.service.hr.pamprg.models.Pamprg00100_X10005Model;

/**
 * @description : 승급관리기준표_Dao
 * @Since : 23.09.12 화요일 작성
 * @Author : minaci
 * @History :
 */
@Repository
public class Pamprg00100_X10005Dao {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public Pamprg00100_X10005Dao(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	/**
	 * 복수 데이터 목록 조회
	 * 
	 * @param Pamprg00100_X10005Model
	 * @return List<Pamprg00100_X10005Model>
	 */
	public List<Pamprg00100_X10005Model> selectPamprg00100_X10005ModelList(HashMap<String, Object> parameters)
			throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".selectPamprg00100_X10005ModelList",
				parameters);
	}

	// 그리드 페이징 조회
	public List<Pamprg00100_X10005Model> master_list_paging(HashMap<String, Object> parameters) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".master_list_paging", parameters);
	}

	// 종전데이터 있는지 여부 확인
	public int checkListExist(HashMap<String, Object> parameters) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".checkListExist", parameters);
	}

	// 사업장 조회
	public List<Pamprg00100_X10005Model> get_BizareaList(HashMap<String, Object> parameters) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".get_BizareaList", parameters);
	}

	/**
	 * 단일 데이터 입력 처리
	 * 
	 * @param Pamprg00100_X10005Model
	 */
	public void mergeintoPAMPRG00100_Model(List<Pamprg00100_X10005Model> Pamprg00100_X10005Model) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".mergeintoPAMPRG00100_Model", Pamprg00100_X10005Model);
	}

	public void uploadPAMPRG00100_Model(Pamprg00100_X10005Model Pamprg00100_X10005Model) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".uploadPAMPRG00100_Model", Pamprg00100_X10005Model);
	}

	/**
	 * 복수 데이터 수정 처리
	 * 
	 * @param Pamprg00100_X10005Model
	 */
	public void updatePAMPRG00100_Model(List<Pamprg00100_X10005Model> parameters) throws Exception {
		this.mybatisSupport.updateBatch(this.getClass().getName() + ".updatePAMPRG00100_Model", parameters);
	}

	/**
	 * 복수 데이터 삭제 처리
	 * 
	 * @param Pamprg00100_X10005Model
	 */
	public void deletePAMPRG00100_Model(List<Pamprg00100_X10005Model> parameters) throws Exception {
		this.mybatisSupport.deleteBatch(this.getClass().getName() + ".deletePAMPRG00100_Model", parameters);
	}

	public List<Pamprg00100_X10005Model> selectModel(HashMap<String, Object> parameters) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".selectModel", parameters);
	}

}
