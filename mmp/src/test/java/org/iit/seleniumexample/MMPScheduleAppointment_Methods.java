package org.iit.seleniumexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMPScheduleAppointment_Methods {

	WebDriver driver ;
	public void launchBrowser(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	public void login(String username,String password)
	{
		//Login Method
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();

	}
	public void navigateToSubMenu(String subMenuText)
	{
		// Method-1 Click on Sub menu for Schedule Appointment
		driver.findElement(By.
	   xpath("//ul/li[@class='submenu']/a/span[contains(text(),'"+subMenuText+"')]")).click();
	}
	public void bookAppointment(String doctorName,String date,String time,String sym)
	{
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		//Method-2 click on book appointment button
		driver.findElement(By.xpath("//table[@class='table']//h4[text()='Dr."+doctorName+"']/ancestor::td/button")).click();
		driver.switchTo().frame("myframe");
		//Method-3
		driver.findElement(By.id("datepicker")).sendKeys(date);
		driver.findElement(By.id("datepicker")).click();
		new Select(driver.findElement(By.id("time"))).selectByVisibleText(time);

		driver.findElement(By.id("ChangeHeatName")).click();
		driver.findElement(By.xpath("//textarea[@id='sym']")).sendKeys(sym);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
	}
	public String fetchPatientData()
	{
		String tableRowText = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]")).getText();
		return tableRowText;
	}
	@Test
	public void validateScheduleAppointment() throws InterruptedException
	{
		String doctorName="Alexander";
		String username="ria1";
		String password="Ria12345";
		String date="03/25/2020";
		String time="10Am";
		String sym="Flu";
		launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		login(username,password);
		navigateToSubMenu("Schedule");
		bookAppointment(doctorName,date,time,sym);
		String tableRowText =  fetchPatientData();
		Assert.assertTrue(tableRowText.contains(sym));
		Assert.assertTrue(tableRowText.contains(doctorName));
		Assert.assertTrue(tableRowText.contains(time));
		Assert.assertTrue(tableRowText.contains(sym));
	}
}







