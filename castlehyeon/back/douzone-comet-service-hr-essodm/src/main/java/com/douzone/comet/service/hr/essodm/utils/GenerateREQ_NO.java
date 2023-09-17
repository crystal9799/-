package com.douzone.comet.service.hr.essodm.utils;

import java.time.LocalDate;

public class GenerateREQ_NO {
	public String generateDocNoByMaxThisMonth(int maxSeq) {
		String prefix = "MPC";

        // 시스템 날짜에서 연도와 월을 가져오기
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();

        // 데이터베이스에서 가져온 최대값 + 1
        int maxNumberFromDB = maxSeq + 1;

        // 4자리 포맷으로 만들기
        String formattedNumber = String.format("%04d", maxNumberFromDB);

        // 13자리 DOC_NO 생성
        String docNo = prefix + year + String.format("%02d", month) + formattedNumber;
        
        System.out.println("Generated DOC_NO ===>: " + docNo);
		
		return docNo;
	}
}
