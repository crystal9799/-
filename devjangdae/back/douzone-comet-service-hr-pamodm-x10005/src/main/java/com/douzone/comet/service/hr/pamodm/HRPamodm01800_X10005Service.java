package com.douzone.comet.service.hr.pamodm;

import com.douzone.comet.components.DzCometService;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.enums.CometModule;
import java.util.List;
import java.util.Map;

import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.comet.service.hr.pamodm.dao.Pamodm01800_X10005Dao;
import com.douzone.comet.service.hr.pamodm.models.Pamodm01800_X10005Model;
import com.douzone.gpd.restful.model.DzGridModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @description : 행사참가직원등록_Service
 * @Since : 2023-09-12
 * @Author : 서장대
 * @History : 개발시작
 */
@DzApiService(value = "HRPamodm01800_X10005Service", module = CometModule.HR, desc = "행사참가직원등록_Service", version = "1.0.20230913.01")
public class HRPamodm01800_X10005Service extends DzCometService {

	@Autowired
	Pamodm01800_X10005Dao pamodm01800_X10005Dao;

	@DzApi(url = "/HRPamodm01800_X10005Service_test", desc = "행사참가직원등록_Service_test", httpMethod = DzRequestMethod.GET)
	public List<Pamodm01800_X10005Model> HRPamodm01800_X10005Service_test() throws Exception {

		List<Pamodm01800_X10005Model> modelList = new ArrayList<Pamodm01800_X10005Model>();

		try {
			Pamodm01800_X10005Model model = new Pamodm01800_X10005Model();
			modelList = pamodm01800_X10005Dao.HRPamodm01800_X10005Service_test(model);
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return modelList;
	}
	
	@DzApi(url = "/list_HR_STRK_INFO_X10005MST", desc = "행사참가직원등록_마스터_조회", httpMethod = DzRequestMethod.POST)
	public List<Pamodm01800_X10005Model> list_HR_STRK_INFO_X10005MST(
			@DzParam(key = "company_cd", desc = "회사코드(멀티)", paramType = DzParamType.Body) String company_cd,
			@DzParam(key = "dept_cd", desc = "부서코드(멀티)", paramType = DzParamType.Body) String dept_cd,
			@DzParam(key = "start_dt", desc = "시작시간", paramType = DzParamType.Body) String start_dt,
			@DzParam(key = "end_dt", desc = "종료시간", paramType = DzParamType.Body) String end_dt,
			@DzParam(key = "dof_tp", desc = "휴무유형", paramType = DzParamType.Body) String dof_tp) throws Exception {
			
		List<Pamodm01800_X10005Model> items = new ArrayList<Pamodm01800_X10005Model>();
		
		try {
			String[] strToStrArrayCompany_cd = company_cd.split("\\|");
			String[] strToStrArrayDept_cd = dept_cd.split("\\|");

			HashMap<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("P_COMPANY_CD", strToStrArrayCompany_cd);
			parameters.put("P_DEPT_CD", strToStrArrayDept_cd);
			parameters.put("P_START_DT", start_dt);
			parameters.put("P_END_DT", end_dt);
			parameters.put("P_DOF_TP", dof_tp);

			items = pamodm01800_X10005Dao.list_HR_STRK_INFO_X10005MST(parameters);
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return items;
	}
}
