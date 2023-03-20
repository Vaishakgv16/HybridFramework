package com.genericlib.demoblaze;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.objectrepo.demoblaze.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public  CommonUtils cu=new CommonUtils();
	public FileLib f=new FileLib();
	public static String propPath="src/test/resources/commondata.properties";
	public static String excelPath="src/test/resources/ExcelData.xlsx";
	public static WebDriver driver;
	public static Homepage hp;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	@BeforeTest
	public void configBT() throws IOException
	{
		extent=new ExtentReports();
		spark=new ExtentSparkReporter("Test Report/DemoBlaze.html");
		extent.attachReporter(spark);
		if(f.getDataFromProperties(propPath, "browser").equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		if(f.getDataFromProperties(propPath, "browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("Launched the browser",true);
		driver.get(f.getDataFromProperties(propPath, "URL"));
		Reporter.log("URL is passed",true);
	}
	@BeforeMethod
	public void configBM() throws IOException
	{
		hp=PageFactory.initElements(driver,Homepage.class);
		hp.getLogin().click();
		hp.getUsername().sendKeys(f.getDataFromProperties(propPath, "username"));
		hp.getPassword().sendKeys(f.getDataFromProperties(propPath, "password"));
		hp.getLoginbutton().click();
		cu.waitForTheText(driver, hp.getVerifyUN());
		boolean VerifyUserName=hp.getVerifyUN().getText().contains(f.getDataFromProperties(propPath, "username"));
		Assert.assertEquals(VerifyUserName,true);
		Reporter.log("Logged in as "+f.getDataFromProperties(propPath,"username"),true);
			}
		
		
		
	
	@AfterMethod
	public void configAM()
	{
		
		cu.waitForElementToBeClickable(driver, hp.getLogout());
		hp.getLogout().click();
		Reporter.log("Logged out",true);
		test.pass("Logged out from the application");
		
	}
	@AfterTest
	public void configAT()
	{
		driver.quit();
		Reporter.log("Closed the browser",true);
		test.pass("Closed the browser");
		extent.flush();
	}
	
	
	

}
