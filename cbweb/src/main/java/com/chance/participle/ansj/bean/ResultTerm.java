package com.chance.participle.ansj.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** 
 * 
 * @author Sean
 * @date 创建时间：Oct 19, 2017 10:08:53 AM
 * @version 1.0
 * 
 */


@JsonIgnoreProperties(ignoreUnknown=true)
public class ResultTerm implements Comparable{

	@JsonProperty("name")
	private String name;
	
//	@JsonProperty("score")
//	private double score;
	@JsonProperty("nature")
	private String nature;
	
	@JsonProperty("frequency")
	private int frequency;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public boolean equals(Object obj) {
		
		ResultTerm term = (ResultTerm) obj;
		
		return this.name.equals(term.getName());
	}
	
	@Override
	public int hashCode() {
		String in = this.name;
		return in.hashCode();
	}
	
	@Override
	public String toString() {
		return "ResultTerm [name=" + name + ", nature=" + nature + ", frequency=" + frequency + "]";
	}

	@Override
	public int compareTo(Object obj) {
		ResultTerm term = (ResultTerm) obj;
		
		return term.getFrequency() - this.frequency;
	}
	
}

