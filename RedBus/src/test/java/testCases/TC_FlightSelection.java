package testCases;

import common.CommonActions;
import pageObjects.POM_01_HomePage;
import pageObjects.POM_02_BusSearchPage;

public class TC_FlightSelection extends CommonActions {
	public static void main(String[] args) throws Exception {
		TC_FlightSelection s=new TC_FlightSelection();
		s.HomePage();
		s.SearchPage();
	}
	
	public void HomePage() throws Exception {
		POM_01_HomePage hp=new POM_01_HomePage(driver);
		hp.browser();
		hp.enterFromPlace();
		hp.getSuggestionFrom();
		Thread.sleep(3000);
		hp.enterDestPlace();
		hp.getSuggestionTo();
		hp.closePopUp();
		hp.selectDate();
		Thread.sleep(3000);
		hp.clickSearchButton();
		Thread.sleep(3000);
	}
	
	public void SearchPage() throws InterruptedException {
		POM_02_BusSearchPage sP=new POM_02_BusSearchPage(driver);
		sP.sortByMethod("Fare");
		Thread.sleep(3000);
		sP.select();
	}
}
