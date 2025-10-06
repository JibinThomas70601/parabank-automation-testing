package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponents.WebDriverSupport;
import com.mindtree.uiStore.NewAccountUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class NewAccount extends NewAccountUI {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public NewAccount(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	
	public void NewAccountOption() throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.click(driver, newaccount, "home page", "new account", log, test);
			//WebDriverSupport.sendKeys(driver, from, "outstation", "from place", log, test, fro);
			WebDriverSupport.click(driver, opennewaccount, "new account", "open new account", log, test);
			//WebDriverSupport.sendKeys(driver, to, "outstation", "to place", log, test, too);
			//WebDriverSupport.click(driver, desti, "outstation", "to place", log, test);
			Thread.sleep(2000);

			//WebDriverSupport.click(driver, select, "outstation", "select car", log, test);
			Thread.sleep(2000);
			if (driver.findElement(accountUOpened).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "Successfully verified", log);
				Thread.sleep(2000);
				WebDriverSupport.click(driver, home, "home page", "home button", log, test);
				Thread.sleep(2000);
			} else {
				ExtentLogUtilities.fail(driver, test, " failed to verify", log);
				throw new PageObjectException("verify failed");
			}
			
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
}
	

