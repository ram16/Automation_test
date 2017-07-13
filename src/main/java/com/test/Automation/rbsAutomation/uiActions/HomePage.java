package com.test.Automation.rbsAutomation.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.Automation.rbsAutomation.testBase.TestBase;

public class HomePage extends TestBase {

	public final String tshirts = "T-shirts";

	public final String casualDresses = "Casual Dresses";

	public final String women = "Women";

	WebDriver driver;

	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;

	@FindBy(xpath = ".//*[@id='email']")
	WebElement logInEmailAddress;

	@FindBy(xpath = ".//*[@id='passwd']")
	WebElement loginPassword;

	@FindBy(xpath = ".//*[@id='SubmitLogin']")
	WebElement SubmitButton;

	@FindBy(xpath = ".//*[@id='center_column']/div[1]/ol/li")
	WebElement Authenticationfailed;

	@FindBy(xpath = ".//*[@id='center_column']/p")
	WebElement Authenticationpassed;

	@FindBy(xpath = "//a[contains(@class,'sf-with-ul') and contains(text(),'women')]")
	WebElement Women;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String emailAddress, String password) throws InterruptedException {
		signIn.click();
		Thread.sleep(3000);
		logInEmailAddress.sendKeys(emailAddress);
		loginPassword.sendKeys(password);
		SubmitButton.click();

	}

	public String getAuthenticationpassed() throws InterruptedException {
		Thread.sleep(3000);
		return Authenticationpassed.getText();
	}

	public void moveMouseOver(String Categery) {
		WebElement menu = driver
				.findElement(By.xpath(".//a[contains(@class,'sf-with-ul') and contains(text(),'" + Categery + "')]"));

		Actions builder = new Actions(driver);

		builder.moveToElement(menu).build().perform();

	}

	public void clickOnProductInWomensSection(String Product) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(".//a[contains(@class,'sf-with-ul') and contains(text(),'Women')]/following-sibling::ul/child::li/child::ul/child::li/child::a[contains(text(),'"
						+ Product + "')]")));
		;
		WebElement menuOption = driver.findElement(By
				.xpath(".//a[contains(@class,'sf-with-ul') and contains(text(),'Women')]/following-sibling::ul/child::li/child::ul/child::li/child::a[contains(text(),'"
						+ Product + "')]"));
		menuOption.click();
	}
}
