package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponents.WebDriverSupport;
import com.mindtree.uiStore.localUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class Local extends localUI {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Local(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void Localcar() throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.click(driver, local , "homepage", "local", log, test);
			WebDriverSupport.click(driver, select, "local", "select car", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, time, "carpage", "time", log, test);
			WebDriverSupport.click(driver, selectcar, "car page", "select car", log, test);
		
			
			
			if (driver.findElement(bookingdetail).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "booking detail shown ", log);
				WebDriverSupport.click(driver, home, "home page", "home button", log, test);
			} else {
				ExtentLogUtilities.fail(driver, test, " booking detail not shown", log);
				throw new PageObjectException("verify failed");
			}
			
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
	
	
		
	
}
