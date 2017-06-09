

package basicweb;

import static org.junit.Assert.*;
import basicweb.WaitTypes;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basicweb.GeneraicMethods;
import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class Screenshots {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		
     driver = new FirefoxDriver();
     baseURL = "http://www.expedia.com";
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
	}	
	
	@Test
	public void testJavaScriptExecution() throws Exception {
    
		driver.get(baseURL);
		System.out.println("opened the site");
		
		driver.findElement(By.id("primary-header-flight")).click();
		System.out.println("clicked on flights tab");
		
		WebElement flight_origin = driver.findElement(By.id("flight-origin-flp"));
		WebElement flight_destination = driver.findElement(By.id("flight-destination-flp"));
		WebElement departure_date = driver.findElement(By.id("flight-departing-flp"));
		WebElement return_date = driver.findElement(By.id("flight-returning-flp"));
		WebElement search = driver.findElement(By.xpath("//label[@class='col search-btn-col']//button[@class='btn-primary btn-action gcw-submit']//span[text()='Search']"));
		
		flight_origin.sendKeys("New York");
		System.out.println("sent the source place");
		flight_destination.sendKeys("New York");
		System.out.println("sent the target place");
		departure_date.sendKeys("05/30/2017");
		System.out.println("sent the departure date");
		return_date.sendKeys("05/31/2017");
		System.out.println("sent the return date");
		search.click();	
		System.out.println("clicked on the search button");
	}	
	
	public static String getRandomString(int length){
		StringBuilder sb = new StringBuilder();
		String characters = "fdssakhfdsjhgfdshsfafdsjhdgfdshfsfdskasf";
		for(int i=0;i<length;i++)
		{
			int index = (int) Math.random() * characters.length();
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Before executing the method"); 
        String fileName = getRandomString(10)+".png";
		System.out.println("After executing the method");
        String directory = "C://Users//sony//Desktop//";
        System.out.println("Read the directory path");
        File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println("The file name is : "+sourcefile);
        System.out.println("Taken the screen shots");
        FileUtils.copyFile(sourcefile, new File(directory + fileName));
        System.out.println("Copying the screen shots in a file");
	}
}
