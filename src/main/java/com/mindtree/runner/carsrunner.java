package com.mindtree.runner;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.exceptions.ApplicationException;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.CorporateCarRental;
import com.mindtree.pageObject.OneWayCabs;
import com.mindtree.pageObject.SignIn;
import com.mindtree.pageObject.SignOut;
import com.mindtree.pageObject.Airport;
import com.mindtree.pageObject.Local;
import com.mindtree.pageObject.OutStation;
import com.mindtree.pageObject.RoundTrip;
import com.mindtree.pageObject.DownloadApp;
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
	
	@Test(priority = 3, dataProvider = "getData1")
	public void Outstation(String fro, String too) throws ApplicationException {
		test = report.startTest("out station");
		try {
			new OutStation(driver, log, test).Outstation(fro, too);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	@DataProvider
	public Object[] getData1() {
		Object data[][] = new Object[1][2];
		data[0][0] = excelData.get("fro");
		data[0][1] = excelData.get("too");
		return data;
	}
	
	@Test(priority = 4)
	public void Selectcar() throws ApplicationException {
		test = report.startTest("select car");
		try {
			new RoundTrip(driver, log, test).Selectcar();
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	
	@Test(priority = 5)
	public void Local() throws ApplicationException {
		test = report.startTest("local");
		try {
			new Local(driver, log, test).Localcar();
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	

	@Test(priority = 6, dataProvider = "getData2")
	public void Airport(String Add) throws ApplicationException {
		test = report.startTest("Airport");
		try {
			new Airport(driver, log, test).Airportcar(Add);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	@DataProvider
	public Object[] getData2() {
		Object val[][] = new Object[1][1];
		val[0][0] = excelData.get("Add");
		return val;
	}
	
	@Test(priority = 7)
	public void ThisApp() throws ApplicationException {
		test = report.startTest("The App");
		try {
			new DownloadApp(driver, log, test).App();
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@Test(priority = 8, dataProvider = "getData3")
	public void CarRental(String nm,String cnm,String em,String ph) throws ApplicationException {
		test = report.startTest("Car Rental");
		try {
			new CorporateCarRental(driver, log, test).CarRental(nm,cnm,em,ph);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	@DataProvider
	public Object[] getData3() {
		Object val[][] = new Object[1][4];
		val[0][0] = excelData.get("nm");
		val[0][1] = excelData.get("cnm");
		val[0][2] = excelData.get("em");
		val[0][3] = excelData.get("ph");
		return val;
	}
	@Test(priority = 9)
	public void Onewaycab() throws ApplicationException {
		test = report.startTest("One Way CAB");
		try {
			new OneWayCabs(driver, log, test).Onewaycab();
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	
	@Test(priority = 10)
	public void SignOut() throws ApplicationException {
		test = report.startTest("Sign Out");
		try {
			new SignOut(driver, log, test).Signoutapp();
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

