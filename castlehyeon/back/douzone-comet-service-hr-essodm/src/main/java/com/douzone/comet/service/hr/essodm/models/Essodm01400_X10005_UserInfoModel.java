package com.douzone.comet.service.hr.essodm.models;
 
import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "Essodm01400_X10005_UserInfoModel", desc = "메인페이지 사원조회 모델", tableName = "")
public class Essodm01400_X10005_UserInfoModel extends DzAbstractModel {

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
	  
	@SerializedName("ORG")
	@DzModelField(name="org", desc="소속", colName="ORG", colSize="200", isKey=false)
	private String org;
	  
	@SerializedName("POSI_CD")
	@DzModelField(name="posi_cd", desc="직위코드", colName="POSI_CD", colSize="5", isKey=false)
	private String POSI_CD;
	
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
	
    @Override
    public String toString() {
      return
        "emp_no: ["+ emp_no +"]\n"+
        "kor_nm: ["+ kor_nm +"]\n"+
        "pstn_cd: ["+ pstn_cd +"]\n"+
        "ogrp_cd: ["+ ogrp_cd +"]\n"+
        "org: ["+ org +"]\n"+
        "posi_cd: ["+ posi_cd +"]";
    }
}
