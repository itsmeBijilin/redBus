package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonActions {
	
	public static WebDriver driver;
	
	public static String loadInputData(String url) throws IOException {
		Properties prop=new Properties();
		FileInputStream FIS=new FileInputStream("D:\\Selenium\\RedBus\\RedBus\\input.properties");
		prop.load(FIS);
		return prop.getProperty(url);
	}
	
	public static void toLaunchBrowser() throws IOException, InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(loadInputData("url"));
		//driver.get("https://www.redbus.in/");
		Thread.sleep(2000);
	}
	
	
	public static void toClick(By element,String log) {
		try {
			driver.findElement(element).click();
			System.out.println(log+"is clicked");
		} catch (Exception e) {
			System.err.println(log+"is not clicked..Please verify");
		}
	}
	
	public static void toSendKeys(By element,String data,String log) {
		try {
			driver.findElement(element).sendKeys(data);
			System.out.println(log+" is passed");
		} catch (Exception e) {
			System.err.println(log+" is not passed");
		}
	}
	
	public void suggestions(By element,String searchDest) {
		List<WebElement> allsuggestions=driver.findElements(element);
		for (WebElement webElement : allsuggestions) {
			if(webElement.getText().equalsIgnoreCase(searchDest)) {
				webElement.click();
				System.out.println(searchDest+" clicked");
				break;
			}
		}
	}
}
