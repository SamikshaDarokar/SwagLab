package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utility.ReadData;

public class CheckoutStepOne extends TestBase
{
	Cart cart = new Cart();
	// object repository
		@FindBy(xpath = "//input[@id='first-name']") private WebElement firstNameTxt;
		@FindBy(xpath = "//input[@id='last-name']") private WebElement lastNameTxt;
		@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalCodeTxt;
		@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;
		@FindBy(xpath = "//button[@id='cancel']") private WebElement cancleBtn;
		@FindBy(xpath = "//span[text()='Checkout: Your Information']") private WebElement checkoutYourInfo;
		
		//Error msg element
		@FindBy(xpath = "//h3[text()='Error: First Name is required']']") private WebElement firstNameErrMsg;
		@FindBy(xpath = "//h3[text()='Error: Last Name is required']']") private WebElement lastNameErrMsg;
		@FindBy(xpath = "//h3[text()='Error: Postal Code is required']']") private WebElement postalCodeErrMsg;
		
		@FindBy(xpath ="//span[@class='shopping_cart_badge']") private WebElement cartCount;
		
		//Constructor
		public CheckoutStepOne()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Method
		public String verifyTitleOfCheckoutStep1Page()
		{
			return checkoutYourInfo.getText();
			
		}
		public String verifyURLOfCheckoutPage()
		{
			return driver.getCurrentUrl();
			
		}
		public String verifyTitleOfCheckoutPage()
		{
			return driver.getTitle();
			
		}
		
		public String fillUpdetailsToContinue() throws IOException, InterruptedException
		{
			firstNameTxt.sendKeys(ReadData.readPropertyFile("FirstName"));
			lastNameTxt.sendKeys(ReadData.readPropertyFile("LastName"));
			postalCodeTxt.sendKeys(ReadData.readPropertyFile("PostalCode"));
			continueBtn.click();
			return driver.getCurrentUrl();	
		}
		
		public String firstNameIsEmptyErrMsg()
		{
			lastNameTxt.sendKeys("Darokar");
			postalCodeTxt.sendKeys("3523634");
			continueBtn.click();
			return firstNameErrMsg.getText();
			
		}
		
		public String lastNameIsEmptyErrMsg()
		{
			firstNameTxt.sendKeys("Sam");
			postalCodeTxt.sendKeys("3523634");
			continueBtn.click();
			return lastNameErrMsg.getText();
			
		}
		
		public String postalCodeIsEmptyErrMsg()
		{
			firstNameTxt.sendKeys("Sam");
			lastNameTxt.sendKeys("Darokar");
			continueBtn.click();
			return postalCodeErrMsg.getText();
		}
		
		public String AllFieldEmptyErrMsg()
		{
			continueBtn.click();
			return firstNameErrMsg.getText();
			
		}
		public String enterAllfield()
		{
			firstNameTxt.sendKeys("Sam");
			lastNameTxt.sendKeys("Darokar");
			postalCodeTxt.sendKeys("3523634");
			continueBtn.click();
			return driver.getCurrentUrl();
		}
		
		
}
