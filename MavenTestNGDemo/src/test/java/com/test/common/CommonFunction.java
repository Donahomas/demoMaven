package com.test.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CommonFunction {
	WebDriver driver;
	
	public CommonFunction(WebDriver driver) {
		 this.driver=driver;
		 }

	 public void scrollPageByPixel() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	//This  will scroll down the page by  1000 pixel vertical		
	     js.executeScript("window.scrollBy(0,1050)");
	     System.out.println("=====Page scrolled by 1000pixel downwards=====");
	 	}
	 
}
