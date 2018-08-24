package com.chance.participle.ansj.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ansj.app.keyword.Keyword;
import org.ansj.domain.Term;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chance.participle.ansj.bean.ASMCustomRequestInfo;
import com.chance.participle.ansj.bean.ASMCustomResponseInfo;
import com.chance.participle.ansj.bean.ASMCustomResultInfo;
import com.chance.participle.ansj.bean.ParticipleRequestInfo;
import com.chance.participle.ansj.bean.ResponseContent;
import com.chance.participle.ansj.bean.ResultTerm;
import com.chance.participle.ansj.filter.PirticipleFilterBuilder;
import com.chance.participle.ansj.utils.enums.PirticipleModel;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 15, 2017 2:20:47 PM
 * @version 1.0
 * 
 */
public class PirticipleContentBuild {

	private static Logger logger = LoggerFactory.getLogger(PirticipleContentBuild.class);
	
	public static ResponseContent getPirticipleResultContent(ParticipleRequestInfo requestInfo) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Start Build the pirticiple result content");
		}
		
		switch (requestInfo.getModel()){
		case BASE_ANALYSE : {
			return getBaseAnsjAnalyseContent(requestInfo);
		}
		case ACCURATE_ANALYSE : {
			return getAccurateAnsjAnalyseContent(requestInfo);
		}
		case DIC_ANALYSE : {
			return null;
		}
		case NLP_ANALYSE : {
			return getNLPAnsjAnalyseContent(requestInfo);
		}
		case INDEX_ANALYSE : {
			return null;
		}
		case KEYWORD_ANALYSE : {
			return getKeyWordAnsjAnalyseContent(requestInfo);
		}
		default : {
			return null;
		}
		}
		
	}
	
	public static ASMCustomResponseInfo getASMPirticipleResultContent(ASMCustomRequestInfo requestInfo) {
		
		ASMCustomResponseInfo rsponseInfo = new ASMCustomResponseInfo();
		ASMCustomResultInfo resultInfo = new ASMCustomResultInfo();
		List<Term> totalList = new ArrayList<Term>();
		
		if(!StringUtils.isBlank(requestInfo.getAppName())) {
			List<Term> appNameTermList = new ArrayList<Term>();
			
			if (PirticipleModel.NLP_ANALYSE.equals(requestInfo.getModel())) {
				
				appNameTermList = AnsjManager.nlpAnalyse(requestInfo.getAppName());
			} else {
				
				appNameTermList = AnsjManager.AccurateAnalyse(requestInfo.getAppName());
			}
			resultInfo.setAppNameTermList(getResultContentByTerm(appNameTermList));
			totalList.addAll(appNameTermList);
		} 

		if(!StringUtils.isBlank(requestInfo.getKeywords())) {
			List<Term> keywordsTermList = new ArrayList<Term>();
			
			if (PirticipleModel.NLP_ANALYSE.equals(requestInfo.getModel())) {
				
				keywordsTermList = AnsjManager.nlpAnalyse(requestInfo.getKeywords());
			} else {
				
				keywordsTermList = AnsjManager.AccurateAnalyse(requestInfo.getKeywords());
			}
			
			resultInfo.setKeywordsTermList(getResultContentByTerm(keywordsTermList));
			totalList.addAll(keywordsTermList);
		}

		if(!StringUtils.isBlank(requestInfo.getSubtitle())) {
			List<Term> subtitleTermList = new ArrayList<Term>();
			
			if (PirticipleModel.NLP_ANALYSE.equals(requestInfo.getModel())) {
				
				subtitleTermList = AnsjManager.nlpAnalyse(requestInfo.getSubtitle());
			} else {
				
				subtitleTermList = AnsjManager.AccurateAnalyse(requestInfo.getSubtitle());
			}
			
			resultInfo.setSubtitleTermList(getResultContentByTerm(subtitleTermList));
			totalList.addAll(subtitleTermList);
		}
		
		resultInfo.setTotalTermList(getResultContentByTerm(totalList));
		
		rsponseInfo.setCode(0);
		rsponseInfo.setResultInfo(resultInfo);
		return rsponseInfo;
	}

	private static ResponseContent getNLPAnsjAnalyseContent(ParticipleRequestInfo requestInfo) {
		
		ResponseContent responseContent = new ResponseContent();
		
		List<Term> resultTermList = new ArrayList<Term>();
		
		for (String content : requestInfo.getContentList()) {
			
			resultTermList.addAll(AnsjManager.nlpAnalyse(content));
			
		}
		
		List<Term> filteredtermList = new ArrayList<Term>();
		
		filteredtermList = Lists.newArrayList(Collections2.filter(resultTermList, PirticipleFilterBuilder.
						buildTermVisibilityPredicate(requestInfo)));
		
		responseContent.setCode(0);
		
		responseContent.setTermList(getResultContentByTerm(filteredtermList));
		
		return responseContent;
	}

	private static ResponseContent getAccurateAnsjAnalyseContent(ParticipleRequestInfo requestInfo) {
		
		ResponseContent responseContent = new ResponseContent();
		
		List<Term> resultTermList = new ArrayList<Term>();
		
		for (String content : requestInfo.getContentList()) {
			
			resultTermList.addAll(AnsjManager.AccurateAnalyse(content));
			
		}
		
		List<Term> filteredtermList = new ArrayList<Term>();
		
		filteredtermList = Lists.newArrayList(Collections2.filter(resultTermList, PirticipleFilterBuilder.
						buildTermVisibilityPredicate(requestInfo)));
		
		responseContent.setCode(0);
		
		responseContent.setTermList(getResultContentByTerm(filteredtermList));
		
		return responseContent;
	}

	private static ResponseContent getKeyWordAnsjAnalyseContent(ParticipleRequestInfo requestInfo) {
		
		ResponseContent responseContent = new ResponseContent();
		
		Collection<Keyword> resultKeyWordList = AnsjManager.keywordScore(requestInfo);
		
		responseContent.setCode(0);
		
		responseContent.setTermList(getResultContentByKeyWord(resultKeyWordList));
		
		return responseContent;
	}



	private static ResponseContent getBaseAnsjAnalyseContent(ParticipleRequestInfo requestInfo) {
		
		ResponseContent responseContent = new ResponseContent();
		
		List<Term> resultTermList = new ArrayList<Term>();
		
		for (String content : requestInfo.getContentList()) {
			
			resultTermList.addAll(AnsjManager.baseAnalyse(content));
			
		}
		
		List<Term> filteredtermList = new ArrayList<Term>();
		
		filteredtermList =
				Lists.newArrayList(Collections2.filter(resultTermList, PirticipleFilterBuilder.
						buildTermVisibilityPredicate(requestInfo)));
		
		responseContent.setCode(0);
		
		responseContent.setTermList(getResultContentByTerm(filteredtermList));
		
		return responseContent;
	}
	
	public static List<ResultTerm> getResultContentByTerm(List<Term> termList) {
		
		List<ResultTerm> tempTermList = new ArrayList<ResultTerm>();
		List<ResultTerm> resultTermList = new ArrayList<ResultTerm>();
		Set<ResultTerm> resultTermSet = new HashSet<ResultTerm>();
		
		//build the response content.
		for (Term term : termList) {
			
			ResultTerm tempTerm = new ResultTerm();
			tempTerm.setName(term.getName());
			tempTerm.setNature(term.getNatureStr());
			tempTermList.add(tempTerm);
		}
		
		resultTermSet.addAll(tempTermList);
		
		for (ResultTerm term : resultTermSet) {
			
			term.setFrequency(Collections.frequency(tempTermList, term));
			resultTermList.add(term);
		}
		
		Collections.sort(resultTermList);
		
		return resultTermList;
	}
	
	
	private static List<ResultTerm> getResultContentByKeyWord(Collection<Keyword> resultKeyWordList) {
		
		List<ResultTerm> resultTermList = new ArrayList<ResultTerm>();
		
		//build the response content.
		for (Keyword keyword : resultKeyWordList) {
			
			ResultTerm tempTerm = new ResultTerm();
			tempTerm.setName(keyword.getName());
			tempTerm.setFrequency(keyword.getFreq());
//			tempTerm.setScore(keyword.getScore());
			
			resultTermList.add(tempTerm);
		}
		return resultTermList;
	}
}

