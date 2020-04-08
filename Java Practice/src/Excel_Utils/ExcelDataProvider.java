package Excel_Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider
{
	WebDriver driver;
	
	
	//function to highlight element 
	public static void highlightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 

		js.executeScript("arguments[0].setAttribute('style', 'background: sky blue; border: 2px solid red;');",
				element);

		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {

			System.out.println(e.getMessage());
		} 

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

	}

	
	@BeforeTest
	public void browserSetup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\geckodriver-v0.21.0-win32\\geckodriver.exe");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\chromedriver_win32_81.0\\chromedriver.exe");
		driver=new FirefoxDriver();

	}
	
	
	
	@Test(dataProvider="test1data")
	public void test1(String Username, String Password) throws Exception
	{
		System.out.println(Username+"  |  "+Password);
		
		driver.get("https://www.facebook.com");
		
		WebElement uname=driver.findElement(By.id("email"));
		
		highlightElement(driver, uname);
		
		uname.sendKeys(Username);
		Thread.sleep(3000);
		
		WebElement password=driver.findElement(By.id("pass"));
		
		highlightElement(driver, password);
		
		password.sendKeys(Password);
	}
	
	
	
	
	
	@DataProvider(name="test1data")
	public static Object[][] getData()
	{
		Object data[][]=testData();
		
		return data;
	}
	
	
	public static Object[][] testData()
	{
		Excel_Utils_Read excel=new Excel_Utils_Read();
		
		int rowCount=excel.getRowCount();
		int colCount=excel.getColCount();
		
				
		Object data[][]=new Object[rowCount-1][colCount];
	
		for (int i=1; i<rowCount; i++)
		{
			for (int j=0; j<colCount; j++)
			{
				String cellData=excel.getCellDataString(i, j);
				System.out.print(cellData+ "  |  ");
				
				data[i-1][j]=cellData;
			}
			
		}
		return data;
	
	}
	
	@AfterTest
	public void close() throws Exception
	{
		driver.close();
		Thread.sleep(3000);
	}
}




