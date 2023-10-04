package com.douzone.comet.service.hr.essodm.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GenerateREQ_NO {
	public String generateDocNoByMaxThisMonth(int maxSeq) {
		String prefix ="PAB";

        // 시스템 날짜에서 연도와 월, 일을 가져오기
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int date = currentDate.getDayOfMonth();

        // 데이터베이스에서 가져온 최대값 + 1
        int maxNumberFromDB = maxSeq + 1;

        // 4자리 포맷으로 만들기
        String formattedNumber = String.format("%04d", maxNumberFromDB);

        // 13자리 DOC_NO 생성
        String docNo = prefix + year + String.format("%02d", month) + String.format("%02d", date) + formattedNumber;
        
        System.out.println("Generated DOC_NO ===>: " + docNo);
		
		return docNo;
	}
	public String generateDocNoByMaxThisMonth_Approve(int maxSeq) {
		String prefix ="EWP_HR_GWA";

		// 시스템 날짜에서 연도와 월을 가져오기
	    LocalDate currentDate = LocalDate.now();

	    // 데이터베이스에서 가져온 최대값 + 1
	    int maxNumberFromDB = maxSeq + 1;

	    // 4자리 포맷으로 만들기
	    String formattedNumber = String.format("%04d", maxNumberFromDB);

	    // 날짜 포맷 설정
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMM");

	    // 오늘 연도와 월을 문자열로 변환
	    String todayYearMonth = currentDate.format(dateFormatter);

	    // 채번 생성
	    String docNo = prefix + todayYearMonth + formattedNumber;
        
        System.out.println("Generated DOC_NO_Approve ===>: " + docNo);
		
		return docNo;
	}
}
