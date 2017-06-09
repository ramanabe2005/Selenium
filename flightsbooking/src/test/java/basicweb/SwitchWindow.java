

package basicweb;

import static org.junit.Assert.*;
import basicweb.WaitTypes;

import java.util.List;
import java.util.Set;
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

public class SwitchWindow {
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
		
		String parentHandle = driver.getWindowHandle();
		System.out.println("The handle of the default page is  :"+parentHandle);
		
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();
		
		System.out.println("Clicked on the open Window button");
		
		Set<String> handles = driver.getWindowHandles();
		
		for(String handle :handles){
			System.out.println("handles are : "+handle);
			
			if(!handle.equals(parentHandle)){
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				WebElement searchBox = driver.findElement(By.id("search-courses"));
				searchBox.sendKeys("Python");
				Thread.sleep(2000);
				driver.close();
				break;
			}
		}
		
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("Ramana");
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(4000);
		//driver.quit();
	}
}
