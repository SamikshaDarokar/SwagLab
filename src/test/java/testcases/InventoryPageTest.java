package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.InventoryPage;
import pages.Login;
import utility.ReadData;

public class InventoryPageTest extends TestBase
{
	Login lg;
	InventoryPage ip;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		lg=new Login();
		lg.loginToApplication();
		ip=new InventoryPage();
	}
	
		
	@Test (groups = "Sanity")
	public void verifyURLOfAPPlicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL= ReadData.readExcel(1, 1);  //"https://www.saucedemo.com/inventory.html";
		String actURL = ip.verifyURLOfAPPlication();
		Assert.assertEquals(expURL, actURL);
	}
	@Test(groups = "Sanity")
	public void verifyTitleOfAPPlicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(1, 2);//"Swag Labs";
		String actTitle =ip.verifyTitleOfAPPlication();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test (groups = "Sanity")
	public void verifyMenuListTest()
	{
		boolean result=ip.verifySwagLabsAppLogo();
		   Assert.assertEquals(result, true);
		
	}
	@Test(groups = "Retest")
	public void verifySwagLabsAppLogoTest()
	{
	   boolean result=ip.verifySwagLabsAppLogo();
	   Assert.assertEquals(result, true);
	}
	@Test(groups = "Retest")
	public void verifyTitleOfInventoryPageTest()
	{
		String expTitle = "Products";
		String actTitle=ip.verifyTitleOfInventoryPage();
		Assert.assertEquals(expTitle, actTitle);
		
	}
	@Test(groups = "Retest")
	public void verifyAdd6ItemTest() throws EncryptedDocumentException, IOException
	{
		String expCount = ReadData.readExcel(1, 3);//"6";
		String actCount=ip.verifyAdd6Item();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total count Item="+actCount);
	}
	@Test(groups = "Retest")
	public void verifyRemove2ProductTest() throws EncryptedDocumentException, IOException
	{
		String expCount =ReadData.readExcel(1, 4); //"4";
		String actCount=ip.verifyRemove2Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total count Item="+actCount);
	}
	@Test
	public void verifyTwitterLogoTest()
	{
		boolean result = ip.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		
	}
	@Test
	public void verifyFacebookLogoTest()
	{
		boolean result = ip.verifyFacebookLogo();
		Assert.assertEquals(result, true);
		
	}
	@Test
	public void verifyLinkedInLogoTest()
	{
		boolean result = ip.verifyLinkedInLogo();
		Assert.assertEquals(result, true);
		
	}
	@Test
	public void verifyFooterTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt = ReadData.readExcel(1, 5); //"© 2025 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actTxt=ip.verifyFooterTxt();
		Assert.assertEquals(expTxt, actTxt);
		
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowse()
	{
		
		driver.close();
	}
	
}
