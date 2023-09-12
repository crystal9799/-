package com.douzone.comet.service.hr.essodm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
import com.douzone.comet.service.hr.essodm.models.Essodm01400_X10005Model;
/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
@Repository
public class Essodm01400_x10005Dao  {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public Essodm01400_x10005Dao(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	/**
	 * 복수 데이터 목록 조회
	 * @param essodm01400_X10005Model
	 * @return List<Essodm01400_X10005Model>
	 */
	public List<Essodm01400_X10005Model> selectEssodm01400_X10005ModelList(Essodm01400_X10005Model essodm01400_X10005Model) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".selectEssodm01400_X10005ModelList", essodm01400_X10005Model);
	}

	/**
	 * 단일 데이터 조회
	 * @param essodm01400_X10005Model
	 * @return List<Essodm01400_X10005Model>
	 */
	public Essodm01400_X10005Model selectEssodm01400_X10005Model(Essodm01400_X10005Model essodm01400_X10005Model) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectEssodm01400_X10005Model", essodm01400_X10005Model);
	}

	/**
	 * 단일 데이터 입력 처리
	 * @param essodm01400_X10005Model
	 */
	public void insertEssodm01400_X10005Model(Essodm01400_X10005Model essodm01400_X10005Model) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".insertEssodm01400_X10005Model", essodm01400_X10005Model);
	}

	/**
	 * 단일 데이터 수정 처리
	 * @param essodm01400_X10005Model
	 */
	public void updateEssodm01400_X10005Model(Essodm01400_X10005Model essodm01400_X10005Model) throws Exception {
		this.mybatisSupport.update(this.getClass().getName() + ".updateEssodm01400_X10005Model", essodm01400_X10005Model);
	}

	/**
	 * 단일 데이터 삭제 처리
	 * @param essodm01400_X10005Model
	 */
	public void deleteEssodm01400_X10005Model(Essodm01400_X10005Model essodm01400_X10005Model) throws Exception {
		this.mybatisSupport.delete(this.getClass().getName() + ".deleteEssodm01400_X10005Model", essodm01400_X10005Model);
	}

}
