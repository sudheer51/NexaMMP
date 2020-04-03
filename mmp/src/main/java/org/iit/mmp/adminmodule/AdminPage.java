package org.iit.mmp.adminmodule;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
	
	WebDriver driver;
	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}
	public String approvePatient(HashMap<String,String> hMap)
	{
		
		Select patientStatus = new Select(driver.findElement(By.id("search")));
		patientStatus.selectByVisibleText("Pending");
		driver.findElement(By.xpath("//a[contains(text(),'"+hMap.get("firstname")+"')]")).click();
		Select approvePatient = new Select(driver.findElement(By.id("sapproval")));
		approvePatient.selectByVisibleText("Accepted");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Alert alrt = driver.switchTo().alert();
		String actual = alrt.getText();
		alrt.accept();
		return actual;
	}

}
