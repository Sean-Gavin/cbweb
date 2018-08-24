package com.chance.participle.ansj.bean;
/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 15, 2017 6:28:06 PM
 * @version 1.0
 * 
 */
public class SessionContext {

	private String clientIp;
	private String userAgent;
	private Long startTime;
	private Long endTime;
	
//	privat
	
	
	
	
	
	
	
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

