package com.chance.participle.ansj.utils.enums;
/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 18, 2017 5:25:40 PM
 * @version 1.0
 * 
 */
public enum PirticipleModel {

	BASE_ANALYSE(1),
	ACCURATE_ANALYSE(2),
	DIC_ANALYSE(3),
	NLP_ANALYSE(4),
	INDEX_ANALYSE(5),
	KEYWORD_ANALYSE(6);
	
	private int code;

	private PirticipleModel (int model) {
		
		this.code = model;
	}
	
	public static PirticipleModel fromString(String model){
		
		int eventType = Integer.valueOf(model);
		return fromInt(eventType);
	}
	
	//TODO throw checked exception.
	public static PirticipleModel fromInt(int model){
		
		for(PirticipleModel type : PirticipleModel.values()){
			
			if(type.code == model){
				
				return type;
			}
		}
		
		throw new IllegalArgumentException("The error event type is: " + model);
	}
	
	public int getCode() {
		return code;
	}
	
	
}

