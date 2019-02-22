package com.freecrm.test;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class FreeCRMLogin {
	
	Logger log=Logger.getLogger(FreeCRMLogin.class);
		
	WebDriver driver;
	
@BeforeMethod
public void setUp() {
	System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	log.info("Driver is Launched");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://classic.crmpro.com/index.html");
	log.info("URL is launched");
	}

@AfterMethod
public void tearDown() {
	driver.quit();
}
	

@Test(priority=2)
public void loginTest() throws Exception {
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Nareshcrm");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Nareshcrm");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(2000);
	String actual_title=driver.getTitle();
	String expected_title="CRMPRO";
	if (actual_title.equalsIgnoreCase(expected_title)) {
		System.out.println("Correct title is getting displayed");
		}
	else
		System.out.println("Incorrect title is displayed");
}

@Test(priority=1)
public void logoTest() {
	
	WebElement logo_ele=driver.findElement(By.xpath("//a[@class='navbar-brand']/img[@class='img-responsive']"));
	boolean flag=logo_ele.isDisplayed();
	if (flag==true) {
		System.out.println("Correct logo is displayed");
		}
	else
		System.out.println("Incorrect logo is displayed");
}

}
