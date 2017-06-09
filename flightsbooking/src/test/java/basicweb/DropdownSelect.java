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

public class DropdownSelect {
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
		WebElement element = driver.findElement(By.id("carselect"));
		Select sel = new Select(element);
		sel.selectByValue("benz");
		Thread.sleep(2000);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		sel.selectByVisibleText("BMW");
		Thread.sleep(2000);
		
		List<WebElement> options = sel.getOptions();
		int size = options.size();
		
		for(int i=0;i<size;i++)
		{
			String optionName = options.get(i).getText();
			System.out.println(optionName);
		}
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
	}



}
