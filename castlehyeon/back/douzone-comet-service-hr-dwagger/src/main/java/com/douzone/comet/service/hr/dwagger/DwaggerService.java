package com.douzone.comet.service.hr.dwagger;

import com.douzone.comet.components.DzCometService;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.enums.CometModule;
import java.util.List;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.comet.service.hr.dwagger.models.CacheDwaggerModels;
import com.douzone.comet.service.hr.dwagger.models.DwaggerModel;
import com.douzone.comet.service.hr.dwagger.utils.APIDataCall;
import com.douzone.comet.service.hr.dwagger.utils.JsonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

/**
 * @description :
 * @Since :
 * @Author :
 * @History :
 */
@DzApiService(value = "DwaggerService", module = CometModule.HR, desc = "서비스조회-서비스명")
public class DwaggerService extends DzCometService {
	@Autowired
	CacheDwaggerModels cacheModels;

	@DzApi(url = "/dwagger_list", desc = "서비스조회-서비스명", httpMethod = DzRequestMethod.GET)
	public CacheDwaggerModels dwagger_list(
			@DzParam(key = "serviceName", desc = "서비스명", paramType = DzParamType.QueryString) String serviceName,
			@DzParam(key = "langCd", desc = "언어", paramType = DzParamType.QueryString) String langCd) throws Exception {
		APIDataCall callDatas = new APIDataCall();
		String response = "";

		try {
			// 나중에는 파라미터로 받은 serviceName을 넣을 것
			System.out.println("Service cacheModels===>" + cacheModels);
			JsonUtils jsonUtils = new JsonUtils();
			String result = callDatas.callApi("결근계");

//어째서인지 자바 객체를 굳이 JSON으로 직렬화하지 않아도 올바르게 데이터가 전송된다. 아마 DzApi가 RestController로 작동하기 때문일 듯.
			if (!result.equals("-1")) {
				jsonUtils.convertJsonToObject(result);
				jsonUtils.saveCacheDwaggerModelsToFile();
			}

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return cacheModels;
	}
}
//save해서 저장하는 것은 전체 데이터가 되도록한다.
