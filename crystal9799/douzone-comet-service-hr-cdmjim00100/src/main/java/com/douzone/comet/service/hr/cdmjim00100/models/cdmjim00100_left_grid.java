package com.douzone.comet.service.hr.cdmjim00100.models;
 
import java.math.BigDecimal;

import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "cdmjim00100_left_grid", desc = "세부분류_그리드", tableName = "")
public class cdmjim00100_left_grid extends DzAbstractModel {

	
	@SerializedName("COMPANY_CD")
	@DzModelField(name="COMPANY_CD", desc="능력분류번호", colName="ACLF_NO", colSize="20", isKey=false)
	private String company_cd;
	
	@SerializedName("ACLF_NO")
	@DzModelField(name="ACLF_NO", desc="능력분류번호", colName="ACLF_NO", colSize="20", isKey=false)
	private String aclf_no;
	  
	@SerializedName("VER_CD")
	@DzModelField(name="VER_CD", desc="버전코드", colName="VER_CD", colSize="5", isKey=false)
	private String ver_cd;
	  
	@SerializedName("AELM_CD")
	@DzModelField(name="AELM_CD", desc="능력요소코드", colName="AELM_CD", colSize="5", isKey=false)
	private String aelm_cd;
	  
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

	
	public String getPCFM_CD() {
		return PCFM_CD;
	}

	public void setPCFM_CD(String pCFM_CD) {
		PCFM_CD = pCFM_CD;
	}

	public String getCompany_cd() {
		return company_cd;
	}

	public void setCompany_cd(String company_cd) {
		this.company_cd = company_cd;
	}

	public String get_uid() {
		return _uid;
	}

	public void set_uid(String _uid) {
		this._uid = _uid;
	}

	public String getAclf_no() {
		return aclf_no;
	}

	public void setAclf_no(String aclf_no) {
		this.aclf_no = aclf_no;
	}
 
	public String getVer_cd() {
		return ver_cd;
	}

	public void setVer_cd(String ver_cd) {
		this.ver_cd = ver_cd;
	}
 
	public String getAelm_cd() {
		return aelm_cd;
	}

	public void setAelm_cd(String aelm_cd) {
		this.aelm_cd = aelm_cd;
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
        "aclf_no: ["+ aclf_no +"]\n"+
        "ver_cd: ["+ ver_cd +"]\n"+
        "aelm_cd: ["+ aelm_cd +"]\n"+
        "aelm_nm: ["+ AELM_NM +"]\n"+
        "aelm_lv: ["+ AELM_LV +"]";
    }
}
