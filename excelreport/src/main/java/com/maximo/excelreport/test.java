package com.maximo.excelreport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class test {

 
	public static void main(String[] args) {
		String driver = "org.mariadb.jdbc.Driver";
	    Connection con;
	    PreparedStatement pstmt;
	    ResultSet rs;
		
		  try {
	            Class.forName(driver);
	            con = DriverManager.getConnection(
	                    "jdbc:mariadb://127.0.0.1:3306/test",
	                    "root",
	                    "1234");
	    		String quary = "SELECT * FROM smchange";
				
				
	    		   
		        
	    		pstmt = con.prepareStatement(quary);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					System.out.println(rs.getString(1));
					
				}
	            if( con != null ) {
	                System.out.println("DB 접속 성공");
	            }
	            
	        } catch (ClassNotFoundException e) { 
	            System.out.println("드라이버 로드 실패");
	        } catch (SQLException e) {
	            System.out.println("DB 접속 실패");
	            e.printStackTrace();
	        }
		
		
	

	}

}
