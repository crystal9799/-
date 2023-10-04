package com.douzone.comet.service.hr.essodm;

import com.douzone.comet.components.DzCometService;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.enums.CometModule;
import java.util.List;
import java.util.Map;

import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.comet.service.hr.essodm.dao.Essodm01400_x10005Dao;
import com.douzone.comet.service.hr.essodm.models.ChartData;
import com.douzone.comet.service.hr.essodm.models.ChartDataByWeek;
import com.douzone.comet.service.hr.essodm.models.Essodm01400_X10005Model;
import com.douzone.comet.service.hr.essodm.models.Essodm01400_X10005_UserInfoModel;
import com.douzone.comet.service.hr.essodm.models.OffApply;
import com.douzone.comet.service.hr.essodm.models.ResponseHashMap;
import com.douzone.comet.service.hr.essodm.utils.GetInsertUpdateInfo;
import com.douzone.gpd.restful.model.DzGridModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description : 결근계_service
 * @Since : 2023-09-12
 * @Author : 김성현
 * @History : 개발환경 세팅
 */
@DzApiService(value = "HREssodm01400_X10005Service", module = CometModule.HR, desc = "결근계 신청")
public class HREssodm01400_X10005Service extends DzCometService {

	@Autowired
	Essodm01400_x10005Dao essodm01400_x10005DAO;

