package Robot_Class_Practice;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.host.event.InputEvent;

public class First_Demo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\geckodriver-v0.21.0-win32\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.get("https://demoqa.com/keyboard-events/");
		
		driver.get("https://demoqa.com/automation-practice-form/");
		Robot robot=new Robot();
		
		
		
		/*
		//code to upload file
		
		//inspect element to upload file 
		driver.findElement(By.id("photo")).click();
		
		//wait for 5 sec
		//robot.setAutoDelay(5000);
		
		//save file path in variable 'selection'
		StringSelection selection= new StringSelection("C:\\Users\\windows7\\Desktop\\id.txt");
		
		//copy above path in clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.setAutoDelay(2000);
		
		//press  Ctrl+V button on keyboard to open the above file path in windows pop up
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		//release Ctrl+V button from keyboard
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.setAutoDelay(2000);
		
		//click enter to upload file
		robot.keyPress(KeyEvent.VK_ENTER);
		
		robot.setAutoDelay(3000);
		*/
		
		//code to download file using robot class
		
		//inspect element to click on the link to download the file
		driver.findElement(By.xpath("//a[contains(text(),'Test File to Download')]")).click();
		
		
		
		//Press down arrow to select save option
		robot.keyPress(KeyEvent.VK_DOWN);
		
		//press tab thrice to move on OK button
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		
		//Press enter to click on ok button
		robot.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		
		driver.close();

	}

}
