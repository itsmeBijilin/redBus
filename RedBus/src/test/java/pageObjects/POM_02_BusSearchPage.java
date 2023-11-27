package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import common.CommonActions;

public class POM_02_BusSearchPage extends CommonActions{
	By fare=By.xpath("//*[text()='Fare']");
	
	By Arrival=By.xpath("//*[text()='Arrival']");
	
	By Departure=By.xpath("//*[text()='Arrival']");
	
	By busNames=By.xpath("//*[@class='bus-items']//div//*[@class='row-sec clearfix']//div//div//div//div//div[@class='travels lh-24 f-bold d-color']");
	
	By buslist=By.xpath("//*[@class='bus-items']//*[@class=\"travels lh-24 f-bold d-color\"]");
	
	
	public POM_02_BusSearchPage(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
	}
	
	public void sortByMethod(String sortBy) {
		if(sortBy.equalsIgnoreCase("Fare")) {
			toClick(fare, "Fare");
		}
		else if (sortBy.equalsIgnoreCase("Arrival")) {
			toClick(Arrival, "Arrival");
		}
		else if(sortBy.equalsIgnoreCase("Departure")) {
			toClick(Departure, "Departure");
		}
	}
	
	public void selectBus(String nameOfBus) {
		List<WebElement> names= driver.findElements(busNames);
		for (WebElement webElement : names) {
			String busName= webElement.getText();
			if(busName.equalsIgnoreCase(nameOfBus)) {
				
			}
		}
	}
	
	public void select() throws InterruptedException {
		int count=0;
		List<WebElement> lists= driver.findElements(buslist);
		int length=lists.size();
		System.out.println(length);
		for (WebElement webElement : lists) {
			String t=webElement.getText();
			System.out.println(t);
			count++;
			
			if(t.equalsIgnoreCase("Sri Rajalakshmi Travels")) {
				Actions action=new Actions(driver);
				action.scrollToElement(webElement).build().perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//*[text()='View Seats'])["+count+"]")).click();
				System.out.println("view seats is clicked");
				System.out.println(count);
			}
		}
		
	}
}
