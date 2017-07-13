package com.test.Automation.rbsAutomation.ProductAddToCart;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.Automation.rbsAutomation.testBase.TestBase;
import com.test.Automation.rbsAutomation.uiActions.HomePage;
import com.test.Automation.rbsAutomation.uiActions.ProductDetailsPage;;

public class TC01_VerifyAddToCart extends TestBase {

	HomePage homepage;
	ProductDetailsPage productDetailsPage;

	@BeforeTest
	public void setup() {
		init();
	}

	@Test
	public void VerifyAddToCart() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.loginToApplication("frameworkbuild@gmail.com", "Framework1!");
		Assert.assertEquals(homepage.getAuthenticationpassed(),
				"Welcome to your account. Here you can manage all of your personal information and orders.");
		homepage.moveMouseOver(homepage.women);
		homepage.clickOnProductInWomensSection(homepage.tshirts);
		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.selectProdut(productDetailsPage.FadedShortSleeveTshirts);
		productDetailsPage.addToCart();
		productDetailsPage.ShippingcheckboxToClick();
		productDetailsPage.PaymentByWire();
		productDetailsPage.OrderConfirmation();
		Assert.assertEquals(productDetailsPage.getConfirmationOfOrderDone(), "Your order on My Store is complete.");

	}



	@AfterTest
	public void endTest() {
		driver.close();

	}
}