package com.expedia.flightsbooking;

import org.testng.annotations.Test;
import basicweb.SearchPageFactory;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestNG_Grouping {

	private WebDriver driver;
	private String baseUrl;
	private static final Logger log = LogManager.getLogger(TestNG_Grouping.class.getName());
	SearchPageFactory searchPage;
  
  @BeforeClass(alwaysRun=true)
  public void beforeClass() {
    System.out.println("Running once before the class");
  }
  
  @BeforeMethod
  public void beforeMethod() {
    System.out.println("Running once before every method");
  }
  
  @Test(groups={"Sedan", "BMW"})
  public void BMW3Series(){
	  System.out.println("Running test - BMW 3 Series");
  }
  
  @Test(groups={"SUV", "BMW"})
  public void BMWX3(){
	  System.out.println("Running test - BMWX3");
  }
  
  @Test(groups={"Sedan", "Audi"})
  public void AudiA6(){
	  System.out.println("Running test - AudiA6");
  }
  
  @Test(groups={"Sedan", "Honda"})
  public void HondaAccord(){
	  System.out.println("Running test - HondaAccord");
  }

  @AfterMethod
  public void afterMethod() {
	System.out.println("Running after each and every method");
  }
  
  @AfterClass(alwaysRun=true)
  public void afterClass() {
	System.out.println("Running once after the whole class");
  }

}
