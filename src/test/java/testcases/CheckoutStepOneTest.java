package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart;
import pages.CheckoutStepOne;
import pages.InventoryPage;
import pages.Login;
import utility.ReadData;
import utility.Screenshot;

public class CheckoutStepOneTest extends TestBase
{
	Login lg;
	InventoryPage ip;
	Cart cart;
	CheckoutStepOne cso;
	@BeforeMethod
	public void Setup() throws IOException 
	{
		initialization();
		lg=new Login();
		ip=new InventoryPage();
		cso=new CheckoutStepOne();
		cart = new Cart();
		lg.loginToApplication();
		ip.verifyAdd6Item();
		ip.clickOnCartIcon();
		cart.clickOnCheckoutBtn();
		
	}
	@Test
	public void verifyTitleOfCheckoutStep1PageTest()
	{
		String expTitle = "Checkout: Your Information";
		String actTitle=cso.verifyTitleOfCheckoutStep1Page();
		Assert.assertEquals(expTitle, actTitle);
		
	}
	@Test
	public void verifyURlOfCheckoutpageTest() throws EncryptedDocumentException, IOException
	{
		String expURL= ReadData.readExcel(3, 1); //https://www.saucedemo.com/checkout-step-one.html
		String actURL= cso.verifyURLOfCheckoutPage();
		Assert.assertEquals(expURL, actURL);
	}
	@Test
	public void fillUpdetailsToContinueTest() throws IOException, InterruptedException
	{
		String expURL= ReadData.readExcel(3, 2); //https://www.saucedemo.com/checkout-step-two.html
		String actURL= cso.fillUpdetailsToContinue();
		Assert.assertEquals(expURL, actURL);
	}
	@Test
	public void firstNameIsEmptyErrMsgTest()
	{
		String exp="Error: First Name is required";
		String act= cso.firstNameIsEmptyErrMsg();
		Assert.assertEquals(exp, act);
		
	}
	@Test
	public void lastNameIsEmptyErrMsgTest()
	{
		String exp="Error: Last Name is required"; 
		String act= cso.lastNameIsEmptyErrMsg();
		Assert.assertEquals(exp, act);

	}
	@Test
	public void postalCodeIsEmptyErrMsgTest()
	{
		String exp="Error: Postal Code is required";
		String act= cso.postalCodeIsEmptyErrMsg();
		Assert.assertEquals(exp, act);
	}
	@Test
	public void AllFieldEmptyErrMsgTest()
	{
		String exp="Error: First Name is required";
		String act= cso.firstNameIsEmptyErrMsg();
		Assert.assertEquals(exp, act);

	}
	@Test
	public void enterAllfieldTest()
	{
		String expURL= "https://www.saucedemo.com/checkout-step-two.html";
		String actURL= cso.enterAllfield();
		Assert.assertEquals(expURL, actURL);
	}
	
	@AfterMethod
	public void closeBrowser() throws IOException
	{
		/*
		 if(it.FAILURE==it.getStatus())
		{
			Screenshot.Screenshot1(it.getName());
		}
		*/
		driver.close();
	}

}
