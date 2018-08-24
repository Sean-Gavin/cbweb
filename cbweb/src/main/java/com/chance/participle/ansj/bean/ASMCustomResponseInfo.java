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
public class ASMCustomResponseInfo {

	@JsonProperty("code")
	private int code;
	
	@JsonProperty("result")
	private ASMCustomResultInfo resultInfo;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public ASMCustomResultInfo getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(ASMCustomResultInfo resultInfo) {
		this.resultInfo = resultInfo;
	}

	@Override
	public String toString() {
		return "ASMCustomResponseInfo [code=" + code + ", resultInfo=" + resultInfo + "]";
	}

}

