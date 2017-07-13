package com.test.Automation.rbsAutomation.homepage;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.Automation.rbsAutomation.testBase.TestBase;
import com.test.Automation.rbsAutomation.uiActions.HomePage;
import com.test.Automation.rbsAutomation.uiActions.MyAccountPage;
import com.test.Automation.rbsAutomation.uiActions.PersonalInformationPage;

public class TC02_VerifyTheUpdatedPersonalInformation extends TestBase {

	HomePage homepage;
	PersonalInformationPage personalInformationPage;
	MyAccountPage myAccountPage;

	@BeforeTest
	public void setup() {
		init();
	}

	@Test
	public void VerifyTheUpdatedPersonalInformation() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.loginToApplication("frameworkbuild@gmail.com", "Framework1!");
		Assert.assertEquals(homepage.getAuthenticationpassed(),
				"Welcome to your account. Here you can manage all of your personal information and orders.");
		myAccountPage = new MyAccountPage(driver);
		myAccountPage.MyAccountPageUpdate();
		personalInformationPage = new PersonalInformationPage(driver);
		personalInformationPage.UpdatePersonalInformation("Panjala", "Framework1!", "password3", "password3");
		Assert.assertEquals(personalInformationPage.Message(),
				"Your personal information has been successfully updated.");

	}
}
