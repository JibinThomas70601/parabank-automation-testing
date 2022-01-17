package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponents.WebDriverSupport;
import com.mindtree.uiStore.airportUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class Airport extends airportUI {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Airport(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void Airportcar(String Add) throws ReusableComponentException, Exception {
		try {
			
			WebDriverSupport.click(driver, airport , "HomePage", "Airport", log, test);
			Select tb=new Select(driver.findElement(trip));
			tb.selectByValue("pick_airport");
			WebDriverSupport.click(driver, address, "Airport", "PickupAddress", log, test);
			WebDriverSupport.sendKeys(driver, address, "Airport", "PickupAddress", log, test, Add);
			WebDriverSupport.click(driver, addresstype, "Airport", "PickupAddress", log, test);
			
			WebDriverSupport.click(driver, select, "Airport", "SelectCar", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, selectcar, "Cars Page", "Select Car", log, test);
			
			if (driver.findElement(bookingdetail).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "booking detail shown ", log);
				WebDriverSupport.click(driver, home, "Home Page", "Home Button", log, test);
			} else {
				ExtentLogUtilities.fail(driver, test, " booking detail not shown", log);
				throw new PageObjectException("verify failed");
			}
			
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
	
		
	
}


