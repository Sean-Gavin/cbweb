package com.chance.participle.test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 18, 2017 7:41:30 PM
 * @version 1.0
 * 
 */
public class Test {
	
	    public static void main(String[] args) {

	    	
	    }
	
		public static void test2() {
			
//			String str = "结婚的和尚未结婚的";
//			String str = "结合成分子";
			String str = "映客";
			List<Term> temp = ToAnalysis.parse(str).getTerms();
			System.out.println("To   " + ToAnalysis.parse(str));
			System.out.println("nlp  " + NlpAnalysis.parse(str));
			System.out.println("Dic  " + temp);
			
			BaseAnalysis.parse(str);
//			
//			for (char a : chars) {
//				
//				System.out.println(a);
//			}
			
		}
		
		public static void test3() {
			
			System.out.println(ToAnalysis.parse("王者榮耀"));
		}

	
	  public static void test() {

	    	//只关注这些词性的词
	        Set<String> expectedNature = new HashSet<String>() {{
	            add("n");add("v");add("vd");add("vn");add("vf");
	            add("vx");add("vi");add("vl");add("vg");
	            add("nt");add("nz");add("nw");add("nl");
	            add("ng");add("userDefine");add("wh");
	        }};
	        
	        try {
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        String str = "Override是覆盖的意思，这是jdk自带的一个注解。表示该方法是继续过来或者实现的方法，如果加了该注解，它的父类或者实现的接口中没有该方法，则ide会报错。不加也可以，但是加了增强了可读性，并且是一种强制性的覆盖。" ;
	        Result result = NlpAnalysis.parse(str); //分词结果的一个封装，主要是一个List<Term>的terms
	        
//	        UserDefineLibrary.insertWord("中文分词", "nzz", 1001);  
	        
//			System.out.println("base " + BaseAnalysis.parse(str));
			System.out.println("To   " + ToAnalysis.parse(str));
//			System.out.println("Dic  " + DicAnalysis.parse(str));
//			System.out.println("Index" + IndexAnalysis.parse(str));
//			System.out.println("nlp  " + NlpAnalysis.parse(str));
	        
	        System.out.println(result.getTerms());
	        List<Term> terms = result.getTerms(); //拿到terms
//	        
	        List<String> resultList = new ArrayList<String>();
//	        
			for (Term term : terms) {
				if (!term.natrue().natureStr.equals("w")) {
					resultList.add(term.getName());
				}
				System.out.println(term.getName()+":"+term.getNatureStr());
			}
			System.out.println(resultList.toString());
//	        System.out.println(terms.size());
	//
//	        for(int i=0; i<terms.size(); i++) {
//	            String word = terms.get(i).getName(); //拿到词
//	            String natureStr = terms.get(i).getNatureStr(); //拿到词性
//	            if(expectedNature.contains(natureStr)) {
//	                System.out.println(word + ":" + natureStr);
//	            }
//	        }
	    }
	    
	    public static void tttt() {
	        KeyWordComputer kwc = new KeyWordComputer();
	        String title = "维基解密否认斯诺登接受委内瑞拉庇护";
	        String content = "有俄罗斯国会议员，9号在社交网站推特表示，美国中情局前雇员斯诺登，已经接受委内瑞拉的庇护，不过推文在发布几分钟后随即删除。俄罗斯当局拒绝发表评论，而一直协助斯诺登的维基解密否认他将投靠委内瑞拉。　　俄罗斯国会国际事务委员会主席普什科夫，在个人推特率先披露斯诺登已接受委内瑞拉的庇护建议，令外界以为斯诺登的动向终于有新进展。　　不过推文在几分钟内旋即被删除，普什科夫澄清他是看到俄罗斯国营电视台的新闻才这样说，而电视台已经作出否认，称普什科夫是误解了新闻内容。　　委内瑞拉驻莫斯科大使馆、俄罗斯总统府发言人、以及外交部都拒绝发表评论。而维基解密就否认斯诺登已正式接受委内瑞拉的庇护，说会在适当时间公布有关决定。　　斯诺登相信目前还在莫斯科谢列梅捷沃机场，已滞留两个多星期。他早前向约20个国家提交庇护申请，委内瑞拉、尼加拉瓜和玻利维亚，先后表示答应，不过斯诺登还没作出决定。　　而另一场外交风波，玻利维亚总统莫拉莱斯的专机上星期被欧洲多国以怀疑斯诺登在机上为由拒绝过境事件，涉事国家之一的西班牙突然转口风，外长马加略]号表示愿意就任何误解致歉，但强调当时当局没有关闭领空或不许专机降落。";
	        Collection<Keyword> result = kwc.computeArticleTfidf(title, content);
	        System.out.println(result);
	        
	        
			ObjectMapper mapper = new ObjectMapper();
			StringWriter sw = new StringWriter();
			
			try {
				mapper.writeValue(sw, result);
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
	        System.out.println(sw.toString());
//	        for (Keyword key : result){
//	        	System.out.println(key.getName() + ":"+ key.getScore() + ":"+ key.getFreq());
//	        }
	    }
	    

		
}

