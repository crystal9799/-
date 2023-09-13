package com.douzone.comet.service.hr.essodm.models;
 
import java.math.BigDecimal;

import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "Essodm01400_X10005Model", desc = "결근계 전체 조회 모델", tableName = "")
public class Essodm01400_X10005Model extends DzAbstractModel {
  
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
	  
	  @DzModelField(name="athz_doc_cd", desc="결재문서코드", colName="ATHZ_DOC_CD",
	  colSize="50", isKey=false) private String athz_doc_cd;
	 
	  
	@SerializedName("ATHZ_ST_CD")
	@DzModelField(name="athz_st_cd", desc="결재상태코드", colName="ATHZ_ST_CD", colSize="5", isKey=false)
	private String athz_st_cd;
	
	@SerializedName("ATHZ_ST_NM")
	@DzModelField(name="athz_st_nm", desc="결재상태코드이름", colName="ATHZ_ST_NM", colSize="20", isKey=false)
	private String athz_st_nm;

 
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

	@Override
	public String toString() {
		return "Essodm01400_X10005Model [req_no=" + req_no + ", req_dt=" + req_dt + ", dnlgb_cd=" + dnlgb_cd
				+ ", dnl_cd=" + dnl_cd + ", start_dt=" + start_dt + ", end_dt=" + end_dt + ", athz_doc_cd="
				+ athz_doc_cd + ", athz_st_cd=" + athz_st_cd + ", athz_st_nm=" + athz_st_nm + "]";
	}
}
