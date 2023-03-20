package com.genericlib.demoblaze;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String getDataFromProperties(String path,String key) throws IOException
	{
		FileInputStream ip=new FileInputStream(path);
		Properties prop=new Properties();
		prop.load(ip);
		String data=prop.getProperty(key);
		return data;
	}
	public String getDataFromExcel(String path,String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream ip=new FileInputStream(path);
		Workbook w=WorkbookFactory.create(ip);
		Sheet sh=w.getSheet(sheet);
		String data=sh.getRow(row).getCell(cell).toString();
		return data;
	}

}
