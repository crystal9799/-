package com.douzone.comet.service.hr.pamprg;

import com.douzone.comet.components.DzCometService;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.enums.CometModule;
import java.util.List;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.comet.service.hr.pamprg.dao.Pamprg00100_X100055Dao;
import com.douzone.comet.service.hr.pamprg.models.Pamprg00100_X10005Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

/**
 * @description : 승급관리기준표_Service
 * @Since : 23.09.12 화요일 작성
 * @Author : minaci
 * @History :
 */
@DzApiService(value = "HRPamprg00100_X10005Service", module = CometModule.HR, desc = "승급기준등록표_Service")
public class HRPamprg00100_X10005Service extends DzCometService {

	@Autowired
	Pamprg00100_X100055Dao pamprg00100_X100055Dao;

	@DzApi(url = "/list_HR_URGDBASETBL_INFO_X10005MST", desc = "승급기준표-조회", httpMethod = DzRequestMethod.GET)
	public List<Pamprg00100_X10005Model> list_HR_URGDBASETBL_INFO_X10005MST(
			@DzParam(key = "STD_YM", desc = "승급년월", required = false, paramType = DzParamType.QueryString) String STD_YM,
			@DzParam(key = "BIZAREA_CD", desc = "사업장", required = false, paramType = DzParamType.QueryString) String BIZAREA_CD)
			throws Exception {
		List<Pamprg00100_X10005Model> pamprg00100_X10005ModelList = new ArrayList<Pamprg00100_X10005Model>();
		try {
			Pamprg00100_X10005Model pamprg00100_X10005Model = new Pamprg00100_X10005Model();
			pamprg00100_X10005Model.setStd_ym(STD_YM);
			pamprg00100_X10005Model.setBizarea_cd(BIZAREA_CD);
 
			pamprg00100_X10005ModelList = pamprg00100_X100055Dao
					.selectPamprg00100_X10005ModelList(pamprg00100_X10005Model);
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return pamprg00100_X10005ModelList;
	}
}
