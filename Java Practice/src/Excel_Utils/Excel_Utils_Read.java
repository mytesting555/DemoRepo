package Excel_Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utils_Read 
{	
	static String projectPath;
	static XSSFWorkbook wrkbook;
	static XSSFSheet sheet;
	
	/*
	//constructor
	public Excel_Utils_Read(String excelPath, String sheetName)
	{
		try {
		
			projectPath= System.getProperty("user.dir");
			
			wrkbook = new XSSFWorkbook(excelPath);
					//C:\\Users\\windows7\\Desktop\\software\\Karan Workspace\\Java Practice\\Excel\\Test Data.xlsx");

			sheet=wrkbook.getSheet(sheetName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		*/
	
	
	public static void main(String[] args)
	{
		getRowCount();
		
		getCellDataString(0,0);
		
		getCellDataNumber(1,1);
		
		getColCount();
	}
	
	//function to get row count
	public static int getRowCount()
	{	
		int rowCount=0;
		try{
			
			projectPath=System.getProperty("user.dir");
			//wrkbook = new XSSFWorkbook(projectPath+"\\Excel\\Test Data.xlsx");
			wrkbook = new XSSFWorkbook(projectPath+"\\Excel\\Test Data1.xlsx");
			
		sheet=wrkbook.getSheet("Sheet1");
	
			rowCount=sheet.getPhysicalNumberOfRows();
			
			System.out.println("No of rows are: "+rowCount);
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}	
		return rowCount;
	
	}
	
	

	//function to get column count
	public static int getColCount()
	{	
		int colCount=0;
		try{
			
			projectPath=System.getProperty("user.dir");
			//wrkbook = new XSSFWorkbook(projectPath+"\\Excel\\Test Data.xlsx");
			wrkbook = new XSSFWorkbook(projectPath+"\\Excel\\Test Data1.xlsx");
			
		sheet=wrkbook.getSheet("Sheet1");
	
			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
			
			//System.out.println("No of columns are: "+colCount);
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}	
		return colCount;
	}
	
	//function to get cell data
	public static String getCellDataString(int rowNum, int colNum)
	{
		String cellData=null;
		try {
			projectPath=System.getProperty("user.dir");
			//wrkbook = new XSSFWorkbook(projectPath+"\\Excel\\Test Data.xlsx");
			wrkbook = new XSSFWorkbook(projectPath+"\\Excel\\Test Data1.xlsx");
			
			sheet=wrkbook.getSheet("Sheet1");
			
			
			//To get characters from sheet use below code
			cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			
			//To get numbers from sheet use below code
			//double celldata=sheet.getRow(1).getCell(1).getNumericCellValue();
			
			
			//System.out.println("Cell data is : "+cellData);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return  cellData;
		}
		
	//function to get cell data number
		public static void getCellDataNumber(int rowNum, int colNum)
		{
			try {
			
				projectPath=System.getProperty("user.dir");
				//wrkbook = new XSSFWorkbook(projectPath+"\\Excel\\Test Data.xlsx");
				wrkbook = new XSSFWorkbook(projectPath+"\\Excel\\Test Data1.xlsx");
				sheet=wrkbook.getSheet("Sheet1");
				
				
				
				//To get numbers from sheet use below code
				double cellData=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
				
				
				System.out.println("Cell data is : "+cellData);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				e.printStackTrace();
			}
		
		
		
	}
		
}

