package basicweb;

import java.util.concurrent.TimeUnit;
import basicweb.SearchPageFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkTestCase {
	private WebDriver driver;
	private String baseUrl;
	SearchPageFactory searchPage;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.expedia.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		searchPage = new SearchPageFactory(driver);
	}

	@Test
	public void testSelenium() throws Exception {
		driver.get(baseUrl);
        searchPage.clickFlightsTab();
        searchPage.setOriginCity("New York");
        searchPage.setDestinationCity("Chicago");
        searchPage.setDepartureDate("06/25/2017");
        searchPage.setReturnDate("06/28/2017");
        Thread.sleep(3000);
        System.out.println("clicked on the submit button");
        searchPage.clickOnSubmit();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}
}
