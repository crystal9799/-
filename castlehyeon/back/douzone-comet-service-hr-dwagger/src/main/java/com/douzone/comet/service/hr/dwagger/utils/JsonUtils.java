package com.douzone.comet.service.hr.dwagger.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.douzone.comet.service.hr.dwagger.models.CacheDwaggerModels;
import com.douzone.comet.service.hr.dwagger.models.DwaggerModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonUtils {
	@Autowired
	CacheDwaggerModels cacheModels;

	public void convertJsonToObject(String jsonData) {
		try {
			// ObjectMapper를 사용하여 JSON 데이터를 Java 객체로 변환
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(jsonData);

			// "data" 배열을 가져와서 List<DwaggerModel>로 변환
			JsonNode dataNode = jsonNode.get("data");
			List<DwaggerModel> dwaggerModelList = objectMapper.convertValue(dataNode,
					new TypeReference<List<DwaggerModel>>() {
					});

//			List<DwaggerModel> dwaggerModelList = objectMapper.readValue(jsonData,
//					new TypeReference<List<DwaggerModel>>() {
//					});
			
			System.out.println("--------------------------");
			System.out.println("dwaggerModelList==>" + dwaggerModelList);
			System.out.println("cacheModels==>" + cacheModels);
			System.out.println("--------------------------");

			// 변환된 자바 객체를 서버메모리에 저장하기 위해 set사용.
			// 새로 값을 불러온다면 이를 파일로 저장.
			if(cacheModels != null){
			cacheModels.setApiList(dwaggerModelList);
			cacheModels.setUpdateDTS(cacheModels.getDate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String serializeToJson(CacheDwaggerModels cacheDwaggerModels) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(cacheDwaggerModels);
		} catch (JsonProcessingException e) {
			// 직렬화 실패 시 예외 처리
			return "{}"; // 빈 JSON 객체 또는 오류 처리 메시지를 반환
		}
	}
	
	//JSON으로 직렬화 한뒤 해당 데이터를 파일에 저장하는 메서드
	public void saveCacheDwaggerModelsToFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "C:\\cacheDwaggerModels.json";
        
        try {
            // CacheDwaggerModels 객체를 JSON 문자열로 직렬화
            String json = objectMapper.writeValueAsString(cacheModels);

            // JSON 문자열을 파일로 저장
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(json);
                System.out.println("CacheDwaggerModels 객체를 파일로 저장했습니다.");
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("CacheDwaggerModels 객체를 파일로 저장하는 데 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("CacheDwaggerModels 객체를 JSON으로 직렬화하는 데 실패했습니다.");
        }
    }
	
}
