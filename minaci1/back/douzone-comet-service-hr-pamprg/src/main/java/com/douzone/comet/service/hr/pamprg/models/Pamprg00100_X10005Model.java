package com.douzone.comet.service.hr.pamprg.models;

import java.math.BigDecimal;

import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;

@DzModel(name = "Pamprg00100_X10005Model", desc = "승급기준표등록", tableName = "")
public class Pamprg00100_X10005Model extends DzAbstractModel {

	@SerializedName("STD_YM")
	@DzModelField(name = "std_ym", desc = "기준년월", colName = "STD_YM", colSize = "6", isKey = false)
	private String std_ym;

	@SerializedName("PSTN_CD")
	@DzModelField(name = "pstn_cd", desc = "직급코드", colName = "PSTN_CD", colSize = "5", isKey = false)
	private String pstn_cd;

	@SerializedName("PSTN_NM")
	@DzModelField(name = "pstn_nm", desc = "직급명", colName = "PSTN_NM", colSize = "5", isKey = false)
	private String pstn_nm;

	@SerializedName("TRGT_GRD_CD")
	@DzModelField(name = "trgt_grd_cd", desc = "대상등급", colName = "TRGT_GRD_CD", colSize = "5", isKey = false)
	private String trgt_grd_cd;

	@SerializedName("UGRD_GRD_CD")
	@DzModelField(name = "ugrd_grd_cd", desc = "승급등급", colName = "UGRD_GRD_CD", colSize = "5", isKey = false)
	private String ugrd_grd_cd;
	
	@SerializedName("MIN_BWRK_MY")
	@DzModelField(name = "min_bwrk_my", desc = "최소근무월수", colName = "MIN_BWRK_MY", colSize = "7", isKey = false)
	private BigDecimal min_bwrk_my;

	@SerializedName("AGGR_TERM_CNT")
	@DzModelField(name = "aggr_term_cnt", desc = "집계기간수", colName = "AGGR_TERM_CNT", colSize = "5", isKey = false)
	private BigDecimal aggr_term_cnt;

	@SerializedName("BWRK_SGRAD_CD")
	@DzModelField(name = "bwrk_sgrad_cd", desc = "근무성적코드", colName = "BWRK_SGRAD_CD", colSize = "5", isKey = false)
	private String bwrk_sgrad_cd;

	@SerializedName("LEDU_CD")
	@DzModelField(name = "ledu_cd", desc = "학력코드", colName = "LEDU_CD", colSize = "5", isKey = false)
	private String ledu_cd;

	@SerializedName("BWRK_MY_CALC_STD_DT")
	@DzModelField(name = "bwrk_my_calc_std_dt", desc = "근무월수산정기준일", colName = "BWRK_MY_CALC_STD_DT", colSize = "8", isKey = false)
	private String bwrk_my_calc_std_dt;

	@SerializedName("BIZAREA_CD")
	@DzModelField(name = "bizarea_cd", desc = "사업장", colName = "BIZAREA_CD", colSize = "8", isKey = false)
	private String bizarea_cd;

	@SerializedName("BIZAREA_NM")
	@DzModelField(name = "bizarea_nm", desc = "사업장명", colName = "BIZAREA_NM", colSize = "8", isKey = false)
	private String bizarea_nm;
	
	@SerializedName("RMK_NM")
	@DzModelField(name="rmk_nm", desc="비고", colName="rmk_nm")
	private String rmk_nm;
	

	public String getStd_ym() {
		return std_ym;
	}

	public void setStd_ym(String std_ym) {
		this.std_ym = std_ym;
	}

	public String getPstn_cd() {
		return pstn_cd;
	}

	public void setPstn_cd(String pstn_cd) {
		this.pstn_cd = pstn_cd;
	}

	public String getTrgt_grd_cd() {
		return trgt_grd_cd;
	}

	public void setTrgt_grd_cd(String trgt_grd_cd) {
		this.trgt_grd_cd = trgt_grd_cd;
	}

	public BigDecimal getMin_bwrk_my() {
		return min_bwrk_my;
	}

	public void setMin_bwrk_my(BigDecimal min_bwrk_my) {
		this.min_bwrk_my = min_bwrk_my;
	}

	public BigDecimal getAggr_term_cnt() {
		return aggr_term_cnt;
	}

	public void setAggr_term_cnt(BigDecimal aggr_term_cnt) {
		this.aggr_term_cnt = aggr_term_cnt;
	}

	public String getBwrk_sgrad_cd() {
		return bwrk_sgrad_cd;
	}

	public void setBwrk_sgrad_cd(String bwrk_sgrad_cd) {
		this.bwrk_sgrad_cd = bwrk_sgrad_cd;
	}

	public String getLedu_cd() {
		return ledu_cd;
	}

	public void setLedu_cd(String ledu_cd) {
		this.ledu_cd = ledu_cd;
	}

	public String getBwrk_my_calc_std_dt() {
		return bwrk_my_calc_std_dt;
	}

	public void setBwrk_my_calc_std_dt(String bwrk_my_calc_std_dt) {
		this.bwrk_my_calc_std_dt = bwrk_my_calc_std_dt;
	}

	public String getBizarea_cd() {
		return bizarea_cd;
	}

	public void setBizarea_cd(String bizarea_cd) {
		this.bizarea_cd = bizarea_cd;
	}

	public String getPstn_nm() {
		return pstn_nm;
	}

	public void setPstn_nm(String pstn_nm) {
		this.pstn_nm = pstn_nm;
	}

	public String getUrgd_grd_cd() {
		return ugrd_grd_cd;
	}

	public void setUrgd_grd_cd(String ugrd_grd_cd) {
		this.ugrd_grd_cd = ugrd_grd_cd;
	}

	public String getBizarea_nm() {
		return bizarea_nm;
	}

	public void setBizarea_nm(String bizarea_nm) {
		this.bizarea_nm = bizarea_nm;
	}

	public String getRmk_nm() {
		return rmk_nm;
	}

	public void setRmk_nm(String rmk_nm) {
		this.rmk_nm = rmk_nm;
	}

	@Override
	public String toString() {
		return "Pamprg00100_X10005Model [std_ym=" + std_ym + ", pstn_cd=" + pstn_cd + ", pstn_nm=" + pstn_nm
				+ ", trgt_grd_cd=" + trgt_grd_cd + ", urgd_grd_cd=" + ugrd_grd_cd + ", min_bwrk_my=" + min_bwrk_my
				+ ", aggr_term_cnt=" + aggr_term_cnt + ", bwrk_sgrad_cd=" + bwrk_sgrad_cd + ", ledu_cd=" + ledu_cd
				+ ", bwrk_my_calc_std_dt=" + bwrk_my_calc_std_dt + ", bizarea_cd=" + bizarea_cd + ", bizarea_nm="
				+ bizarea_nm + ", rmk_nm=" + rmk_nm + "]";
	}
}
