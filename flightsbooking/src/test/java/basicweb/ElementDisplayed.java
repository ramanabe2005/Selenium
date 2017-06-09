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

public class ElementDisplayed {
	WebDriver driver;
	String baseURL1, baseURL2;

	@Before
	public void setUp() throws Exception {
     driver = new FirefoxDriver();
     baseURL1 = "http://letskodeit.teachable.com/p/practice";
     baseURL2 = "http://www.expedia.com";
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.manage().window().maximize();
	}	
	
	@Test
	public void testLetsKodeIt() throws Exception {
	     driver.get(baseURL1);
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Text Box Displayed :" +textBox.isDisplayed());
		Thread.sleep(2000);
		
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();
		System.out.println("Text Box Displayed :" +textBox.isDisplayed());
		Thread.sleep(2000);
		
		WebElement showButton = driver.findElement(By.id("show-textbox"));
		showButton.click();
		System.out.println("Text Box Displayed :" +textBox.isDisplayed());
		
	}
	
	@Test
	public void testExpedia() throws Exception {
	     driver.get(baseURL2);
	     
		WebElement childElement = driver.findElement(By.id("'package-1-age-select-1-hp-package"));
		System.out.println("Child drop down Displayed :" +childElement.isDisplayed());

			
	}
	
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
	}



}
