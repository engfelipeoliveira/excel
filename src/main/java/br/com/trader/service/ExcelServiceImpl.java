package br.com.trader.service;

import static org.apache.poi.ss.usermodel.CellType.STRING;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExcelServiceImpl implements ExcelService {
	
	@Value("${file.excel}")
	private String FILE_EXCEL;

	@Override
	public void read() throws Exception {
		File file = new File(FILE_EXCEL);
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			row.getCell(0).setCellType(STRING);
			String a1 = row.getCell(0).getStringCellValue();
			
			System.out.println(a1);
		}
	}

}
