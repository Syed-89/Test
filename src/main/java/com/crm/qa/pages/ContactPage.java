package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.Testbase;

public class ContactPage extends Testbase {
	
	@FindBy(xpath="//td[contains(text(), 'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	


	public ContactPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		
	}	
	
	public boolean verifyContactLabel()
	{
		
		return contactLabel.isDisplayed(); 
		
	}
	
	public void createNewContact(String ftName, String ltName, String comp)
	{
	
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();


	}
	
	public void Test()
	{
		
		
		
		
	}
}
	
	
