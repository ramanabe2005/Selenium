

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basicweb.GeneraicMethods;
import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class ExplicitWaitDemo2 {
	WebDriver driver;
	String baseURL;
	//GeneraicMethods gm;

	@Before
	public void setUp() throws Exception {
     driver = new FirefoxDriver();
     baseURL = "http://letskodeit.teachable.com/p/practice";
     driver.manage().window().maximize();
    // driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}	
	
	@Test
	public void testLetsKodeIt() throws Exception {
		driver.get(baseURL);
		driver.findElement(By.linkText("Login")).click();
		WebDriverWait wait = new WebDriverWait(driver,3);
		WebElement emailField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		emailField.sendKeys("test");
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
}
