package com.chance.participle.ansj.bean;

import java.util.List;

import com.chance.participle.ansj.utils.enums.PirticipleModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 8, 2017 2:53:52 PM
 * @version 1.0
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipleRequestInfo{
	
	//The request use which analyse model.
	//1-base;2-
	@JsonProperty("model")
	private PirticipleModel model;
	
	@JsonProperty("count")
	private int termConut;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("content")
	private List<String> contentList;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getContentList() {
		return contentList;
	}
	public void setContentList(List<String> contentList) {
		this.contentList = contentList;
	}
	public PirticipleModel getModel() {
		return model;
	}
	public void setModel(PirticipleModel model) {
		this.model = model;
	}
	
	public int getTermConut() {
		return termConut;
	}
	public void setTermConut(int termConut) {
		this.termConut = termConut;
	}
	@Override
	public String toString() {
		return "ParticipleRequestInfo [model=" + model + ", termConut=" + termConut + ", title=" + title + ", contentList="
				+ contentList + "]";
	}

}

