package Java_4_Automation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class Captcha_Demo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.gecko.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\geckodriver-v0.21.0-win32\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://testing-ground.scraping.pro/captcha");
		
		JavascriptExecutor js=( JavascriptExecutor) driver;
		  
		  js.executeScript("window.scrollBy(0,600)");
		  
		  String path=System.getProperty("user.dir")+ "Screenshots\\Captcha.jpg";
		  
		  File src=driver.findElement(By.xpath("//img[@id='captcha']")).getScreenshotAs(OutputType.FILE);
		  
		  
		 // FileHandler.copy(src, new File(path));
		  
		  FileUtils.copyFile(src, new File(path));
		  
		  Tesseract image=new Tesseract();
		  
		  String imagetext=image.doOCR(new File(path));
		  
		  System.out.println("Captcha is: "+imagetext);
		  
		 
		  
		  driver.close();
	}

}
