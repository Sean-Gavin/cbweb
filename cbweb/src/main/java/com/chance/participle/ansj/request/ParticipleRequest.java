package com.chance.participle.ansj.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestHandler;

import com.chance.participle.ansj.bean.ASMCustomRequestInfo;
import com.chance.participle.ansj.bean.ASMCustomResponseInfo;
import com.chance.participle.ansj.manager.PirticipleContentBuild;
import com.chance.participle.ansj.manager.PirticipleResponseBuild;
import com.chance.participle.ansj.utils.NetworkUtils;
import com.chance.participle.ansj.utils.RequestUtils;

/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 18, 2017 8:01:44 PM
 * @version 1.0
 * 
 */
public class ParticipleRequest implements HttpRequestHandler {

private static Logger logger = LoggerFactory.getLogger(ParticipleRequest.class);
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (logger.isDebugEnabled()) {

			logger.debug("Receive request from {}", NetworkUtils.getClientIp(request));
		}
		
		ASMCustomRequestInfo asmRequestInfo = RequestUtils.generateParticipleASMRequestInfo(request);
		
		if (null == asmRequestInfo || null == asmRequestInfo.getModel()){
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		} else {
			logger.info("Receive a request: " + asmRequestInfo.toString());
		}
		
		ASMCustomResponseInfo responseContent = PirticipleContentBuild.getASMPirticipleResultContent(asmRequestInfo);
		
		String responseStr = PirticipleResponseBuild.getPirticipleResponse(responseContent);
		
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

