package org.iit.mmp.patientmodule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	 HashMap<String,String> hMap = new HashMap<String,String>();
	Random rnd = new Random();
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public HashMap<String, String> registerPatient(String uname,String pword)  
	{
		 	WebElement stateTxtField = driver.findElement(By.id("state"));
		stateTxtField.sendKeys("New York");
		hMap.put("state", stateTxtField.getAttribute("value"));
		
		WebElement cityTxtField = driver.findElement(By.id("city"));
		cityTxtField.sendKeys("seattle");
		hMap.put("city", cityTxtField.getAttribute("value"));
		
		WebElement addressTxtField = driver.findElement(By.id("address"));
		addressTxtField.sendKeys("10 street");
		hMap.put("address", addressTxtField.getAttribute("value"));
		
		WebElement zipcodeTxtField = driver.findElement(By.id("zipcode"));
		long zipValue = 10000+rnd.nextInt(90000);
		zipcodeTxtField.sendKeys(""+zipValue);
		hMap.put("zipcode", zipcodeTxtField.getAttribute("value"));
		
		WebElement ageTxtField = driver.findElement(By.id("age"));
		long ageValue = 10+rnd.nextInt(90);
		ageTxtField.sendKeys(""+ageValue); 
		hMap.put("age", ageTxtField.getAttribute("value"));
		
		WebElement heightTxtField = driver.findElement(By.id("height"));
		heightTxtField.sendKeys("50");
		hMap.put("height", heightTxtField.getAttribute("value"));
		
		WebElement weightTxtField = driver.findElement(By.id("weight"));
		weightTxtField.sendKeys("50");
		hMap.put("weight", weightTxtField.getAttribute("value"));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		Date d = new Date();
	 
		
		WebElement datePickerTxtField = driver.findElement(By.id("datepicker"));
		datePickerTxtField.sendKeys(sdf.format(d));
		hMap.put("datepicker", datePickerTxtField.getAttribute("value"));
		
	
		WebElement firstnameTxtField = driver.findElement(By.id("firstname"));
		String fNameValue = "AutotestFN" +  (char) (65+rnd.nextInt(26));
		firstnameTxtField.sendKeys(fNameValue);
		hMap.put("firstname", firstnameTxtField.getAttribute("value"));
		
		
		WebElement lastnameTxtField = driver.findElement(By.id("lastname"));
		String LNameValue = "testLN" +  (char) (65+rnd.nextInt(26));
		lastnameTxtField.sendKeys(LNameValue);
		hMap.put("lastname", lastnameTxtField.getAttribute("value"));
		
		
		
		WebElement emailTxtField = driver.findElement(By.id("email"));
		String emailValue = "testEmail" +10+rnd.nextInt(90)+  (char) (65+rnd.nextInt(26))+"@gmail.com";
		emailTxtField.sendKeys(emailValue );
		hMap.put("email", emailTxtField.getAttribute("value"));
		
		WebElement usernameTxtField = driver.findElement(By.id("username"));
		 
		usernameTxtField.sendKeys(uname);
		hMap.put("username", usernameTxtField.getAttribute("value"));
		
		WebElement passwordTxtField = driver.findElement(By.id("password"));
	 
		passwordTxtField.sendKeys(pword);
		hMap.put("password", passwordTxtField.getAttribute("value"));
		
		WebElement confirmpasswordTxtField = driver.findElement(By.id("confirmpassword"));
		confirmpasswordTxtField.sendKeys(pword);
		hMap.put("confirmpassword", confirmpasswordTxtField.getAttribute("value"));
		
		Select select = new Select(driver.findElement(By.id("security")));
		select.selectByVisibleText("what is your best friend name");
		
		WebElement answerTxtField = driver.findElement(By.id("answer"));
		answerTxtField.sendKeys(uname);
		hMap.put("answer", answerTxtField.getAttribute("value"));
		
	 
		WebElement ssnTxtField = driver.findElement(By.id("ssn"));
		long ssnValue = 100000000+rnd.nextInt(900000000);
		ssnTxtField.sendKeys(""+ssnValue);
		hMap.put("ssn", ssnTxtField.getAttribute("value"));
		
		WebElement licenseTxtField = driver.findElement(By.id("license"));
		licenseTxtField.sendKeys("12345678");
		System.out.println("License Value:: "+ licenseTxtField.getAttribute("value"));
		hMap.put("license", licenseTxtField.getAttribute("value"));
		
		driver.findElement(By.name("register")).click();
		
		
		//input[@name='register']
		
		Alert alrt = driver.switchTo().alert();
		String successMsg = alrt.getText();
		hMap.put("successMsg", successMsg);
		alrt.accept();
		
		return hMap;
		
		
		
		
		
		
		
	}
}
