package org.iit.seleniumexample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
    
{
     @Test
     public void validateSearchResults()
     {
    	 WebDriverManager.chromedriver().setup();
    	 WebDriver driver = new ChromeDriver();
    	 driver.get("http://www.google.com");
    	 
     }
}
