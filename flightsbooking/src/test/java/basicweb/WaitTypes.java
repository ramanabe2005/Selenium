package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
WebDriver driver;

public WaitTypes(WebDriver driver){
	this.driver = driver;
}

public static WebElement getWhenVisible(WebDriver driver, By locator, int timeout ){
	WebElement element = null;
	WebDriverWait wait = new WebDriverWait(driver,timeout);
    element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    return element;
}

public WebElement waitForElement(By locator,int timeout){
	WebElement element = null;
	try{
		System.out.println("Waiting for the maximum of :"+timeout+" seconds");
		
		WebDriverWait wait = new WebDriverWait(driver,3);
		element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(locator));
		System.out.println("Element appeared on the web page");
		
	}
	catch(Exception e){
		System.out.println("Element not appeared on the web page");
    }
	return element;
  }

public void clickWhenReady(By locator,int timeout){
	WebElement element = null;
	try{
		System.out.println("Waiting for the maximum of :"+timeout+" seconds");
		
		WebDriverWait wait = new WebDriverWait(driver,3);
		element = wait.until(
				ExpectedConditions.elementToBeClickable(locator));
		element.click();
		System.out.println("Element clicked on the web page");
		
	}
	catch(Exception e){
		System.out.println("Element not clicked on the web page");
    }
	
  }

}
