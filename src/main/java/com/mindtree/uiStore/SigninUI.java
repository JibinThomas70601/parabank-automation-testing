package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class SigninUI {
	
	public static By signin = By.xpath("//span[contains(text(),'Sign In')]");
	public static By email = By.xpath("//input[@name='username']");
	public static By password =By.xpath("//input[@name='password']");
	public static By login = By.xpath("//input[@value='Log In']");
	public static By myacc = By.xpath("//h1[normalize-space()='Accounts Overview']");

}