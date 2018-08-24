package com.chance.participle.ansj.request;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ansj.dic.impl.Jar2Stream;
import org.ansj.util.MyStaticValue;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestHandler;

import com.chance.participle.ansj.bean.ASMCustomRequestInfo;
import com.chance.participle.ansj.newwords.NewwordsFilter;
import com.chance.participle.ansj.utils.FileOperationUtils;
import com.chance.participle.ansj.utils.NetworkUtils;
import com.chance.participle.ansj.utils.RequestUtils;

/** 
 * 
 * @author Sean
 * @date 创建时间：Nov 6, 2017 8:01:51 PM
 * @version 1.0
 * 
 */
public class UpdateDicRequest implements HttpRequestHandler {

	private static Logger logger = LoggerFactory.getLogger(UpdateDicRequest.class);
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (logger.isDebugEnabled()) {

			logger.debug("Receive request from {}", NetworkUtils.getClientIp(request));
		}
		
		List<String> words = RequestUtils.generateWordListInfo(request);
		
		if (null == words || words.size() == 0){
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		} else {
			logger.info("Receive a request: " + words.toString());
		}
		
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "userLibrary.dic";
//		InputStream is = new Jar2Stream().toStream(path);
		
		for (String word : words) {
			String info = NewwordsFilter.filterWords(word);
			if (!StringUtils.isBlank(info)) {
				StringBuffer infoSB = new StringBuffer();
				infoSB.append(info).append("\t").append("n").append("\t").append("1").append("\n");
				logger.info("Insert a word into dic:" + infoSB.toString());
				logger.info("The Path is:" + path);
				FileOperationUtils.writeToFileByFileWriter(path, infoSB.toString().getBytes(), "UTF-8");
			}
		}
		
		MyStaticValue.reloadLibrary("dic");
		logger.info("Reroad the dic!");
		
		String responseStr = "OK";
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		if (!StringUtils.isBlank(responseStr)) {
			
			response.setContentLength(responseStr.getBytes().length);
			response.getWriter().write(responseStr);
			response.getWriter().close();
			
		} else {
			logger.error("There is no content return to client!");
			response.sendError(HttpServletResponse.SC_NO_CONTENT);
			return;
		}
	}
	
}

