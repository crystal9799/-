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
import com.douzone.comet.service.hr.essodm.models.Essodm01400_X10005Model;
import com.douzone.comet.service.hr.essodm.models.Essodm01400_X10005_UserInfoModel;
import com.douzone.comet.service.hr.essodm.models.ResponseHashMap;
import com.douzone.gpd.restful.model.DzGridModel;
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

	// 이건 사용하지 않을 것 그리드에서 기본정보를 다 들고 있음.
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

	// posi_cd=19, end_dt=20201208, reason_dc=수술, req_no=PAB202010300005,
	// pstn_cd=2C, req_emp_no=KHLEE,
	// start_dt=20201201, dept_cd=50042165, emp_no=KHLEE, company_cd=EWP, req_dy=8,
	// ogrp_cd=B, dnl_cd=5100,

	//// 기본키
//                        company_cd: self.COMPANY_CD.text(),//회사코드
//                        req_no: self.main_grid.getCellValue(0, 'REQ_NO'), // 신청번호
//
//
//                        //소속 (사업장/부서)
//                        bizarea_cd: self.main_grid.getCellValue(0, 'BIZAREA_CD'), //사업장코드
//                        dept_cd: self.main_grid.getCellValue(0, 'DEPT_CD'),
//
//                        //결근 대상자 정보
//                        emp_no: self.EMP_NO.text(),  // 결근 대상자 사원번호
//                        pstn_cd: self.main_grid.getCellValue(0, 'PSTN_CD'), // 결근 대상자 직급코드
//                        ogrp_cd: self.main_grid.getCellValue(0, 'OGRP_CD'), // 직군코드
//                        posi_cd: self.main_grid.getCellValue(0, 'POSI_CD'), // 직위 코드
//
//                        //결근 신청자 정보
//                        req_emp_no: self.REQ_EMP_NO.text(), // 결근 신청하는(현재 로그인한) 사원번호
//                        dnl_cd: self.DNL_CD.value(), // 현재 선택되어 있는 드랍다운리스트의 value 값
//                        start_dt: self.START_DT.value(),
//                        end_dt: self.END_DT.value(),
//                        req_dy: self.main_grid.getCellValue(0, 'REQ_DY'),
//                        reason_dc: self.main_grid.getCellValue(0, 'REASON_DC')
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
//	    	parameters.put("P_START_DT", start_dt.substring(0, 9).replace("-", ""));
			parameters.put("P_START_DT", start_dt);
			parameters.put("P_END_DT", end_dt);
			parameters.put("P_REQ_DY", req_dy);
			parameters.put("P_REASON_DC", reason_dc);

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

			if (response.get("MSG").equals("OK")) {
				essodm01400_x10005DAO.updateEssodm01400_X10005Model(parameters);
			}

			return (String) response.get("MSG");
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}
}

// update
//	        for(Essodm01400_X10005Model essodm01400_X10005Model : main_ds.getUpdated()) {
//	        	essodm01400_x10005DAO.updateEssodm01400_X10005Model(essodm01400_X10005Model);
//	        }

// delete
//	        for(Essodm01400_X10005Model essodm01400_X10005Model : main_ds.getDeleted()) {
//	        	essodm01400_x10005DAO.deleteEssodm01400_X10005Model(essodm01400_X10005Model);
//	        }

// add
//	        for(Essodm01400_X10005Model essodm01400_X10005Model : main_ds.getAdded()) {
//	        	
//	        	essodm01400_x10005DAO.insertEssodm01400_X10005Model(essodm01400_X10005Model);
//	        }
