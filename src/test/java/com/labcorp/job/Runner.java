package com.labcorp.job;

public class Runner { 	
	
	public static void main(String[] args) {
		
		Driver driver = new Driver();
		JobSearch jobSearch = new JobSearch(driver.getDriver());    
		jobSearch.openJobPage("https://labcorp.com/");    
		jobSearch.searchByKeyword("QA Test Automation Developer");   
		jobSearch.selectJob("QA Test Automation Developer/Engineer");  
		jobSearch.confirmTitleLocationJobID("QA Test Automation Developer/Engineer","Burlington, North Carolina"," 19-86757");   
		jobSearch.confirmText("The right candidate for this role will participate in the test automation technology development and best practice models.");
		jobSearch.confirmConfirmSecondBullet("Prepare test plans, budgets, and schedules."); 
		jobSearch.confirmConfirmThirdRequirement("5+ years of experience in QA automation development and scripting."); 
		jobSearch.confirmConfirmSelenium("Selenium"); 
		jobSearch.applyNow(); 
	} 
}
 