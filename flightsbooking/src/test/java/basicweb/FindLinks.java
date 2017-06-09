package basicweb;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import basicweb.SearchPageFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindLinks {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.expedia.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}

	@Test
	public void testFindLinks() throws Exception {
		driver.get(baseUrl);
		//SearchPage.navigateToFlightTab(driver);
		List<WebElement> linksList = clickableLinks(driver);
		for(WebElement link : linksList){
			String href = link.getAttribute("href");
			try{
				System.out.println("URL is "+href+ "returned "+linkStatus(new URL(href)));
			}
			catch (Exception e){
				System.out.println("There is problem with link testing");
			}
		}
    }

	public static List<WebElement> clickableLinks(WebDriver driver){
		
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
	    elements.addAll(driver.findElements(By.tagName("img")));
	    
	    for(WebElement e :elements){
	    	if(e.getAttribute("href")!= null){
	    		linksToClick.add(e);
	    	}
	    	//System.out.println("HREF is "+elements.toString());
	    }
		return linksToClick;
	}
	
	public static String linkStatus(URL url){
		try{
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			//System.out.println("successfully connected to " + url);
			String responseMessage = http.getResponseMessage();
			//System.out.println("Response message is " + responseMessage);
			http.disconnect();
			//System.out.println("Disconnected from the link " + url);
		    return responseMessage;
		    
		}
		catch(Exception e){
			return e.getMessage();
		}	
	}
		
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}
}
