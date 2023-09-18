package com.douzone.comet.service.hr.cdmjim00100.models;
 
import java.math.BigDecimal;

import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "cdmjim00100_left_grid", desc = "세부분류_그리드", tableName = "")
public class cdmjim00100_left_grid extends DzAbstractModel {

	@SerializedName("ACLF_NO")
	@DzModelField(name="aclf_no", desc="능력분류번호", colName="ACLF_NO", colSize="20", isKey=false)
	private String aclf_no;
	  
	@SerializedName("VER_CD")
	@DzModelField(name="ver_cd", desc="버전코드", colName="VER_CD", colSize="5", isKey=false)
	private String ver_cd;
	  
	@SerializedName("AELM_CD")
	@DzModelField(name="aelm_cd", desc="능력요소코드", colName="AELM_CD", colSize="5", isKey=false)
	private String aelm_cd;
	  
	@SerializedName("AELM_NM")
	@DzModelField(name="aelm_nm", desc="능력요소명", colName="AELM_NM", colSize="300", isKey=false)
	private String aelm_nm;
	  
	@SerializedName("AELM_LV")
	@DzModelField(name="aelm_lv", desc="능력요소레벨", colName="AELM_LV", colSize="3", isKey=false)
	private BigDecimal aelm_lv;

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
		return aelm_nm;
	}

	public void setAelm_nm(String aelm_nm) {
		this.aelm_nm = aelm_nm;
	}
 
	public BigDecimal getAelm_lv() {
		return aelm_lv;
	}

	public void setAelm_lv(BigDecimal aelm_lv) {
		this.aelm_lv = aelm_lv;
	}
	
    @Override
    public String toString() {
      return
        "aclf_no: ["+ aclf_no +"]\n"+
        "ver_cd: ["+ ver_cd +"]\n"+
        "aelm_cd: ["+ aelm_cd +"]\n"+
        "aelm_nm: ["+ aelm_nm +"]\n"+
        "aelm_lv: ["+ aelm_lv +"]";
    }
}
