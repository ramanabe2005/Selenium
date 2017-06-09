

package basicweb;

import static org.junit.Assert.*;
import basicweb.WaitTypes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basicweb.GeneraicMethods;
import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class CalendarSelection {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
     driver = new FirefoxDriver();
     baseURL = "http://www.expedia.com";
     driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
     
	}	
	
	public void testLetsKodeIt() throws Exception {
		driver.get(baseURL);
		driver.findElement(By.id("primary-header-flight")).click();
		System.out.println("Clicked on the Flights Button");
		
		driver.findElement(By.id("flight-departing-flp")).click();
		System.out.println("Clicked on the dates button");
	//	departingfield.click();


		WebElement dateToSelect = 
		driver.findElement(By.xpath("//table//button[text()='31']"));
		dateToSelect.click();

		System.out.println("Selected date 31st ");
	}
	
	
	@Test
	public void test2() throws Exception {
		driver.get(baseURL);
		driver.findElement(By.id("primary-header-flight")).click();
		System.out.println("Clicked on the Flights Button");
		
		WebElement departingfield = driver.findElement(By.id("flight-departing-flp"));
	    departingfield.click();
		System.out.println("Clicked on the dates button");
		
		WebElement calMonth = 
		driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=1]"));
		
		List<WebElement> allValidDates = calMonth.findElements(By.tagName("td"));

		for(WebElement date : allValidDates)
		{
			if(date.getText().equals("31"))
			{
				date.click();
				break;
			}
		//System.out.println("all Valid Dates are :"+ date.getText());
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
}
