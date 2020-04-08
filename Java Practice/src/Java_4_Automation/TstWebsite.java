package Java_4_Automation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TstWebsite {

	// TODO Auto-generated method stub
	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest test;

	WebDriver driver;


	///method for highlight element
	public static void highlightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 

		js.executeScript("arguments[0].setAttribute('style', 'background:lightblue ; border: 2px solid red;');",
				element);

		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {

			System.out.println(e.getMessage());
		} 

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

	}


	@BeforeTest
	public void beforeTest() 
	{

		report=new ExtentHtmlReporter("Tst-website1.html");

		extent=new ExtentReports();

		extent.attachReporter(report);

		test=extent.createTest("My first test", "Test extent reports on testng");

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\geckodriver-v0.21.0-win32\\geckodriver.exe");

		//WebDriver driver=new ChromeDriver();

		driver=new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/automation-practice-form/");
	}



	/* Failed test cases
			@BeforeMethod
			public void setup()
			{
				browsersetup();
			}*/


	@Test (priority=1)
	public void fullName() throws Exception 
	{
		test=extent.createTest("Users full name", "My 1st test");

		//inspect first name web element
		WebElement name=driver.findElement(By.name("firstname"));

		//call highlightElement method to highlight field
		highlightElement(driver, name);

		name.sendKeys("Ethan");

		//inspect last name web element
		WebElement lastname=driver.findElement(By.id("lastname"));

		highlightElement(driver, lastname);
		test.pass("User's full name entered");

		lastname.sendKeys("Hunt");
		Thread.sleep(5000);
	}

	@Test(priority=2)
	public void gender()
	{
		test=extent.createTest("Users gender", "My 2nd test");

		WebElement gender=driver.findElement(By.id("sex-0"));

		highlightElement(driver, gender);

		test.pass("Gender selected");

		gender.click();	
	}

	@Test(priority=3)
	public void experience() throws Exception
	{
		test=extent.createTest("Users experience", "My 3rd test");

		//inspect last name web element
		WebElement exp=driver.findElement(By.id("exp-3"));

		highlightElement(driver, exp);

		exp.click();

		test.pass("Experience selected");
		Thread.sleep(3000);
	}

	@Test(priority=4)
	public void profession()
	{
		test=extent.createTest("Users profession", "My 4th test");

		//inspect profession web element
		WebElement prof=driver.findElement(By.id("profession-1"));

		highlightElement(driver, prof);

		test.pass("Profession selected");

		prof.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority=5)
	public void tools() throws Exception
	{
		test=extent.createTest("Users tools", "My 5th test");
		
		//inspect tool1 web element
		WebElement tool1=driver.findElement(By.id("tool-0"));

		highlightElement(driver, tool1);

		tool1.click();
		
		//inspect tool2 web element
		WebElement tool2=driver.findElement(By.id("tool-2"));

		highlightElement(driver, tool2);

		tool2.click();

		test.pass("Tools selected");

		Thread.sleep(5000);
	}

	@Test(priority=6)
	public void continent()
	{
		test=extent.createTest("Users continent", "My 6th test");
		
		//select value from drop down
		WebElement drp=driver.findElement(By.id("continents"));

		Select select=new Select(driver.findElement(By.id("continents")));

		highlightElement(driver, drp);

		select.selectByVisibleText("Australia");

	}

	@AfterMethod
	public void screenshot()
	{
		File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshotFile, new File("C:\\Users\\windows7\\Desktop\\"
					+ "software\\Karan Workspace\\Java Practice\\Screenshots\\test1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






	/*Failed test cases

			@AfterMethod
			public void screenshot(String testMethodName)
			{
				File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				/*
				try {
					FileUtils.copyFile(screenshotFile, new File("C:\\Users\\windows7\\Desktop\\software\\KARAN_New_Workspace\\Selenium_Automation_Practice\\Screenshots\\sample1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					FileUtils.copyFile(screenshotFile, new File("C:\\Users\\windows7\\Desktop\\software\\KARAN_New_Workspace\\"
								+ "Selenium_Automation_Practice\\Screenshots\\"+testMethodName+"_"+".jpg"));
				} catch ( IOException e) 
				{
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}

			}
	 */


	@AfterTest
	public void afterTest() {
		extent.flush();

		System.out.println("Test completed");
		driver.close();

	}

}
