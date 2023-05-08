package utility.externalFileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	FileInputStream fis;
	Workbook workbook;
	Sheet sheet;
	DataFormatter df;
	FileOutputStream fos;
	public ExcelUtility() {
          initExcel();
	}

	private void  initExcel() {
		df=new DataFormatter();
		try {
			fis=new FileInputStream("./src/test/resources/MakeMyTrip.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}

	public Object[][] getExcelData(String sheetName){
		try {
			df=new DataFormatter();
			fis=new FileInputStream("./src/test/resources/apiTestData.xlsx");
			workbook=WorkbookFactory.create(fis);
			sheet=workbook.getSheet(sheetName);
			Object[][]a=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<a.length;i++) {
				for(int j=0;j<a[i].length;j++) {
					a[i][j]=df.formatCellValue( sheet.getRow(i+1).getCell(j));


				}
			}
			workbook.close();
			return a;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void setData(String sheetName,Map<Integer, List<String>> h) {
		try {
			workbook=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {

		}
		sheet=workbook.getSheet(sheetName);
		for(int i=0;i<h.size();i++) {
			 	List<String> values = h.get(i);
			for(int j=0;j<values.size();j++) {
				sheet.getRow(i+1).createCell(j).setCellValue(values.get(j)); 
			}
			
		}

	}
	public void saveExcel() {
		try {
		fos=new FileOutputStream("./src/test/resources/MakeMyTrip.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}

}
