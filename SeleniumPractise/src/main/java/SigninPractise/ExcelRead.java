package SigninPractise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class ExcelRead {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Excel File - WORKBOOK - SHEET - ROW - CELL
		
		FileInputStream file = new FileInputStream("C:\\Users\\LENOVO\\OneDrive\\Desktop\\TestData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int totalRows = sheet.getLastRowNum();
		
		int totalCell = sheet.getRow(0).getLastCellNum();
		
		for(int r=0;r<totalRows;r++) {
			XSSFRow currentRow = sheet.getRow(r);
			
			if (currentRow == null) {
				System.out.println("Row " + r + " is completely empty.");
				continue; // Skip to the next iteration
			}
			
			for(int c=0;c<=totalCell;c++) {
				XSSFCell cell = currentRow.getCell(c);
				if (cell == null) {
					System.out.print("\t"); // Handle empty cells gracefully
					continue;
				}
				
				// Fix 5: Handle different cell types
				switch (cell.getCellType()) {
				    case STRING:
				        System.out.print(cell.getStringCellValue() + "\t");
				        break;
				    case NUMERIC:
				        // For numeric values, use getNumericCellValue()
				        System.out.print(cell.getNumericCellValue() + "\t");
				        break;
				    case BOOLEAN:
				        System.out.print(cell.getBooleanCellValue() + "\t");
				        break;
				    case FORMULA:
				        // You might need more complex handling for formulas
				        System.out.print(cell.getCellFormula() + "\t"); 
				        break;
				    default:
				        // Default to a string representation if not null
				        System.out.print(cell.toString() + "\t");
				        break;
				}
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}
}
