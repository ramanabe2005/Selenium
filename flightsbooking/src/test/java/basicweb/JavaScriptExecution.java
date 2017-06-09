

package basicweb;

import static org.junit.Assert.*;
import basicweb.WaitTypes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basicweb.GeneraicMethods;
import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class JavaScriptExecution {
	WebDriver driver;
	String baseURL;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		
     driver = new FirefoxDriver();
     baseURL = "http://letskodeit.teachable.com/p/practice";
     js = (JavascriptExecutor) driver;
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
	}	
	
	@Test
	public void testJavaScriptExecution() throws Exception {
    
		// driver.get(baseURL);
		 js.executeScript("window.location='http://letskodeit.teachable.com/p/practice';");
		 System.out.println("opened the site");
		WebElement element = driver.findElement(By.id("name"));
		 //WebElement element = (WebElement) js.executeScript("return document.getElementById('name');");
		 js.executeScript("arguments[0].scrollIntoView(true);",element);
		 js.executeScript("window.scrollBy(0,-190);");
		 System.out.println("Executed scroll by -190 view");

		 System.out.println("finding text box");
		 element.sendKeys("Test");
		 System.out.println("sending the keys test");
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
}
