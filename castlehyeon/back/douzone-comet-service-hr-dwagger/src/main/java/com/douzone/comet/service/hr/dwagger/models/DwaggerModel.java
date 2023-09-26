package com.douzone.comet.service.hr.dwagger.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DwaggerModel {
	@JsonProperty("params")
	private List<ApiParam> apiParamList;
	@JsonProperty("schemas")
	private List<ApiSchema> apiSchemaList;
	@JsonProperty("service")
	private String service;
	@JsonProperty("urlPattern")
	private String urlPattern;
	@JsonProperty("module")
	private String module;
	@JsonProperty("moduleDesc")
	private String moduleDesc;
	@JsonProperty("serviceDesc")
	private String serviceDesc;
	@JsonProperty("serviceVersion")
	private String serviceVersion;
	@JsonProperty("patternDesc")
	private String patternDesc;
	@JsonProperty("security")
	private String security;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getModuleDesc() {
		return moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}

	public String getServiceDesc() {
		return serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getPatternDesc() {
		return patternDesc;
	}

	public void setPatternDesc(String patternDesc) {
		this.patternDesc = patternDesc;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public List<ApiParam> getApiParamList() {
		return apiParamList;
	}

	public void setApiParamList(List<ApiParam> apiParamList) {
		this.apiParamList = apiParamList;
	}

	public List<ApiSchema> getApiSchemaList() {
		return apiSchemaList;
	}

	public void setApiSchemaList(List<ApiSchema> apiSchemaList) {
		this.apiSchemaList = apiSchemaList;
	}

	
}