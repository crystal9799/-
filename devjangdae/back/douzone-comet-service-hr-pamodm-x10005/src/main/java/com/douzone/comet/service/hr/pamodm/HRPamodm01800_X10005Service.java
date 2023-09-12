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
import com.douzone.gpd.restful.model.DzGridModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

/**
 * @description : 행사참가직원등록_Service
 * @Since : 2023-09-12
 * @Author : 서장대
 * @History : 개발시작
 */
@DzApiService(value = "HRPamodm01800_X10005Service", module = CometModule.HR, desc = "행사참가직원등록_Service")
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
}
