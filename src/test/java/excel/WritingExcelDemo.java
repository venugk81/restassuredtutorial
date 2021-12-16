package excel;


import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class WritingExcelDemo {
 public static void main(String[] args) throws Exception {
  File file = new File("./data/data.xls");
  
  
  Workbook wb = Workbook.getWorkbook(file);
  
  Sheet sheet = wb.getSheet(0);
  
  int noOfRows = sheet.getRows();
  int noOfColumns = sheet.getColumns();
  
  System.out.println("No of Rows: " + noOfRows);
  System.out.println("No of Columns: " + noOfColumns);
  
  System.out.println("Cell02 1st Column and 3rd Row: " 
  + sheet.getCell(0, 2).getContents());
  String data = "";
  for (int i = 0; i < noOfRows; i++) {
   for (int j = 0; j < noOfColumns; j++) {
    data = sheet.getCell(j, i).getContents();
    System.out.print(data + "\t");
   }
   System.out.println();
  }
  wb.close();
 }
}