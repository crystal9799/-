package com.douzone.comet.service.hr.cdmjim00100.services;
 
import com.douzone.comet.components.DzCometService;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.enums.CometModule;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.comet.service.hr.cdmjim00100.dao.cdmjim00100_MainGrid_Dao;
import com.douzone.comet.service.hr.cdmjim00100.dao.cdmjim00100_SubGrid_Dao;
import com.douzone.comet.service.hr.cdmjim00100.models.cdmjim00100_left_grid;
import com.douzone.comet.service.hr.cdmjim00100.models.cdmjim00100_maingrid;
import com.douzone.gpd.restful.model.DzGridModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	HttpServletRequest request;
	
	@Autowired
	cdmjim00100_MainGrid_Dao cdmjim00100_maingridDAO; 
	cdmjim00100_SubGrid_Dao cdmjim00100_subgridDAO;

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

//	@Transactional(rollbackFor = Exception.class)
	@DzApi(url="/cdmjim00100_MainGrid_Save", desc="메인그리드_저장", httpMethod=DzRequestMethod.POST)
	public void cdmjim00100_MainGrid_Save(
		@DzParam(key="MAIN_DS", desc="메인그리드튜플", paramType = DzParamType.Body, required = false) DzGridModel<cdmjim00100_maingrid> MAIN_DS
	) throws Exception {	    
		System.out.println("받아온 데이터 정보1 : ====== > " + MAIN_DS.toString());
	    try {	        	
	    	//Add List
	    	List<cdmjim00100_maingrid> add_list = new ArrayList<>();
	    	add_list = MAIN_DS.getAdded();
	    	
	    	//Update List
	    	List<cdmjim00100_maingrid> update_List = new ArrayList<>();
	    	update_List = MAIN_DS.getUpdated();
	    	//Delete List
	    	List<cdmjim00100_maingrid> delete_List = new ArrayList<>();
	    	delete_List = MAIN_DS.getDeleted();
	    	
	    	//Add
	    	if(add_list != null) {
	    		for(cdmjim00100_maingrid add_data: add_list) {	    			
	    			System.out.println("인서트 데이터 정보 : ====== > " + add_list.toString());
	    			//능력분류번호 채번
//	    			String num = add_data.getLclas_cd() + add_data.getMlsfc_cd() + add_data.getS_csf_cd() + add_data.getTclf_cd() + add_data.getAclf_cd();
	    			//채번한 값 모델에 set
//	    			add_data.setAclf_no(num);  	    		
	    			add_data.setUSER_ID(this.getUserId());
	    			add_data.setIP(request.getRemoteAddr());
	    			cdmjim00100_maingridDAO.insertcdmjim00100_maingrid(add_data);
	    		}
	    	}
	    	if(update_List != null) {
	    		for(cdmjim00100_maingrid update_data: update_List) {
	    			System.out.println("업데이트 데이터 정보 : ====== > " + update_data.toString());
	    			update_data.setCompany_cd(getCompanyCode());
	    			update_data.setUSER_ID(this.getUserId());
	    			update_data.setIP(request.getRemoteAddr());
	    			cdmjim00100_maingridDAO.updatecdmjim00100_maingrid(update_data);
	    		}	    		
	    	}
	    	if(delete_List != null) {
	    		for(cdmjim00100_maingrid delete_data: delete_List) {
	    			System.out.println("딜리트 데이터 정보 : ====== > " + delete_data.toString());
	    			delete_data.setCompany_cd(getCompanyCode());
	    			cdmjim00100_maingridDAO.deletecdmjim00100_maingrid(delete_data);
	    			
	    			//하위 그리드 삭제
	    			Map<String, Object> parameters = new HashMap<>();
	    			parameters.put("ACLF_NO", delete_data.getAclf_no());
	    			parameters.put("VER_CD", delete_data.getVer_cd());
	    			cdmjim00100_subgridDAO.deletecdmjim00100_right1_grid_all(parameters);
	    			cdmjim00100_subgridDAO.deletecdmjim00100_right2_grid_all(parameters);
	    		}	    		
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace(); // 예외의 스택 트레이스 출력
	        throw new DzApplicationRuntimeException(e);
	    }
	}
	
}
