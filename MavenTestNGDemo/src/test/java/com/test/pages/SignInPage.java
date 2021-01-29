package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.dataProvider.ConfigFileReader;

public class SignInPage{

 WebDriver driver;
 ConfigFileReader configFileReader = new ConfigFileReader();
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public SignInPage(WebDriver driver) {
	 this.driver=driver;
	 }
	 
	 //Locator for email/phone number field	 
	 By emailField = By.name("email");	
	 
	//Locator for continue button
	 By continueButton = By.id("continue");
	 
	//Locator for password field	
	 By passwordField = By.id("ap_password");
	 
	//Locator for SigniIn button	
	 By signInButton = By.id("signInSubmit");
	 
	 //Method for SignIn
	 public void signInDetails(String username,String password){
		 driver.findElement(emailField).sendKeys(username);
		 driver.findElement(continueButton).click();
		 driver.findElement(passwordField).sendKeys(password);
		 driver.findElement(signInButton).click();
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.titleIs(configFileReader.getpageTitle()));
		 String testTitle = configFileReader.getpageTitle();
	     String originalTitle = driver.getTitle();
	     Assert.assertEquals(originalTitle, testTitle);
		 System.out.println("=====SignIn successful=====");		 
	 	}
	 }
