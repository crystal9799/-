package com.douzone.comet.service.hr.dwagger.models;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

//파일 스트림으로 저장할 클래스
//모든 서비스의 리스트가 저장되는 클래스
@Component
public class CacheDwaggerModels {
	@JsonProperty("data")
	List<DwaggerModel> apiList;
	String updateDTS;
	 // 'transient' 키워드를 사용하여 직렬화에서 제외시킴
//	 @JsonIgnore
//	transient String date;
		
		//스프링 빈은 기본적으로 싱글톤 스코프로 관리
		//파일을 읽어와 데이터를 초기화하는 부분을 싱글톤 빈의 라이프사이클과 분리
		//한 번 생성된 데이터는 캐시로 저장하고, 다음에 CacheDwaggerModels 객체가 요청되면 캐시된 데이터를 반환하도록 구현
		//싱글톤 빈의 초기화를 위한 @PostConstruct 어노테이션을 사용
		@PostConstruct
	    public void init() {
	        // 파일이 존재하는지 확인
	        File file = new File("C:\\cacheDwaggerModels.json");
	        if (file.exists()) {
	            // 파일이 존재하면 JSON 데이터를 역직렬화하여 객체로 변환
	            ObjectMapper objectMapper = new ObjectMapper();
	            try {
	                CacheDwaggerModels cachedModels = objectMapper.readValue(file, CacheDwaggerModels.class);
	                this.apiList = cachedModels.getApiList();
	                this.updateDTS = cachedModels.getUpdateDTS();
	                System.out.println("역직렬화를 통해 불러온 cacheModels====>" + cachedModels);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } else {
	            // 파일이 존재하지 않을 때 초기화 로직을 수행
	            apiList = new ArrayList<>();
	            updateDTS = getDate();
	        }
	    }
	
	
	
	
	public List<DwaggerModel> getApiList() {
		return apiList;
	}




	public void setApiList(List<DwaggerModel> apiList) {
		this.apiList = apiList;
	}




	public String getUpdateDTS() {
		return updateDTS;
	}




	public void setUpdateDTS(String updateDTS) {
		this.updateDTS = updateDTS;
	}




	public void addModel(DwaggerModel ParamModel) {
		this.apiList.add(ParamModel);
	}
	
	
	
	@Override
	public String toString() {
		return "CacheDwaggerModels [apiList=" + apiList + ", updateDTS=" + updateDTS + "]";
	}




	public String getDate() {
		String strDate = null;
		Date date = new Date();

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		strDate = simpleDateFormat.format(date);
		return strDate;
	}
	
}
