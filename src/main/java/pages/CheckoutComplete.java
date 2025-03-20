package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutComplete extends TestBase
{
	@FindBy(xpath = "//span[text()='Checkout: Complete!']") private WebElement checkoutCompleteTxt;
	
	public CheckoutComplete()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyitleOfCompletePage()
	{
		return checkoutCompleteTxt.getText();
		
	}
}
