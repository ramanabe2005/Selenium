package basicweb;

import org.apache.logging.log4j.LogManager;
import basicweb.WaitTypes;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.expedia.flightsbooking.TestNG_TestSuite;

public class SearchPageFactory {
	
	WebDriver driver;
	private static final Logger log = LogManager.getLogger(TestNG_TestSuite.class.getName());
	
	WaitTypes wt = new WaitTypes(driver);
	
	@FindBy(id="tab-flight-tab-hp")
    WebElement flighttab;
	
	@FindBy(id="flight-origin-hp-flight")
    WebElement originCity;
	
	@FindBy(id="flight-destination-hp-flight")
    WebElement destinationCity;
	
	@FindBy(id="flight-departing-hp-flight")
    WebElement departureDate;
	
	@FindBy(id="flight-returning-hp-flight")
    WebElement returnDate;
	
	@FindBy(xpath="//a[@id='flight-advanced-options-hp-flight']")
	WebElement advanceTab;
	
	@FindBy(id="advanced-flight-nonstop-label-hp-flight")
	WebElement nonstopCheckbox;
	
	@FindBy(xpath="//select[@id='flight-advanced-preferred-class-hp-flight']")
	WebElement prefferedClass;
	
	@FindBy(xpath="//label[@class='col search-btn-col']//button[@class='btn-primary btn-action gcw-submit']//span[text()='Search']")
    WebElement submitElement;
			
	public SearchPageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlightsTab(){
		flighttab.click();
		log.info("Clicked on the Flights Button");
	}
	
	public void setOriginCity(String origin){
		originCity.sendKeys(origin);
		log.info("Sending Origin city details");
	}
	
	public void setDestinationCity(String Dest){
		destinationCity.sendKeys(Dest);
		log.info("Sending destination city details");
	}
	
	public void setDepartureDate(String DepDate){
		departureDate.sendKeys(DepDate);
		log.info("Sending Departure Date");
	}

	public void setReturnDate(String RetDate){
		returnDate.sendKeys(RetDate);
		log.info("Sending return Date");
	}
	
	public void clickAdvanceTab(){
		advanceTab.click();
		log.info("Clicked on the advanced Button");
	}
	
	public void clickNonstopCheckbox(){
		nonstopCheckbox.click();
		log.info("Clicked on the Nonstop Checkbox Button");
	}
	
	public void selectPrefferedClass(String PrefClass){
		Select options = new Select(prefferedClass);
		options.selectByValue(PrefClass);
		log.info("Selecting the preffered class");
	}
	
	public void clickOnSubmit(){
		submitElement.click();
		log.info("Finally clicking on the Submit Button");
	}
	
	public static void clickMorningFlight(WebDriver driver){
		WebElement element = WaitTypes.getWhenVisible(driver,By.xpath("//span[@id='outbound-departure-times-Evening-flights-checkbox']"), 30);
		element.click();
	}
	
	public void clearAllFields(){
		originCity.clear();
		destinationCity.clear();
		departureDate.clear();
		returnDate.clear();	
	}
}
