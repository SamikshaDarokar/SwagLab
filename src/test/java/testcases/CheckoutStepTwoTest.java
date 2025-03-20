package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart;
import pages.CheckoutStepOne;
import pages.CheckoutStepTwo;
import pages.InventoryPage;
import pages.Login;

public class CheckoutStepTwoTest extends TestBase
{ 
	Login lg;
	InventoryPage ip;
	Cart cart;
	CheckoutStepOne cso;
	CheckoutStepTwo cst;
    @BeforeMethod
    public void setUp() throws IOException
    {
    	initialization();
    	lg= new Login();
    	lg.loginToApplication();
    	ip=new InventoryPage();
    	ip.verifyAdd6Item();
    	ip.clickOnCartIcon();
    	
    	cart = new Cart();
    	cart.Remove3ProductfromCartAndRemanintContinueOnChecoutStepOne();
    	cart.clickOnCheckoutBtn();
    	
    	cso= new CheckoutStepOne();
    	cso.enterAllfield();
    	cst= new CheckoutStepTwo();
    }
	
	@Test
	public void verifyTitleOfCheckoutStep2PageTest()
	{
		String expTitle = "Checkout: Overview";
		String actTitle=cst.verifyTitleOfCheckoutStep2Page();
		Assert.assertEquals(expTitle, actTitle);	
	}
	@Test
	public void clickOnFinishBtnTest()
	{
		String expURL = "https://www.saucedemo.com/checkout-complete.html";
		String actURL=cst.clickOnFinishBtn();
		Assert.assertEquals(expURL, actURL);
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
		
	}
}
