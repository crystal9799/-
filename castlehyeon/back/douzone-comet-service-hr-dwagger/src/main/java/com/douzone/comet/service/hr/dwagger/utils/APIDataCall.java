package com.douzone.comet.service.hr.dwagger.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APIDataCall {

	public String callApi(String service) {
		StringBuilder response = new StringBuilder();
		try {
			// 요청을 보낼 URL 설정
			String baseUrl = "http://localhost:8080/api/CM/ServiceRegistrySearchService/metadataModels/ServiceNames";
			String urlStr = baseUrl + buildQueryString(service);

			URL url = new URL(urlStr);

			// HttpURLConnection을 생성하고 설정
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// 요청 헤더에 한글 인코딩 설정 추가
			conn.setRequestProperty("Accept-Charset", "UTF-8");

			// 응답 데이터 읽기
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// 응답 코드 확인 (HTTP 200 OK가 반환되어야 함)
//            int responseCode = conn.getResponseCode();

			String jsonResponse = response.toString();
			//JSON 파싱
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(jsonResponse);
			
			System.out.println("jsonResponse===>"+ jsonResponse);
			if (jsonNode.has("state") && "error".equals(jsonNode.get("state").asText())) {
				// 응답에 에러 상태가 포함되어 있으면 에러로 처리
				response.setLength(0); // 기존 데이터 초기화
				response.append("-1");
				System.out.println("HTTP GET 요청 실패. 응답 데이터: " + jsonResponse);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response.toString();
	}

	private String buildQueryString(String service) {
		return "?serviceName=" + service + "&langCd=KR";
	}
}
