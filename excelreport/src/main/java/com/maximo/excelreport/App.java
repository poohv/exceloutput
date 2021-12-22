package com.maximo.excelreport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.FileOutputStream;
import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;


public class App 
{
    public static void main( String[] args )
    {
    	Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String file_size = null;
		String file_path = "C:\\temp\\"+date.format(new Date())+"_Report";
		
		Workbook xworkbook = null; //엑셀파일 객체 생성
		Sheet xSheet = null; //시트 객체 생성
		Row xRow = null; //행 객체 생성
		Cell xCell = null; //열 객체 생성
					
		try {
							
			xworkbook = new SXSSFWorkbook(); //엑셀파일 생성
			xSheet = xworkbook.createSheet("sheet1"); //시트 생성
			
			String quary = "SELECT * FROM smchange";
			 Class.forName("org.mariadb.jdbc.Driver");        
			 conn = DriverManager.getConnection(url, user, pw);
			
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();
			
		
			//파일 생성
			File file = new File(file_path + ".xlsx"); // 파일 확장자 .xlsx로 고정		
			FileOutputStream fos = new FileOutputStream(file);
			
			System.out.println("Write Start " + date.format(new Date()));
				
			//첫 행 입력
			xRow = xSheet.createRow(0);
			xCell = xRow.createCell(0);
			xCell.setCellValue("자산번호");
			xCell = xRow.createCell(1);
			xCell.setCellValue("상위자산번호");
			xCell = xRow.createCell(2);
			xCell.setCellValue("상태");
			xCell = xRow.createCell(3);
			xCell.setCellValue("서버관리자");
			xCell = xRow.createCell(4);
			xCell.setCellValue("타워");
			xCell = xRow.createCell(5);
			xCell.setCellValue("자산소유권");
			xCell = xRow.createCell(6);
			xCell.setCellValue("설치site");
			xCell = xRow.createCell(7);
			xCell.setCellValue("설치층");
			xCell = xRow.createCell(8);
			xCell.setCellValue("Machine type");
			xCell = xRow.createCell(9);
			xCell.setCellValue("모델");
			xCell = xRow.createCell(10);
			xCell.setCellValue("Serial NO");
			xCell = xRow.createCell(11);
			xCell.setCellValue("호스트명");
			xCell = xRow.createCell(12);
			xCell.setCellValue("서비스 개시일");
			xCell = xRow.createCell(13);
			xCell.setCellValue("서비스 종료일");
			xCell = xRow.createCell(14);
			xCell.setCellValue("DR 대상여부");
			xCell = xRow.createCell(15);
			xCell.setCellValue("예외승인여부");
			xCell = xRow.createCell(16);
			xCell.setCellValue("인터넷 접근 여부");
			xCell = xRow.createCell(17);
			xCell.setCellValue("CBN 여부");
			xCell = xRow.createCell(18);
			xCell.setCellValue("QEV 여부");
			xCell = xRow.createCell(19);
			xCell.setCellValue("PR 여부");
			xCell = xRow.createCell(20);
			xCell.setCellValue("SLA 여부");
			xCell = xRow.createCell(21);
			xCell.setCellValue("고객ID 수");
			xCell = xRow.createCell(22);
			xCell.setCellValue("OS 명");
			xCell = xRow.createCell(23);
			xCell.setCellValue("OS 버전");	
			xCell = xRow.createCell(24);
			xCell.setCellValue("서비스 IP");	
			int row = 1; //row번째 행
				
			while(rs.next()) {
				
				// quary 결과에서 데이터 가져오기
				String wonum = rs.getString(1); // 쿼리 select문의 첫번째 열
				String description = rs.getString(2); // 쿼리 select문의 두번째 열
                //String description = rs.getString(description) 처럼 숫자 대신 컬럼명 입력해도 문제 없음
				
				// 데이터 입력
				xRow = xSheet.createRow(row);
				xCell = xRow.createCell(0);
				xCell.setCellValue(wonum);
				xCell = xRow.createCell(1);
				xCell.setCellValue(description);
				
				row++;		
			}
				
			rs.close();
			pstm.close();
			conn.close();
			
			// 파일 쓰기
			xworkbook.write(fos);
			if(fos != null) {
				fos.close();
			}
			System.out.println("Write complete " + date.format(new Date()));
									
				
		} catch(SQLException sqle) {
				
			System.out.println("quary Error");
			sqle.printStackTrace();
				
		} catch (Exception e) {
				
			System.out.print(e);
			
		} finally {
				
			try {
					
				if(rs != null) { rs.close();}
				if(pstm != null) { pstm.close();}
				if(conn != null) { conn.close();}
					
			} catch(Exception e) {
					
				throw new RuntimeException(e.getMessage());
					
			}
			
		}
    }
}
