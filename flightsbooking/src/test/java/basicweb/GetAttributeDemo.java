

package basicweb;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class GetAttributeDemo {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
     driver = new FirefoxDriver();
     baseURL = "http://letskodeit.teachable.com/p/practice";
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.manage().window().maximize();
	}	
	
	@Test
	public void testLetsKodeIt() throws Exception {
	     driver.get(baseURL);
		WebElement buttonElement = driver.findElement(By.id("name"));
		String AttributeValue = buttonElement.getAttribute("placeholder");
		System.out.println("The text value of the button is : " +AttributeValue);		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}



}
