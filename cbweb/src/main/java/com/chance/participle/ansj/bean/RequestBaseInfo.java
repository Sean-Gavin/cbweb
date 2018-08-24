package com.chance.participle.ansj.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 14, 2017 7:40:30 PM
 * @version 1.0
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestBaseInfo {
	
	private String clientIp;
	private String userAgent;
	private Long startTime;
	private Long endTime;
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "RequestBaseInfo [clientIp=" + clientIp + ", userAgent=" + userAgent + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
}

