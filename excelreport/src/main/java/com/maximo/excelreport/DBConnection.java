package com.maximo.excelreport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection dbConn;
	
	
	public static Connection getConnection() {
			try {
				
				String user = "root"; 
                String pw = "1234";
                String url = "jdbc:mariadb://127.0.0.1:3306/test";
                
                Class.forName("org.mariadb.jdbc.Driver");        
                dbConn = DriverManager.getConnection(url, user, pw);
                if(dbConn != null) {
                System.out.println("Database에 연결되었습니다.\n");
                }
			 } catch (ClassNotFoundException cnfe) {
	                System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
	            } catch (SQLException sqle) {
	                System.out.println("DB 접속실패 : "+sqle.toString());
	            } catch (Exception e) {
	                System.out.println("Unkonwn error");
	                e.printStackTrace();
	            }
			
		return dbConn;
		
	}

}
