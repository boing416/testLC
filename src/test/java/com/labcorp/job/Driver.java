package com.labcorp.job;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	public WebDriver driver;
	
	public Driver()
	{
		System.setProperty("webdriver.chrome.driver","E:\\drivers\\79\\chromedriver.exe");     
		driver = new ChromeDriver();    
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() 
	{
		return driver;  
	}
}
