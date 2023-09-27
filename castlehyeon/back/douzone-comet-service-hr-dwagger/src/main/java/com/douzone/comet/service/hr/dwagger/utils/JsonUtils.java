package com.douzone.comet.service.hr.dwagger.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
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

	public List<DwaggerModel> convertJsonToObject(String jsonData) {
		List<DwaggerModel> dwaggerModelList = null;
		try {
			// ObjectMapper를 사용하여 JSON 데이터를 Java 객체로 변환
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(jsonData);

			// "data" 배열을 가져와서 List<DwaggerModel>로 변환
			JsonNode dataNode = jsonNode.get("data");
			dwaggerModelList = objectMapper.convertValue(dataNode,
					new TypeReference<List<DwaggerModel>>() {
					});

//			List<DwaggerModel> dwaggerModelList = objectMapper.readValue(jsonData,
//					new TypeReference<List<DwaggerModel>>() {
//					});

			System.out.println("--------------------------");
			System.out.println("dwaggerModelList==>" + dwaggerModelList);
			System.out.println("--------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dwaggerModelList;
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

	// JSON으로 직렬화 한뒤 해당 데이터를 파일에 저장하는 메서드
	public void saveCacheDwaggerModelsToFile() {
		ObjectMapper objectMapper = new ObjectMapper();
		String filePath = "C:\\cacheDwaggerModels.json";

		try {
			// CacheDwaggerModels 객체를 JSON 문자열로 직렬화
			String json = objectMapper.writeValueAsString(cacheModels);

			// JSON 문자열을 파일로 저장
			// 한글 인코딩 문제로 UTF-8 인코딩 설정
			try (FileOutputStream fos = new FileOutputStream(filePath);
					OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
					BufferedWriter writer = new BufferedWriter(osw)) {
				writer.write(json);
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
