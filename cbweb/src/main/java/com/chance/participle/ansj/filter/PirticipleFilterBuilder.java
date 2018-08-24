package com.chance.participle.ansj.filter;


import org.ansj.domain.Term;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chance.participle.ansj.bean.ParticipleRequestInfo;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 18, 2017 5:14:31 PM
 * @version 1.0
 * 
 */
public class PirticipleFilterBuilder {
	
	private static Logger logger = LoggerFactory.getLogger(PirticipleFilterBuilder.class);
	
	@SuppressWarnings("unchecked")
	public static Predicate<Term> buildTermVisibilityPredicate(ParticipleRequestInfo requestInfo) {
		
		if (logger.isDebugEnabled()) {

			logger.debug("Build the whole term filter chain.");
		}
		
		Predicate<Term> filterPrdicates =  Predicates.and(
				TermNatureFilterBuilder.buildNaturePredicate());
				
		return filterPrdicates;
		
	}
}

