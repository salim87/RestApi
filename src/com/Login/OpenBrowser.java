package com.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

	private WebDriver driver;

    @BeforeMethod
    
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver=new FirefoxDriver();
    }

    @Test
    public void test() {
        driver.get("https://www.freecrm.com/");
        System.out.println(driver.getTitle());
    }
    
@AfterMethod
public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    

}
