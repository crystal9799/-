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

	//서비스를 받아오는 api
	//프론트의 로컬스토리지에 저장내역이 없는 경우에도 사용.
	@DzApi(url = "/dwagger_totalList", desc = "서비스조회-서비스명", httpMethod = DzRequestMethod.GET)
	public List<DwaggerModel> dwagger_totalList(
			@DzParam(key = "keywords", desc = "검색어", paramType = DzParamType.QueryString) String keywords,
			@DzParam(key = "langCd", desc = "언어", paramType = DzParamType.QueryString) String langCd,
			@DzParam(key = "condition_cd", desc = "검색조건코드", paramType = DzParamType.QueryString) String condition_cd) throws Exception {
		APIDataCall callDatas = new APIDataCall();
		List<DwaggerModel> dwaggerModelList = new ArrayList<DwaggerModel>();
		try {
			System.out.println("Service cacheModels===>" + cacheModels);
			String result = callDatas.callApi(keywords, condition_cd);
			System.out.println("callApi결과 result ===>" + result);
			//어째서인지 자바 객체를 굳이 JSON으로 직렬화하지 않아도 올바르게 데이터가 전송된다. 아마 DzApi가 RestController로 작동하기 때문일 듯.
			//결과값을 찾을 수 있다면
			// 등록서비스 조회 api의 state가 error가 아니라면
			if (!result.equals("-1")) {
				dwaggerModelList = jsonUtils.convertJsonToObject(result);
				
				// 변환된 자바 객체를 서버메모리에 저장하기 위해 set사용.
				// 새로 값을 불러온다면 이를 파일로 저장.
				// 반드시 전체조건검색일 때만 백업파일로 저장하기
				if (cacheModels != null && condition_cd.equals("1")) {
					cacheModels.setApiList(dwaggerModelList);
					cacheModels.setUpdateDTS(cacheModels.getDate());
					jsonUtils.saveCacheDwaggerModelsToFile();
				}
				System.out.println("--------------------------");
				System.out.println("cacheModels==>" + cacheModels);
				System.out.println("--------------------------");
			}else {
				DwaggerModel errorModel = new DwaggerModel();
				errorModel.setModule(result);
				dwaggerModelList.add(errorModel);
			}
			System.out.println("DwaggerModelList===>"+dwaggerModelList.toString());
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return dwaggerModelList;
	}
	
	//DEWS API에서 "java.lang.reflect.InvocationTargetException: null"오류 뜨는 경우
	//빈에 저장되어있는 캐시 데이터 반환
	@DzApi(url = "/dwagger_errorGetInfo", desc = "서비스조회-로컬스토리지존재X", httpMethod = DzRequestMethod.GET)
	public List<DwaggerModel> dwagger_notExistLocal(
			@DzParam(key = "keywords", desc = "검색어", paramType = DzParamType.QueryString) String keywords,
			@DzParam(key = "langCd", desc = "언어", paramType = DzParamType.QueryString) String langCd,
			@DzParam(key = "condition_cd", desc = "검색조건코드", paramType = DzParamType.QueryString) String condition_cd) throws Exception {
		List<DwaggerModel> dwaggerModelList = new ArrayList<DwaggerModel>();
		try {
			System.out.println("Service cacheModels===>" + cacheModels);
			dwaggerModelList = cacheModels.getApiList();
				
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return dwaggerModelList;
	}
}
//save해서 저장하는 것은 전체 데이터가 되도록한다.
