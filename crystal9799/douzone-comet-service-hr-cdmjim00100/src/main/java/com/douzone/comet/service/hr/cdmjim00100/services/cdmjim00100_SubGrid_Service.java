package com.douzone.comet.service.hr.cdmjim00100.services;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.douzone.comet.components.DzCometService;
import com.douzone.comet.service.hr.cdmjim00100.dao.cdmjim00100_SubGrid_Dao;
import com.douzone.comet.service.hr.cdmjim00100.models.cdmjim00100_left_grid;
import com.douzone.comet.service.hr.cdmjim00100.models.cdmjim00100_right_grid1;
import com.douzone.comet.service.hr.cdmjim00100.models.cdmjim00100_right_grid2;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.CometModule;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;

/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
  
@DzApiService(value="Cdmjim00100_SubGrid_Service", module=CometModule.HR, desc="직무분류_서브그리드_서비스")
public class cdmjim00100_SubGrid_Service extends DzCometService {
	
	@Autowired
	cdmjim00100_SubGrid_Dao subgrid_dao;
	
	@DzApi(url="/selectcdmjim00100_left_gridList", desc="세부분류_조회", httpMethod=DzRequestMethod.POST)
	public List<cdmjim00100_left_grid> selectcdmjim00100_left_gridList(
			@DzParam(key = "ACLF_NO", desc = "능력분류번호", defaultValue = "", required = false, paramType = DzParamType.Body) String ACLF_NO,
			@DzParam(key = "VER_CD", desc = "버전", defaultValue = "", required = false, paramType = DzParamType.Body) String VER_CD
	)throws Exception{
		List<cdmjim00100_left_grid> left_grid_List = new ArrayList<>();
		try {
			System.out.println("ACLF_NO = "+ ACLF_NO);
			System.out.println("VER_CD = "+ VER_CD);
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("ACLF_NO", ACLF_NO);
			parameters.put("VER_CD", VER_CD);
			
			left_grid_List = subgrid_dao.selectcdmjim00100_left_gridList(parameters);
			
			for(cdmjim00100_left_grid lg:left_grid_List){
				lg.set_uid(UUID.randomUUID().toString());
			}
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
		return left_grid_List;
	}
	@DzApi(url="/cdmjim00100_right_grid1_List", desc="수행준거_상단_조회", httpMethod=DzRequestMethod.POST)
	public List<cdmjim00100_right_grid1> right1_grid_List(
			@DzParam(key = "ACLF_NO", desc = "능력분류번호", defaultValue = "", required = false, paramType = DzParamType.Body) String ACLF_NO,
			@DzParam(key = "VER_CD", desc = "버전", defaultValue = "", required = false, paramType = DzParamType.Body) String VER_CD,
			@DzParam(key = "AELM_CD", desc = "능력단위요소번호", defaultValue = "", required = false, paramType = DzParamType.Body) String AELM_CD
			)throws Exception{
		List<cdmjim00100_right_grid1> right_grid1_List = new ArrayList<>();
		try {
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("COMPANY_CD", this.getCompanyCode());
			parameters.put("ACLF_NO", ACLF_NO);
			parameters.put("VER_CD", VER_CD);
			parameters.put("AELM_CD", AELM_CD);
			
			right_grid1_List = subgrid_dao.selectcdmjim00100_right_grid1List(parameters);
			
			for(cdmjim00100_right_grid1 rg1:right_grid1_List){
				rg1.set_uid(UUID.randomUUID().toString());
			}
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
		return right_grid1_List;
	}
	@DzApi(url="/cdmjim00100_right_grid2_List", desc="수행준거_하단_조회", httpMethod=DzRequestMethod.POST)
	public List<cdmjim00100_right_grid2> right2_grid_List(
			@DzParam(key = "ACLF_NO", desc = "능력분류번호", defaultValue = "", required = false, paramType = DzParamType.Body) String ACLF_NO,
			@DzParam(key = "VER_CD", desc = "버전", defaultValue = "", required = false, paramType = DzParamType.Body) String VER_CD,
			@DzParam(key = "PCFM_CD", desc = "수행준거번호", defaultValue = "", required = false, paramType = DzParamType.Body) String PCFM_CD,
			@DzParam(key = "AELM_CD", desc = "능력요소코드", defaultValue = "", required = false, paramType = DzParamType.Body) String AELM_CD
			)throws Exception{
		List<cdmjim00100_right_grid2> right_grid2_List = new ArrayList<>();
		try {
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("COMPANY_CD", this.getCompanyCode());
			parameters.put("ACLF_NO", ACLF_NO);
			parameters.put("VER_CD", VER_CD);
			parameters.put("PCFM_CD", PCFM_CD);
			parameters.put("AELM_CD", AELM_CD);
						
			right_grid2_List = subgrid_dao.selectcdmjim00100_right_grid2List(parameters);
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
		return right_grid2_List;
	}
}
