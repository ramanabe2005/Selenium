package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	
	WebDriver driver;
	
	@Given("^Open Chrome or Firefox and start the application$") 
	public void Open_Chrome_or_Firefox_and_start_the_application() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
	}

	@When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$") 
	public void I_enter_valid_Username_and_Password(String uname, String pass) {
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("pass")).sendKeys(pass);

	}

	@Then("^User should be able to login successfully$") 
	public void User_should_be_able_to_login_successfully(){
		driver.findElement(By.id("loginbutton")).click();
		driver.quit();
	}

}
