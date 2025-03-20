package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart extends TestBase 
{	
	InventoryPage ip;
	//Object repository
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkoutBtn;
	@FindBy(xpath = "//button[@id='continue-shopping']") private WebElement continueShoppingBtn;
	@FindBy(xpath ="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath ="//span[text()='Your Cart']") private WebElement yourCartText;
	
	//Remove product from the cart
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")private WebElement removeBackpackItem;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")private WebElement removeBikeLightItem;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement removeBoltTShirtItem;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']")private WebElement removeFleeceJacketItem;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']")private WebElement removeOnesieItem;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']")private WebElement removeTShirtItem;
	

	//Constructor
	public Cart()
	{
		PageFactory.initElements(driver,this);
	}
	
	//Methods
	public  String verifyTitleOfCartPage()
	{
		
		return yourCartText.getText();
	}
	
	public  String verifyCheckoutBtn()
	{
		checkoutBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifycontinueShoppingBtn()
	{
		continueShoppingBtn.click();
		return driver.getCurrentUrl();
	}
	public String removeProductFromCart()
	{
		removeBackpackItem.click();
		removeBikeLightItem.click();
		removeOnesieItem.click();
		return cartCount.getText();
	}
	
	public void clickOnCheckoutBtn()
	{
		checkoutBtn.click();
	}
	
	public String Remove3ProductfromCartAndRemanintContinueOnChecoutStepOne()
	{
		removeProductFromCart();
		return cartCount.getText();
	}
	
}
