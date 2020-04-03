package org.iit.mmp.patient.tests;

import java.util.HashMap;
import java.util.Random;

import org.iit.mmp.adminmodule.AdminLogin;
import org.iit.mmp.adminmodule.AdminPage;
import org.iit.mmp.patientmodule.PatientLogin;
import org.iit.mmp.patientmodule.RegistrationPage;
import org.iit.mmp.utility.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//Adding comment for patient tests
public class PatientTests {
	 WebDriver driver;
	 Random rnd = new Random();
	 HashMap<String,String> hMap ;
	
	@Test 
	public void approvePatient()
	{
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
		RegistrationPage regPage = new RegistrationPage(driver);
		
		String usernameValue = "testUName" +10+rnd.nextInt(90);
		String passwordValue = "testPWord" +10+rnd.nextInt(90);
		hMap = regPage.registerPatient(usernameValue, passwordValue);
		String actual = hMap.get("successMsg").trim();
		String expected ="Thank you for registering with MMP.";
		Assert.assertEquals(actual, expected);
		
		driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		AdminLogin adminLogin = new AdminLogin(driver);
		adminLogin.loginToAdmin("Thomas_444","Edison_444");
		HelperMethods helperMethod = new HelperMethods(driver);
		helperMethod.navigateToSubMenu("Users");
		AdminPage adminPage = new AdminPage(driver);
		actual=adminPage.approvePatient(hMap).trim();
		expected="USER has been updated.";
		Assert.assertEquals(actual, expected);
		
		
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		PatientLogin patientLogin = new PatientLogin(driver);
		patientLogin.login(usernameValue, passwordValue);
		actual = patientLogin.fetchUname().trim();
		expected = usernameValue;
		Assert.assertEquals(actual, expected);
		
	}

}
