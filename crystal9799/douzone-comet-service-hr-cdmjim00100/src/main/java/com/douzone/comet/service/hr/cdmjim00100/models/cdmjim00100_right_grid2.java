package com.douzone.comet.service.hr.cdmjim00100.models;
 
import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "cdmjim00100_right_grid2", desc = "수행준거내역_하단", tableName = "")
public class cdmjim00100_right_grid2 extends DzAbstractModel {

	@SerializedName("ACLF_NO")
	@DzModelField(name="aclf_no", desc="능력분류번호", colName="ACLF_NO", colSize="20", isKey=false)
	private String aclf_no;
	  
	@SerializedName("VER_CD")
	@DzModelField(name="ver_cd", desc="버전코드", colName="VER_CD", colSize="5", isKey=false)
	private String ver_cd;
	  
	@SerializedName("AELM_CD")
	@DzModelField(name="aelm_cd", desc="능력요소코드", colName="AELM_CD", colSize="5", isKey=false)
	private String aelm_cd;
	  
	@SerializedName("PCFM_CD")
	@DzModelField(name="pcfm_cd", desc="수행준거코드", colName="PCFM_CD", colSize="5", isKey=false)
	private String pcfm_cd;
	  
	@SerializedName("NEED_RQISIT_FG")
	@DzModelField(name="need_rqisit_fg", desc="필요요건구분", colName="NEED_RQISIT_FG", colSize="5", isKey=false)
	private String need_rqisit_fg;
	  
	@SerializedName("NEED_RQISIT_CD")
	@DzModelField(name="need_rqisit_cd", desc="필요요건코드", colName="NEED_RQISIT_CD", colSize="5", isKey=false)
	private String need_rqisit_cd;
	  
	@SerializedName("NEED_RQISIT_NM")
	@DzModelField(name="need_rqisit_nm", desc="필요요건명", colName="NEED_RQISIT_NM", colSize="200", isKey=false)
	private String need_rqisit_nm;

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
 
	public String getPcfm_cd() {
		return pcfm_cd;
	}

	public void setPcfm_cd(String pcfm_cd) {
		this.pcfm_cd = pcfm_cd;
	}
 
	public String getNeed_rqisit_fg() {
		return need_rqisit_fg;
	}

	public void setNeed_rqisit_fg(String need_rqisit_fg) {
		this.need_rqisit_fg = need_rqisit_fg;
	}
 
	public String getNeed_rqisit_cd() {
		return need_rqisit_cd;
	}

	public void setNeed_rqisit_cd(String need_rqisit_cd) {
		this.need_rqisit_cd = need_rqisit_cd;
	}
 
	public String getNeed_rqisit_nm() {
		return need_rqisit_nm;
	}

	public void setNeed_rqisit_nm(String need_rqisit_nm) {
		this.need_rqisit_nm = need_rqisit_nm;
	}
	
    @Override
    public String toString() {
      return
        "aclf_no: ["+ aclf_no +"]\n"+
        "ver_cd: ["+ ver_cd +"]\n"+
        "aelm_cd: ["+ aelm_cd +"]\n"+
        "pcfm_cd: ["+ pcfm_cd +"]\n"+
        "need_rqisit_fg: ["+ need_rqisit_fg +"]\n"+
        "need_rqisit_cd: ["+ need_rqisit_cd +"]\n"+
        "need_rqisit_nm: ["+ need_rqisit_nm +"]";
    }
}
