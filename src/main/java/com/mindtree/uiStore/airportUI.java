package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class airportUI {

	   public static By airport = By.xpath("//span[contains(text(),'Airport')]");
	   public static By trip = By.xpath("//select[@formcontrolname='frmLocalSubTripType']");
	   public static By addresstype = By.xpath("//span[contains(text(),'KEB Colony, Industrial Area, Hoodi')]");
	   public static By address = By.xpath("//input[@id='search_places']");
	   public static By calendar = By.xpath("//input[@placeholder='dd-mm-yyyy')]");
		public static By date = By.xpath("//span[contains(text(),'24']");
		public static By pickup = By.xpath("select[@id='pickUpTime");
	   public static By select = By.xpath("//button[contains(text(),'Select Car')]");
		public static By selectcar= By.xpath("//button[contains(text(),'Select')]");
		public static By bookingdetail = By.xpath("//div[@class='card ng-star-inserted']");
		public static By home = By.xpath("//header/div[1]/div[1]/a[1]/img[1]");
}
