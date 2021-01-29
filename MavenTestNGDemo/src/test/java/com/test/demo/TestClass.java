package com.test.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.dataProvider.ConfigFileReader;
import com.test.pages.AddItemToCartPage;
import com.test.pages.AddNewAddress;
import com.test.pages.HomePage;
import com.test.pages.SignInPage;

public class TestClass {
	
  WebDriver driver ;
  ConfigFileReader configFileReader = new ConfigFileReader();
//  static ExtentTest test;
//  static ExtentReports report;
  
//  @BeforeClass
//  public static void startTest()
//  {
//  report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
//  test = report.startTest("ExtentDemo");
//  }
  
  @Test
  public void f() throws InterruptedException {  
  
      driver = new ChromeDriver();
      driver.get(configFileReader.getBaseUrl());
      Thread.sleep(2000);
      System.out.println("Launching Google Chrome browser"); 
      driver.manage().window().maximize();
          
       	 	
      //Creating object of home page
      HomePage home = new HomePage(driver);
      home.clickSignIn();
      
      //Creating object of SignIn page
      SignInPage signIn = new SignInPage(driver);
      signIn.signInDetails(configFileReader.getUsername(),configFileReader.getPassword());
      
      //Creating object of AddItemToCart page
      AddItemToCartPage addItem = new AddItemToCartPage(driver);
      addItem.addAnItemToCartAndVerify();
      
      //Creating object of AddNewAddress page
      AddNewAddress addIteaddAddressm = new AddNewAddress(driver);
      addIteaddAddressm.moveToAddressPage();
      addIteaddAddressm.addAddress();
 //   addIteaddAddressm.removeAddress();
      System.out.println("TEST over");
  } 
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Starting test");
	  System.setProperty("webdriver.chrome.driver",configFileReader.getDriverPath());
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  System.out.println("After test completed");
  }

}
