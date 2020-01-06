package FirstTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StoresLoginExcelget {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File src = new File("C:\\Users\\new\\workspace\\FirstTestNGProject\\TestData\\InputData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int rowcount = sheet1.getLastRowNum();
		for(int i=0;i<rowcount;i++){
			String data0 = sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.print(data0+" ");
		wb.close();
	}
}
}