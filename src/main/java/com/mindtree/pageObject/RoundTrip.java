package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponents.WebDriverSupport;
import com.mindtree.uiStore.roundtripUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class RoundTrip extends roundtripUI {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public RoundTrip(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void Selectcar() throws ReusableComponentException, Exception {
		try {
		    Thread.sleep(2000);
			WebDriverSupport.click(driver, round, "home page", "round", log, test);
			
			WebDriverSupport.click(driver, select, "round", "selectcar", log, test);
			Thread.sleep(2000);
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
