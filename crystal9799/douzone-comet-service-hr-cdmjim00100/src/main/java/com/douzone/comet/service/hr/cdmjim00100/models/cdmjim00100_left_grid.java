package com.douzone.comet.service.hr.cdmjim00100.models;
 
import java.math.BigDecimal;

import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "cdmjim00100_left_grid", desc = "세부분류_그리드", tableName = "")
public class cdmjim00100_left_grid extends DzAbstractModel {

	
	@SerializedName("COMPANY_CD")
	@DzModelField(name="COMPANY_CD", desc="능력분류번호", colName="COMPANY_CD", colSize="20", isKey=false)
	private String COMPANY_CD;
	
	@SerializedName("ACLF_NO")
	@DzModelField(name="ACLF_NO", desc="능력분류번호", colName="ACLF_NO", colSize="20", isKey=false)
	private String ACLF_NO;
	  
	@SerializedName("VER_CD")
	@DzModelField(name="VER_CD", desc="버전코드", colName="VER_CD", colSize="5", isKey=false)
	private String VER_CD;
	  
	@SerializedName("AELM_CD")
	@DzModelField(name="AELM_CD", desc="능력요소코드", colName="AELM_CD", colSize="10", isKey=false)
	private String AELM_CD;
	  
	@SerializedName("AELM_NM")
	@DzModelField(name="AELM_NM", desc="능력요소명", colName="AELM_NM", colSize="300", isKey=false)
	private String AELM_NM;
	  
	@SerializedName("AELM_LV")
	@DzModelField(name="AELM_LV", desc="능력요소레벨", colName="AELM_LV", colSize="3", isKey=false)
	private BigDecimal AELM_LV;
	
	@SerializedName("_uid")
	@DzModelField(name="_uid", desc="_uid", colName="_uid", colSize="100", isKey=false)
	private String _uid;
	
	@SerializedName("PCFM_CD")
	@DzModelField(name="PCFM_CD", desc="PCFM_CD", colName="PCFM_CD", colSize="100", isKey=false)
	private String PCFM_CD;
	
	@SerializedName("IP")
	@DzModelField(name="IP", desc="IP", colName="IP", colSize="100", isKey=false)
	private String IP;

	@SerializedName("USER_ID")
	@DzModelField(name = "USER_ID", desc = "USER_ID", colName = "USER_ID", colSize = "100", isKey = false)
	private String USER_ID;
	
	@SerializedName("OG_AELM_CD")
	@DzModelField(name="OG_AELM_CD", desc="능력요소코드", colName="OG_AELM_CD", colSize="10", isKey=false)
	private String OG_AELM_CD;
	
	
	public String getOG_AELM_CD() {
		return OG_AELM_CD;
	}

	public void setOG_AELM_CD(String oG_AELM_CD) {
		OG_AELM_CD = oG_AELM_CD;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getPCFM_CD() {
		return PCFM_CD;
	}

	public void setPCFM_CD(String pCFM_CD) {
		PCFM_CD = pCFM_CD;
	}

	public String getCompany_cd() {
		return COMPANY_CD;
	}

	public void setCompany_cd(String COMPANY_CD) {
		this.COMPANY_CD = COMPANY_CD;
	}

	public String get_uid() {
		return _uid;
	}

	public void set_uid(String _uid) {
		this._uid = _uid;
	}

	public String getAclf_no() {
		return ACLF_NO;
	}

	public void setAclf_no(String aclf_no) {
		this.ACLF_NO = aclf_no;
	}
 
	public String getVer_cd() {
		return VER_CD;
	}

	public void setVer_cd(String VER_CD) {
		this.VER_CD = VER_CD;
	}
 
	public String getAelm_cd() {
		return AELM_CD;
	}

	public void setAelm_cd(String aelm_cd) {
		this.AELM_CD = aelm_cd;
	}
 
	public String getAelm_nm() {
		return AELM_NM;
	}

	public void setAelm_nm(String AELM_NM) {
		this.AELM_NM = AELM_NM;
	}
 
	public BigDecimal getAelm_lv() {
		return AELM_LV;
	}

	public void setAelm_lv(BigDecimal aelm_lv) {
		this.AELM_LV = aelm_lv;
	}
	
    @Override
    public String toString() {
      return
        "aclf_no: ["+ ACLF_NO +"]\n"+
        "ver_cd: ["+ VER_CD +"]\n"+
        "aelm_cd: ["+ AELM_CD +"]\n"+
        "aelm_nm: ["+ AELM_NM +"]\n"+
        "aelm_lv: ["+ AELM_LV +"]";
    }
}
