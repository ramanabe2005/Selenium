package com.expedia.flightsbooking;

import org.testng.annotations.Test;
import basicweb.SearchPageFactory;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestNG_TestSuite {

	private WebDriver driver;
	private String baseUrl;
	private static final Logger log = LogManager.getLogger(TestNG_TestSuite.class.getName());
	SearchPageFactory searchPage;
  
  @BeforeClass
  public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://www.expedia.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		searchPage = new SearchPageFactory(driver);
  }

  @Test
  public void Test1(){
		driver.get(baseUrl);
        searchPage.clickFlightsTab();
        searchPage.setOriginCity("New York");
        searchPage.setDestinationCity("Chicago");
        searchPage.setDepartureDate("06/25/2017");
        searchPage.setReturnDate("06/28/2017");
  }
  
  @Test
  public void Test2(){
        try{
        searchPage.clickNonstopCheckbox();
        searchPage.selectPrefferedClass("first");
        }
        catch(Exception e){
        	searchPage.clickAdvanceTab();
            searchPage.clickNonstopCheckbox();
            searchPage.selectPrefferedClass("first");
        }
        searchPage.clickOnSubmit();
  }
  
  @AfterClass
  public void afterClass() {
	 // driver.quit();
  }

}
