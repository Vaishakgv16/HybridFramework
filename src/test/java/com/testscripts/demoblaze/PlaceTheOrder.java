package com.testscripts.demoblaze;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.demoblaze.Base;
import com.genericlib.demoblaze.EventList;
@Listeners(EventList.class)
public class PlaceTheOrder extends Base {
	@Test
	public void placeTheOrderTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
   // AddToCart act=new AddToCart();
	//act.addToCartTest();
	test=extent.createTest("Verify product can be placed");
	test.pass("Logged into DemoBlaze as "+f.getDataFromProperties(propPath,"username"));
	Thread.sleep(3000);
	test.pass("Landed on Homepage");
	hp.getCart().click();
	test.pass("Navigated to cart page");
	try {
		cu.findProductInCart(driver, "Samsung galaxy s6");
	}
	catch(NoSuchElementException n)
	{
		Assert.assertTrue(false, "Product has not been added to cart");
	}
	hp.getPlaceOrder().click();
	test.pass("Navigated to Place order popup");
	hp.getName().sendKeys(f.getDataFromExcel(excelPath, "Sheet1", 1, 0));
	hp.getCountry().sendKeys(f.getDataFromExcel(excelPath, "Sheet1", 1, 1));
	hp.getCity().sendKeys(f.getDataFromExcel(excelPath, "Sheet1", 1, 2));
	hp.getCreditCard().sendKeys(f.getDataFromExcel(excelPath, "Sheet1", 1, 3));
	hp.getMonth().sendKeys(f.getDataFromExcel(excelPath, "Sheet1", 1, 4));
	hp.getYear().sendKeys(f.getDataFromExcel(excelPath, "Sheet1", 1, 5));
	test.pass("Entered all the details in the Place order popup");
	hp.getPurchase().click();
	test.pass("Confirmation message is displayed");
	hp.getOK().click();
	hp.getClose().click();
	Reporter.log("Order is placed",true);
	test.pass("Successfully placed the order");
	}

}
