package com.labcorp.job;



import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	
	static void ScrollByParams(WebDriver driver, String x, String y)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")"); 
	}
	
	static int GetHeightWindow (WebDriver driver)
	{
		Dimension initial_size = driver.manage().window().getSize();
	    return initial_size.getHeight(); 
	    
	}	
	
	static int GetWidthWindow (WebDriver driver)
	{
		Dimension initial_size = driver.manage().window().getSize();
	    return initial_size.getWidth(); 
	    
	}
	
	static void ScrollToElement(WebDriver driver, By element) 
	{
		WebElement elementw = driver.findElement(element);  
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementw);  
	} 	
	
	static void GoTo(WebDriver driver, String url) 
	{
		driver.get(url); 
	} 	
	
	static boolean testText(WaitCondition waitCondition, String exeptedStr, By element)
	{
		boolean testPass = false;		
		WebElement elementNew = waitCondition.waitForVisibilityOfElementLocatedBy(element);  
		if (elementNew.getText().indexOf(exeptedStr) != -1) {
			  testPass = true;
		}			 
		return testPass;	 	
	}
	
}
