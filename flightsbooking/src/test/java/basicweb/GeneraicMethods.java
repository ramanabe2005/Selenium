package basicweb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneraicMethods {
	WebDriver driver;
	
	public GeneraicMethods(WebDriver driver){
		this.driver = driver;		
	}
	
	public WebElement getElement(String locator, String type){
		type = type.toLowerCase();
		if(type.equals("id")){
			System.out.println("Element found with id :"+type);
			return this.driver.findElement(By.id(locator));
		}
		else if(type.equals("xpath")){
			System.out.println("Element found with xpath: "+type);
			return this.driver.findElement(By.xpath(locator));
		}
		else{
			System.out.println("Location type not supported");
			return null;
		}
	}

	
	
	public List<WebElement> getElementList(String locator, String type){
		type = type.toLowerCase();
		
		List<WebElement> elementList = new ArrayList<WebElement>();
		if(type.equals("id")){
			elementList = this.driver.findElements(By.id(locator));
		}
		else if(type.equals("xpath")){
			//System.out.println("Element found with xpath: "+locator);
			elementList = this.driver.findElements(By.xpath(locator));
		}
		else{
			System.out.println("Location type not supported");
			return null;
		}
		if(elementList.isEmpty())
		{
			System.out.println("Element not found with : "+locator);
		}
		else{
			System.out.println("Element found with : "+locator);
		}
		return elementList;		
	}
	
	
	
	public boolean isElementPresent(String locator, String type){
		List<WebElement> elementList = getElementList(locator,type);
		int size = elementList.size();
		if(size>0){
			return true;
		}
		else
		{
			return false;
		}
	}
	


}
