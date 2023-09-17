package com.douzone.comet.service.hr.essodm.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.douzone.comet.components.DzCometService;

public class GetInsertUpdateInfo extends DzCometService {

	// 현재 사용자의 company_cd
	private String companyCode = this.getCompanyCode();
	// 현재 사용자의 id
	private String userId = this.getUserId();
	// 현재 사용자의 empCode
	private String empCode = this.getEmpCode();
	// 현재 사용자의 아이피
	public String getIp() {
		InetAddress local;
		String ip = null;
		try {
			local = InetAddress.getLocalHost();
			ip = local.getHostAddress();
		} catch (UnknownHostException error) {
			System.out.println(error.getMessage());
		}
		return ip;
	}
	// 현재 사용자의 작업날짜.
	public String getDate() {
		String strDate = null;
		Date date = new Date();

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		strDate = simpleDateFormat.format(date);
		return strDate;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	

}
