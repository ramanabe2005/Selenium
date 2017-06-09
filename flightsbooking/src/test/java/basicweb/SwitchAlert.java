

package basicweb;

import static org.junit.Assert.*;
import basicweb.WaitTypes;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basicweb.GeneraicMethods;
import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class SwitchAlert {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
     driver = new FirefoxDriver();
     baseURL = "https://letskodeit.teachable.com/p/practice";
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
     driver.get(baseURL);    
	}	
	
	@Test
	public void test2() throws Exception {
		
		Thread.sleep(3000);
		WebElement textElement = driver.findElement(By.id("name"));
		textElement.sendKeys("Anil");
		
		WebElement alertElement = driver.findElement(By.id("alertbtn"));
		alertElement.click();
		
		Thread.sleep(6000);
		Alert alert = driver.switchTo().alert();		
		alert.accept();
	}
	
	@Test
	public void test3() throws Exception {
		
		Thread.sleep(3000);
		WebElement textElement = driver.findElement(By.id("name"));
		textElement.sendKeys("Anil");
		
		WebElement alertElement = driver.findElement(By.id("confirmbtn"));
		alertElement.click();
		
		Thread.sleep(6000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();	
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(4000);
		//driver.quit();
	}
}
