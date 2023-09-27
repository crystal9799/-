package com.douzone.comet.service.hr.cdmjim00100.models;
 
import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "cdmjim00100_right_grid2", desc = "수행준거내역_하단", tableName = "")
public class cdmjim00100_right_grid2 extends DzAbstractModel {

	@SerializedName("COMPANY_CD")
	@DzModelField(name="COMPANY_CD", desc="능력분류번호", colName="COMPANY_CD", colSize="20", isKey=false)
	private String COMPANY_CD;
	
	@SerializedName("IP")
	@DzModelField(name="IP", desc="IP", colName="IP", colSize="100", isKey=false)
	private String IP;

	@SerializedName("USER_ID")
	@DzModelField(name = "USER_ID", desc = "USER_ID", colName = "USER_ID", colSize = "100", isKey = false)
	private String USER_ID;
	
	@SerializedName("ACLF_NO")
	@DzModelField(name="ACLF_NO", desc="능력분류번호", colName="ACLF_NO", colSize="20", isKey=false)
	private String ACLF_NO;
	  
	@SerializedName("VER_CD")
	@DzModelField(name="VER_CD", desc="버전코드", colName="VER_CD", colSize="5", isKey=false)
	private String VER_CD;
	  
	@SerializedName("AELM_CD")
	@DzModelField(name="AELM_CD", desc="능력요소코드", colName="AELM_CD", colSize="5", isKey=false)
	private String AELM_CD;
	  
	@SerializedName("PCFM_CD")
	@DzModelField(name="PCFM_CD", desc="수행준거코드", colName="PCFM_CD", colSize="5", isKey=false)
	private String PCFM_CD;
	  
	@SerializedName("NEED_RQISIT_NM1")
	@DzModelField(name="NEED_RQISIT_NM1", desc="필요지식", colName="NEED_RQISIT_NM1", colSize="100", isKey=false)
	private String NEED_RQISIT_NM1;
	  
	@SerializedName("NEED_RQISIT_NM2")
	@DzModelField(name="NEED_RQISIT_NM2", desc="필요기술", colName="NEED_RQISIT_NM2", colSize="100", isKey=false)
	private String NEED_RQISIT_NM2;
	  
	@SerializedName("NEED_RQISIT_NM3")
	@DzModelField(name="NEED_RQISIT_NM3", desc="필요역량", colName="NEED_RQISIT_NM3", colSize="200", isKey=false)
	private String NEED_RQISIT_NM3;
	
	@SerializedName("NEED_RQISIT_CD")
	@DzModelField(name="NEED_RQISIT_CD", desc="코드", colName="NEED_RQISIT_CD", colSize="200", isKey=false)
	private String NEED_RQISIT_CD;
	
	public String getCOMPANY_CD() {
		return COMPANY_CD;
	}

	public void setCOMPANY_CD(String cOMPANY_CD) {
		COMPANY_CD = cOMPANY_CD;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getNeed_rqisit_cd() {
		return NEED_RQISIT_CD;
	}

	public void setNeed_rqisit_cd(String need_rqisit_cd) {
		this.NEED_RQISIT_CD = need_rqisit_cd;
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

	public void setVer_cd(String ver_cd) {
		this.VER_CD = ver_cd;
	}
 
	public String getAelm_cd() {
		return AELM_CD;
	}

	public void setAelm_cd(String aelm_cd) {
		this.AELM_CD = aelm_cd;
	}
 
	public String getPcfm_cd() {
		return PCFM_CD;
	}

	public void setPcfm_cd(String pcfm_cd) {
		this.PCFM_CD = pcfm_cd;
	}

	public String getNeed_rqisit_nm1() {
		return NEED_RQISIT_NM1;
	}

	public void setNeed_rqisit_nm1(String need_rqisit_nm1) {
		this.NEED_RQISIT_NM1 = need_rqisit_nm1;
	}

	public String getNeed_rqisit_nm2() {
		return NEED_RQISIT_NM2;
	}

	public void setNeed_rqisit_nm2(String need_rqisit_nm2) {
		this.NEED_RQISIT_NM2 = need_rqisit_nm2;
	}

	public String getNeed_rqisit_nm3() {
		return NEED_RQISIT_NM3;
	}

	public void setNeed_rqisit_nm3(String need_rqisit_nm3) {
		this.NEED_RQISIT_NM3 = need_rqisit_nm3;
	}

	@Override
	public String toString() {
		return "cdmjim00100_right_grid2 [COMPANY_CD=" + COMPANY_CD + ", ACLF_NO=" + ACLF_NO + ", VER_CD=" + VER_CD
				+ ", AELM_CD=" + AELM_CD + ", PCFM_CD=" + PCFM_CD + ", NEED_RQISIT_NM1=" + NEED_RQISIT_NM1
				+ ", NEED_RQISIT_NM2=" + NEED_RQISIT_NM2 + ", NEED_RQISIT_NM3=" + NEED_RQISIT_NM3 + ", NEED_RQISIT_CD="
				+ NEED_RQISIT_CD + "]";
	}
	
}