	@DzApi(url = "/list_HR_OFFAPPLY_MST_X10005MST", desc = "결근계 조회", httpMethod = DzRequestMethod.GET)
	public List<Essodm01400_X10005Model> list_HR_OFFAPPLY_MST_X10005(
			@DzParam(key = "start_dt", desc = "시작일", paramType = DzParamType.QueryString) String start_dt,
			@DzParam(key = "end_dt", desc = "종료일", paramType = DzParamType.QueryString) String end_dt,
			@DzParam(key = "company_cd", desc = "회사코드", paramType = DzParamType.QueryString) String company_cd)
			throws Exception {
		List<Essodm01400_X10005Model> items = new ArrayList<Essodm01400_X10005Model>();
		try {
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("P_COMPANY_CD", company_cd);
			parameters.put("P_START_DT", start_dt);
			parameters.put("P_END_DT", end_dt);

			items = essodm01400_x10005DAO.selectEssodm01400_X10005ModelList(parameters);

			System.out.println("MainGrid1Model==========================");
			for (Essodm01400_X10005Model item : items) {
				System.out.println(item.toString());
			}
			System.out.println("MainGrid1Model==========================");
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return items;
	}

	
	@DzApi(url = "/getUserInfo", desc = "메인페이지 기본정보 조회", httpMethod = DzRequestMethod.GET)
	public List<Essodm01400_X10005_UserInfoModel> getUserInfo(
			@DzParam(key = "company_cd", desc = "회사코드", paramType = DzParamType.QueryString) String company_cd,
			@DzParam(key = "emp_no", desc = "사원번호", paramType = DzParamType.QueryString) String emp_no)
			throws Exception {
		Essodm01400_X10005_UserInfoModel item = new Essodm01400_X10005_UserInfoModel();
		List<Essodm01400_X10005_UserInfoModel> items = new ArrayList<Essodm01400_X10005_UserInfoModel>();
		// 현재 접속자 정보를 가져오지 않고 가장 많은 건수를 가진 사원정보를 입력
//		String company_cd = "EWP";
//		String emp_no = "20200308";
		try {
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("P_EMP_NO", emp_no);
			parameters.put("P_COMPANY_CD", company_cd);
			item = essodm01400_x10005DAO.getUserInfo(parameters);
			items.add(item);
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return items;
	}
	
	@DzApi(url = "/selectDataByCondition", desc = "메인페이지 차트정보 조회 월간", httpMethod = DzRequestMethod.GET)
	public List<ChartData> selectDataByCondition(
			@DzParam(key = "company_cd", desc = "회사코드", paramType = DzParamType.QueryString) String company_cd,
			@DzParam(key = "bizarea_cd", desc = "사업장코드", paramType = DzParamType.QueryString) String bizarea_cd,
			@DzParam(key = "dept_cd", desc = "부서코드", paramType = DzParamType.QueryString) String dept_cd)
			throws Exception {
		List<ChartData> datas = new ArrayList<ChartData>();
		try {
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("P_COMPANY_CD", company_cd);
			parameters.put("P_BIZAREA_CD", bizarea_cd);
			parameters.put("P_DEPT_CD", dept_cd);
			datas = essodm01400_x10005DAO.selectDataByCondition(parameters);
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return datas;
	}
	
	
	@DzApi(url = "/getDataByWeek", desc = "메인페이지 차트정보 조회 주간", httpMethod = DzRequestMethod.GET)
	public List<ChartDataByWeek> getDataByWeek()
			throws Exception {
		OffApply offApply = new OffApply();
		List<ChartDataByWeek> list = new ArrayList<ChartDataByWeek>();
		try {
			list = offApply.getDataByWeek(essodm01400_x10005DAO.selectDataByWeekCondition());
			System.out.println("차트정보주간==>"+list.toString());
			
			
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return list;
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	@DzApi(url = "/update_HR_OFFAPPLY_MST_X10005MST", desc = "결근계 수정", httpMethod = DzRequestMethod.GET)
	public String save_HR_OFFAPPLY_MST_X10005(
			@DzParam(key = "company_cd", desc = "", paramType = DzParamType.QueryString) String company_cd,
			@DzParam(key = "req_no", desc = "", paramType = DzParamType.QueryString) String req_no,
			@DzParam(key = "bizarea_cd", desc = "", paramType = DzParamType.QueryString) String bizarea_cd,
			@DzParam(key = "dept_cd", desc = "", paramType = DzParamType.QueryString) String dept_cd,
			@DzParam(key = "emp_no", desc = "", paramType = DzParamType.QueryString) String emp_no,
			@DzParam(key = "pstn_cd", desc = "", paramType = DzParamType.QueryString) String pstn_cd,
			@DzParam(key = "ogrp_cd", desc = "", paramType = DzParamType.QueryString) String ogrp_cd,
			@DzParam(key = "posi_cd", desc = "", paramType = DzParamType.QueryString) String posi_cd,
			@DzParam(key = "req_emp_no", desc = "", paramType = DzParamType.QueryString) String req_emp_no,
			@DzParam(key = "dnl_cd", desc = "", paramType = DzParamType.QueryString) String dnl_cd,
			@DzParam(key = "start_dt", desc = "", paramType = DzParamType.QueryString) String start_dt,
			@DzParam(key = "end_dt", desc = "", paramType = DzParamType.QueryString) String end_dt,
			@DzParam(key = "req_dy", desc = "", paramType = DzParamType.QueryString) String req_dy,
			@DzParam(key = "reason_dc", desc = "", paramType = DzParamType.QueryString) String reason_dc,
			@DzParam(key = "athz_st_cd", desc = "", paramType = DzParamType.QueryString) String athz_st_cd)
			throws Exception {
		// 전부 단건 처리
		// 1. 파라미터로 들어온 기간이 기존에 있는지 검사
		// 2. 해당기간에 공휴일이 있는지 검사(추가기능사항으로 => 공휴일과 주말 제외한 "실제 휴가일" 컬럼추가)
		// 이를 급여와 연관시키기.
		try {
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("P_COMPANY_CD", company_cd);
			parameters.put("P_REQ_NO", req_no);
			parameters.put("P_BIZAREA_CD", bizarea_cd);
			parameters.put("P_DEPT_CD", dept_cd);
			parameters.put("P_EMP_NO", emp_no);
			parameters.put("P_PSTN_CD", pstn_cd);
			parameters.put("P_OGRP_CD", ogrp_cd);
			parameters.put("P_POSI_CD", posi_cd);
			parameters.put("P_REQ_EMP_NO", req_emp_no);
			parameters.put("P_DNL_CD", dnl_cd);
//	    	parameters.put("P_START_DT", start_dt.substring(0, 9).replace("-", ""));
			parameters.put("P_START_DT", start_dt);
			parameters.put("P_END_DT", end_dt);
			parameters.put("P_REQ_DY", req_dy);
			parameters.put("P_REASON_DC", reason_dc);


			logger.info("parameter====>" + parameters);

			// 기존에 기간이 겹치는지 유효성 검사, 기간이 변경되지 않았을 경우 유효성 검사를 진행하지 않음.
			Essodm01400_X10005Model oldModel = null;
			oldModel = essodm01400_x10005DAO.selectEssodm01400_X10005ModelByPK(parameters);
			ResponseHashMap responseMap = new ResponseHashMap();
			Essodm01400_X10005Model model = new Essodm01400_X10005Model();
			HashMap<String, Object> response = new HashMap<String, Object>();
			logger.info("oldModel.getStart_dt()==>" + oldModel.getStart_dt() + "oldModel.getEnd_dt()===>"
					+ oldModel.getEnd_dt());
			if (!oldModel.getStart_dt().equals(parameters.get("P_START_DT"))
					&& !oldModel.getEnd_dt().equals(parameters.get("P_END_DT"))
					&& oldModel.getReq_no().equals(parameters.get("P_REQ_NO"))) {
				model.setCompany_cd(company_cd);
				model.setEmp_no(emp_no);
				model.setStart_dt(start_dt);
				model.setEnd_dt(end_dt);
				response = responseMap.hasContainSamePeriod(model, essodm01400_x10005DAO);
			} else
				response.put("MSG", "OK");

			if (response.get("MSG").equals("OK")) {
				GetInsertUpdateInfo userInfo = new GetInsertUpdateInfo();
				parameters.put("P_UPDATE_ID", userInfo.getUserId() != null ? userInfo.getUserId() : this.getUserId());
				parameters.put("P_UPDATE_IP", userInfo.getIp());
				parameters.put("P_UPDATE_DTS", userInfo.getDate());
				essodm01400_x10005DAO.updateEssodm01400_X10005Model(parameters);
			}

			return (String) response.get("MSG");
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}

	@Transactional(rollbackFor = Exception.class)
	@DzApi(url = "/insert_HR_OFFAPPLY_MST_X10005MST", desc = "결근계 신청", httpMethod = DzRequestMethod.GET)
	public String insert_HR_OFFAPPLY_MST_X10005MST(
			@DzParam(key = "company_cd", desc = "", paramType = DzParamType.QueryString) String company_cd,
			@DzParam(key = "req_no", desc = "", paramType = DzParamType.QueryString) String req_no,
			@DzParam(key = "dnlgb_cd", desc = "", paramType = DzParamType.QueryString) String dnlgb_cd,
			@DzParam(key = "bizarea_cd", desc = "", paramType = DzParamType.QueryString) String bizarea_cd,
			@DzParam(key = "dept_cd", desc = "", paramType = DzParamType.QueryString) String dept_cd,
			@DzParam(key = "emp_no", desc = "", paramType = DzParamType.QueryString) String emp_no,
			@DzParam(key = "pstn_cd", desc = "", paramType = DzParamType.QueryString) String pstn_cd,
			@DzParam(key = "ogrp_cd", desc = "", paramType = DzParamType.QueryString) String ogrp_cd,
			@DzParam(key = "posi_cd", desc = "", paramType = DzParamType.QueryString) String posi_cd,
			@DzParam(key = "req_emp_no", desc = "", paramType = DzParamType.QueryString) String req_emp_no,
			@DzParam(key = "dnl_cd", desc = "", paramType = DzParamType.QueryString) String dnl_cd,
			@DzParam(key = "start_dt", desc = "", paramType = DzParamType.QueryString) String start_dt,
			@DzParam(key = "end_dt", desc = "", paramType = DzParamType.QueryString) String end_dt,
			@DzParam(key = "req_dy", desc = "", paramType = DzParamType.QueryString) String req_dy,
			@DzParam(key = "req_dt", desc = "", paramType = DzParamType.QueryString) String req_dt,
			@DzParam(key = "reason_dc", desc = "", paramType = DzParamType.QueryString) String reason_dc)
			throws Exception {
		// 전부 단건 처리
		// 1. 파라미터로 들어온 기간이 기존에 있는지 검사
		// 2. 해당기간에 공휴일이 있는지 검사(추가기능사항으로 => 공휴일과 주말 제외한 "실제 휴가일" 컬럼추가)
		// 이를 급여와 연관시키기.
		try {
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("P_COMPANY_CD", company_cd);
			parameters.put("P_REQ_NO", req_no);
			parameters.put("P_BIZAREA_CD", bizarea_cd);
			parameters.put("P_DEPT_CD", dept_cd);
			parameters.put("P_EMP_NO", emp_no);
			parameters.put("P_PSTN_CD", pstn_cd);
			parameters.put("P_OGRP_CD", ogrp_cd);
			parameters.put("P_POSI_CD", posi_cd);
			parameters.put("P_REQ_EMP_NO", req_emp_no);
			parameters.put("P_DNL_CD", dnl_cd);
			parameters.put("P_START_DT", start_dt);
			parameters.put("P_END_DT", end_dt);
			parameters.put("P_REQ_DY", req_dy);
			parameters.put("P_REASON_DC", reason_dc);
			parameters.put("P_DNLGB_CD", dnlgb_cd);
			parameters.put("P_REQ_DT", req_dt);

			logger.info("parameter====>" + parameters);

			// 기존에 기간이 겹치는지 유효성 검사
			ResponseHashMap responseMap = new ResponseHashMap();
			Essodm01400_X10005Model model = new Essodm01400_X10005Model();
			model.setCompany_cd(company_cd);
			model.setEmp_no(emp_no);
			model.setStart_dt(start_dt);
			model.setEnd_dt(end_dt);
			HashMap<String, Object> response = new HashMap<String, Object>();
			response = responseMap.hasContainSamePeriod(model, essodm01400_x10005DAO);
			// 유효성 검사 통과
			if (response.get("MSG").equals("OK")) {
				// 채번 생성
				response = responseMap.createReqNo(model, essodm01400_x10005DAO);
				model.setReq_no((String) response.get("REQ_NO"));
				logger.info("새로 생성된 req_no=========>" + model.getReq_no());
				// 모델로 넘기지 않고 파라미터로 넘긴다.
				parameters.put("P_REQ_NO", model.getReq_no());

				// 유저정보 추가
				GetInsertUpdateInfo userInfo = new GetInsertUpdateInfo();
				parameters.put("P_INSERT_ID", userInfo.getUserId() != null ? userInfo.getUserId() : this.getUserId());
				parameters.put("P_INSERT_IP", userInfo.getIp());
				parameters.put("P_INSERT_DTS", userInfo.getDate());
				essodm01400_x10005DAO.insertEssodm01400_X10005Model(parameters);
				response.put("MSG", model.getReq_no());
			}
			
			return (String) response.get("MSG");
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}

	
	@Transactional(rollbackFor = Exception.class)
	@DzApi(url = "/approve_HR_OFFAPPLY_MST_X10005MST", desc = "결근계 결재", httpMethod = DzRequestMethod.GET)
	public void approve_HR_OFFAPPLY_MST_X10005MST(
			@DzParam(key = "company_cd", desc = "", paramType = DzParamType.QueryString) String company_cd,
			@DzParam(key = "req_no", desc = "", paramType = DzParamType.QueryString) String req_no,
			@DzParam(key = "athz_st_cd", desc = "", paramType = DzParamType.QueryString) String athz_st_cd)
			throws Exception {
		try {
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("P_COMPANY_CD", company_cd);
			parameters.put("P_REQ_NO", req_no);
			parameters.put("P_ATHZ_ST_CD", athz_st_cd);
			logger.info("parameter====>" + parameters);
			
			
			GetInsertUpdateInfo userInfo = new GetInsertUpdateInfo();
			//결재완료 시 결재문서번호 넣기 ATHZ_DOC_CD  예시) EWP_HR_GWA2022050176
			ResponseHashMap responseMap = new ResponseHashMap();
			String doc_no = responseMap.createDocNo(essodm01400_x10005DAO);
			System.out.println("생성된 결재문서번호===>"+doc_no);
			parameters.put("P_ATHZ_DOC_CD", doc_no);
			parameters.put("P_UPDATE_ID", userInfo.getUserId() != null ? userInfo.getUserId() : this.getUserId());
			parameters.put("P_UPDATE_IP", userInfo.getIp());
			parameters.put("P_UPDATE_DTS", userInfo.getDate());
			essodm01400_x10005DAO.approveEssodm01400_X10005Model(parameters);
			
			
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	@DzApi(url = "/delete_HR_OFFAPPLY_MST_X10005MST", desc = "결근계 삭제", httpMethod = DzRequestMethod.GET)
	public String delete_HR_OFFAPPLY_MST_X10005MST(
			@DzParam(key = "company_cd", desc = "", paramType = DzParamType.QueryString) String company_cd,
			@DzParam(key = "req_no", desc = "", paramType = DzParamType.QueryString) String req_no) throws Exception {
		try {
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("P_COMPANY_CD", company_cd);
			parameters.put("P_REQ_NO", req_no);

			logger.info("parameter====>" + parameters);
			HashMap<String, Object> response = new HashMap<String, Object>();
			try {
				essodm01400_x10005DAO.deleteEssodm01400_X10005Model(parameters);
				response.put("MSG", "OK");
			} catch (Exception e) {
				logger.info(e.getMessage());
				response.put("MSG", "FAIL");
			}
			return (String) response.get("MSG");
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}
}
