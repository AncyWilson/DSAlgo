package utilities;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class ExcelReader {
	
	//method to find the excel path and get the sheet name
	
	public List<Map<String,String>> getData(String excelfilepath,String sheetName) throws Exception, IOException{
		
		Workbook workbook = WorkbookFactory.create(new File(excelfilepath));
		LoggerLoad.info("File Path : " + excelfilepath);
		Sheet sheet = workbook.getSheet(sheetName);
		LoggerLoad.info(" Sheet Name : " + sheetName);
		workbook.close();
		return readSheet (sheet);
		
		
	}
	
	//method to read the data from the sheet name read in the above method
	public List<Map<String,String>> readSheet(Sheet sheet){
		
		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		
		Row row;
		Cell cell;
		LoggerLoad.info("Read Sheet data");
		
		//get the total row of the sheet
		int totalRow = sheet.getLastRowNum();
		
		for (int currentRow = 1; currentRow <= totalRow; currentRow++) {

			row = sheet.getRow(currentRow);
			LoggerLoad.info("Row : " + row);
			
			int totalColumn = row.getLastCellNum();
			
			LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
			
			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {

				cell = row.getCell(currentColumn);
				LoggerLoad.info("Cell : " + cell);
				
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();
				LoggerLoad.info("Column Header Name : " + columnHeaderName);

				columnMapdata.put(columnHeaderName, cell.getStringCellValue());
			}

			excelRows.add(columnMapdata);
		}

		return excelRows;
		
	
	}
	
	public static void main(String[] args) throws IOException, Exception {
		
		ExcelReader excelData = new ExcelReader();
		ConfigReader.loadConfig();
		List<Map<String, String>> signinData = new ArrayList<Map<String, String>>();
		Map<String, String> eachSigninData = new HashMap<String, String>();
		signinData = excelData.getData(ConfigReader.getExcelFilePath(), "SignIn");
		
		
		Iterator<Map<String,String>> listIterator = signinData.listIterator();
		while (listIterator.hasNext()) {
			eachSigninData = listIterator.next();
			for(Map.Entry<String, String> entry : eachSigninData.entrySet()){
				System.out.println("Key is :" + entry.getKey());
				System.out.println("Value is :" + entry.getValue());
			}
		}
		
		
	}
	
}
