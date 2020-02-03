package com.labcorp.job;



import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JobSearch {		
	
	WaitCondition waitCondition;
	WebDriver driver;
	
	public JobSearch(WebDriver driver) 
	{
		this.driver = driver;
		waitCondition = new WaitCondition(driver);
	}
	
	void openJobPage(String url) 
	{		 		
		driver.get(url);   
		By element = By.xpath("//a[.='Careers']"); 	
		Utility.ScrollToElement(driver, element);
		WebElement link = driver.findElement(element);   
		Utility.GoTo(driver, link.getAttribute("href")); 		
	}
	
	void searchByKeyword(String searchText)   
	{	
		WebElement input =  waitCondition.waitForVisibilityOfElementLocatedBy(By.xpath("//input[contains(@class, 'search-keyword')]"));
		input.sendKeys(searchText);       
		WebElement submit =  waitCondition.waitForVisibilityOfElementLocatedBy(By.xpath("//button[contains(@class,'search-form__submit')]"));
		submit.click();  
	}
	
	void selectJob(String jobTitle)
	{  
		WebElement element =  waitCondition.waitForClickableOfElementLocatedBy(By.xpath("//h2[contains(text(),'QA Test Automation Developer/Engineer')]"));
		element.click();  
	} 	
	
	void confirmTitleLocationJobID(String title, String location, String jobId)  
	{	 		  
		Utility.ScrollToElement(driver, By.xpath("//span[contains(@class,'job-id job-info')]"));  
		assertTrue(Utility.testText(waitCondition, title, By.xpath("//h1[contains(@class,'job-description__heading')]")), "Verification Failed: Title");  
		assertTrue(Utility.testText(waitCondition, location, By.xpath("//span[contains(@class,'job-location job-info')]")), "Verification Failed: Location"); 
		assertTrue(Utility.testText(waitCondition, jobId, By.xpath("//span[contains(@class,'job-id job-info')]")), "Verification Failed: Job ID"); 
	}
	
	void confirmText(String text)   
	{	 		   
		By element = By.xpath("(//div[contains(@class,'ats-description')]/p)[5]/span[1]");
		By element2 = By.xpath("(//div[contains(@class,'ats-description')]/p)[5]/span[2]");
		Utility.ScrollToElement(driver, element);  			
		String elementText = waitCondition.waitForVisibilityOfElementLocatedBy(element).getText();
		elementText = elementText + " " +waitCondition.waitForVisibilityOfElementLocatedBy(element2).getText();
		boolean testPass = false;		
		WebElement elementNew = waitCondition.waitForVisibilityOfElementLocatedBy(element);  
		if (elementText.indexOf(text) != -1) {
			  testPass = true;
		}   
		assertTrue(testPass,"Verification Failed: First sentence of second paragraph "); 
	}
	
	
	
	void confirmConfirmSecondBullet(String text)  
	{	 
		By element = By.xpath("//div[contains(@class,'ats-description')]/ul[3]/li[2]/span[2]");
		Utility.ScrollToElement(driver, element);   
		assertTrue(Utility.testText(waitCondition, text, element), "Verification Failed: Second Bullet");  
	} 
	
	void confirmConfirmThirdRequirement(String text)  
	{	  		
		By element = By.xpath("//div[contains(@class,'ats-description')]/div/span/div/ul/li[3]/span[2]");
		By element2 = By.xpath("//div[contains(@class,'ats-description')]/div/span/div/ul/li[3]/span[3]"); 
		Utility.ScrollToElement(driver, element);  			
		String elementText = waitCondition.waitForVisibilityOfElementLocatedBy(element).getText();
		elementText = elementText + "" +waitCondition.waitForVisibilityOfElementLocatedBy(element2).getText();
		boolean testPass = false;		
		WebElement elementNew = waitCondition.waitForVisibilityOfElementLocatedBy(element);  
		if (elementText.indexOf(text) != -1) {
			  testPass = true;
		}   
		assertTrue(testPass,"Verification Failed: Third Requirement"); 
	}
	
	void confirmConfirmSelenium(String text)  
	{	  
		By element = By.xpath("//div[contains(@class,'ats-description')]/div/span/div/ul/li[12]/ul/li/span[2]");
		Utility.ScrollToElement(driver, element);   
		assertTrue(Utility.testText(waitCondition, text, element), "Verification Failed: Third Requirement");  
	}
	
	void applyNow()   
	{	      
		WebElement submit =  waitCondition.waitForVisibilityOfElementLocatedBy(By.xpath("//a[contains(@class,'button job-apply bottom')]"));
		submit.click();  
	}
	
	
}
