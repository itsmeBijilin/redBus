package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import common.CommonActions;

public class POM_01_HomePage extends CommonActions {
	
	@FindBy(name="username")
	private static WebElement userName;
	
	@FindBy(id = "src")
	private static WebElement fromPlace1;

	@FindBy(id = "dest")
	private static WebElement destPlace1;
	
	By destPlace=By.id("src");
	
	By fromPlace=By.id("dest");
	
	By suggestionsFrom=By.xpath("//*[@class='sc-dnqmqq eFEVtU']//li//div[@class='sc-gZMcBi grvhsy']//text[@class='placeHolderMainText']");

	By suggestionsTo=By.xpath("//*[@class='sc-dnqmqq eFEVtU']//li//div//text[@class='placeHolderMainText']");
	
	By searchButton=By.id("search_button");
	
	By dateYear=By.xpath("(//*[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[2]");
	
	By nxtArrow=By.xpath("(//*[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[3]");
	
	By searchBtn=By.id("search_button");
	
	public POM_01_HomePage(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
	}

	public void browser() throws IOException, Exception {
		toLaunchBrowser();
	}

	public  void enterFromPlace() throws IOException {
		toSendKeys(destPlace, loadInputData("Departure"), loadInputData("Departure"));
	}

	public void enterDestPlace() throws IOException {
		toSendKeys(fromPlace, loadInputData("Arrival"), loadInputData("Arrival"));
	}
	
	public void closePopUp() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
	}
	
	public void getSuggestionFrom() {
		suggestions(suggestionsFrom, "Vadasery Omni Bus Stand");
	}
	
	
	public void getSuggestionTo() {
		suggestions(suggestionsTo, "CMBT, Chennai");
	}
	
	public void clickSearchBuses() {
		toClick(searchButton, "SearchButton");
	}
	
	public void selectDate() {
		while(!(driver.findElement(dateYear).getText().contains("Nov 2023")==true)) {
		//System.out.println(driver.findElement(dateYear).getText());
		//String text=driver.findElement(dateYear).getText();
		//String[] arr= text.split(" ");
		//System.out.println(arr[0]);
		driver.findElement(nxtArrow).click();
		}
		driver.findElement(By.xpath("//*[text()='22']")).click();
	}
	
	public void clickSearchButton() {
		toClick(searchBtn, "Search Button");
	}

}
