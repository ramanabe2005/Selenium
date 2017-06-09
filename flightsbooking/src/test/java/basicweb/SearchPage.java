	package basicweb;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public static WebElement element = null;
	
	public static WebElement originTextBox(WebDriver driver){
		element = driver.findElement(By.id("package-origin-hp-package"));
		return element;
	}
	
	public static void fillOriginTextBox(WebDriver driver, String origin){
		element = originTextBox(driver);
		element.sendKeys(origin);;
	}
	
	public static WebElement destinationTextBox(WebDriver driver){
		element = driver.findElement(By.id("package-destination-hp-package"));
		return element;
	}
	
	public static void fillDestinationTextBox(WebDriver driver, String origin){
		element = destinationTextBox(driver);
		element.sendKeys(origin);;
	}
	
	public static WebElement departureDateTextBox(WebDriver driver){
		element = driver.findElement(By.id("package-departing-hp-package"));
		return element;
	}
	
	public static void fillDepartureDateTextBox(WebDriver driver, String origin){
		element = departureDateTextBox(driver);
		element.sendKeys(origin);;
	}
	
	public static WebElement DestinationDateTextBox(WebDriver driver){
		element = driver.findElement(By.id("package-returning-hp-package"));
		return element;
	}	
	
	public static void fillDestinationDateTextBox(WebDriver driver, String origin){
		element = DestinationDateTextBox(driver);
		element.sendKeys(origin);;
	}
	
	public static WebElement searchButton(WebDriver driver){
		element = driver.findElement(By.id("search-button-hp-package"));
		return element;
	}
	
	public static void clickOnSearchButton(WebDriver driver){
		element = searchButton(driver);
		element.click();
	}
	
	public static WebElement advanceButton(WebDriver driver){
		element = driver.findElement(By.id("package-advanced-options-hp-package"));
		return element;
	}
	
	public static void clickOnAdvanceButton(WebDriver driver){
		element = advanceButton(driver);
		element.click();
	}
	
	public static WebElement prefferedClassButton(WebDriver driver){
		element = driver.findElement(By.id("package-advanced-preferred-class-hp-package"));
		return element;
	}
	
	public static void fillPrefferedClassButton(WebDriver driver, String preclass){
		element = prefferedClassButton(driver);
		element.sendKeys(preclass);
	}
	
	
	public static void navigateToFlightTab(WebDriver driver){
		element = driver.findElement(By.id("primary-header-flight"));
		element.click();
	}
	
	public static void clickMorningFlight(WebDriver driver){
		WebElement element = WaitTypes.getWhenVisible(driver,By.xpath("//span[@id='outbound-departure-times-Evening-flights-checkbox']"), 30);
		System.out.println("Found evening flight Tab");
		element.click();
	}
}
