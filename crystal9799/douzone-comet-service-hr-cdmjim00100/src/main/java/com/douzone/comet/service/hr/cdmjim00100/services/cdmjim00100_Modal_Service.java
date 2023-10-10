package com.douzone.comet.service.hr.cdmjim00100.services;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.douzone.comet.components.DzCometService;
import com.douzone.comet.service.hr.cdmjim00100.dao.cdmjim00100_Modal;
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
  
@DzApiService(value="Cdmjim00100_Modal_Service", module=CometModule.HR, desc="직무분류관리_모달_서비스")
public class cdmjim00100_Modal_Service extends DzCometService {
	
	@Autowired
	cdmjim00100_Modal dao;

	@DzApi(url = "/selectFgList", desc = "직무분류_등록구분_조회", httpMethod = DzRequestMethod.POST)
	public List<Map<String, Object>> selectFgList(
			@DzParam(key = "param_cd", desc = "선택분류_코드", defaultValue = "", required = false, paramType = DzParamType.Body) String param_cd,
			@DzParam(key = "param_name", desc = "선택분류_이름", defaultValue = "", required = false, paramType = DzParamType.Body) String param_name,
			@DzParam(key = "LCLAS_CD", desc = "대분류", defaultValue = "", required = false, paramType = DzParamType.Body) String LCLAS_CD,
			@DzParam(key = "MLSFC_CD", desc = "중분류", defaultValue = "", required = false, paramType = DzParamType.Body) String MLSFC_CD,
			@DzParam(key = "S_CSF_CD", desc = "소분류", defaultValue = "", required = false, paramType = DzParamType.Body) String S_CSF_CD,
			@DzParam(key = "TCLF_CD", desc = "세분류", defaultValue = "", required = false, paramType = DzParamType.Body) String TCLF_CD,
			@DzParam(key = "ACLF_CD", desc = "능력단위코드", defaultValue = "", required = false, paramType = DzParamType.Body) String ACLF_CD,
			@DzParam(key = "ACLF_LV", desc = "능력단위레벨", defaultValue = "", required = false, paramType = DzParamType.Body) String ACLF_LV,
			@DzParam(key = "TARGET", desc = "검색분류", defaultValue = "", required = false, paramType = DzParamType.Body) String TARGET,
			@DzParam(key = "NAME", desc = "검색내용", defaultValue = "", required = false, paramType = DzParamType.Body) String NAME
	)throws Exception{
		List<Map<String,Object>> fgList = new ArrayList<>();
		try {
			System.out.println("param_cd ========= " + param_cd);
			System.out.println("param_name ========= " + param_name);
			System.out.println("TARGET ========" + TARGET);
			System.out.println("NAME ========" + NAME);
			Map<String, Object> parameters = new HashMap<>();
			System.out.println("COMPANY_CD ========= " + this.getCompanyCode());
			parameters.put("COMPANY_CD", this.getCompanyCode());
			parameters.put("param_cd", param_cd);
			parameters.put("param_name", param_name);
			parameters.put("LCLAS_CD", LCLAS_CD);
			parameters.put("MLSFC_CD", MLSFC_CD);
			parameters.put("S_CSF_CD", S_CSF_CD);
			parameters.put("TCLF_CD", TCLF_CD);
			parameters.put("TARGET", TARGET);
			parameters.put("NAME", NAME);
									
			fgList = dao.selectFgList(parameters);
			System.out.println("출력 분류 ========= >" + fgList);
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
		return fgList;
	}
}
