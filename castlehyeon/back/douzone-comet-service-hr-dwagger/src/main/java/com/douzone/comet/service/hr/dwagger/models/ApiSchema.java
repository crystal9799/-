package com.douzone.comet.service.hr.dwagger.models;

import com.fasterxml.jackson.annotation.JsonProperty;

//하단 우측 그리드에 담길 정보
public class ApiSchema {
	@JsonProperty("col")
    private String col;
    @JsonProperty("type")
    private String type;
    @JsonProperty("desc")
    private String desc;
    
    

	public String getCol() {
		return col;
	}
	public void setCol(String col) {
		this.col = col;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
    
    
}
