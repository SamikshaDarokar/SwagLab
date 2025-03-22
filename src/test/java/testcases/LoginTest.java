package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.Login;
import utility.ReadData;

public class LoginTest extends TestBase{
	
	Login lg;
	@BeforeMethod //(alwaysRun = true)
	public void setUp() throws IOException 
	{
		initialization();
		lg=new Login();
	}
	//Data Provider
	@DataProvider(name="ValidationForLogin")
	public Object [][] getData()
    {
		return new Object [][]
				{
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"},
				};
	}
	
	@Test (dataProvider="ValidationForLogin")
	public void verifyMultiCreds(String username, String password)
	{
		SoftAssert sa= new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=lg.verifyMultiCreds(username,password);
		sa.assertEquals(expURL, actURL);
		sa.assertAll();
		//Assert.assertEquals(expURL, actURL); //(hard assert)
	}
	
	@Test  //(groups = "Sanity") //(enabled = false)  (priority = 2)  (dependsOnMethods = "verifyURLOfApplicationTest")
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(0, 1); //https://www.saucedemo.com/inventory.html
		String actURL=lg.loginToApplication();
		Assert.assertEquals(expURL, actURL);
		//Reporter.log("Login Susccesfull="+actURL);
	}
	
	
	@Test //(groups = {"Sanity", "Retest"}, priority = 1) 
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 2); //"https://www.saucedemo.com/";
		String actURL=lg.verifyURLOfApplication();
		Assert.assertEquals(expURL, actURL);
	}
	
	@Test // (groups = "Sanity")//(enabled = true) (priority = 3)
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 3); //Swag Labs
		String actTitle=lg.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	
	@AfterMethod //(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		/*
		 if(ITestResult.FAILURE==it.getStatus())
		{
			Screenshot.Screenshot1(it.getName());
		}
		//report.flush();
		 */
		driver.close();
	}

	
	



}
