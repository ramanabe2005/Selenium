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

public class MultipleSelect {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
     driver = new FirefoxDriver();
     baseURL = "https://letskodeit.teachable.com/p/practice";
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.manage().window().maximize();
     driver.get(baseURL);
	}	
	
	@Test
	public void testListOfElements() throws Exception {
		WebElement element = driver.findElement(By.id("multiple-select-example"));
		Select sel = new Select(element);
		
		sel.selectByValue("orange");
		Thread.sleep(2000);
		sel.deselectByValue("orange");
		Thread.sleep(2000);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		sel.selectByVisibleText("Apple");
		Thread.sleep(2000);
		
		List<WebElement> selectedOptions = sel.getAllSelectedOptions();
		
		for(WebElement option :selectedOptions){
			System.out.println(option.getText());
		}
		
		Thread.sleep(2000);
		System.out.println("De select all the selected options");
		sel.deselectAll();
			
	}
	
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
	}



}
