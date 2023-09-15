package com.douzone.comet.service.hr.essodm.models;
 
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
 
@DzModel(name = "Essodm01400_X10005Model", desc = "수정조회쿼리: 그리드와 기본정보를 다 들고오는 모델", tableName = "")
public class Essodm01400_X10005Model extends DzAbstractModel {

	@SerializedName("COMPANY_CD")
	@DzModelField(name="company_cd", desc="회사코드", colName="COMPANY_CD", colSize="7", isKey=false)
	private String company_cd;
	  
	@SerializedName("REQ_NO")
	@DzModelField(name="req_no", desc="신청번호", colName="REQ_NO", colSize="20", isKey=false)
	private String req_no;
	  
	@SerializedName("REQ_DT")
	@DzModelField(name="req_dt", desc="신청일", colName="REQ_DT", colSize="8", isKey=false)
	private String req_dt;
	  
	@SerializedName("DNLGB_CD")
	@DzModelField(name="dnlgb_cd", desc="근태구분코드", colName="DNLGB_CD", colSize="5", isKey=false)
	private String dnlgb_cd;
	  
	@SerializedName("DNL_CD")
	@DzModelField(name="dnl_cd", desc="근태코드", colName="DNL_CD", colSize="10", isKey=false)
	private String dnl_cd;
	  
	@SerializedName("START_DT")
	@DzModelField(name="start_dt", desc="시작일", colName="START_DT", colSize="8", isKey=false)
	private String start_dt;
	  
	@SerializedName("END_DT")
	@DzModelField(name="end_dt", desc="종료일", colName="END_DT", colSize="8", isKey=false)
	private String end_dt;
	  
	@SerializedName("ATHZ_DOC_CD")
	@DzModelField(name="athz_doc_cd", desc="결재문서코드", colName="ATHZ_DOC_CD", colSize="50", isKey=false)
	private String athz_doc_cd;
	  
	@SerializedName("ATHZ_ST_CD")
	@DzModelField(name="athz_st_cd", desc="결재상태코드", colName="ATHZ_ST_CD", colSize="5", isKey=false)
	private String athz_st_cd;
	  
	@SerializedName("EMP_NO")
	@DzModelField(name="emp_no", desc="사원번호", colName="EMP_NO", colSize="20", isKey=false)
	private String emp_no;
	  
	@SerializedName("KOR_NM")
	@DzModelField(name="kor_nm", desc="한글명", colName="KOR_NM", colSize="50", isKey=false)
	private String kor_nm;
	  
	@SerializedName("PSTN_CD")
	@DzModelField(name="pstn_cd", desc="직급코드", colName="PSTN_CD", colSize="5", isKey=false)
	private String pstn_cd;
	  
	@SerializedName("OGRP_CD")
	@DzModelField(name="ogrp_cd", desc="직군코드", colName="OGRP_CD", colSize="5", isKey=false)
	private String ogrp_cd;
	  
	@SerializedName("DEPT_CD")
	@DzModelField(name="dept_cd", desc="부서코드", colName="DEPT_CD", colSize="20", isKey=false)
	private String dept_cd;
	  
	@SerializedName("ORG")
	@DzModelField(name="org", desc="N/A", colName="ORG", colSize="4000", isKey=false)
	private String org;
	  
	@SerializedName("POSI_CD")
	@DzModelField(name="posi_cd", desc="직위코드", colName="POSI_CD", colSize="5", isKey=false)
	private String posi_cd;
	
	@SerializedName("REQ_EMP_NO")
	@DzModelField(name="req_emp_no", desc="신청사원번호", colName="REQ_EMP_NO", colSize="20", isKey=false)
	private String req_emp_no;
	
	@SerializedName("REQ_KOR_NM")
	@DzModelField(name="req_kor_nm", desc="신청사원이름", colName="REQ_KOR_NM", colSize="50", isKey=false)
	private String req_kor_nm;
	
	@SerializedName("REASON_DC")
	@DzModelField(name="reason_dc", desc="사유내역", colName="REASON_DC", colSize="500", isKey=false)
	private String reason_dc;

