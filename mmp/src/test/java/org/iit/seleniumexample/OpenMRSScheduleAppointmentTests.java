package org.iit.seleniumexample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenMRSScheduleAppointmentTests {

	WebDriver driver;
	@Test
	public void validateDoctorAppointment()
	{    	 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
		driver.findElement(By.name("givenName")).sendKeys("Sachin");
		driver.findElement(By.name("middleName")).sendKeys("Tendulkar");
		driver.findElement(By.name("familyName")).sendKeys("Sachin");
		navigateToModule("//ul[@id='formBreadcrumb']/li[1]/ul/li","Gender");
		new Select(driver.findElement(By.id("gender-field"))).selectByVisibleText("Male");
		navigateToModule("//ul[@id='formBreadcrumb']/li[1]/ul/li","Birthdate");
		driver.findElement(By.id("birthdateDay-field")).sendKeys("23");
		new Select(driver.findElement(By.id("birthdateMonth-field"))).selectByVisibleText("January");
		driver.findElement(By.id("birthdateYear-field")).sendKeys("1980");
		navigateToModule("//ul[@id='formBreadcrumb']/li[2]/ul/li","Address");
		driver.findElement(By.id("address1")).sendKeys("Bangalore");
		navigateToModule("//ul[@id='formBreadcrumb']/li[2]/ul/li","Phone Number");
		driver.findElement(By.name("phoneNumber")).sendKeys("125115");
		navigateToModule("//ul[@id='formBreadcrumb']/li[3]/ul/li","Relatives");
		new Select(driver.findElement(By.id("relationship_type"))).selectByVisibleText("Doctor");
		driver.findElement(By.xpath("//input[@placeholder='Person Name']")).sendKeys("James");  
		driver.findElement(By.xpath("//ul[@id='formBreadcrumb']/li[4]")).click();  
		driver.findElement(By.id("submit")).click();
		
		//navigate to homePage
		driver.findElement(By.xpath("//ul[@id='breadcrumbs']/li[1]")).click();
		driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
		driver.findElement(By.id("patient-search")).sendKeys("Sachin");	
		boolean result = driver.findElement(By.xpath("//table[@id='patient-search-results-table']/tbody/tr")).getText().contains("Sachin");
		Assert.assertTrue(result);
	}
	public void navigateToModule(String locator,String locatorValue)
	{
		List<WebElement> demoGraphicList = driver.findElements(By.xpath(locator));
		System.out.println("Size of the List " + demoGraphicList.size());
		for(int i =0 ;i<demoGraphicList.size();i++)
		{
			System.out.println(demoGraphicList.get(i).getText());
			if(demoGraphicList.get(i).getText().contains(locatorValue))
			{
				demoGraphicList.get(i).click();

			}
		}
	}
}
