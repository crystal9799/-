package com.douzone.comet.service.hr.essodm.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

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

	@Override
	public String toString() {
		return "OffApply [reqNo=" + reqNo + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	public List<ChartDataByWeek> getDataByWeek(List<OffApply> queryResult) {
		// 오늘 날짜를 기준으로 해당 주의 날짜 범위 계산
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(new Date());

		// 현재 요일을 구하여 주의 시작일과 마지막일을 계산
		int currentDayOfWeek = startCalendar.get(Calendar.DAY_OF_WEEK);
		int daysUntilMonday = (currentDayOfWeek + 7 - Calendar.MONDAY) % 7;

		startCalendar.add(Calendar.DATE, -daysUntilMonday); // 주의 시작일로 이동 (월요일)
		Date startDateOfWeek = startCalendar.getTime();

		// 별도의 Calendar 객체를 사용하여 주의 마지막일 계산
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(startDateOfWeek);
		endCalendar.add(Calendar.DATE, 4); // 금요일로 이동
		Date endDateOfWeek = endCalendar.getTime();



	    System.out.println("startDateOfWeek===>"+startDateOfWeek);
	    System.out.println("endDateOfWeek===>"+endDateOfWeek);
		Map<String, Integer> dayCountMap = new HashMap<>();
		dayCountMap.put("월", 0);
		dayCountMap.put("화", 0);
		dayCountMap.put("수", 0);
		dayCountMap.put("목", 0);
		dayCountMap.put("금", 0);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);

		// 영어 요일명과 한글 요일명 매핑
		Map<String, String> dayOfWeekMapping = new HashMap<>();
		dayOfWeekMapping.put("Mon", "월");
		dayOfWeekMapping.put("Tue", "화");
		dayOfWeekMapping.put("Wed", "수");
		dayOfWeekMapping.put("Thu", "목");
		dayOfWeekMapping.put("Fri", "금");

		// 해당 주의 날짜 범위를 SET으로 저장
		Set<String> weekDateSet = new HashSet<>();

		// 새로운 Calendar 객체를 사용하여 주의 시작일과 마지막일 계산
		Calendar weekCalendar = Calendar.getInstance();
		weekCalendar.setTime(startDateOfWeek);

		// 주의 시작일부터 주의 마지막일까지 날짜를 SET에 추가
		while (!weekCalendar.getTime().after(endDateOfWeek)) {
		    weekDateSet.add(dateFormat.format(weekCalendar.getTime()));
		    weekCalendar.add(Calendar.DATE, 1);
		}
		System.out.println("weekDateSet==>" + weekDateSet);

		// 대상리스트의 요소가 기준리스트에 포함되면 카운트
		for (OffApply offApply : queryResult) {
		    try {
		        Date offStartDate = dateFormat.parse(offApply.getStartDate());
		        Date offEndDate = dateFormat.parse(offApply.getEndDate());

		        // OffApply의 시작일과 종료일을 포함한 대상리스트를 SET으로 저장
		        Set<String> targetDateSet = new HashSet<>();
		        Calendar offCalendar = Calendar.getInstance();
		        offCalendar.setTime(offStartDate);

		        while (!offCalendar.getTime().after(offEndDate)) {
		            String offDateStr = dateFormat.format(offCalendar.getTime());
		            targetDateSet.add(offDateStr);
		            offCalendar.add(Calendar.DATE, 1);
		        }

		        for (String date : targetDateSet) {
		            if (weekDateSet.contains(date)) {
		                String dayOfWeekEnglish = new SimpleDateFormat("E", Locale.ENGLISH)
		                        .format(dateFormat.parse(date));

		                String dayOfWeekKorean = dayOfWeekMapping.get(dayOfWeekEnglish);

		                if (dayOfWeekKorean != null && dayCountMap.containsKey(dayOfWeekKorean)) {
		                    int currentCount = dayCountMap.get(dayOfWeekKorean);
		                    dayCountMap.put(dayOfWeekKorean, currentCount + 1);
		                }
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

		System.out.println("chartDataList====>" + chartDataList);
		return chartDataList;
	}

}
