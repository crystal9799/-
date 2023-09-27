package com.douzone.comet.service.hr.cdmjim00100.services;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.douzone.comet.components.DzCometService;
import com.douzone.comet.service.hr.cdmjim00100.dao.cdmjim00100_SubGrid_Dao;
import com.douzone.comet.service.hr.cdmjim00100.models.cdmjim00100_left_grid;
import com.douzone.comet.service.hr.cdmjim00100.models.cdmjim00100_maingrid;
import com.douzone.comet.service.hr.cdmjim00100.models.cdmjim00100_right_grid1;
import com.douzone.comet.service.hr.cdmjim00100.models.cdmjim00100_right_grid2;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.CometModule;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.gpd.restful.model.DzGridModel;

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
	
	@Autowired
	HttpServletRequest request;
	
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
	
	
	@DzApi(url="/selectcdmjim00100_right_grid1List", desc="수행준거_상단_조회", httpMethod=DzRequestMethod.POST)
	public List<cdmjim00100_right_grid1> selectcdmjim00100_right_grid1List(
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
			System.out.println(right_grid1_List.toString());
			
			for(cdmjim00100_right_grid1 rg1:right_grid1_List){
				rg1.set_uid(UUID.randomUUID().toString());
			}
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
		return right_grid1_List;
	}
	
	
	@DzApi(url="/selectcdmjim00100_right_grid2List", desc="수행준거_하단_조회", httpMethod=DzRequestMethod.POST)
	public List<cdmjim00100_right_grid2> selectcdmjim00100_right_grid2List(
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
	
	@DzApi(url="/cdmjim00100_Leftgrid_Save", desc="세부분류_저장", httpMethod=DzRequestMethod.POST)
	public void cdmjim00100_Leftgrid_Save(
		@DzParam(key="LEFT_DS", desc="세부분류", paramType = DzParamType.Body) DzGridModel<cdmjim00100_left_grid> LEFT_DS

	) throws Exception {	    
		System.out.println("받아온 데이터 정보1 : ====== > " + LEFT_DS.toString());
	    try {	        	
	    	//Add List
	    	List<cdmjim00100_left_grid> add_list = new ArrayList<>();
	    	add_list = LEFT_DS.getAdded();
	    	//Update List
	    	List<cdmjim00100_left_grid> update_List = new ArrayList<>();
	    	update_List = LEFT_DS.getUpdated();
	    	//Delete List
	    	List<cdmjim00100_left_grid> delete_List = new ArrayList<>();
	    	delete_List = LEFT_DS.getDeleted();
	    	
	    	//Add
	    	if(add_list != null) {
	    		for(cdmjim00100_left_grid add_data: add_list) {
	    			System.out.println("인서트 데이터 정보 : ====== > " + add_list.toString());	 
	    			add_data.setCompany_cd(this.getCompanyCode());
	    			add_data.setUSER_ID(getUserId());
	    			add_data.setIP(request.getRemoteAddr());
	    			System.out.println("아이피 입력 테스트 ===========================" + request.getRemoteAddr());
	    			subgrid_dao.insertcdmjim00100_leftgrid(add_data);
	    		}	    		
	    	}
	    	if(update_List != null) {
	    		for(cdmjim00100_left_grid update_data: update_List) {
	    			System.out.println("업데이트 데이터 정보 : ====== > " + update_data.toString());
	    			update_data.setIP(request.getRemoteAddr());
	    			update_data.setUSER_ID(getUserId());
	    			subgrid_dao.updatecdmjim00100_left_grid(update_data);
	    		}	    		
	    	}
	    	if(delete_List != null) {
	    		for(cdmjim00100_left_grid delete_data: delete_List) {
	    			System.out.println("딜리트 데이터 정보 : ====== > " + delete_data.toString());
	    			delete_data.setCompany_cd(this.getCompanyCode());
	    			subgrid_dao.deletecdmjim00100_left_grid(delete_data);
	    			
	    			//하위 그리드 삭제
	    			Map<String, Object> parameters = new HashMap<>();
	    			parameters.put("ACLF_NO", delete_data.getAclf_no());
	    			parameters.put("VER_CD", delete_data.getVer_cd());
	    			parameters.put("AELM_CD", delete_data.getAelm_cd());
	    			parameters.put("COMPANY_CD", this.getCompanyCode());
	    			subgrid_dao.deletecdmjim00100_right1_grid_all(parameters);
	    			subgrid_dao.deletecdmjim00100_right2_grid_all(parameters);
	    		}	    		
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace(); // 예외의 스택 트레이스 출력
	        throw new DzApplicationRuntimeException(e);
	    }
	}
	@DzApi(url="/cdmjim00100_Right1grid_Save", desc="수행준거내역1_저장", httpMethod=DzRequestMethod.POST)
	public void cdmjim00100_Right1grid_Save(
		@DzParam(key="RIGHT1_DS", desc="세부분류", paramType = DzParamType.Body) DzGridModel<cdmjim00100_right_grid1> RIGHT1_DS

	) throws Exception {	    
		System.out.println("받아온 데이터 정보1 : ====== > " + RIGHT1_DS.toString());
	    try {	        	
	    	//Add List
	    	List<cdmjim00100_right_grid1> add_list = new ArrayList<>();
	    	add_list = RIGHT1_DS.getAdded();
	    	//Update List
	    	List<cdmjim00100_right_grid1> update_List = new ArrayList<>();
	    	update_List = RIGHT1_DS.getUpdated();
	    	//Delete List
	    	List<cdmjim00100_right_grid1> delete_List = new ArrayList<>();
	    	delete_List = RIGHT1_DS.getDeleted();
	    	
	    	//Add
	    	if(add_list != null) {
	    		for(cdmjim00100_right_grid1 add_data: add_list) {
	    			System.out.println("인서트 데이터 정보 : ====== > " + add_list.toString());	
	    			System.out.println("컴퍼니 코드 ======= > " + this.getCompanyCode());
	    			add_data.setCompany_cd(this.getCompanyCode());
	    			add_data.setUSER_ID(this.getUserId());
	    			add_data.setIP(request.getRemoteAddr());
	    			System.out.println("아이피 입력 테스트 ===========================" + request.getRemoteAddr());
	    			subgrid_dao.insertcdmjim00100_right1_grid(add_data);
	    		}	    		
	    	}
	    	if(update_List != null) {
	    		for(cdmjim00100_right_grid1 update_data: update_List) {
	    			System.out.println("업데이트 데이터 정보 : ====== > " + update_data.toString());
	    			update_data.setIP(request.getRemoteAddr());
	    			update_data.setCompany_cd(this.getCompanyCode());
	    			update_data.setUSER_ID(this.getUserId());
	    			subgrid_dao.updatecdmjim00100_right1_grid(update_data);
	    		}	    		
	    	}
	    	if(delete_List != null) {
	    		for(cdmjim00100_right_grid1 delete_data: delete_List) {
	    			System.out.println("딜리트 데이터 정보 : ====== > " + delete_data.toString());
	    			delete_data.setCompany_cd(this.getCompanyCode());
	    			subgrid_dao.deletecdmjim00100_right1_grid(delete_data);
	    			
	    			//하위 그리드 삭제
	    			Map<String, Object> parameters = new HashMap<>();
	    			parameters.put("ACLF_NO", delete_data.getAclf_no());
	    			parameters.put("VER_CD", delete_data.getVer_cd());
	    			parameters.put("AELM_CD", delete_data.getAelm_cd());
	    			parameters.put("COMPANY_CD", this.getCompanyCode());
	    			parameters.put("PCFM_CD", delete_data.getPCFM_CD());
	    			subgrid_dao.deletecdmjim00100_right2_grid_all(parameters);
	    		}	    		
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace(); // 예외의 스택 트레이스 출력
	        throw new DzApplicationRuntimeException(e);
	    }
	}
	
	@DzApi(url="/cdmjim00100_Right2grid_Save", desc="수행준거내역2_저장", httpMethod=DzRequestMethod.POST)
	public void cdmjim00100_Right2grid_Save(
		@DzParam(key="RIGHT2_DS", desc="세부분류", paramType = DzParamType.Body) DzGridModel<cdmjim00100_right_grid2> RIGHT2_DS

	) throws Exception {	    
		System.out.println("받아온 데이터 정보1 : ====== > " + RIGHT2_DS.toString());
	    try {	        	
	    	//Add List
	    	List<cdmjim00100_right_grid2> add_list = new ArrayList<>();
	    	add_list = RIGHT2_DS.getAdded();
	    	//Update List
	    	List<cdmjim00100_right_grid2> update_List = new ArrayList<>();
	    	update_List = RIGHT2_DS.getUpdated();
	    	//Delete List
	    	List<cdmjim00100_right_grid2> delete_List = new ArrayList<>();
	    	delete_List = RIGHT2_DS.getDeleted();
	    	
	    	//Add
	    	if(add_list != null) {
	    		for(cdmjim00100_right_grid2 add_data: add_list) {
	    			System.out.println("인서트 데이터 정보 : ====== > " + add_list.toString());	
	    			System.out.println("컴퍼니 코드 ======= > " + this.getCompanyCode());
	    			add_data.setCOMPANY_CD(this.getCompanyCode());
	    			add_data.setUSER_ID(this.getUserId());
	    			add_data.setIP(request.getRemoteAddr());
	    			System.out.println("아이피 입력 테스트 ===========================" + request.getRemoteAddr());
	    			subgrid_dao.insertcdmjim00100_right2_grid(add_data);
	    		}	    		
	    	}
	    	//UPDATE
	    	if(update_List != null) {
	    		for(cdmjim00100_right_grid2 update_data: update_List) {
	    			System.out.println("업데이트 데이터 정보 : ====== > " + update_data.toString());
	    			update_data.setIP(request.getRemoteAddr());
	    			update_data.setCOMPANY_CD(this.getCompanyCode());
	    			update_data.setUSER_ID(this.getUserId());
	    			subgrid_dao.updatecdmjim00100_right2_grid1(update_data);
	    			subgrid_dao.updatecdmjim00100_right2_grid2(update_data);
	    			subgrid_dao.updatecdmjim00100_right2_grid3(update_data);
	    		}	    		
	    	}
	    	//DELETE
	    	if(delete_List != null) {
	    		for(cdmjim00100_right_grid2 delete_data: delete_List) {
	    			System.out.println("딜리트 데이터 정보 : ====== > " + delete_data.toString());
	    			delete_data.setCOMPANY_CD(this.getCompanyCode());
	    			subgrid_dao.deletecdmjim00100_right2_grid(delete_data);
	    		}	    		
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace(); // 예외의 스택 트레이스 출력
	        throw new DzApplicationRuntimeException(e);
	    }
	}
}
