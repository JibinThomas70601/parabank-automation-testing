package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponents.WebDriverSupport;
import com.mindtree.uiStore.SignoutUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class SignOut extends SignoutUI {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public SignOut(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void Signoutapp() throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.click(driver, img, "img", "img", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, bookings, "bookings", "bookings", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, cancelled, "cancelled", "cancelled", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, completed, "completed", "completed", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, booknow, "booknow", "booknow", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, img, "img", "img", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, accountsetting, "accountsetting", "accountsetting", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, home, "home", "home", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, img, "img", "img", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, logout, "logout", "logout", log, test);

			if (driver.findElement(SignIn).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "Signed out sucessfully ", log);
				
			} else {
				ExtentLogUtilities.fail(driver, test, "signout unsucessful", log);
				throw new PageObjectException("verify failed");
			}
			
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
		}

