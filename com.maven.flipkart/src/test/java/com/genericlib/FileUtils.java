package com.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtils {
	public String getPropertyKeyValue(String path,String key)
	{
		FileInputStream ip=null;
		try {
			ip = new FileInputStream(path);
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Properties props=new Properties();
		
		try {
			props.load(ip);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return props.getProperty(key);
	}
	
	public String getExcelData(String path,String sheetName ,int cell ,int row) {
		Workbook wb=null;
		org.apache.poi.ss.usermodel.Sheet sh=null;
		String st=null;
		FileInputStream ip=null;
		
		try {
			ip=new FileInputStream(path);
		} 
		catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		
		try {
		wb=WorkbookFactory.create(ip);
		sh=wb.getSheet(sheetName);
		st=sh.getRow(row).getCell(cell).toString();
		}
		catch (Exception e) {
			e.printStackTrace();
	}
		return st;
	}
}