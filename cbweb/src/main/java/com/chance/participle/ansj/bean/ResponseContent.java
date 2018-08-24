package com.chance.participle.ansj.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** 
 * 
 * @author Sean
 * @date 创建时间：Oct 19, 2017 9:49:54 AM
 * @version 1.0
 * 
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseContent {

	@JsonProperty("code")
	private int code;
	
	@JsonProperty("result")
	private List<ResultTerm> termList;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<ResultTerm> getTermList() {
		return termList;
	}

	public void setTermList(List<ResultTerm> termList) {
		this.termList = termList;
	}

	@Override
	public String toString() {
		return "ResponseInfo [code=" + code + ", termList=" + termList + "]";
	}
	
}

