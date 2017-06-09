

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

public class ExplicitWaitWithUtilityDemo {
	WebDriver driver;
	String baseURL;
	WaitTypes wt;
	//GeneraicMethods gm;

	@Before
	public void setUp() throws Exception {
     driver = new FirefoxDriver();
     baseURL = "http://letskodeit.teachable.com/p/practice";
     driver.manage().window().maximize();
    // driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
     wt = new WaitTypes(driver);
	}	
	
	@Test
	public void testLetsKodeIt() throws Exception {
		driver.get(baseURL);
		driver.findElement(By.linkText("Login")).click();
		WebElement emailField = wt.waitForElement(By.id("user_email"), 4);
		emailField.sendKeys("test");
		
		wt.clickWhenReady(By.name("commit"), 3);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
}
