package com.douzone.comet.service.hr.pamprg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.douzone.comet.components.DzCometService;
import com.douzone.comet.service.hr.pamprg.dao.Pamprg00100_X10005Dao;
import com.douzone.comet.service.hr.pamprg.models.Pamprg00100_X10005Model;
import com.douzone.comet.service.util.mybatis.MyBatisUtil;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import com.douzone.gpd.jdbc.core.MapperType;
import com.douzone.gpd.jdbc.objects.SqlPack;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.CometModule;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;

/**
 * @description : 승급관리기준표_Service
 * @Since : 23.09.12 화요일 작성
 * @Author : minaci
 * @History :
 */
@DzApiService(value = "HRPamprg00100_X10005Service", module = CometModule.HR, desc = "승급기준등록표_Service")
public class HRPamprg00100_X10005Service extends DzCometService {

	@Autowired
	Pamprg00100_X10005Dao pamprg00100_X10005Dao;

	@DzApi(url = "/list_HR_URGDBASETBL_INFO_X10005MST", desc = "승급기준표-조회", httpMethod = DzRequestMethod.POST)
	public List<Pamprg00100_X10005Model> list_HR_URGDBASETBL_INFO_X10005MST(
			@DzParam(key = "mpPROMO_YEAR_MONTH", desc = "승급년월", required = false, paramType = DzParamType.Body) String mpPROMO_YEAR_MONTH,
			@DzParam(key = "BIZAREA_CD", desc = "사업장", required = false, paramType = DzParamType.Body) String BIZAREA_CD)
			throws Exception {
			List<Pamprg00100_X10005Model> pamprg00100_X10005ModelList = new ArrayList<Pamprg00100_X10005Model>();

		try {
			
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			String company_cd = "EWP";
			parameters.put("P_COMPANY_CD", company_cd);
			parameters.put("P_BIZAREA_CD", BIZAREA_CD);
			parameters.put("P_PROMO_YEAR_MONTH", mpPROMO_YEAR_MONTH);
			
			pamprg00100_X10005ModelList = pamprg00100_X10005Dao.selectPamprg00100_X10005ModelList(parameters);
			System.out.println("pamprg00100_X10005ModelList"+pamprg00100_X10005ModelList.toString());
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
		return pamprg00100_X10005ModelList;
	}

	@DzApi(url = "/get_BizareaList", desc = "사업장 조회", httpMethod = DzRequestMethod.GET)
	public List<Map<String, Object>> get_BizareaList() 
		throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			String company_cd = "EWP";
			parameters.put("P_COMPANY_CD", company_cd);
			
			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pamprg00100_X10005Dao.get_BizareaList");
			SqlPack so = new SqlPack();
			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.setSqlText(sqlText);
			so.getInParameters().putAll(parameters);

			list = this.queryForList(so);
  
		} catch (DzApplicationRuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

		return list;
	}
}
