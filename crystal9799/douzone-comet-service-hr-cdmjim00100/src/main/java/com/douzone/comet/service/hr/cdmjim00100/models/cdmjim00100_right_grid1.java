package com.douzone.comet.service.hr.cdmjim00100.models;
 
import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "cdmjim00100_right_grid1", desc = "수행준거내역_상단", tableName = "")
public class cdmjim00100_right_grid1 extends DzAbstractModel {

	@SerializedName("AELM_CD")
	@DzModelField(name="aelm_cd", desc="능력요소코드", colName="AELM_CD", colSize="5", isKey=false)
	private String aelm_cd;
	  
	@SerializedName("ACLF_NO")
	@DzModelField(name="aclf_no", desc="능력분류번호", colName="ACLF_NO", colSize="20", isKey=false)
	private String aclf_no;
	  
	@SerializedName("VER_CD")
	@DzModelField(name="ver_cd", desc="버전코드", colName="VER_CD", colSize="5", isKey=false)
	private String ver_cd;
	  
	@SerializedName("PCFM_CD")
	@DzModelField(name="pcfm_cd", desc="수행준거코드", colName="PCFM_CD", colSize="5", isKey=false)
	private String pcfm_cd;
	  
	@SerializedName("PCFM_DC")
	@DzModelField(name="pcfm_dc", desc="수행준거내역", colName="PCFM_DC", colSize="500", isKey=false)
	private String pcfm_dc;

	@SerializedName("_uid")
	@DzModelField(name="_uid", desc="_uid", colName="_uid", colSize="100", isKey=false)
	private String _uid;
	
	
	public String get_uid() {
		return _uid;
	}

	public void set_uid(String _uid) {
		this._uid = _uid;
	}

	public String getAelm_cd() {
		return aelm_cd;
	}

	public void setAelm_cd(String aelm_cd) {
		this.aelm_cd = aelm_cd;
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
 
	public String getPcfm_cd() {
		return pcfm_cd;
	}

	public void setPcfm_cd(String pcfm_cd) {
		this.pcfm_cd = pcfm_cd;
	}
 
	public String getPcfm_dc() {
		return pcfm_dc;
	}

	public void setPcfm_dc(String pcfm_dc) {
		this.pcfm_dc = pcfm_dc;
	}
	
    @Override
    public String toString() {
      return
        "aelm_cd: ["+ aelm_cd +"]\n"+
        "aclf_no: ["+ aclf_no +"]\n"+
        "ver_cd: ["+ ver_cd +"]\n"+
        "pcfm_cd: ["+ pcfm_cd +"]\n"+
        "pcfm_dc: ["+ pcfm_dc +"]";
    }
}
