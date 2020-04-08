package Java_4_Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class First_Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello java");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\geckodriver-v0.21.0-win32\\geckodriver.exe");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\chromedriver_win32_81.0\\chromedriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com");
		driver.close();
		
	}

}
