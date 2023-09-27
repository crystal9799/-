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
	@Autowired
	JsonUtils jsonUtils;

	// 사용자 입력값에 따라 결과를 받아오는 api
	@DzApi(url = "/dwagger_list", desc = "서비스조회-서비스명", httpMethod = DzRequestMethod.GET)
	public List<DwaggerModel> dwagger_list(
			@DzParam(key = "serviceName", desc = "서비스명", paramType = DzParamType.QueryString) String serviceName,
			@DzParam(key = "langCd", desc = "언어", paramType = DzParamType.QueryString) String langCd) throws Exception {

		List<DwaggerModel> dwaggerModelList = new ArrayList<DwaggerModel>();
		APIDataCall callDatas = new APIDataCall();
		
		System.out.println("serviceName===>"+serviceName);
		System.out.println("langCd===>"+langCd);
		try {
			// 파라미터로 받은 serviceName과 일치하는 DwaggerModel을 찾기 위한 변수
			DwaggerModel foundModel = null;
			
			String result = callDatas.callApi("");
			
			//결과값을 찾을 수 있다면
			// 등록서비스 조회 api의 state가 error가 아니라면
			if (!result.equals("-1")) {
				dwaggerModelList = jsonUtils.convertJsonToObject(result);
			}else if(serviceName != null && serviceName.equals("")) {
				// APICall을 사용하는 것이 아닌 기존 빈등록된 객체 정보 내에서 값을 찾도록 로직 작성
				// 기존 cacheModels 객체에서 로직에 따라 데이터 조회
				// 로직작성
				// cacheModels 객체의 apiList에서 serviceName과 일치하는 DwaggerModel 찾기
				for (DwaggerModel model : cacheModels.getApiList()) {
					if (model.getService().equals(serviceName)) {
						foundModel = model;
						dwaggerModelList.add(foundModel);
					}
				}
			}

			/////
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return dwaggerModelList;
	}

	// 초기에 전체 서비스를 받아오는 api
	@DzApi(url = "/dwagger_totalList", desc = "서비스조회-서비스명", httpMethod = DzRequestMethod.GET)
	public List<DwaggerModel> dwagger_totalList(
			@DzParam(key = "serviceName", desc = "서비스명", paramType = DzParamType.QueryString) String serviceName,
			@DzParam(key = "langCd", desc = "언어", paramType = DzParamType.QueryString) String langCd) throws Exception {
		APIDataCall callDatas = new APIDataCall();
		List<DwaggerModel> dwaggerModelList = new ArrayList<DwaggerModel>();
		try {
			System.out.println("Service cacheModels===>" + cacheModels);
			String result = callDatas.callApi("");

//어째서인지 자바 객체를 굳이 JSON으로 직렬화하지 않아도 올바르게 데이터가 전송된다. 아마 DzApi가 RestController로 작동하기 때문일 듯.
			if (!result.equals("-1")) {
				dwaggerModelList = jsonUtils.convertJsonToObject(result);
				
				// 변환된 자바 객체를 서버메모리에 저장하기 위해 set사용.
				// 새로 값을 불러온다면 이를 파일로 저장.
				if (cacheModels != null) {
					cacheModels.setApiList(dwaggerModelList);
					cacheModels.setUpdateDTS(cacheModels.getDate());
				}
				System.out.println("--------------------------");
				System.out.println("cacheModels==>" + cacheModels);
				System.out.println("--------------------------");
				jsonUtils.saveCacheDwaggerModelsToFile();
			}

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return dwaggerModelList;
	}
}
//save해서 저장하는 것은 전체 데이터가 되도록한다.
