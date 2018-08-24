package com.chance.participle.ansj.bean;

import com.chance.participle.ansj.utils.enums.PirticipleModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** 
 * 
 * @author Sean
 * @date 创建时间：Oct 25, 2017 7:59:44 PM
 * @version 1.0
 * 
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ASMCustomRequestInfo {

	@JsonProperty("model")
	private PirticipleModel model;
	
	@JsonProperty("appName")
	private String appName;
	
	@JsonProperty("subtitle")
	private String subtitle;
	
	@JsonProperty("keywords")
	private String keywords;

	public PirticipleModel getModel() {
		return model;
	}

	public void setModel(PirticipleModel model) {
		this.model = model;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "ASMCustomRequestInfo [model=" + model + ", appName=" + appName + ", subtitle=" + subtitle
				+ ", keywords=" + keywords + "]";
	}

}

