package com.douzone.comet.service.hr.essodm.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class OffApply {
    private String reqNo;
    private String startDate;
    private String endDate;

    

    public String getReqNo() {
		return reqNo;
	}



	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}



	public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public List<ChartDataByWeek> getDataByWeek(List<OffApply> queryResult) {
        System.out.println("쿼리결과====>" + queryResult);
        
        // 오늘 날짜를 기준으로 해당 주의 날짜 범위 계산
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int todayYear = calendar.get(Calendar.YEAR);
        int todayMonth = calendar.get(Calendar.MONTH);
        int todayDay = calendar.get(Calendar.DAY_OF_MONTH);
        
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.set(Calendar.YEAR, todayYear);
        calendar.set(Calendar.MONTH, todayMonth);
        calendar.set(Calendar.DAY_OF_MONTH, todayDay);
        
        Date startDateOfWeek = calendar.getTime();
        
        calendar.add(Calendar.DATE, 6);
        Date endDateOfWeek = calendar.getTime();

        Map<String, Integer> dayCountMap = new HashMap<>();
        dayCountMap.put("월", 0);
        dayCountMap.put("화", 0);
        dayCountMap.put("수", 0);
        dayCountMap.put("목", 0);
        dayCountMap.put("금", 0);

        // 영어 요일명과 한글 요일명 매핑
        Map<String, String> dayOfWeekMapping = new HashMap<>();
        dayOfWeekMapping.put("Mon", "월");
        dayOfWeekMapping.put("Tue", "화");
        dayOfWeekMapping.put("Wed", "수");
        dayOfWeekMapping.put("Thu", "목");
        dayOfWeekMapping.put("Fri", "금");

        // 요일별 count를 계산하여 dayCountMap에 저장
        for (OffApply offApply : queryResult) {
            try {
                Date offStartDate = dateFormat.parse(offApply.getStartDate());
                Date offEndDate = dateFormat.parse(offApply.getEndDate());

                // OffApply의 날짜 범위가 해당 주의 범위에 포함되는지 확인
                if (!offEndDate.before(startDateOfWeek) && !offStartDate.after(endDateOfWeek)) {
                    Calendar offCalendar = Calendar.getInstance();
                    offCalendar.setTime(offStartDate);
                    while (!offCalendar.getTime().after(offEndDate)) {
                        String dayOfWeekEnglish = new SimpleDateFormat("E", Locale.ENGLISH).format(offCalendar.getTime());
                        String dayOfWeekKorean = dayOfWeekMapping.get(dayOfWeekEnglish);
                        if (dayOfWeekKorean != null && dayCountMap.containsKey(dayOfWeekKorean)) {
                            int currentCount = dayCountMap.get(dayOfWeekKorean);
                            dayCountMap.put(dayOfWeekKorean, currentCount + 1);
                        }
                        offCalendar.add(Calendar.DATE, 1);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // 결과를 ChartDataByWeek 객체 리스트로 변환
        List<ChartDataByWeek> chartDataList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : dayCountMap.entrySet()) {
            ChartDataByWeek chartData = new ChartDataByWeek();
            chartData.setDay(entry.getKey());
            chartData.setCount(entry.getValue());
            chartDataList.add(chartData);
        }

        
        // 요일별로 정렬 (월요일부터 금요일까지)
        Collections.sort(chartDataList, new Comparator<ChartDataByWeek>() {
            @Override
            public int compare(ChartDataByWeek o1, ChartDataByWeek o2) {
                Map<String, Integer> dayOrder = new HashMap<>();
                dayOrder.put("월", 1);
                dayOrder.put("화", 2);
                dayOrder.put("수", 3);
                dayOrder.put("목", 4);
                dayOrder.put("금", 5);

                return Integer.compare(dayOrder.get(o1.getDay()), dayOrder.get(o2.getDay()));
            }
        });
        
        return chartDataList;
    }
}
