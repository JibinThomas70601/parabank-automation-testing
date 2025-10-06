package com.mindtree.runner;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.exceptions.ApplicationException;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.SignIn;
import com.mindtree.pageObject.NewAccount;
import com.mindtree.pageObject.ValidPage;
import com.mindtree.reusableComponents.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class carsrunner extends Base {
	static Logger log;
	static ExtentTest test;
	static ExtentReports report;

	public carsrunner() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest()
	public void initializeDriver() throws ApplicationException {
		try {
			report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
					+ System.currentTimeMillis() + "-.html");
			log = Logger.getLogger(carsrunner.class.getName());
			driver = initialize();
			test = report.startTest("Home Page");
			driver.get(GetProperties.get.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			ExtentLogUtilities.pass(driver, test, "URL Opened", log);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	@Test(priority = 1, dataProvider = "getTitle")
	public void validateTitle(String title) throws ApplicationException {
		test = report.startTest("Validate Title");
		try {
			new ValidPage(driver, log, test).validate(title);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	@DataProvider
	public Object[] getTitle() {
		Object data[] = new Object[1];
		data[0] = get.getProperty("title");
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getData")
	public void LogIn(String uid, String pw) throws ApplicationException {
		test = report.startTest("Log in");
		try {
			new SignIn(driver, log, test).login(uid, pw);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	@DataProvider
	public Object[] getData() {
		Object data[][] = new Object[1][2];
		data[0][0] = excelData.get("id");
		data[0][1] = excelData.get("pw");
		return data;
	}
	
	@Test(priority = 3)
	public void NewAccount() throws ApplicationException {
		test = report.startTest("Open New Account");
		try {
			new NewAccount(driver, log, test).NewAccountOption();
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	
	
	@AfterTest
	public void closeInstance() {
		driver.close();
		driver.quit();
	}
}

