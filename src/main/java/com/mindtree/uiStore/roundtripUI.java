package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class roundtripUI {
	
	public static By round = By.xpath("//label[contains(text(),'Round Trip')]");
	public static By calendar = By.xpath("//input[@placeholder='dd-mm-yyyy')]");
	public static By date = By.xpath("//span[contains(text(),'24']");
	public static By pickup = By.xpath("select[@id='pickUpTime");
	public static By select = By.xpath("//button[contains(text(),'Select Car')]");
	public static By selectcar= By.xpath("//button[contains(text(),'Select')]");
	public static By bookingdetail = By.xpath("//div[@class='card ng-star-inserted']");
	public static By location = By.xpath("//input[@id='search_places']");
	public static By locat = By.xpath("//span[contains(text(),'Bangalore Designers')]");
	public static By proceed = By.xpath("//span[contains(text(),'Proceed')]");
	public static By paynow = By.xpath("//div[contains(text(),'Pay now')]");
	public static By book = By.xpath("//span[contains(text(),'Book Now')]");
	public static By popup = By.xpath("//div[@id='modal']");
	public static By home = By.xpath("//header/div[1]/div[1]/a[1]/img[1]");
}
		