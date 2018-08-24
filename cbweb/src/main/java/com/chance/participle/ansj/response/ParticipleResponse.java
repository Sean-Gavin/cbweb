package com.chance.participle.ansj.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 15, 2017 11:13:21 AM
 * @version 1.0
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipleResponse {

	@JsonProperty("code")
	private String code;
	
	@JsonProperty("result")
	private String result;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ParticipleResponse [code=" + code + ", result=" + result + "]";
	}
	
}

