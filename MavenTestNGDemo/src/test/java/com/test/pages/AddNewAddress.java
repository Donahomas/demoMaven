package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.test.common.CommonFunction;
import com.test.dataProvider.ConfigFileReader; 

public class AddNewAddress {
	
	WebDriver driver;
	ConfigFileReader configFileReader = new ConfigFileReader();

	 //Constructor that will be automatically called as soon as the object of the class is created
	 public AddNewAddress(WebDriver driver) {
	 this.driver=driver;
	 }
	 
	 By hamburgerMenu = By.xpath("//div[@class='nav-left']/following::a[@id='nav-hamburger-menu']");	
	 
	 By myAccount = By.xpath("//div[@id='hmenu-content']//following::ul/li/a[text()='Your Account']");
	 
	 By yourAddress = By.xpath("//h2[contains(text(),'Your Addresses')]//ancestor::div[@class='ya-card-cell']");	 
	 
	 By addAddress = By.xpath("//div[@class = 'a-box first-desktop-address-tile']/div");
	 
	 By fullName = By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']");
	 
	 By mobileNumber = By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']");
	 
	 By postalCode = By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']");
	 
	 By addressline1 = By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']");
	 
	 By state = By.xpath("//select[@name='address-ui-widgets-enterAddressStateOrRegion']");
	 
	 By city = By.xpath("//input[@id='address-ui-widgets-enterAddressCity']");
	 
	 By addAddressButton = By.xpath("//input[@class='a-button-input']");
	 
	 By addressAddedConfirmation = By.xpath("//h4[contains(text(),'Address saved')]");
	 
	 By removeButton = By.xpath("//h5[contains(text(),'"+configFileReader.getName()+"')]//following::span/a[text()='Remove']");
	 
	 By confirmdeletionButton = By.xpath("//span[@id='deleteAddressModal-5-submit-btn-announce']");
	 
	 By deleteConfirmMsg = By.xpath("//h4[contains(text(),'Address deleted')]");
	 
	 
	 public void moveToAddressPage() throws InterruptedException {
		 driver.findElement(hamburgerMenu).click();
		
		 //Creating object of Common functions page
		 CommonFunction common = new CommonFunction(driver);
		 
		 //scrolling page down
		 common.scrollPageByPixel();
		 
		 WebDriverWait wait=new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(myAccount));
		 driver.findElement(myAccount).click();
		 System.out.println("=====Moved to myAccount page=====");
		 wait.until(ExpectedConditions.elementToBeClickable(yourAddress));
		 driver.findElement(yourAddress).click();
		 System.out.println("=====Moved to address page=====");
	 }
	 
	 
	 public void addAddress() throws InterruptedException{
		 driver.findElement(addAddress).click();
		 driver.findElement(fullName).sendKeys(configFileReader.getName());
		 driver.findElement(mobileNumber).sendKeys(configFileReader.getMobile());
		 driver.findElement(postalCode).sendKeys(configFileReader.getPincode());
		 driver.findElement(addressline1).sendKeys(configFileReader.getAddress());
		 driver.findElement(city).sendKeys(configFileReader.getCity());
		 Select select = new Select(driver.findElement(state));
		 select.selectByVisibleText(configFileReader.getRegion());
		 driver.findElement(addAddressButton).click();
		 Boolean addressAdded = driver.findElement(addressAddedConfirmation).isDisplayed();
	     Assert.assertTrue(addressAdded);
	     System.out.println("=====Verified that address has been added=====");
	 }
	 
	 public void removeAddress() throws InterruptedException{
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		 WebElement remove = wait.until(ExpectedConditions.elementToBeClickable(removeButton));
		 remove.click();
//		 Thread.sleep(2000);
//		 driver.findElement(removeButton).click();
//		 Thread.sleep(8000);
		//window handling 
//		 Set<String> windows = driver.getWindowHandles();
//		 System.out.println("%%%%%%%%%%"+driver.getWindowHandles().size());
//		 Iterator<String> it = windows.iterator();
//		 while(it.hasNext()) {
//			 driver.switchTo().window(it.next()); 
//		 }		 
//		 System.out.println("=====Focus moved to new window=====");
//		 WebDriverWait wait=new WebDriverWait(driver, 10);
//		 WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmdeletionButton));
//		 confirmDelete.click();
//		 Alert alert = driver.switchTo().alert();
//		 System.out.println("%%%%%%%%%%"+alert.getText());
//		 Thread.sleep(3000);
//		 alert.accept();
		 
		 
//		 Boolean yesButton = driver.findElement(confirmdeletionButton).isDisplayed();
//		 Assert.assertTrue(yesButton);
//		 driver.findElement(confirmdeletionButton).click();
		 Boolean deletionMsg = driver.findElement(deleteConfirmMsg).isDisplayed();
	     Assert.assertTrue(deletionMsg);
	     System.out.println("=====Verified that address has been deleted=====");
	 }

}
