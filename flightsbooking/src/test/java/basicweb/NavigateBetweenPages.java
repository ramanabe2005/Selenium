package basicweb;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateBetweenPages {
	
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "http://letskodeit.teachable.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void test() {
		driver.get(baseURL);
		String title = driver.getTitle();
		System.out.println("The title of the current page is : " +title);
		
		String currenturl = driver.getCurrentUrl();
		System.out.println("Current URL is : "+currenturl);
		
		
		String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
		driver.navigate().to(urlToNavigate);
		System.out.println("The URL after navigating to login page is :"+urlToNavigate);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.navigate().back();
		currenturl = driver.getCurrentUrl();
		System.out.println("The URL after navigating back to home page is :"+currenturl);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.navigate().forward();
		currenturl = driver.getCurrentUrl();
		System.out.println("The URL after navigating forward to home page is :"+currenturl);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.navigate().back();
		currenturl = driver.getCurrentUrl();
		System.out.println("The URL after navigating back to home page is :"+currenturl);
		
		driver.navigate().refresh();
		currenturl = driver.getCurrentUrl();
		System.out.println("URL after refreshing the page is :"+currenturl);
				
	}

	@After
	public void tearDown() throws Exception {
	}

	


}
