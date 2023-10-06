package utills;

import java.util.Date;
import com.douzone.comet.components.DzCometService;
import com.douzone.comet.service.hr.pamprg.models.Pamprg00100_X10005Model;

public class CommonUtil extends DzCometService{
  
     
	public Pamprg00100_X10005Model setCommonFields(Pamprg00100_X10005Model model, String companyCode, String userId, String userHost) {
 
	        model.setCompany_cd(companyCode);
	        model.setInsert_id(userId);
	        model.setInsert_ip(userHost);
	        model.setUpdate_ip(userHost);
	        model.setInsert_dts(new Date());
	        model.setUpdate_dts(new Date());
	        
	        return model;
	}	 
}
