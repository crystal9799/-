package com.douzone.comet.service.hr.essodm.models;

public class ChartDataByWeek {
	private String day;
    private Integer count;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ChartDataByWeek [day=" + day + ", count=" + count + "]";
	}

}
