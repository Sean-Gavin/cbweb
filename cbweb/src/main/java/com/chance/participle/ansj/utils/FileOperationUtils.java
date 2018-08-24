package com.chance.participle.ansj.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/** 
 * 
 * @author Sean
 * @date 创建时间：Nov 6, 2017 8:11:38 PM
 * @version 1.0
 * 
 */
public class FileOperationUtils {

	public static boolean writeToFileByFileWriter(String path, byte[] contentBytes, String code) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(path, true);
			fw.write(new String(contentBytes, code));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static boolean writeToFileByBufferWriter(String path, byte[] contentBytes, String code) {
		BufferedWriter out = null;     
        try {     
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true)));     
            out.write(new String(contentBytes, code));    
            return true;
        } catch (Exception e) {     
            e.printStackTrace();     
        } finally {     
            try {     
                if(out != null){  
                    out.close();     
                }  
            } catch (IOException e) {     
                e.printStackTrace();     
            }     
        }    
        return false;
	}
}

