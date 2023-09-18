package com.douzone.comet.service.hr.cdmjim00100.models;
 
import java.math.BigDecimal;

import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "cdmjim00100_maingrid", desc = "직무분류_메인그리드", tableName = "")
public class cdmjim00100_maingrid extends DzAbstractModel {

	@SerializedName("USE_YN")
	@DzModelField(name="use_yn", desc="사용여부", colName="USE_YN", colSize="1", isKey=false)
	private String USE_YN;
	  
	@SerializedName("JOB_FG")
	@DzModelField(name="job_fg", desc="직업구분", colName="JOB_FG", colSize="5", isKey=false)
	private String job_fg;
	  
	@SerializedName("ACLF_NO")
	@DzModelField(name="aclf_no", desc="능력분류번호", colName="ACLF_NO", colSize="20", isKey=false)
	private String aclf_no;
	  
	@SerializedName("VER_CD")
	@DzModelField(name="ver_cd", desc="버전코드", colName="VER_CD", colSize="5", isKey=false)
	private String ver_cd;
	  
	@SerializedName("LCLAS_CD")
	@DzModelField(name="lclas_cd", desc="대분류코드", colName="LCLAS_CD", colSize="5", isKey=false)
	private String lclas_cd;
	  
	@SerializedName("LCLAS_NM")
	@DzModelField(name="lclas_nm", desc="대분류명", colName="LCLAS_NM", colSize="100", isKey=false)
	private String lclas_nm;
	  
	@SerializedName("MLSFC_CD")
	@DzModelField(name="mlsfc_cd", desc="중분류코드", colName="MLSFC_CD", colSize="5", isKey=false)
	private String mlsfc_cd;
	  
	@SerializedName("MLSFC_NM")
	@DzModelField(name="mlsfc_nm", desc="중분류명", colName="MLSFC_NM", colSize="100", isKey=false)
	private String mlsfc_nm;
	  
	@SerializedName("S_CSF_CD")
	@DzModelField(name="s_csf_cd", desc="소분류코드", colName="S_CSF_CD", colSize="5", isKey=false)
	private String s_csf_cd;
	  
	@SerializedName("S_CSF_NM")
	@DzModelField(name="s_csf_nm", desc="소분류명", colName="S_CSF_NM", colSize="200", isKey=false)
	private String s_csf_nm;
	  
	@SerializedName("TCLF_CD")
	@DzModelField(name="tclf_cd", desc="세분류코드", colName="TCLF_CD", colSize="5", isKey=false)
	private String tclf_cd;
	  
	@SerializedName("TCLF_NM")
	@DzModelField(name="tclf_nm", desc="세분류명", colName="TCLF_NM", colSize="50", isKey=false)
	private String tclf_nm;
	  
	@SerializedName("ACLF_CD")
	@DzModelField(name="aclf_cd", desc="능력분류코드", colName="ACLF_CD", colSize="5", isKey=false)
	private String aclf_cd;
	  
	@SerializedName("ACLF_NM")
	@DzModelField(name="aclf_nm", desc="능력분류명", colName="ACLF_NM", colSize="50", isKey=false)
	private String aclf_nm;
	  
	@SerializedName("ACLF_LV")
	@DzModelField(name="aclf_lv", desc="능력분류레벨", colName="ACLF_LV", colSize="3", isKey=false)
	private BigDecimal aclf_lv;
	  
	@SerializedName("ACLF_TXT")
	@DzModelField(name="aclf_txt", desc="능력분류텍스트", colName="ACLF_TXT", colSize="1000", isKey=false)
	private String aclf_txt;

	@SerializedName("COMPANY_CD")
	@DzModelField(name="company_cd", desc="회사코드", colName="COMPANY_CD", colSize="1000", isKey=false)
	private String COMPANY_CD;
	

	public String getCompany_cd() {
		return COMPANY_CD;
	}

	public void setCompany_cd(String company_cd) {
		this.COMPANY_CD = company_cd;
	}

	public String getUse_yn() {
		return USE_YN;
	}

	public void setUse_yn(String use_yn) {
		this.USE_YN = use_yn;
	}
 
	public String getJob_fg() {
		return job_fg;
	}

	public void setJob_fg(String job_fg) {
		this.job_fg = job_fg;
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
 
	public String getLclas_cd() {
		return lclas_cd;
	}

	public void setLclas_cd(String lclas_cd) {
		this.lclas_cd = lclas_cd;
	}
 
	public String getLclas_nm() {
		return lclas_nm;
	}

	public void setLclas_nm(String lclas_nm) {
		this.lclas_nm = lclas_nm;
	}
 
	public String getMlsfc_cd() {
		return mlsfc_cd;
	}

	public void setMlsfc_cd(String mlsfc_cd) {
		this.mlsfc_cd = mlsfc_cd;
	}
 
	public String getMlsfc_nm() {
		return mlsfc_nm;
	}

	public void setMlsfc_nm(String mlsfc_nm) {
		this.mlsfc_nm = mlsfc_nm;
	}
 
	public String getS_csf_cd() {
		return s_csf_cd;
	}

	public void setS_csf_cd(String s_csf_cd) {
		this.s_csf_cd = s_csf_cd;
	}
 
	public String getS_csf_nm() {
		return s_csf_nm;
	}

	public void setS_csf_nm(String s_csf_nm) {
		this.s_csf_nm = s_csf_nm;
	}
 
	public String getTclf_cd() {
		return tclf_cd;
	}

	public void setTclf_cd(String tclf_cd) {
		this.tclf_cd = tclf_cd;
	}
 
	public String getTclf_nm() {
		return tclf_nm;
	}

	public void setTclf_nm(String tclf_nm) {
		this.tclf_nm = tclf_nm;
	}
 
	public String getAclf_cd() {
		return aclf_cd;
	}

	public void setAclf_cd(String aclf_cd) {
		this.aclf_cd = aclf_cd;
	}
 
	public String getAclf_nm() {
		return aclf_nm;
	}

	public void setAclf_nm(String aclf_nm) {
		this.aclf_nm = aclf_nm;
	}
 
	public BigDecimal getAclf_lv() {
		return aclf_lv;
	}

	public void setAclf_lv(BigDecimal aclf_lv) {
		this.aclf_lv = aclf_lv;
	}
 
	public String getAclf_txt() {
		return aclf_txt;
	}

	public void setAclf_txt(String aclf_txt) {
		this.aclf_txt = aclf_txt;
	}
	
    @Override
    public String toString() {
      return
        "use_yn: ["+ USE_YN +"]\n"+
        "job_fg: ["+ job_fg +"]\n"+
        "aclf_no: ["+ aclf_no +"]\n"+
        "ver_cd: ["+ ver_cd +"]\n"+
        "lclas_cd: ["+ lclas_cd +"]\n"+
        "lclas_nm: ["+ lclas_nm +"]\n"+
        "mlsfc_cd: ["+ mlsfc_cd +"]\n"+
        "mlsfc_nm: ["+ mlsfc_nm +"]\n"+
        "s_csf_cd: ["+ s_csf_cd +"]\n"+
        "s_csf_nm: ["+ s_csf_nm +"]\n"+
        "tclf_cd: ["+ tclf_cd +"]\n"+
        "tclf_nm: ["+ tclf_nm +"]\n"+
        "aclf_cd: ["+ aclf_cd +"]\n"+
        "aclf_nm: ["+ aclf_nm +"]\n"+
        "aclf_lv: ["+ aclf_lv +"]\n"+
        "aclf_txt: ["+ aclf_txt +"]";
    }
}
