package com.chance.participle.ansj.utils;

import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;


/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 8, 2017 3:03:59 PM
 * @version 1.0
 * 
 */
public class NetworkUtils {

	private static Logger logger = Logger.getLogger(NetworkUtils.class);
	
	public static final String ipSegment = "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
	 
	public static final Pattern ipv4Pattern = Pattern.compile("^(?:" + ipSegment + "\\.){3}" + ipSegment + "$");
	
	
	public static String getClientIp(HttpServletRequest request) {

		if (null == request) {

			return null;
		}

		String headerIp = null;
		String forwordHeader = request.getHeader("X-FORWARDED-FOR");
		boolean found = false;

		//the format of X-FORWORD-FOR is client-ip,proxy1-ip,proxy2-ip,... and the client ip may be private ip.
		if (forwordHeader != null) {
			
			StringTokenizer tokenizer = new StringTokenizer(forwordHeader, ",");
			while (tokenizer.hasMoreTokens()) {

				headerIp = tokenizer.nextToken().trim();
				if (isIPv4Valid(headerIp) && !isIPv4Private(headerIp)) {

					found = true;
					break;
				}
			}
		}
		else{
			if(logger.isDebugEnabled()){
				
				logger.debug("The header X-FORWARDED-FOR is empty, return remote address of servlet.");
			}
			return request.getRemoteAddr();
		}
		
		if (!found) {

			String remoteAddr = request.getRemoteAddr();
			if(isIPv4Valid(remoteAddr) && !isIPv4Private(remoteAddr)){
				
				return remoteAddr;
			}
		}
		
		return headerIp;
	}
	
	public static boolean isIPv4Private(String ip) {
		
		if(ip.trim().equalsIgnoreCase("127.0.0.1")){
			
			return true;
		}
		
		long longIp;
		try {
			longIp = ipToLong(ip);
			return (longIp >= ipToLong("10.0.0.0") && longIp <= ipToLong("10.255.255.255"))
					|| (longIp >= ipToLong("172.16.0.0") && longIp <= ipToLong("172.31.255.255"))
					|| longIp >= ipToLong("192.168.0.0") && longIp <= ipToLong("192.168.255.255");
		} catch (UnknownHostException e) {
			
			logger.error("Catch UnknownHostException {}", e);
		}
		
		return true;
	}
	
	public static boolean isIPv4Valid(String ip) {
		
		return ipv4Pattern.matcher(ip).matches();
	}
	
	public static long ipToLong(String ipAddressOri) throws UnknownHostException{

		if(StringUtils.isBlank(ipAddressOri)){

			logger.error("The ip address is null or empty.");
			throw new UnknownHostException("The ip address is null or empty.");
		}
		String ipAddress = ipAddressOri.trim();
		long[] ipSegments = new long[4];
		int position1 = ipAddress.indexOf(".");
		if(position1 < 0){
			logger.error("The format of ip address " +ipAddress+ "is incorrect.");
			throw new UnknownHostException(ipAddress);
		}
		int position2 = ipAddress.indexOf(".", position1 + 1);
		if(position2 < 0){
			
			logger.error("The format of ip address " +ipAddress+ "is incorrect.");
			throw new UnknownHostException(ipAddress);
		}
		int position3 = ipAddress.indexOf(".", position2 + 1);
		if(position3 < 0){
			
			logger.error("The format of ip address " +ipAddress+ "is incorrect.");
			throw new UnknownHostException(ipAddress);
		}
		ipSegments[0] = Long.parseLong(ipAddress.substring(0, position1));
		ipSegments[1] = Long.parseLong(ipAddress.substring(position1 + 1, position2));
		ipSegments[2] = Long.parseLong(ipAddress.substring(position2 + 1, position3));
		ipSegments[3] = Long.parseLong(ipAddress.substring(position3 + 1));
		return (ipSegments[0] << 24) + (ipSegments[1] << 16) + (ipSegments[2] << 8) + ipSegments[3];
	}
	
	
	
}

