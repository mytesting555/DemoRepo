package Java_4_Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Tst1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExtentHtmlReporter report=new ExtentHtmlReporter("demo-tst1.html");

		ExtentReports extent=new ExtentReports();

		extent.attachReporter(report);
		
		ExtentTest test=extent.createTest("My first test", "Test extent reports on testng");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\geckodriver-v0.21.0-win32\\geckodriver.exe");
		
		//WebDriver driver=new ChromeDriver();
		
		WebDriver driver=new FirefoxDriver();
		
		//Maximize window
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Launch web site
		driver.get("https://demoqa.com/automation-practice-form/");
		
		//enter first name and surname
		driver.findElement(By.name("firstname")).sendKeys("Ethan");
		test.pass("Firstname entered");
		
		driver.findElement(By.id("lastname")).sendKeys("Hunt");
		
		
		extent.flush();
		
		//close the browser
		driver.close();
		
		
		
		
		

	}

}
