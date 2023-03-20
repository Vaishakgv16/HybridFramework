package com.testscripts.demoblaze;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.demoblaze.Base;
import com.genericlib.demoblaze.EventList;
@Listeners(EventList.class)
public class AddToCart extends Base {
	@Test
	public void addToCartTest() throws InterruptedException, IOException
	{
		test=extent.createTest("Verify a product can be added to cart");
		test.pass("Logged into DemoBlaze as "+f.getDataFromProperties(propPath,"username"));
		Thread.sleep(3000);
		test.pass("Landed on Homepage");
		cu.waitForElementToBeClickable(driver,cu.getProductDetails(driver, "Samsung galaxy s6"));
		cu.getProductDetails(driver, "Samsung galaxy s6").click();
		test.pass("Navigated to product details page");
		Thread.sleep(3000);
		hp.getAddToCart().click();
		cu.waitForAlertToBePresent(driver);
		cu.handleAlert(driver, "accept");
		test.pass("Handled the alert");
		test.pass("Added the product to cart");
		hp.getCart().click();
		test.pass("Navigated to cart page");
		try {
			cu.findProductInCart(driver, "Samsung galaxy s6");
		}
		catch(NoSuchElementException n)
		{
			Assert.assertTrue(false, "Product has not been added to cart");
		}
		Reporter.log("Added to the Cart",true);
		test.pass("Product has been verified in the cart");
	}
}
