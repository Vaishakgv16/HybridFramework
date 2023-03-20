package com.genericlib.demoblaze;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	WebDriverWait wait;
	FileLib f=new FileLib();
	public void mouseHoverAction(WebDriver driver,WebElement ele)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(ele).build().perform();
	}
	public void resolveStaleElementReferenceExce(WebElement ele)
	{
		for (int i = 0; i < 5; i++) {
			try {
				ele.click();
				break;
			}
			catch(StaleElementReferenceException s)
			{
				
			}
			
		}
		
	}
	public WebElement getProductDetails(WebDriver driver,String productName)
	{
	return	driver.findElement(By.xpath("//a[text()='"+productName+"']"));
	}
	public void handleAlert(WebDriver driver,String command)
	{
		Alert alt=driver.switchTo().alert();
		if(command=="accept")
		{
			alt.accept();
		}
		if(command=="dismiss")
		{
			alt.dismiss();
		}
	}
	public WebElement findProductInCart(WebDriver driver,String productName)
	{
		return driver.findElement(By.xpath("//td[text()='"+productName+"']"));
	}
	public void waitForElementToBeClickable(WebDriver driver,WebElement e)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	public void waitForAlertToBePresent(WebDriver driver)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void waitForTheText(WebDriver driver,WebElement e) throws IOException
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(e, "Welcome "+f.getDataFromProperties(Base.propPath, "username")));
	}

}
