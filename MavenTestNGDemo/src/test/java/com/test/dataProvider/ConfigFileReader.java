package com.test.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath= "config//data.properties";
	
	 public ConfigFileReader(){
		 BufferedReader reader;
		 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 properties = new Properties();
		 try {
		 properties.load(reader);
		 reader.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		 } 
		 }
	 
	 public String getDriverPath(){
		 String driverPath = properties.getProperty("driverPath");
		 if(driverPath!= null) return driverPath;
		 else throw new RuntimeException("driverPath not specified in the data.properties file."); 
		 }
	 
	 public String getBaseUrl() {
		 String url = properties.getProperty("baseUrl");
		 if(url != null) return url;
		 else throw new RuntimeException("url not specified in the data.properties file.");
		 }
	 
	 public String getUsername() {
		 String uname = properties.getProperty("username");
		 if(uname != null) return uname;
		 else throw new RuntimeException("username not specified in the data.properties file.");
		 }
	 
	 public String getPassword() {
		 String pwd = properties.getProperty("password");
		 if(pwd != null) return pwd;
		 else throw new RuntimeException("password not specified in the data.properties file.");
		 }
	 
	 public String getItemName() {
		 String item = properties.getProperty("itemName");
		 if(item != null) return item;
		 else throw new RuntimeException("item name not specified in the data.properties file.");
		 }
	 public String getName() {
		 String fullname = properties.getProperty("name");
		 if(fullname != null) return fullname;
		 else throw new RuntimeException("name not specified in the data.properties file.");
		 }
	 public String getMobile() {
		 String mob = properties.getProperty("mobile");
		 if(mob != null) return mob;
		 else throw new RuntimeException("mobile number not specified in the data.properties file.");
		 }
	 public String getPincode() {
		 String postalcode = properties.getProperty("pincode");
		 if(postalcode != null) return postalcode;
		 else throw new RuntimeException("pincode not specified in the data.properties file.");
		 }
	 public String getAddress() {
		 String homeAddress = properties.getProperty("address");
		 if(homeAddress != null) return homeAddress;
		 else throw new RuntimeException("Address not specified in the data.properties file.");
		 }
	 
	 public String getRegion() {
		 String place = properties.getProperty("region");
		 if(place != null) return place;
		 else throw new RuntimeException("Region not specified in the data.properties file.");
		 }
	 
	 public String getCity() {
		 String town = properties.getProperty("city");
		 if(town != null) return town;
		 else throw new RuntimeException("city name not specified in the data.properties file.");
		 }
	 
	 public String getpageTitle() {
		 String title = properties.getProperty("pageTitle");
		 if(title != null) return title;
		 else throw new RuntimeException("Page title not specified in the data.properties file.");
		 }
	 
	 public String getExpectedTitle() {
		 String titleExpected = properties.getProperty("expectedTitle");
		 if(titleExpected != null) return titleExpected;
		 else throw new RuntimeException("Expected title not specified in the data.properties file.");
		 }
	 
}
