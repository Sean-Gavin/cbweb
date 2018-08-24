package com.chance.participle.ansj.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ansj.domain.Term;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 14, 2017 7:59:56 PM
 * @version 1.0
 * 
 */
public class TermNatureFilterBuilder {
	private static Logger logger = LoggerFactory.getLogger(TermNatureFilterBuilder.class);
	
	//不需要的词性
	private static List<String> expectedNature = new ArrayList<String>(Arrays.asList("w","null"));
	
	public static Predicate<Term> buildNaturePredicate() {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Start Build the nature filter.");
		}
		return Predicates.and(Predicates.notNull(),
                new Predicate<Term>() {

					public boolean apply(Term term) {
						
						try {
							
							if (expectedNature.contains(term.getNatureStr())) {
								if (logger.isDebugEnabled()) {
									logger.debug("We don't need this term, because the nature of term is " 
											+ term.getNatureStr() + ", and the term is"+ term.getName());
								}
								return false;
							}
							
							return true;
						} catch (Exception e) {
							
							logger.error("Catch exception in buildNaturePredicate, the exception is " + e);
							return false;
						}
						
					}
			
		});
	}
	
	
	
	
}

