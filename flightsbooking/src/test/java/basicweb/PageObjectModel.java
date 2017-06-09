package basicweb;
import basicweb.SearchPage;

import static org.junit.Assert.*;
import basicweb.WaitTypes;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basicweb.GeneraicMethods;
import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class PageObjectModel {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		
     driver = new FirefoxDriver();
     baseURL = "http://www.expedia.com";
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
	}	
	
	@Test
	public void testJavaScriptExecution() throws Exception{
    
		driver.get(baseURL);
        SearchPage.fillOriginTextBox(driver, "New York");
        Thread.sleep(3000);
        SearchPage.fillDestinationTextBox(driver, "Chicago");
        Thread.sleep(3000);
        SearchPage.fillDepartureDateTextBox(driver,"06/25/2017");
        Thread.sleep(3000);
        SearchPage.fillDestinationDateTextBox(driver,"06/28/2017");
        Thread.sleep(3000);
        SearchPage.clickOnSearchButton(driver);
	}	
	
	@After
	public void tearDown() throws Exception {
       Thread.sleep(3000);
	}
}
