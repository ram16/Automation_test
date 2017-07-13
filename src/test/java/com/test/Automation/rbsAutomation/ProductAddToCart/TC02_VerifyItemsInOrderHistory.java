package com.test.Automation.rbsAutomation.ProductAddToCart;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.Automation.rbsAutomation.testBase.TestBase;
import com.test.Automation.rbsAutomation.uiActions.HomePage;
import com.test.Automation.rbsAutomation.uiActions.MyAccountPage;
import com.test.Automation.rbsAutomation.uiActions.PersonalInformationPage;

public class TC02_VerifyItemsInOrderHistory extends TestBase {

	HomePage homepage;
	PersonalInformationPage personalInformationPage;
	MyAccountPage myAccountPage;

	@BeforeTest
	public void setup() {
		init();
	}

	@Test
	public void VerifyItemsInOrderHistory() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.loginToApplication("panjala.ramu16@gmail.com", "password");
		Assert.assertEquals(homepage.getAuthenticationpassed(),
				"Welcome to your account. Here you can manage all of your personal information and orders.");
		myAccountPage = new MyAccountPage(driver);
		myAccountPage.MyAccountPageUpdate();
		personalInformationPage = new PersonalInformationPage(driver);
		personalInformationPage.UpdatePersonalInformation("Panjala", "password321", "password3", "password3");
		Assert.assertEquals(personalInformationPage.Message(),
				"Your personal information has been successfully updated.");

	}
}
