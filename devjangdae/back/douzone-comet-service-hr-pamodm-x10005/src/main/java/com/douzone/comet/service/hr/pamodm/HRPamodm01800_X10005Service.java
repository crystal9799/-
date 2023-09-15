package com.douzone.comet.service.hr.pamodm;

import com.douzone.comet.components.DzCometService;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.enums.CometModule;
import java.util.List;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.comet.service.hr.pamodm.dao.Pamodm01800_X10005Dao;
import com.douzone.comet.service.hr.pamodm.models.Pamodm01800_X10005Model;
import com.douzone.comet.service.util.StringUtil;
import com.douzone.comet.service.util.exception.DzExceptionWrapper;
import com.douzone.gpd.restful.model.DzGridModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
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
			@DzParam(key = "bizarea_cd", desc = "사업장코드(멀티)", paramType = DzParamType.Body) String bizarea_cd,
			@DzParam(key = "dept_cd", desc = "부서코드(멀티)", paramType = DzParamType.Body) String dept_cd,
			@DzParam(key = "start_dt", desc = "시작시간", paramType = DzParamType.Body) String start_dt,
			@DzParam(key = "end_dt", desc = "종료시간", paramType = DzParamType.Body) String end_dt,
			@DzParam(key = "dof_tp", desc = "휴무유형", paramType = DzParamType.Body) String dof_tp) throws Exception {

		List<Pamodm01800_X10005Model> items = new ArrayList<Pamodm01800_X10005Model>();

		try {
			String[] strToStrArrayBizarea_cd = bizarea_cd.split("\\|");
			String[] strToStrArrayDept_cd = dept_cd.split("\\|");

			HashMap<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("P_COMPANY_CD", this.getCompanyCode());
			
			parameters.put("P_BIZAREA_CD", strToStrArrayBizarea_cd);
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

	@Transactional(rollbackFor = Exception.class)
	@DzApi(url = "/save_HR_STRK_INFO_X10005MST", desc = "행사참가직원등록_마스터_저장", httpMethod = DzRequestMethod.POST)
	public void save_HR_STRK_INFO_X10005MST(
			@DzParam(key = "dataSourceMst", desc = "데이터소스마스터", paramType = DzParamType.Body) DzGridModel<Pamodm01800_X10005Model> dataSourceMst) throws Exception {
			
		try {
			String companyCd = "";
			Integer count;


			// [DELETE 배치]
			for (Pamodm01800_X10005Model row : dataSourceMst.getDeleted()) {

				// COMPANY_CD
				companyCd = pamodm01800_X10005Dao.getCompanyCode(row.getEmp_no());
				if (companyCd == null || companyCd.equals("")) {
					throw new DzApplicationRuntimeException("조회된 사원번호는 존재하지 않습니다.\n재조회 후 처리하십시오.");
				}
				row.setCompany_cd(companyCd);
				// START_DT
				row.setStart_dt(StringUtil.getLocaleTimeString(row.getStart_dt(), "yyyyMMdd"));
				// END_DT
				row.setEnd_dt(StringUtil.getLocaleTimeString(row.getEnd_dt(), "yyyyMMdd"));

				// pamodm01800_X10005Dao.deleteBatch(row); // delete 배치사용함
			}

			if (dataSourceMst.getDeleted() != null && dataSourceMst.getDeleted().size() > 0) {
				pamodm01800_X10005Dao.delete_HR_STRK_INFO_X10005MST(dataSourceMst.getDeleted());
			}


			// [UPDATE 배치]
			for (Pamodm01800_X10005Model row : dataSourceMst.getUpdated()) {

				// COMPANY_CD
				companyCd = pamodm01800_X10005Dao.getCompanyCode(row.getEmp_no());
				if (companyCd == null || companyCd.equals("")) {
					throw new DzApplicationRuntimeException("조회된 사원번호는 존재하지 않습니다.\n재조회 후 처리하십시오.");
				}
				row.setCompany_cd(companyCd);
				row.setEmp_no(row.getEmp_no());
				// START_DT
				row.setStart_dt(StringUtil.getLocaleTimeString(row.getStart_dt(), "yyyyMMdd"));
				// END_DT
				row.setEnd_dt(StringUtil.getLocaleTimeString(row.getEnd_dt(), "yyyyMMdd"));

				row.setDof_tp(row.getDof_tp());
				row.setStart_tm(row.getStart_tm());
				row.setEnd_tm(row.getEnd_tm());
				row.setDof_tm_cnt(row.getDof_tm_cnt());
				row.setLve_tm_cnt(row.getLve_tm_cnt());

				// UPDATE_ID
				row.setUpdate_id(this.getUserId());
				// UPDATE_IP
				row.setUpdate_ip(this.getRemoteHost());
				// UPDATE_DTS
				row.setUpdate_dts(new Date());

				// pamodm01800_X10005Dao.updateBatch(row); //update 배치사용함
			}

			if (dataSourceMst.getUpdated() != null && dataSourceMst.getUpdated().size() > 0) {
				pamodm01800_X10005Dao.update_HR_STRK_INFO_X10005MST(dataSourceMst.getUpdated());
			}


			// [INSERT]
			for (Pamodm01800_X10005Model row : dataSourceMst.getAdded()) {

				// COMPANY_CD
				// companyCd = pamodm01800_X10005Dao.getCompanyCode(row.getEmp_no());
				// if (companyCd == null || companyCd.equals("")) {
				// throw new DzApplicationRuntimeException("조회된 사원번호는 존재하지 않습니다.\n재조회 후
				// 처리하십시오.");
				// } insert의 경우 로그인한 사용자의 회사 코드가 들어가게 됨.
				row.setCompany_cd(this.getCompanyCode());
				// START_DT
				row.setStart_dt(StringUtil.getLocaleTimeString(row.getStart_dt(), "yyyyMMdd"));
				// END_DT
				row.setEnd_dt(StringUtil.getLocaleTimeString(row.getEnd_dt(), "yyyyMMdd"));
				row.setStart_tm(row.getStart_tm());
				row.setEnd_tm(row.getEnd_tm());
				row.setDof_tm_cnt(row.getDof_tm_cnt());
				row.setLve_tm_cnt(row.getLve_tm_cnt());

				// INSERT_ID
				row.setInsert_id(this.getUserId());
				// INSERT_IP
				row.setInsert_ip(this.getRemoteHost());
				// INSERT_DTS
				row.setInsert_dts(new Date());

				count = pamodm01800_X10005Dao.hasContainPrimaryKey(row);
				if (count > 0) {
					throw new DzApplicationRuntimeException("이미 등록된 데이터가 있습니다.\n재조회 후 처리하십시오.");
				}

				pamodm01800_X10005Dao.insert_HR_STRK_INFO_X10005MST(row); // insert 배치아닌경우
			}

		} catch (Exception e) {
			throw DzExceptionWrapper.getDzApplicationRuntimeException(e);
		}
	}
}
