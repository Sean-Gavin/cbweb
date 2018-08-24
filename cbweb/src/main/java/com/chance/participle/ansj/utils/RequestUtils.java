package com.chance.participle.ansj.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.chance.participle.ansj.bean.ASMCustomRequestInfo;
import com.chance.participle.ansj.bean.ParticipleRequestInfo;
import com.chance.participle.ansj.utils.enums.PirticipleModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 8, 2017 3:00:39 PM
 * @version 1.0
 * 
 */
public class RequestUtils {

	public static ParticipleRequestInfo generateParticipleRequestInfo(HttpServletRequest request){
		
		ParticipleRequestInfo requestInfo = new ParticipleRequestInfo();
		BufferedReader reader = null;
		String line = null;
		StringBuffer buffer = new StringBuffer();
		try {
			reader = new BufferedReader(new InputStreamReader(
					request.getInputStream(), "UTF-8"));
			
			while ((line = reader.readLine()) != null) {

				buffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			JsonNode rootNode = mapper.readTree(buffer.toString());
			
			JsonNode contents = rootNode.path("content");
			
			if (null != contents && contents.size() > 0 && !StringUtils.isBlank(contents.toString())) {
				
				List<String> contentList = new ArrayList<String>();
				for (JsonNode content : contents) {
					contentList.add(content.textValue());
				}
				requestInfo.setContentList(contentList);
			}
			
			JsonNode title = rootNode.path("title");
			
			if (null != title && !StringUtils.isBlank(title.textValue())) {
				
				requestInfo.setTitle(StringUtils.deleteWhitespace(title.textValue().trim()));
			}
			
			JsonNode count = rootNode.path("count");
			
			if (null != count && StringUtils.isBlank(count.textValue())) {
				
				requestInfo.setTermConut(count.intValue());
			}
			
			JsonNode model = rootNode.path("model");
			
			if (null != model && 0 != model.intValue()) {
				
				requestInfo.setModel(PirticipleModel.fromInt(model.intValue()));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		System.out.println(requestInfo);
//		requestInfo.setClientIp(NetworkUtils.getClientIp(request));
//		requestInfo.setStartTime(System.currentTimeMillis());
		return requestInfo;
	}
	
	public static ASMCustomRequestInfo generateParticipleASMRequestInfo(HttpServletRequest request){
		ASMCustomRequestInfo requestInfo = new ASMCustomRequestInfo();
		BufferedReader reader = null;
		String line = null;
		StringBuffer buffer = new StringBuffer();
		try {
			reader = new BufferedReader(new InputStreamReader(
					request.getInputStream(), "UTF-8"));
			
			while ((line = reader.readLine()) != null) {

				buffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			JsonNode rootNode = mapper.readTree(buffer.toString());
			
			JsonNode appName = rootNode.path("appName");
			
			if (null != appName && !StringUtils.isBlank(appName.textValue())) {
				
				requestInfo.setAppName(StringUtils.deleteWhitespace(appName.textValue().trim()));
			}
			
			JsonNode subtitle = rootNode.path("subtitle");
			
			if (null != subtitle && !StringUtils.isBlank(subtitle.textValue())) {
				
				requestInfo.setSubtitle(StringUtils.deleteWhitespace(subtitle.textValue().trim()));
			}
			
			JsonNode keywords = rootNode.path("keywords");
			
			if (null != keywords && !StringUtils.isBlank(keywords.textValue())) {
				
				requestInfo.setKeywords(StringUtils.deleteWhitespace(keywords.textValue().trim()));
			}
			
			JsonNode model = rootNode.path("model");
			
			if (null != model && 0 != model.intValue()) {
				
				requestInfo.setModel(PirticipleModel.fromInt(model.intValue()));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return requestInfo;
	}
	
	public static List<String> generateWordListInfo(HttpServletRequest request){
		
		BufferedReader reader = null;
		String line = null;
		StringBuffer buffer = new StringBuffer();
		try {
			reader = new BufferedReader(new InputStreamReader(
					request.getInputStream(), "UTF-8"));
			
			while ((line = reader.readLine()) != null) {

				buffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<String> list = new ArrayList<String>();
		
		try {
			JsonNode rootNode = mapper.readTree(buffer.toString());
			
			JsonNode words = rootNode.path("words");
			
			if (null != words && words.size() > 0 && !StringUtils.isBlank(words.toString())) {
				
				for (JsonNode content : words) {
					list.add(content.textValue());
				}
			}
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

