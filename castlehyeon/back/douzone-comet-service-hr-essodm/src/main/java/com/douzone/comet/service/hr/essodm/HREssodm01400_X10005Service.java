package com.douzone.comet.service.hr.essodm;
 
import com.douzone.comet.components.DzCometService;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.enums.CometModule;
import java.util.List;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.comet.service.hr.essodm.dao.Essodm01400_x10005Dao;
import com.douzone.comet.service.hr.essodm.models.Essodm01400_X10005Model;
import com.douzone.gpd.restful.model.DzGridModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
@DzApiService(value="HREssodm01400_X10005Service", module=CometModule.HR, desc="결근계 신청")
public class HREssodm01400_X10005Service extends DzCometService {

	@Autowired
	Essodm01400_x10005Dao essodm01400_x10005DAO; 

	@DzApi(url="/list_HR_OFFAPPLY_MST_X10005", desc="결근계 조회", httpMethod=DzRequestMethod.GET)
	public List<Essodm01400_X10005Model> list_HR_OFFAPPLY_MST_X10005(
		@DzParam(key="start_dt", desc="시작일", paramType = DzParamType.QueryString) String start_dt,
		@DzParam(key="end_dt", desc="종료일", paramType = DzParamType.QueryString) String end_dt,
		@DzParam(key="company_cd", desc="회사코드", paramType = DzParamType.QueryString) String company_cd,
		@DzParam(key="emp_no", desc="사원번호", paramType = DzParamType.QueryString) String emp_no
	) throws Exception {
		List<Essodm01400_X10005Model> essodm01400_X10005ModelList =  new ArrayList<Essodm01400_X10005Model>();
		try {
	 		Essodm01400_X10005Model essodm01400_X10005Model = new Essodm01400_X10005Model();
	 		essodm01400_X10005Model.setStart_dt(start_dt);
			essodm01400_X10005Model.setEnd_dt(end_dt);
			essodm01400_X10005Model.setCompany_cd(company_cd);
			essodm01400_X10005Model.setEmp_no(emp_no);
			//essodm01400_X10005Model.setCompany_cd(this.getCompanyCode());
			//essodm01400_X10005Model.setLang_cd(this.getLanguage().toUpperCase());
	 		essodm01400_X10005ModelList = essodm01400_x10005DAO.selectEssodm01400_X10005ModelList(essodm01400_X10005Model);
	 	} catch(Exception e) {
	        throw new DzApplicationRuntimeException(e);
	    }
	    
	    return essodm01400_X10005ModelList;
 	}

	@Transactional(rollbackFor = Exception.class)
	@DzApi(url="/save_HR_OFFAPPLY_MST_X10005", desc="결근계 신청", httpMethod=DzRequestMethod.POST)
	public void save_HR_OFFAPPLY_MST_X10005(
		@DzParam(key="Essodm01400_X10005Model", desc="모델", paramType = DzParamType.Body) DzGridModel<Essodm01400_X10005Model> Essodm01400_X10005Model
	) throws Exception {	    
	    try {	        	        
	        // update
	        for(Essodm01400_X10005Model essodm01400_X10005Model : Essodm01400_X10005Model.getUpdated()) {
	        	essodm01400_x10005DAO.updateEssodm01400_X10005Model(essodm01400_X10005Model);
	        }
	        
	        // delete
	        for(Essodm01400_X10005Model essodm01400_X10005Model : Essodm01400_X10005Model.getDeleted()) {
	        	essodm01400_x10005DAO.deleteEssodm01400_X10005Model(essodm01400_X10005Model);
	        }
	        
	        // add
	        for(Essodm01400_X10005Model essodm01400_X10005Model : Essodm01400_X10005Model.getAdded()) {
	        	essodm01400_x10005DAO.insertEssodm01400_X10005Model(essodm01400_X10005Model);
	        }
	        
	    } catch (Exception e) {
	        throw new DzApplicationRuntimeException(e);
	    }
	}
}
