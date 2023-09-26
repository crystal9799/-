package com.douzone.comet.service.hr.dwagger.models;

import com.fasterxml.jackson.annotation.JsonProperty;

//하단 좌측 그리드 정보
public class ApiParam {
	@JsonProperty("key")
    private String key;
    @JsonProperty("description")
    private String description;
    @JsonProperty("parameterType")
    private String parameterType;
    @JsonProperty("declareParameterType")
    private String declareParameterType;
    @JsonProperty("encryption")
    private String encryption;
    
    
    
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParameterType() {
		return parameterType;
	}
	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}
	public String getDeclareParameterType() {
		return declareParameterType;
	}
	public void setDeclareParameterType(String declareParameterType) {
		this.declareParameterType = declareParameterType;
	}
	public String getEncryption() {
		return encryption;
	}
	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}
	
	
    
}
