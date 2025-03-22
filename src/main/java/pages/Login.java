package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class Login extends TestBase{
	
	//Object repository
	@FindBy(xpath="//input[@id='user-name']") private WebElement userNameTxtBox;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordTxtBox;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;
	
	public Login()
	{
		PageFactory.initElements(driver, this);
	}
	
	// multiple username and password
	public String verifyMultiCreds(String username, String password)
	{
		userNameTxtBox.sendKeys(username);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String loginToApplication() throws IOException
	{
		/*
		logger=report.createTest("Login to Sauce labs Application");
		userNameTxtBox.sendKeys(ReadData.readPropertyFile("UserName"));
		logger.log(Status.INFO, "UserName is entered");
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO, "Password is entered");
		loginBtn.click();
		logger.log(Status.PASS, "Login is successful");
		return driver.getCurrentUrl();
		*/
		userNameTxtBox.sendKeys(ReadData.readPropertyFile("UserName"));
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		loginBtn.click();
		return driver.getCurrentUrl();

	}
	
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}
	

}
