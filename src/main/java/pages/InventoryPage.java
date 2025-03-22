package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utility.HandleDropDownList;

public class InventoryPage extends TestBase 
{
	//Object Repository
		@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement menuList;
		@FindBy(xpath ="//div[@class='app_logo']") private WebElement swagLabsAppLogo;
		@FindBy(xpath ="//a[@class='shopping_cart_link']") private WebElement cartIcon;
		@FindBy(xpath ="//span[@class='shopping_cart_badge']") private WebElement cartCount;
		@FindBy(xpath ="//span[@class='title']") private WebElement productTitleText;
		@FindBy(xpath ="//select[@class='product_sort_container']") private WebElement dropDownListBox;
		//Add product to cart
		@FindBy(xpath ="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackItem;
		@FindBy(xpath ="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightItem;
		@FindBy(xpath ="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTShirtItem;
		@FindBy(xpath ="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketItem;
		@FindBy(xpath ="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieItem;
		@FindBy(xpath ="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement tShirtItem;
		//Remove product from the cart
		@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")private WebElement removeBackpackItem;
		@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")private WebElement removeBikeLightItem;
		@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement removeBoltTShirtItem;
		@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']")private WebElement removeFleeceJacketItem;
		@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']")private WebElement removeOnesieItem;
		@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']")private WebElement removeTShirtItem;
		
		@FindBy(xpath ="//a[text()='Twitter']") private WebElement twitterLogo;
		@FindBy(xpath ="//a[text()='Facebook']") private WebElement faceBookLogo;
		@FindBy(xpath ="//a[text()='LinkedIn']") private WebElement linkedInLogo;
		@FindBy(xpath ="//div[@class='footer_copy']") private WebElement footerTxt;
		
		//menu element
		@FindBy(xpath = "//a[@id='inventory_sidebar_link']") private WebElement allItemLink;
		@FindBy(xpath = "//a[@id='about_sidebar_link']") private WebElement aboutLink;
		@FindBy(xpath = "//a[@id='logout_sidebar_link']") private WebElement logoutLink;
		@FindBy(xpath = "//a[@id='reset_sidebar_link']") private WebElement resetLink;
		//Constructor
		public InventoryPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Methods
		public String verifyURLOfAPPlication()
		{
			return driver.getCurrentUrl();
			
		}
		public String verifyTitleOfAPPlication()
		{
			return driver.getTitle();
		}
		
		public boolean verifyMenuList()
		{
			return menuList.isDisplayed();
			
		}
		
		public boolean verifySwagLabsAppLogo()
		{
			return swagLabsAppLogo.isDisplayed();
			
		}
		public String verifyTitleOfInventoryPage()
		{
			return productTitleText.getText();
			
		}

		public String verifyAdd6Item()
		{
			//Select s= new Select(dropDownListBox);
			//s.selectByVisibleText("Price (high to low)");
			HandleDropDownList.handleListBox(dropDownListBox, "Price (high to low)");
			backpackItem.click();
			bikeLightItem.click();
			boltTShirtItem.click();
			fleeceJacketItem.click();
			onesieItem.click();
			tShirtItem.click();
			return cartCount.getText();	
		}
		public String verifyRemove2Product()
		{
			verifyAdd6Item();
			removeBikeLightItem.click();
			removeFleeceJacketItem.click();
			return cartCount.getText();
		}
		public boolean verifyTwitterLogo()
		{
			return twitterLogo.isDisplayed();
			
		}
		public boolean verifyFacebookLogo()
		{
			return faceBookLogo.isDisplayed();
			
		}
		public boolean verifyLinkedInLogo()
		{
			return linkedInLogo.isDisplayed();
			
		}
		
		public String verifyFooterTxt()
		{
			return footerTxt.getText();
			
		}
		
		public void clickOnCartIcon()
		{
			cartIcon.click();
		}
		
		
}
