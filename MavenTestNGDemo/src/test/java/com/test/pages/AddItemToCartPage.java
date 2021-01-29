package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.*;
import com.test.common.CommonFunction;
import com.test.dataProvider.ConfigFileReader;

public class AddItemToCartPage {
	WebDriver driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public AddItemToCartPage(WebDriver driver) {
	 this.driver=driver;
	 }
	 
	 //Locator for search field	 
	 By searchBar = By.xpath("//input[@id='twotabsearchtextbox']");	
	 
	//Locator for search button	 
	 By searchButton = By.xpath("//div/span/input[@type='submit']");
	 
	//Locator for item	 
	 By item = By.xpath("//span[contains(text(),'Tabelito Bussiness Laptop Bag 15.6 inch, 35 L Water Resistant Laptop Backpack (Grey)')]");
	 
	//Locator for add to cart button	 
	 By addToCartButton = By.id("add-to-cart-button");
	 
	//Locator for added to cart message	 
	 By addedToCart = By.xpath("//h1[contains(text(),'Added to Cart')]");
	 
	//Locator for cart	 
	 By cart = By.id("nav-cart");
	 
	//Locator for amazon logo	 
	 By amazonLogo = By.xpath("//div[@id='nav-logo']//child::a");
	 

	 //method for adding an item to cart
	 public void addAnItemToCartAndVerify() throws InterruptedException {
		 driver.findElement(searchBar).sendKeys(configFileReader.getItemName());
		 driver.findElement(searchButton).click();
		 //Creating object of Common functions page
		 CommonFunction common = new CommonFunction(driver);
		 //scrolling page down
		 common.scrollPageByPixel();
		 driver.findElement(item).click();
		 
		 //window handling when item is added to cart - focus moves to next tab
		 Set<String> windows = driver.getWindowHandles();
		 Iterator<String> it = windows.iterator();
		 while(it.hasNext()) {
			 driver.switchTo().window(it.next()); 
		 }		 
		 System.out.println("=====Focus moved to new window=====");
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
		 driver.findElement(addToCartButton).click();
		 System.out.println("=====Item added to cart=====");
		 
		 //verifies title to ensure we have reached expected page
		 String expectedTitle = configFileReader.getExpectedTitle();									
	     String originalTitle = driver.getTitle();
	     Assert.assertEquals(originalTitle, expectedTitle);
	     driver.findElement(cart).click();
	     System.out.println("=====Inside Shopping Cart Page=====");
	     
	     //Below line of code verifies if item has been added to cart
	     Boolean itemAdded = driver.findElement(item).isDisplayed();
	     Assert.assertTrue(itemAdded);
	     System.out.println("=====Verified that item has been added to cart=====");
	     
	     driver.findElement(amazonLogo).click();	     
	 	}

}
