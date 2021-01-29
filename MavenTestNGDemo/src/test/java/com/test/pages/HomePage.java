package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	 WebDriver driver;
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public HomePage(WebDriver driver) {
	 this.driver=driver;
	 }
	 
	 //Locator for signIn navigation 
	 By signInNavigation = By.id("nav-link-accountList");
	 
	 
	 //Method to click sign in  button
	 public void clickSignIn() {
     driver.findElement(signInNavigation).click();	 
     System.out.println("=====Entering signIn page=====");
	 }
}
