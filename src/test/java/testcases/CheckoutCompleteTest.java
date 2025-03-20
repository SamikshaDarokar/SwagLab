package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart;
import pages.CheckoutComplete;
import pages.CheckoutStepOne;
import pages.CheckoutStepTwo;
import pages.InventoryPage;
import pages.Login;

public class CheckoutCompleteTest extends TestBase
{
	Login lg;
	InventoryPage ip;
	Cart cart;
	CheckoutStepOne cso;
	CheckoutStepTwo cst;
	CheckoutComplete cc;
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
    	cst.clickOnFinishBtn();
    	cc= new CheckoutComplete();
    }
    
    @Test
    public void verifyitleOfCompletePageTest()
    {
    	String expTitle="Checkout: Complete!";
    	String actTitle=cc.verifyitleOfCompletePage();
    	Assert.assertEquals(expTitle, actTitle);
    }
    
    @AfterMethod
    public void closeBrowser()
    {
    	driver.close();
    }
    
    

}
