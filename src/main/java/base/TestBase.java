package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadData;

public class TestBase {
	
	//public ExtentReports report=Extent_Reports.getReportInstance();
	//public ExtentTest logger;
	public static WebDriver driver;
	public void initialization() throws IOException
	{
		String browser= ReadData.readPropertyFile("Browser");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver();
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver();
			driver=new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("safari"))
		{
			WebDriverManager.safaridriver();
			driver=new SafariDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(ReadData.readPropertyFile("URL"));
		
	}
	
	
}

