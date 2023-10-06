package com.douzone.comet.service.hr.essodm.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.douzone.comet.components.DzCometService;
import com.douzone.comet.service.hr.essodm.dao.Essodm01400_x10005Dao;
import com.douzone.comet.service.hr.essodm.utils.GenerateREQ_NO;
import com.douzone.comet.service.util.mybatis.MyBatisUtil;
import com.douzone.gpd.jdbc.core.MapperType;
import com.douzone.gpd.jdbc.objects.SqlPack;

public class ResponseHashMap extends DzCometService {
//	@Autowired
//	Essodm01400_x10005Dao essodm01400_x10005DAO;

	HashMap<String, Object> response;

	public ResponseHashMap() {
		super();
		response = new HashMap<String, Object>();
		response.put("MSG", "");
	}

	// 유효성 검사
	// 해당 REQ_NO이 존재하는지. 없다면 새로 생성해주기.
	public HashMap<String, Object> createReqNo(Essodm01400_X10005Model parameter,
			Essodm01400_x10005Dao essodm01400_x10005DAO) {
		// 기존값이 있을 수도 있으니 clear
		response.clear();
		GenerateREQ_NO genNO = new GenerateREQ_NO();
		int seq = 0;
		String req_no = parameter.getReq_no();
		// 만약 req_no가 없다면?
		if (parameter.getReq_no() == null || req_no.equals("") || req_no == null) {
			seq = essodm01400_x10005DAO.selectMaxReqNo();
			req_no = genNO.generateDocNoByMaxThisMonth(seq);
			this.response.put("REQ_NO", req_no);
			this.response.put("MSG", "OK");
		} else
			this.response.put("MSG", "OK");
		return this.response;
	}

	// 해당 DOC_NO이 존재하는지. 없다면 새로 생성해주기.
	public String createDocNo(Essodm01400_x10005Dao essodm01400_x10005DAO) {
		GenerateREQ_NO genNO = new GenerateREQ_NO();
		int seq = 0;
		seq = essodm01400_x10005DAO.selectMaxDocNo();
		String doc_no = genNO.generateDocNoByMaxThisMonth_Approve(seq);
		return doc_no;
	}

	// 유효성 검사
	// 전달받은 파라미터에서 선택한 기간이 기존에 근태기간과 겹치지 않는지 검사
	public HashMap<String, Object> hasContainSamePeriod(Essodm01400_X10005Model parameter,
			Essodm01400_x10005Dao essodm01400_x10005DAO) {
		response.clear();
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		String result = "";
		parameters.put("P_COMPANY_CD", parameter.getCompany_cd());
		parameters.put("P_EMP_NO", parameter.getEmp_no());
		parameters.put("P_START_DT", parameter.getStart_dt());
		parameters.put("P_END_DT", parameter.getEnd_dt());

		System.out.println("essodm01400_x10005DAO==>" + essodm01400_x10005DAO);
		// 여기서 null 체크 추가
		if (essodm01400_x10005DAO != null) {
			result = essodm01400_x10005DAO.hasContainSamePeriod(parameters);
		}

		System.out.println("유효성 체크 result===>" + result);
		logger.info("유효성 체크 result===>" + result);

		// 기존에 내역이 존재한다면.
		if (result != null && result.equals("true")) {
			this.response.put("MSG", "already_existed");
		} else {
			this.response.put("MSG", "OK");
		}

		return this.response;
	}

}

//String req_no = parameter.getReq_no();
//		HashMap<String, Object> parameters = new HashMap<String, Object>();
//		List<Essodm01400_X10005Model> list = new ArrayList<>();
//
//			parameters.put("P_REQ_NO", req_no);
//
//			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Essodm01400_x10005Dao.isExistSameperiod");
//			SqlPack so = new SqlPack();
//			so.setStoreProcedure(false);
//			so.setMapperType(MapperType.MyBatis);
//			so.setSqlText(sqlText);
//			so.getInParameters().putAll(parameters);
//
//			list  = this.queryForObject(so);
