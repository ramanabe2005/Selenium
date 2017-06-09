

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

public class Autocomplete {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
     driver = new FirefoxDriver();
     baseURL = "http://www.southwest.com";
     driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
     
	}	
	
	@Test
	public void test2() throws Exception {
		driver.get(baseURL);
		String searchingText = "New York/Newark, NJ - EWR";
		String partialText = "New York";
		
		WebElement text = driver.findElement(By.id("air-city-departure"));
		text.sendKeys(partialText);
		WebElement element = driver.findElement(By.xpath("//ul[@id='air-city-departure-menu']"));
		List<WebElement> results = element.findElements(By.tagName("li"));
		int size = results.size();
		System.out.println(" The size of the array is : "+size);
		
		for(int i=0;i<size;i++){
			System.out.println("The element names are :"+results.get(i).getText());
		}
		
		for(WebElement result :results){
			if(result.getText().equals(searchingText)){
				result.click();
			}
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
}
