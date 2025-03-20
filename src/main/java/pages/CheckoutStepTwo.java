package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutStepTwo extends TestBase
{
	
	@FindBy(xpath = "//span[text()='Checkout: Overview']") private WebElement checkoutOverviewTxt;
	@FindBy(xpath = "//button[@id='finish']") private WebElement finishBtn;
	
	public  CheckoutStepTwo()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitleOfCheckoutStep2Page()
	{
		return checkoutOverviewTxt.getText();
		
	}
	public String clickOnFinishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
	}

}
