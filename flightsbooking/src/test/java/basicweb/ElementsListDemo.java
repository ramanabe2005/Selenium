

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
import basicweb.GeneraicMethods;
import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class ElementsListDemo {
	WebDriver driver;
	String baseURL;
	GeneraicMethods gm;

	@Before
	public void setUp() throws Exception {
     driver = new FirefoxDriver();
     baseURL = "http://letskodeit.teachable.com/p/practice";
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.manage().window().maximize();
     gm = new GeneraicMethods(driver);
	}	
	
	@Test
	public void testLetsKodeIt() throws Exception {
	    driver.get(baseURL);
		List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");
		//System.out.println("The element list is :"+elementList.toString());
		int sie = elementList.size();
		System.out.println("Size of the element list is :"+sie);
        //elementList.sendKeys("test");		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
}
