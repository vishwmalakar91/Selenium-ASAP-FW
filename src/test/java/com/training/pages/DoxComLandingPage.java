package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AutoHackathon.Project.CommonLib;
import AutoHackathon.Project.DataDriver.HashMapNew;


public class DoxComLandingPage {
	
	public WebDriver oDriver;
	public ExtentReports oExtentReports;
	public ExtentTest oExtentTest;
	public HashMapNew dictionary;
	
	By header = By.xpath ("//*[@id='header']/h1");
	By inpCustID = By.id("CustID");
	By btnSearch= By.id("OpenButton");
	By custDetails= By.xpath("//h4");
	
	
	
	
	public DoxComLandingPage (WebDriver oDriver,ExtentReports oExtentReports,ExtentTest oExtentTest,HashMapNew dictionary)
	
	{
		this.oDriver= oDriver;
		this.oExtentReports= oExtentReports ;
		this.oExtentTest=oExtentTest;
		this.dictionary=dictionary;
		
		
	}

	
	public boolean fCheckHomepage () {
		
		WebElement eHeader = oDriver.findElement(header);
		
		if (eHeader.isDisplayed())
		{
			
			oExtentTest.log(LogStatus.PASS, "Landed on DOXCOM Home Page");
			return true;
			
		}
		 
		oExtentTest.log(LogStatus.FAIL,"Unable to load  DOXCOM Home Page");
		return false;
		  
	}
	
	public boolean fSearchCustomer() {
	 CommonLib.sendKeys(oDriver, inpCustID, dictionary.get("CUSTOMER_ID"));
	WebElement ebtnSearch =oDriver.findElement(btnSearch);
	 
	if (ebtnSearch.isEnabled())
	{
		ebtnSearch.click();
		oExtentTest.log(LogStatus.PASS,"Search Button is clicked");
	}
	 WebDriverWait oWait= new WebDriverWait (oDriver, 30);
	 WebElement e= oWait.until(ExpectedConditions.visibilityOfElementLocated(custDetails));

	if (e.isDisplayed())
	{
		oExtentTest.log(LogStatus.PASS,"Search Customer Successful");
		return true;
	}
	 
	 oExtentTest.log(LogStatus.FAIL,"Failed to perform Search Customer");
	 return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
