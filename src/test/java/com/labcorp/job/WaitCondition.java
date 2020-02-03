package com.labcorp.job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitCondition { 

	private static final int DELAY = 15;

	private WebDriverWait webDriverWait;

	public WaitCondition(WebDriver driver) {
		webDriverWait = new WebDriverWait(driver, DELAY);
	}

	public WebElement waitForVisibilityOfElementLocatedBy(final By locator) { 
		return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement waitForClickableOfElementLocatedBy(final By locator) {  
		return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
