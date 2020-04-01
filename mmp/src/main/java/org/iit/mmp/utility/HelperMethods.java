package org.iit.mmp.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperMethods {

	WebDriver driver;
	public HelperMethods(WebDriver driver) {
		this.driver = driver;
	}
	public  void navigateToSubMenu(String subMenuText)
	{
		// Method-1 Click on Sub menu for Schedule Appointment
		driver.findElement(By.
	   xpath("//ul/li[@class='submenu']/a/span[contains(text(),'"+subMenuText+"')]")).click();
	}
}
