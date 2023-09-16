package com.douzone.comet.service.hr.essodm.utils;
import java.util.HashMap;
import java.util.Map;

public class DateConvertUtil {

	public String convertInputToDate(String dateString){
		
		System.out.println("input한 date ==>" + dateString);
		String outputDate = null;
		
		//포맷정의
		//월단위로 직접 매핑하기
		Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");
        
		
		
		try {
			//추출한 문자열을 키값으로 value인 숫자값 찾기
			String monthString = dateString.substring(4, 7);
			String monthFormatted = monthMap.get(monthString);
	        
	        // 일 데이터 추출
	        String dayString = dateString.substring(8, 10);
	        
	        // 연도 데이터 추출
	        String yearString = dateString.substring(11, 15);
	        
	        // 조합하기
	        String formattedDate = yearString + monthFormatted + dayString;
	        System.out.println("포맷팅한 date ==>" +formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return outputDate;
	}
}
