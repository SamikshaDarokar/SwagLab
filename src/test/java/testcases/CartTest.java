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
import pages.InventoryPage;
import pages.Login;
import utility.ReadData;
import utility.Screenshot;

public class CartTest extends TestBase 
{
	Login lg;
	InventoryPage ip;
	Cart cart;
	@BeforeMethod
	public void Setup() throws IOException
	{
		initialization();
		lg= new Login();
		lg.loginToApplication();
		ip=new InventoryPage();
		cart= new Cart();
		ip.verifyAdd6Item();
		ip.clickOnCartIcon();
	}
	@Test
	public  void verifyCheckoutBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(2, 1); //"https://www.saucedemo.com/checkout-step-one.html";
		String actURL= cart.verifyCheckoutBtn();
		Assert.assertEquals(expURL, actURL);
	}
	@Test
	public void verifycontinueShoppingBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(2, 2); //"https://www.saucedemo.com/inventory.html";
		String actURL= cart.verifycontinueShoppingBtn();
		Assert.assertEquals(expURL, actURL);
	}
	@Test 
    public void removeProductFromCartTest() throws EncryptedDocumentException, IOException
    {
		
		String expCount=ReadData.readExcel(2, 3); //3;
		String actCount= cart.removeProductFromCart();
		Assert.assertEquals(expCount, actCount);
    }
	
	@Test
	public void Remove3ProductfromCartAndRemanintContinueOnChecoutStepOneTest()
	{
			
		String expCount= "3";
		String actCount= cart.Remove3ProductfromCartAndRemanintContinueOnChecoutStepOne();
		Assert.assertEquals(expCount, actCount);
	}
	@Test
	public void verifyTitleOfCartPageTest()
	{
		String expTitle = "Your Cart";
		String actTitle=cart.verifyTitleOfCartPage();
		Assert.assertEquals(expTitle, actTitle);
		
	}
	
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.Screenshot1(it.getName());
		}
		driver.close();
	}
	
}
