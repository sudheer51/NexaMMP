package org.iit.mmp.adminmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminLogin {

    @FindBy(how = How.ID, using = "username")
	WebElement unameTxtField;
    
    WebDriver driver;
    //Constructor for Admin Login
	public AdminLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void loginToAdmin(String uname,String pword)
	{
		unameTxtField.sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.name("admin")).click();
		
	}
	 
}
