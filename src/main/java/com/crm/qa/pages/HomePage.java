package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.Testbase;

public class HomePage extends Testbase {
	
	@FindBy(xpath="//td[contains(text(), 'User: Demo User')]")
	@CacheLookup
	WebElement UserNamelabel;
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactlink;
	@FindBy(xpath = "//*[@id='navmenu']/ul/li[4]/ul/li[1]/a")
	WebElement newContactLink;
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement Deallink;

	public HomePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyusername()
	{
		return UserNamelabel.isDisplayed();
		
	}
	
	public String verifyHomePagetitle()
	{
		
		return driver.getTitle();
		
	}
	
	public ContactPage clickOnContactlink()
	{
		contactlink.click();
		return new ContactPage();
		
	}
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactlink).perform();
		newContactLink.click();
	}

     public DealsPage clickOnDealLink()
      {
	
        Deallink.click();
        return new DealsPage();

}
	
	
}
