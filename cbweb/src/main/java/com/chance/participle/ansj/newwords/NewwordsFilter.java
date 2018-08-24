package com.chance.participle.ansj.newwords;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chance.participle.ansj.request.ParticipleRequest;

/** 
 * 
 * @author Sean
 * @date 创建时间：Nov 6, 2017 6:48:33 PM
 * @version 1.0
 * 
 */
public class NewwordsFilter {

	private static Logger logger = LoggerFactory.getLogger(NewwordsFilter.class);
	
	static String punctuation = "[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]$";
	
	
	public static String filterWords(String word) {
		
		if (null == word) {
			return null;
		}
		
		if (word.length() > 10) {
			logger.info("This word is too long, skip it. The Word is :" + word);
			return null;
		}
		
		Pattern patPunc = Pattern.compile(punctuation);  
		Matcher matcher = patPunc.matcher(word);
		
		if (matcher.find()) {
			logger.info("This word contains punctuation, skip it. The Word is :" + word);
			return null;
		}
		
		Result result = ToAnalysis.parse(word);
		
		if (result.getTerms().size() <= 1) {
			logger.info("The dic contains this word, or the program can deal is, so skip it. The Word is :" + word);
			return null;
		}
		
		return word;
	}
	
}

