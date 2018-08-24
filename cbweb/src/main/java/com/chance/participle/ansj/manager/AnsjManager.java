package com.chance.participle.ansj.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

import com.chance.participle.ansj.bean.ParticipleRequestInfo;

/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 14, 2017 7:48:24 PM
 * @version 1.0
 * 
 */
public class AnsjManager {
	
	public static List<Term> baseAnalyse(String content) {
		
		List<Term> resultTermList = new ArrayList<Term>();
		
		resultTermList = BaseAnalysis.parse(content).getTerms();
		
		return resultTermList;
	} 
	
	public static List<Term> nlpAnalyse(String content) {
		
		List<Term> resultTermList = new ArrayList<Term>();
		
		resultTermList = NlpAnalysis.parse(content).getTerms();
		
		return resultTermList;
	} 
	
	public static List<Term> AccurateAnalyse(String content) {
		
		List<Term> resultTermList = new ArrayList<Term>();
		
		resultTermList = ToAnalysis.parse(content).getTerms();
		
		return resultTermList;
	} 
	
	public static Collection<Keyword> keywordScore(ParticipleRequestInfo requestInfo) {
		
		int termCont = 5;
		
		if (0 != requestInfo.getTermConut()) {
			
			termCont = requestInfo.getTermConut();
		}
		
		KeyWordComputer kwc = new KeyWordComputer(termCont);
		
		Collection<Keyword> result = kwc.computeArticleTfidf(requestInfo.getTitle(), requestInfo.getContentList().get(0));
		
		return result;
	} 
	
}

