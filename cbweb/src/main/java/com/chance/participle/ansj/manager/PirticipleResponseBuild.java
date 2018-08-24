package com.chance.participle.ansj.manager;

import java.io.IOException;
import java.io.StringWriter;

import com.chance.participle.ansj.bean.ResponseContent;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 15, 2017 3:47:13 PM
 * @version 1.0
 * 
 */
public class PirticipleResponseBuild {

	public static <T> String getPirticipleResponse(T t) {
		
		ObjectMapper mapper = new ObjectMapper();
		StringWriter sw = new StringWriter();
		
		try {
			mapper.writeValue(sw, t);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw.toString();
	}
	
}

