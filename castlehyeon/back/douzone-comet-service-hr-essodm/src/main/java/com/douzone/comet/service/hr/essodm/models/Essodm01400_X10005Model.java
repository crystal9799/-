package com.douzone.comet.service.hr.essodm.models;
 
import java.math.BigDecimal;

import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "Essodm01400_X10005Model", desc = "결근계 전체 조회 모델", tableName = "")
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
	  
	@SerializedName("REQ_FG")
	@DzModelField(name="req_fg", desc="신청구분", colName="REQ_FG", colSize="5", isKey=false)
	private String req_fg;
	  
	@SerializedName("ORGL_REQ_NO")
	@DzModelField(name="orgl_req_no", desc="원본신청번호", colName="ORGL_REQ_NO", colSize="20", isKey=false)
	private String orgl_req_no;
	  
	@SerializedName("BIZAREA_CD")
	@DzModelField(name="bizarea_cd", desc="사업장코드", colName="BIZAREA_CD", colSize="7", isKey=false)
	private String bizarea_cd;
	  
	@SerializedName("DEPT_CD")
	@DzModelField(name="dept_cd", desc="부서코드", colName="DEPT_CD", colSize="20", isKey=false)
	private String dept_cd;
	  
	@SerializedName("EMP_NO")
	@DzModelField(name="emp_no", desc="사원번호", colName="EMP_NO", colSize="20", isKey=false)
	private String emp_no;
	  
	@SerializedName("PSTN_CD")
	@DzModelField(name="pstn_cd", desc="직급코드", colName="PSTN_CD", colSize="5", isKey=false)
	private String pstn_cd;
	  
	@SerializedName("OGRP_CD")
	@DzModelField(name="ogrp_cd", desc="직군코드", colName="OGRP_CD", colSize="5", isKey=false)
	private String ogrp_cd;
	  
	@SerializedName("POSI_CD")
	@DzModelField(name="posi_cd", desc="직위코드", colName="POSI_CD", colSize="5", isKey=false)
	private String posi_cd;
	  
	@SerializedName("REQ_EMP_NO")
	@DzModelField(name="req_emp_no", desc="신청사원번호", colName="REQ_EMP_NO", colSize="20", isKey=false)
	private String req_emp_no;
	  
	@SerializedName("DNL_TP")
	@DzModelField(name="dnl_tp", desc="근태유형", colName="DNL_TP", colSize="5", isKey=false)
	private String dnl_tp;
	  
	@SerializedName("DNL_CD")
	@DzModelField(name="dnl_cd", desc="근태코드", colName="DNL_CD", colSize="10", isKey=false)
	private String dnl_cd;
	  
	@SerializedName("START_DT")
	@DzModelField(name="start_dt", desc="시작일", colName="START_DT", colSize="8", isKey=false)
	private String start_dt;
	  
	@SerializedName("END_DT")
	@DzModelField(name="end_dt", desc="종료일", colName="END_DT", colSize="8", isKey=false)
	private String end_dt;
	  
	@SerializedName("REQ_DY")
	@DzModelField(name="req_dy", desc="신청일수", colName="REQ_DY", colSize="11", isKey=false)
	private BigDecimal req_dy;
	  
	@SerializedName("START_TM")
	@DzModelField(name="start_tm", desc="시작시간", colName="START_TM", colSize="8", isKey=false)
	private String start_tm;
	  
	@SerializedName("END_TM")
	@DzModelField(name="end_tm", desc="종료시간", colName="END_TM", colSize="8", isKey=false)
	private String end_tm;
	  
	@SerializedName("START_TM_DY")
	@DzModelField(name="start_tm_dy", desc="시작시간일수", colName="START_TM_DY", colSize="7", isKey=false)
	private BigDecimal start_tm_dy;
	  
	@SerializedName("END_TM_DY")
	@DzModelField(name="end_tm_dy", desc="종료시간일수", colName="END_TM_DY", colSize="7", isKey=false)
	private BigDecimal end_tm_dy;
	  
	@SerializedName("REQ_TM_DY")
	@DzModelField(name="req_tm_dy", desc="신청시간일수", colName="REQ_TM_DY", colSize="7", isKey=false)
	private BigDecimal req_tm_dy;
	  
	@SerializedName("STD_WORKTM_DY")
	@DzModelField(name="std_worktm_dy", desc="기준근무시간일수", colName="STD_WORKTM_DY", colSize="7", isKey=false)
	private BigDecimal std_worktm_dy;
	  
	@SerializedName("USE_TM_DY")
	@DzModelField(name="use_tm_dy", desc="사용시간일수", colName="USE_TM_DY", colSize="7", isKey=false)
	private BigDecimal use_tm_dy;
	  
	@SerializedName("VCTN_DECL_YN")
	@DzModelField(name="vctn_decl_yn", desc="휴가신고여부", colName="VCTN_DECL_YN", colSize="1", isKey=false)
	private String vctn_decl_yn;
	  
	@SerializedName("PRMTN_YN")
	@DzModelField(name="prmtn_yn", desc="촉진여부", colName="PRMTN_YN", colSize="1", isKey=false)
	private String prmtn_yn;
	  
	@SerializedName("ATHZ_DOC_CD")
	@DzModelField(name="athz_doc_cd", desc="결재문서코드", colName="ATHZ_DOC_CD", colSize="50", isKey=false)
	private String athz_doc_cd;
	  
	@SerializedName("ATHZ_ST_CD")
	@DzModelField(name="athz_st_cd", desc="결재상태코드", colName="ATHZ_ST_CD", colSize="5", isKey=false)
	private String athz_st_cd;
	  
	@SerializedName("ATHZ_ST_2_CD")
	@DzModelField(name="athz_st_2_cd", desc="결재상태2코드", colName="ATHZ_ST_2_CD", colSize="5", isKey=false)
	private String athz_st_2_cd;
	  
	@SerializedName("AGNTWRK_YN")
	@DzModelField(name="agntwrk_yn", desc="대리근무여부", colName="AGNTWRK_YN", colSize="1", isKey=false)
	private String agntwrk_yn;
	  
	@SerializedName("AGNTWRK_REASON_CD")
	@DzModelField(name="agntwrk_reason_cd", desc="대리근무사유코드", colName="AGNTWRK_REASON_CD", colSize="5", isKey=false)
	private String agntwrk_reason_cd;
	  
	@SerializedName("AGNTWRK_FG")
	@DzModelField(name="agntwrk_fg", desc="대리근무구분", colName="AGNTWRK_FG", colSize="5", isKey=false)
	private String agntwrk_fg;
	  
	@SerializedName("REASON_CD")
	@DzModelField(name="reason_cd", desc="사유코드", colName="REASON_CD", colSize="5", isKey=false)
	private String reason_cd;
	  
	@SerializedName("REASON_DC")
	@DzModelField(name="reason_dc", desc="사유내역", colName="REASON_DC", colSize="500", isKey=false)
	private String reason_dc;
	  
	@SerializedName("RMK_DC")
	@DzModelField(name="rmk_dc", desc="비고내역", colName="RMK_DC", colSize="200", isKey=false)
	private String rmk_dc;
	  
	@SerializedName("PRGNCY_TERM_CD")
	@DzModelField(name="prgncy_term_cd", desc="임신기간코드", colName="PRGNCY_TERM_CD", colSize="5", isKey=false)
	private String prgncy_term_cd;
	  
	@SerializedName("PAY_MTHD_FG")
	@DzModelField(name="pay_mthd_fg", desc="지급방법구분", colName="PAY_MTHD_FG", colSize="3", isKey=false)
	private String pay_mthd_fg;
	  
	@SerializedName("BWRK_TYPE_CD")
	@DzModelField(name="bwrk_type_cd", desc="근무타입코드", colName="BWRK_TYPE_CD", colSize="5", isKey=false)
	private String bwrk_type_cd;
	  
	@SerializedName("WORKTP_CD")
	@DzModelField(name="worktp_cd", desc="근무유형코드", colName="WORKTP_CD", colSize="5", isKey=false)
	private String worktp_cd;
	  
	@SerializedName("NGHT_TM_DY")
	@DzModelField(name="nght_tm_dy", desc="야간시간일수", colName="NGHT_TM_DY", colSize="7", isKey=false)
	private BigDecimal nght_tm_dy;
	  
	@SerializedName("ELTR_ATHZ_DOC_NO")
	@DzModelField(name="eltr_athz_doc_no", desc="전자결재문서번호", colName="ELTR_ATHZ_DOC_NO", colSize="50", isKey=false)
	private String eltr_athz_doc_no;
	  
	@SerializedName("VCTN_DECL_CNCL_CD")
	@DzModelField(name="vctn_decl_cncl_cd", desc="휴가신고취소코드", colName="VCTN_DECL_CNCL_CD", colSize="5", isKey=false)
	private String vctn_decl_cncl_cd;
	  
	@SerializedName("MBL_YN")
	@DzModelField(name="mbl_yn", desc="모바일여부", colName="MBL_YN", colSize="1", isKey=false)
	private String mbl_yn;
	  
	@SerializedName("MBL_LNKNG_CD")
	@DzModelField(name="mbl_lnkng_cd", desc="모바일연계코드", colName="MBL_LNKNG_CD", colSize="200", isKey=false)
	private String mbl_lnkng_cd;
	  
	@SerializedName("XTSN_BWRK_FG")
	@DzModelField(name="xtsn_bwrk_fg", desc="연장근무구분", colName="XTSN_BWRK_FG", colSize="5", isKey=false)
	private String xtsn_bwrk_fg;
	  
	@SerializedName("REL_NO")
	@DzModelField(name="rel_no", desc="관련번호", colName="REL_NO", colSize="20", isKey=false)
	private String rel_no;
	  
	@SerializedName("DIRECTINPUT_YN")
	@DzModelField(name="directinput_yn", desc="직접입력여부", colName="DIRECTINPUT_YN", colSize="1", isKey=false)
	private String directinput_yn;
	  
	@SerializedName("INSERT_ID")
	@DzModelField(name="insert_id", desc="등록ID", colName="INSERT_ID", colSize="30", isKey=false)
	private String insert_id;
	  
	@SerializedName("INSERT_IP")
	@DzModelField(name="insert_ip", desc="등록IP", colName="INSERT_IP", colSize="200", isKey=false)
	private String insert_ip;
	  
	@SerializedName("INSERT_MCADDR_NM")
	@DzModelField(name="insert_mcaddr_nm", desc="등록맥어드레스명", colName="INSERT_MCADDR_NM", colSize="200", isKey=false)
	private String insert_mcaddr_nm;
	  
	@SerializedName("INSERT_DTS")
	@DzModelField(name="insert_dts", desc="등록일시", colName="INSERT_DTS", colSize="0", isKey=false)
	private String insert_dts;
	  
	@SerializedName("UPDATE_ID")
	@DzModelField(name="update_id", desc="수정ID", colName="UPDATE_ID", colSize="30", isKey=false)
	private String update_id;
	  
	@SerializedName("UPDATE_IP")
	@DzModelField(name="update_ip", desc="수정IP", colName="UPDATE_IP", colSize="200", isKey=false)
	private String update_ip;
	  
	@SerializedName("UPDATE_MCADDR_NM")
	@DzModelField(name="update_mcaddr_nm", desc="수정맥어드레스명", colName="UPDATE_MCADDR_NM", colSize="200", isKey=false)
	private String update_mcaddr_nm;
	  
	@SerializedName("UPDATE_DTS")
	@DzModelField(name="update_dts", desc="수정일시", colName="UPDATE_DTS", colSize="0", isKey=false)
	private String update_dts;

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
 
	public String getReq_fg() {
		return req_fg;
	}

	public void setReq_fg(String req_fg) {
		this.req_fg = req_fg;
	}
 
	public String getOrgl_req_no() {
		return orgl_req_no;
	}

	public void setOrgl_req_no(String orgl_req_no) {
		this.orgl_req_no = orgl_req_no;
	}
 
	public String getBizarea_cd() {
		return bizarea_cd;
	}

	public void setBizarea_cd(String bizarea_cd) {
		this.bizarea_cd = bizarea_cd;
	}
 
	public String getDept_cd() {
		return dept_cd;
	}

	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
 
	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
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
 
	public String getDnl_tp() {
		return dnl_tp;
	}

	public void setDnl_tp(String dnl_tp) {
		this.dnl_tp = dnl_tp;
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
 
	public BigDecimal getReq_dy() {
		return req_dy;
	}

	public void setReq_dy(BigDecimal req_dy) {
		this.req_dy = req_dy;
	}
 
	public String getStart_tm() {
		return start_tm;
	}

	public void setStart_tm(String start_tm) {
		this.start_tm = start_tm;
	}
 
	public String getEnd_tm() {
		return end_tm;
	}

	public void setEnd_tm(String end_tm) {
		this.end_tm = end_tm;
	}
 
	public BigDecimal getStart_tm_dy() {
		return start_tm_dy;
	}

	public void setStart_tm_dy(BigDecimal start_tm_dy) {
		this.start_tm_dy = start_tm_dy;
	}
 
	public BigDecimal getEnd_tm_dy() {
		return end_tm_dy;
	}

	public void setEnd_tm_dy(BigDecimal end_tm_dy) {
		this.end_tm_dy = end_tm_dy;
	}
 
	public BigDecimal getReq_tm_dy() {
		return req_tm_dy;
	}

	public void setReq_tm_dy(BigDecimal req_tm_dy) {
		this.req_tm_dy = req_tm_dy;
	}
 
	public BigDecimal getStd_worktm_dy() {
		return std_worktm_dy;
	}

	public void setStd_worktm_dy(BigDecimal std_worktm_dy) {
		this.std_worktm_dy = std_worktm_dy;
	}
 
	public BigDecimal getUse_tm_dy() {
		return use_tm_dy;
	}

	public void setUse_tm_dy(BigDecimal use_tm_dy) {
		this.use_tm_dy = use_tm_dy;
	}
 
	public String getVctn_decl_yn() {
		return vctn_decl_yn;
	}

	public void setVctn_decl_yn(String vctn_decl_yn) {
		this.vctn_decl_yn = vctn_decl_yn;
	}
 
	public String getPrmtn_yn() {
		return prmtn_yn;
	}

	public void setPrmtn_yn(String prmtn_yn) {
		this.prmtn_yn = prmtn_yn;
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
 
	public String getAthz_st_2_cd() {
		return athz_st_2_cd;
	}

	public void setAthz_st_2_cd(String athz_st_2_cd) {
		this.athz_st_2_cd = athz_st_2_cd;
	}
 
	public String getAgntwrk_yn() {
		return agntwrk_yn;
	}

	public void setAgntwrk_yn(String agntwrk_yn) {
		this.agntwrk_yn = agntwrk_yn;
	}
 
	public String getAgntwrk_reason_cd() {
		return agntwrk_reason_cd;
	}

	public void setAgntwrk_reason_cd(String agntwrk_reason_cd) {
		this.agntwrk_reason_cd = agntwrk_reason_cd;
	}
 
	public String getAgntwrk_fg() {
		return agntwrk_fg;
	}

	public void setAgntwrk_fg(String agntwrk_fg) {
		this.agntwrk_fg = agntwrk_fg;
	}
 
	public String getReason_cd() {
		return reason_cd;
	}

	public void setReason_cd(String reason_cd) {
		this.reason_cd = reason_cd;
	}
 
	public String getReason_dc() {
		return reason_dc;
	}

	public void setReason_dc(String reason_dc) {
		this.reason_dc = reason_dc;
	}
 
	public String getRmk_dc() {
		return rmk_dc;
	}

	public void setRmk_dc(String rmk_dc) {
		this.rmk_dc = rmk_dc;
	}
 
	public String getPrgncy_term_cd() {
		return prgncy_term_cd;
	}

	public void setPrgncy_term_cd(String prgncy_term_cd) {
		this.prgncy_term_cd = prgncy_term_cd;
	}
 
	public String getPay_mthd_fg() {
		return pay_mthd_fg;
	}

	public void setPay_mthd_fg(String pay_mthd_fg) {
		this.pay_mthd_fg = pay_mthd_fg;
	}
 
	public String getBwrk_type_cd() {
		return bwrk_type_cd;
	}

	public void setBwrk_type_cd(String bwrk_type_cd) {
		this.bwrk_type_cd = bwrk_type_cd;
	}
 
	public String getWorktp_cd() {
		return worktp_cd;
	}

	public void setWorktp_cd(String worktp_cd) {
		this.worktp_cd = worktp_cd;
	}
 
	public BigDecimal getNght_tm_dy() {
		return nght_tm_dy;
	}

	public void setNght_tm_dy(BigDecimal nght_tm_dy) {
		this.nght_tm_dy = nght_tm_dy;
	}
 
	public String getEltr_athz_doc_no() {
		return eltr_athz_doc_no;
	}

	public void setEltr_athz_doc_no(String eltr_athz_doc_no) {
		this.eltr_athz_doc_no = eltr_athz_doc_no;
	}
 
	public String getVctn_decl_cncl_cd() {
		return vctn_decl_cncl_cd;
	}

	public void setVctn_decl_cncl_cd(String vctn_decl_cncl_cd) {
		this.vctn_decl_cncl_cd = vctn_decl_cncl_cd;
	}
 
	public String getMbl_yn() {
		return mbl_yn;
	}

	public void setMbl_yn(String mbl_yn) {
		this.mbl_yn = mbl_yn;
	}
 
	public String getMbl_lnkng_cd() {
		return mbl_lnkng_cd;
	}

	public void setMbl_lnkng_cd(String mbl_lnkng_cd) {
		this.mbl_lnkng_cd = mbl_lnkng_cd;
	}
 
	public String getXtsn_bwrk_fg() {
		return xtsn_bwrk_fg;
	}

	public void setXtsn_bwrk_fg(String xtsn_bwrk_fg) {
		this.xtsn_bwrk_fg = xtsn_bwrk_fg;
	}
 
	public String getRel_no() {
		return rel_no;
	}

	public void setRel_no(String rel_no) {
		this.rel_no = rel_no;
	}
 
	public String getDirectinput_yn() {
		return directinput_yn;
	}

	public void setDirectinput_yn(String directinput_yn) {
		this.directinput_yn = directinput_yn;
	}
 
	public String getInsert_id() {
		return insert_id;
	}

	public void setInsert_id(String insert_id) {
		this.insert_id = insert_id;
	}
 
	public String getInsert_ip() {
		return insert_ip;
	}

	public void setInsert_ip(String insert_ip) {
		this.insert_ip = insert_ip;
	}
 
	public String getInsert_mcaddr_nm() {
		return insert_mcaddr_nm;
	}

	public void setInsert_mcaddr_nm(String insert_mcaddr_nm) {
		this.insert_mcaddr_nm = insert_mcaddr_nm;
	}
 
	public String getInsert_dts() {
		return insert_dts;
	}

	public void setInsert_dts(String insert_dts) {
		this.insert_dts = insert_dts;
	}
 
	public String getUpdate_id() {
		return update_id;
	}

	public void setUpdate_id(String update_id) {
		this.update_id = update_id;
	}
 
	public String getUpdate_ip() {
		return update_ip;
	}

	public void setUpdate_ip(String update_ip) {
		this.update_ip = update_ip;
	}
 
	public String getUpdate_mcaddr_nm() {
		return update_mcaddr_nm;
	}

	public void setUpdate_mcaddr_nm(String update_mcaddr_nm) {
		this.update_mcaddr_nm = update_mcaddr_nm;
	}
 
	public String getUpdate_dts() {
		return update_dts;
	}

	public void setUpdate_dts(String update_dts) {
		this.update_dts = update_dts;
	}
	
    @Override
    public String toString() {
      return
        "company_cd: ["+ company_cd +"]\n"+
        "req_no: ["+ req_no +"]\n"+
        "req_dt: ["+ req_dt +"]\n"+
        "dnlgb_cd: ["+ dnlgb_cd +"]\n"+
        "req_fg: ["+ req_fg +"]\n"+
        "orgl_req_no: ["+ orgl_req_no +"]\n"+
        "bizarea_cd: ["+ bizarea_cd +"]\n"+
        "dept_cd: ["+ dept_cd +"]\n"+
        "emp_no: ["+ emp_no +"]\n"+
        "pstn_cd: ["+ pstn_cd +"]\n"+
        "ogrp_cd: ["+ ogrp_cd +"]\n"+
        "posi_cd: ["+ posi_cd +"]\n"+
        "req_emp_no: ["+ req_emp_no +"]\n"+
        "dnl_tp: ["+ dnl_tp +"]\n"+
        "dnl_cd: ["+ dnl_cd +"]\n"+
        "start_dt: ["+ start_dt +"]\n"+
        "end_dt: ["+ end_dt +"]\n"+
        "req_dy: ["+ req_dy +"]\n"+
        "start_tm: ["+ start_tm +"]\n"+
        "end_tm: ["+ end_tm +"]\n"+
        "start_tm_dy: ["+ start_tm_dy +"]\n"+
        "end_tm_dy: ["+ end_tm_dy +"]\n"+
        "req_tm_dy: ["+ req_tm_dy +"]\n"+
        "std_worktm_dy: ["+ std_worktm_dy +"]\n"+
        "use_tm_dy: ["+ use_tm_dy +"]\n"+
        "vctn_decl_yn: ["+ vctn_decl_yn +"]\n"+
        "prmtn_yn: ["+ prmtn_yn +"]\n"+
        "athz_doc_cd: ["+ athz_doc_cd +"]\n"+
        "athz_st_cd: ["+ athz_st_cd +"]\n"+
        "athz_st_2_cd: ["+ athz_st_2_cd +"]\n"+
        "agntwrk_yn: ["+ agntwrk_yn +"]\n"+
        "agntwrk_reason_cd: ["+ agntwrk_reason_cd +"]\n"+
        "agntwrk_fg: ["+ agntwrk_fg +"]\n"+
        "reason_cd: ["+ reason_cd +"]\n"+
        "reason_dc: ["+ reason_dc +"]\n"+
        "rmk_dc: ["+ rmk_dc +"]\n"+
        "prgncy_term_cd: ["+ prgncy_term_cd +"]\n"+
        "pay_mthd_fg: ["+ pay_mthd_fg +"]\n"+
        "bwrk_type_cd: ["+ bwrk_type_cd +"]\n"+
        "worktp_cd: ["+ worktp_cd +"]\n"+
        "nght_tm_dy: ["+ nght_tm_dy +"]\n"+
        "eltr_athz_doc_no: ["+ eltr_athz_doc_no +"]\n"+
        "vctn_decl_cncl_cd: ["+ vctn_decl_cncl_cd +"]\n"+
        "mbl_yn: ["+ mbl_yn +"]\n"+
        "mbl_lnkng_cd: ["+ mbl_lnkng_cd +"]\n"+
        "xtsn_bwrk_fg: ["+ xtsn_bwrk_fg +"]\n"+
        "rel_no: ["+ rel_no +"]\n"+
        "directinput_yn: ["+ directinput_yn +"]\n"+
        "insert_id: ["+ insert_id +"]\n"+
        "insert_ip: ["+ insert_ip +"]\n"+
        "insert_mcaddr_nm: ["+ insert_mcaddr_nm +"]\n"+
        "insert_dts: ["+ insert_dts +"]\n"+
        "update_id: ["+ update_id +"]\n"+
        "update_ip: ["+ update_ip +"]\n"+
        "update_mcaddr_nm: ["+ update_mcaddr_nm +"]\n"+
        "update_dts: ["+ update_dts +"]";
    }
}
