package Java_4_Automation;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Excel_Utils.Excel_Utils_Read;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Test_Website_Excel_Read extends Excel_Utils_Read 
{
	WebDriver driver;
	
	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest test;

	
	//function to highlight element 
		public static void highlightElement(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver; 

			js.executeScript("arguments[0].setAttribute('style', 'background:yellow ; border: 2px solid red;');",
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
  public void beforeTest() 
  {
	  
	  report=new ExtentHtmlReporter("multiple-data.html");

		extent=new ExtentReports();

		extent.attachReporter(report);

		//test=extent.createTest("My first test", "Test extent reports on testng");

		
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\geckodriver-v0.21.0-win32\\geckodriver.exe");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\chromedriver_win32_81.0\\chromedriver.exe");
		driver=new FirefoxDriver();
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
  }

  
  @Test(dataProvider="test1data")
  public void test1(String  Fname, String Lname, String Username, String Email, String Password, String Short)
  //public void test1(String Username, String Password)
  {
	  System.out.println(Fname+" | "+Lname+" | "+Username+ " | "+Email+ " | "+Password+" | "+Short);
	  
	  test=extent.createTest("Testing form with different test data ", "Test data is");

	  driver.get("https://wpforms.com/demo/user-registration-form-demo/");
	  
	  //scroll down
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  
	  js.executeScript("window.scrollBy(0,750)");
	  test.info("page scrolled down");
	  
	  //inspect first name field
	  WebElement firstName=driver.findElement(By.xpath("//input[@id='wpforms-259288-field_1']"));
	  
	  highlightElement(driver, firstName);
	  
	  firstName.sendKeys(Fname);
	  test.info("first name entered: "+Fname);
	  
	  //inspect last name field
	  WebElement lastName=driver.findElement(By.xpath("//input[@id='wpforms-259288-field_1-last']"));
	  
	  highlightElement(driver, lastName);
	  
	  lastName.sendKeys(Lname);
	  test.pass("Last name entered: "+Lname);
	  
	  //inspect User name field
	  WebElement uname=driver.findElement(By.xpath("//input[@id='wpforms-259288-field_2']"));
	  
	  highlightElement(driver, uname);
	  
	  uname.sendKeys(Username);
	  test.pass("User name enetered: "+Username);
	  
	  //inspect email field
	  WebElement mail=driver.findElement(By.xpath("//input[@id='wpforms-259288-field_3']"));
	  
	  highlightElement(driver, mail);
	  
	  mail.sendKeys(Email);
	  test.pass("email entered: "+Email);
	  
	  //inspect password field
	  WebElement pass=driver.findElement(By.xpath("//input[@id='wpforms-259288-field_4']"));
	  
	  highlightElement(driver, pass);
	  
	  pass.sendKeys(Password);
	  test.pass("Password enetered: "+Password);
	  
	  //inspect short field
	  WebElement shrt=driver.findElement(By.xpath("//textarea[@id='wpforms-259288-field_5']"));
	  
	  highlightElement(driver, shrt);
	  
	  shrt.sendKeys(Short);
	  test.pass("Description entered is: "+Short);
	  
	  
	  
	  
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
			System.out.println();
		}
		return data;
	
	}
  
  @AfterTest
  public void afterTest() 
  {
	  extent.flush();
	  
	  driver.close();
  }

}
