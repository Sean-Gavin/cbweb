package com.chance.participle.test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.ansj.domain.TermNatures;
import org.ansj.recognition.impl.NatureRecognition;
import org.ansj.splitWord.analysis.DicAnalysis;
import org.ansj.util.MyStaticValue;

import com.chance.participle.ansj.newwords.NewwordsFilter;
import com.chance.participle.ansj.utils.MysqlConnManager;

/** 
 * 
 * @author Sean
 * @date 创建时间：Nov 6, 2017 6:46:25 PM
 * @version 1.0
 * 
 */
public class MakeMyDic {

    private static Connection conn = null;
    
    public static void main(String[] args) {
		
//    	String filePath = "C:/Users/Jack/Desktop/test.txt";
    	String filePath = "library/userLibrary.dic";
    	String sql = "select keyname from asm_keywords_dict";
//    	FileOutputStream out = null;
    	FileWriter fw = null;
    	Connection conn = null;
    	try {
    		fw = new FileWriter(filePath);
    		conn = MysqlConnManager.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int i = 1;
			while (rs.next()) {
				String keyword = rs.getString("keyname");
				if (null != NewwordsFilter.filterWords(keyword)) {
					
					StringBuffer infoSB = new StringBuffer();
					
					infoSB.append(keyword).append("\t").append("n").append("\t").append("1").append("\n");
					
					fw.write(infoSB.toString());
					i ++;
					if (i % 100 == 0) {
						System.out.println("load library----------------" + i);
						MyStaticValue.reloadLibrary("dic");
					}
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				conn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    	
	}
    
    
}