	@SerializedName("REQ_DY")
	@DzModelField(name="req_dy", desc="신청일수", colName="REQ_DY", colSize="5", isKey=false)
	private BigDecimal req_dy;

	public String getCompany_cd() {
		return company_cd;
	}

	public void setCompany_cd(String company_cd) {
		this.company_cd = company_cd;
	}
 
	public String getReq_no() {
		return req_no;
	}

	public void setReq_no(String req_no) {
		this.req_no = req_no;
	}
 
	public String getReq_dt() {
		return req_dt;
	}

	public void setReq_dt(String req_dt) {
		this.req_dt = req_dt;
	}
 
	public String getDnlgb_cd() {
		return dnlgb_cd;
	}

	public void setDnlgb_cd(String dnlgb_cd) {
		this.dnlgb_cd = dnlgb_cd;
	}
 
	public String getDnl_cd() {
		return dnl_cd;
	}

	public void setDnl_cd(String dnl_cd) {
		this.dnl_cd = dnl_cd;
	}
 
	public String getStart_dt() {
		return start_dt;
	}

	public void setStart_dt(String start_dt) {
		this.start_dt = start_dt;
	}
 
	public String getEnd_dt() {
		return end_dt;
	}

	public void setEnd_dt(String end_dt) {
		this.end_dt = end_dt;
	}
 
	public String getAthz_doc_cd() {
		return athz_doc_cd;
	}

	public void setAthz_doc_cd(String athz_doc_cd) {
		this.athz_doc_cd = athz_doc_cd;
	}
 
	public String getAthz_st_cd() {
		return athz_st_cd;
	}

	public void setAthz_st_cd(String athz_st_cd) {
		this.athz_st_cd = athz_st_cd;
	}
 
	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
 
	public String getKor_nm() {
		return kor_nm;
	}

	public void setKor_nm(String kor_nm) {
		this.kor_nm = kor_nm;
	}
 
	public String getPstn_cd() {
		return pstn_cd;
	}

	public void setPstn_cd(String pstn_cd) {
		this.pstn_cd = pstn_cd;
	}
 
	public String getOgrp_cd() {
		return ogrp_cd;
	}

	public void setOgrp_cd(String ogrp_cd) {
		this.ogrp_cd = ogrp_cd;
	}
 
	public String getDept_cd() {
		return dept_cd;
	}

	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
 
	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}
 
	public String getPosi_cd() {
		return posi_cd;
	}

	public void setPosi_cd(String posi_cd) {
		this.posi_cd = posi_cd;
	}
	
	
    public String getReq_emp_no() {
		return req_emp_no;
	}

	public void setReq_emp_no(String req_emp_no) {
		this.req_emp_no = req_emp_no;
	}

	public String getReq_kor_nm() {
		return req_kor_nm;
	}

	public void setReq_kor_nm(String req_kor_nm) {
		this.req_kor_nm = req_kor_nm;
	}

	public String getReason_dc() {
		return reason_dc;
	}

	public void setReason_dc(String reason_dc) {
		this.reason_dc = reason_dc;
	}

	public BigDecimal getReq_dy() {
		return req_dy;
	}

	public void setReq_dy(BigDecimal req_dy) {
		this.req_dy = req_dy;
	}

	@Override
	public String toString() {
		return "Essodm01400_X10005Model [company_cd=" + company_cd + ", req_no=" + req_no + ", req_dt=" + req_dt
				+ ", dnlgb_cd=" + dnlgb_cd + ", dnl_cd=" + dnl_cd + ", start_dt=" + start_dt + ", end_dt=" + end_dt
				+ ", athz_doc_cd=" + athz_doc_cd + ", athz_st_cd=" + athz_st_cd + ", emp_no=" + emp_no + ", kor_nm="
				+ kor_nm + ", pstn_cd=" + pstn_cd + ", ogrp_cd=" + ogrp_cd + ", dept_cd=" + dept_cd + ", org=" + org
				+ ", posi_cd=" + posi_cd + ", req_emp_no=" + req_emp_no + ", req_kor_nm=" + req_kor_nm + ", reason_dc="
				+ reason_dc + ", req_dy=" + req_dy + "]";
	}


}
