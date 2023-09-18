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
	private String posi_cd;
	
	@SerializedName("BIZAREA_CD")
	@DzModelField(name="bizarea_cd", desc="사업장코드", colName="BIZAREA_CD", colSize="7", isKey=false)
	private String bizarea_cd;
	
	@SerializedName("BIZAREA_NM")
	@DzModelField(name="bizarea_nm", desc="사업장명", colName="BIZAREA_NM", colSize="50", isKey=false)
	private String bizarea_nm;
	
	@SerializedName("GRP_NM")
	@DzModelField(name="grp_nm", desc="그룹명", colName="GRP_NM", colSize="100", isKey=false)
	private String grp_nm;
	
	@SerializedName("DEPT_NM")
	@DzModelField(name="dept_nm", desc="부서명", colName="DEPT_NM", colSize="50", isKey=false)
	private String dept_nm;
	
	@SerializedName("PATH")
	@DzModelField(name="path", desc="수정소속", colName="PATH", colSize="200", isKey=false)
	private String path;
	
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
	
	
    public String getBizarea_cd() {
		return bizarea_cd;
	}

	public void setBizarea_cd(String bizarea_cd) {
		this.bizarea_cd = bizarea_cd;
	}

	
	public String getBizarea_nm() {
		return bizarea_nm;
	}

	public void setBizarea_nm(String bizarea_nm) {
		this.bizarea_nm = bizarea_nm;
	}

	public String getGrp_nm() {
		return grp_nm;
	}

	public void setGrp_nm(String grp_nm) {
		this.grp_nm = grp_nm;
	}

	public String getDept_nm() {
		return dept_nm;
	}

	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}

	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Essodm01400_X10005_UserInfoModel [emp_no=" + emp_no + ", kor_nm=" + kor_nm + ", pstn_cd=" + pstn_cd
				+ ", ogrp_cd=" + ogrp_cd + ", org=" + org + ", posi_cd=" + posi_cd + ", bizarea_cd=" + bizarea_cd
				+ ", bizarea_nm=" + bizarea_nm + ", grp_nm=" + grp_nm + ", dept_nm=" + dept_nm + ", path=" + path + "]";
	}
	
}
