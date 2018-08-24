package com.chance.participle.ansj.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** 
 * 
 * @author Sean
 * @date 创建时间：Oct 25, 2017 8:03:55 PM
 * @version 1.0
 * 
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class ASMCustomResultInfo {

	@JsonProperty("appName")
	private List<ResultTerm> appNameTermList;
	
	@JsonProperty("subtitle")
	private List<ResultTerm> subtitleTermList;
	
	@JsonProperty("keywords")
	private List<ResultTerm> keywordsTermList;
	
	@JsonProperty("total")
	private List<ResultTerm> totalTermList;


	public List<ResultTerm> getAppNameTermList() {
		return appNameTermList;
	}

	public void setAppNameTermList(List<ResultTerm> appNameTermList) {
		this.appNameTermList = appNameTermList;
	}

	public List<ResultTerm> getSubtitleTermList() {
		return subtitleTermList;
	}

	public void setSubtitleTermList(List<ResultTerm> subtitleTermList) {
		this.subtitleTermList = subtitleTermList;
	}

	public List<ResultTerm> getKeywordsTermList() {
		return keywordsTermList;
	}

	public void setKeywordsTermList(List<ResultTerm> keywordsTermList) {
		this.keywordsTermList = keywordsTermList;
	}

	public List<ResultTerm> getTotalTermList() {
		return totalTermList;
	}

	public void setTotalTermList(List<ResultTerm> totalTermList) {
		this.totalTermList = totalTermList;
	}

	@Override
	public String toString() {
		return "ASMCustomResponseInfo [appNameTermList=" + appNameTermList + ", subtitleTermList="
				+ subtitleTermList + ", keywordsTermList=" + keywordsTermList + ", totalTermList=" + totalTermList
				+ "]";
	}
	
}

