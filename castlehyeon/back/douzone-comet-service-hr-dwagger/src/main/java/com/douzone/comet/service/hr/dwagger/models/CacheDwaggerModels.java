package com.douzone.comet.service.hr.dwagger.models;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

//파일 스트림으로 저장할 클래스
//모든 서비스의 리스트가 저장되는 클래스
@Component
public class CacheDwaggerModels {
	@JsonProperty("data")
	List<DwaggerModel> apiList;
	String updateDTS;

	public CacheDwaggerModels() {
		super();
		//리스트는 객체 오직 한개만 사용.
		apiList = new ArrayList<>();
		//객체가 생성되었을 때 시점 저장.
		updateDTS = this.getDate();
		
		// 파일이 존재하는지 확인
        File file = new File("C:\\cacheDwaggerModels.json");
        if (file.exists()) {
            // 파일이 존재하면 JSON 데이터를 역직렬화하여 객체로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                CacheDwaggerModels cachedModels = objectMapper.readValue(file, CacheDwaggerModels.class);
                this.apiList = cachedModels.getApiList();
                this.updateDTS = cachedModels.getUpdateDTS();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
