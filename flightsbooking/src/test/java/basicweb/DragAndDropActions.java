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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basicweb.GeneraicMethods;
import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class DragAndDropActions {
	WebDriver driver;
	String baseURL;
	JavascriptExecutor jse;

	@Before
	public void setUp() throws Exception {
     driver = new FirefoxDriver();
     baseURL = "https://jqueryui.com/droppable/";
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
     driver.get(baseURL);   
     jse = (JavascriptExecutor)driver;
	}	
	
	@Test
	public void test() throws Exception {
		Thread.sleep(3000);
        driver.switchTo().frame(0);
        
        WebElement fromElement = driver.findElement(By.id("draggable"));
        WebElement toElement = driver.findElement(By.id("droppable"));
        
        Actions action = new Actions(driver);
       // action.dragAndDrop(fromElement, toElement).build().perform();
        action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(4000);
		//driver.quit();
	}
}
