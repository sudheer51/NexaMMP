package org.iit.seleniumexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMPScheduleAppointment {

	WebDriver driver ;
	
	@Test
	public void validateScheduleAppointment() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		//Login Method
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		
		
		// Method-1 Click on Sub menu for Schedule Appointment
		driver.findElement(By.xpath("//ul/li[@class='submenu']/a/span[contains(text(),'Schedule')]")).click();
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		//Method-2 click on book appointment button
		driver.findElement(By.xpath("//table[@class='table']//h4[text()='Dr.Alexander']/ancestor::td/button")).click();
		driver.switchTo().frame("myframe");
		
		//Method-3
		driver.findElement(By.id("datepicker")).sendKeys("03/25/2019");
		driver.findElement(By.id("datepicker")).click();
		new Select(driver.findElement(By.id("time"))).selectByVisibleText("10Am");
		 
		driver.findElement(By.id("ChangeHeatName")).click();
		driver.findElement(By.xpath("//textarea[@id='sym']")).sendKeys("Flu");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		//Method-4
		String tableRowText = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]")).getText();
		Assert.assertTrue(tableRowText.contains("Flu"));
		Assert.assertTrue(tableRowText.contains("Alexander"));
		Assert.assertTrue(tableRowText.contains("10Am"));
		Assert.assertTrue(tableRowText.contains("03/25/2019"));
	}
}







