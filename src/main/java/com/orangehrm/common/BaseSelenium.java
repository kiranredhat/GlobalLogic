package com.orangehrm.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners(Testlistner.class)
public class BaseSelenium {

	@DataProvider(name = "logindata")
	public String[][] getLoginData() {
		String[][] data = 
			{ 
				{ "admi", "admi" },
				{ "kiran", "kiran" },
				{ "newkiran", "newkiran" }
			};
		return data;
	}

	@DataProvider(name = "logindataFromCSV")
	public String[][] getLoginDataFromCSVFile() throws IOException {
		String fileName = "C:/Users/User/Contacts/Desktop/kiran.txt";
		File File = new File(fileName);

		FileReader fr = new FileReader(File);
		BufferedReader br = new BufferedReader(fr);
		String line;
		String[][] data = new String[3][0];
		int i = 0;
		while ((line = br.readLine()) != null) {

			// process the line
			System.out.println(line);
			String[] tempdata = line.split(",");
			data[i] = tempdata;
			i = i + 1;

		}
		System.out.println(data);
		return data;

	}

	public static XSSFWorkbook Wb;
	public static XSSFSheet Ws;
	public static XSSFCell Cell;

	@DataProvider(name = "excelDataProvider")
	public String[][] getExcelData(Method m) throws IOException {
		String[][] tabArray = null;

		String strFilePath = getfilepath(m.getDeclaringClass());
		FileInputStream fis = new FileInputStream(strFilePath);

		XSSFWorkbook Wb = new XSSFWorkbook(fis);
		String sheetname = m.getName();
		System.out.println(sheetname);

		XSSFSheet Ws = Wb.getSheet(sheetname);
		int totalRows = Ws.getLastRowNum();
		int totalCols = Ws.getRow(0).getLastCellNum();
		tabArray = new String[totalRows][totalCols];
		for (int intRowCounter = 0; intRowCounter < totalRows; intRowCounter++) {
			for (int intColCounter = 0; intColCounter < totalCols; intColCounter++) {

				XSSFCell Cell = Ws.getRow(intRowCounter).getCell(intColCounter);

				tabArray[intRowCounter][intColCounter] = Cell.getStringCellValue();
				System.out.print(" " + tabArray[intRowCounter][intColCounter]);
			}

			System.out.println(" ");
		}
		return tabArray;

	}

	private String getfilepath(Class<?> cls) {
		String strclasspath = cls.getResource(cls.getSimpleName() + ".class").getPath();
		String strfilepath = strclasspath.replace(".class", ".xlsx");
		System.out.println("" + strfilepath);
		return strfilepath;
	}
}