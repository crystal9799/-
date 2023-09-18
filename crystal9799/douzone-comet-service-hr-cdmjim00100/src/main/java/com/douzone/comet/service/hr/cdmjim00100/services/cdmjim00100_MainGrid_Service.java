package com.douzone.comet.service.hr.cdmjim00100.services;
 
import com.douzone.comet.components.DzCometService;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.enums.CometModule;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.comet.service.hr.cdmjim00100.dao.cdmjim00100_MainGrid_Dao;
import com.douzone.comet.service.hr.cdmjim00100.models.cdmjim00100_maingrid;
import com.douzone.gpd.restful.model.DzGridModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashMap;

/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
@DzApiService(value="Cdmjim00100_MainGrid_Service", module=CometModule.HR, desc="메인그리드_서비스")
public class cdmjim00100_MainGrid_Service extends DzCometService {

	@Autowired
	cdmjim00100_MainGrid_Dao cdmjim00100_maingridDAO; 

	@DzApi(url="/cdmjim00100_MainGrid_List", desc="메인그리드_조회", httpMethod=DzRequestMethod.POST)
	public List<cdmjim00100_maingrid> cdmjim00100_MainGrid_List(
		@DzParam(key="JOB_FG", desc="직무구분", required = false, defaultValue = "", paramType = DzParamType.Body) String JOB_FG,
		@DzParam(key="USE_YN", desc="사용여부", required = false, defaultValue = "", paramType = DzParamType.Body) String USE_YN,
		@DzParam(key="lst_ver_yn", desc = "최종조건", required = false, defaultValue = "", paramType = DzParamType.Body) String lst_ver_yn
	) throws Exception {
		List<cdmjim00100_maingrid> cdmjim00100_maingridList =  new ArrayList<cdmjim00100_maingrid>();
		try {
	 		Map<String, Object> cdmjim00100_maingrid = new HashMap<>();
	 		System.out.println("lst_ver_yn = " + lst_ver_yn);
	 		System.out.println("COMPANY_CD = " + this.getCompanyCode());
	 		System.out.println("JOB_FG = " + JOB_FG);
	 		System.out.println("USE_YN = " + USE_YN);
	 		cdmjim00100_maingrid.put("lst_ver_yn", "true".equals(lst_ver_yn) ? "true" : null);
	 		cdmjim00100_maingrid.put("COMPANY_CD",this.getCompanyCode());
			cdmjim00100_maingrid.put("JOB_FG",JOB_FG);
			cdmjim00100_maingrid.put("USE_YN",USE_YN);
	 		cdmjim00100_maingridList = cdmjim00100_maingridDAO.selectcdmjim00100_maingridList(cdmjim00100_maingrid);
	 		for(cdmjim00100_maingrid mg: cdmjim00100_maingridList){
	 			mg.set_uid(UUID.randomUUID().toString());
	 		}
	 	} catch(Exception e) {
	        throw new DzApplicationRuntimeException(e);
	    }
	    
	    return cdmjim00100_maingridList;
 	}

	@Transactional(rollbackFor = Exception.class)
	@DzApi(url="/cdmjim00100_MainGrid_Save", desc="메인그리드_저장", httpMethod=DzRequestMethod.POST)
	public void cdmjim00100_MainGrid_Save(
		@DzParam(key="cdmjim00100_MainGrid", desc="메인그리드튜플", paramType = DzParamType.Body) DzGridModel<cdmjim00100_maingrid> cdmjim00100_MainGrid
	) throws Exception {	    
	    try {	        	        

	    } catch (Exception e) {
	        throw new DzApplicationRuntimeException(e);
	    }
	}
}
