package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class LoginPage extends Testbase{

	@FindBy(how=How.NAME, using="username")
	WebElement username;
	@FindBy(how=How.NAME, using="password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement Loginbtn;
	@FindBy(xpath="//*[contains(text(),signup)]")
	WebElement button2;
	@FindBy(how=How.CLASS_NAME, using="img-responsive")
	WebElement Crmlogo;
	public LoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateloginpageTitle()
	{
		
		return driver.getTitle();
		
		
	}
	
	public boolean validatelogo()
	{
	
	return Crmlogo.isDisplayed();
		
	}
	
	public HomePage login(String um, String pwd)
	{
		try {
			Thread.sleep(5000);
			username.sendKeys(um);
			password.sendKeys(pwd);
			Loginbtn.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new HomePage();
		
		
		
		
	}

}
