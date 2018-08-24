package com.chance.participle.ansj.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/** 
 * 
 * @author Sean
 * @date 创建时间：Nov 6, 2017 6:10:00 PM
 * @version 1.0
 * 
 */
public class MysqlConnManager {
	


	private static Connection conn = null;
    private final static String DB_URL = "jdbc:mysql://localhost:3306/sean";
    private final static String USER = "root";
    private final static String PASSWORD = "123456";
    
 
    
	public static Connection getConnection() {
        try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}
	
}

