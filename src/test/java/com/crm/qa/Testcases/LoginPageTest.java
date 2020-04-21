package com.crm.qa.Testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.Testbase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends Testbase {

	LoginPage login;
	HomePage homepage;
	public LoginPageTest() {
		super();
		// TODO Auto-generated constructor stub
				
}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		login=new LoginPage();
	}
	
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		
		String title=login.validateloginpageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");	
		
	}
	
	@Test(priority=2)
	public void CrmlogoTest()
	{
		
		boolean flag=login.validatelogo();
		Assert.assertTrue(flag);
		
	}

	@Test(priority=3)
	public void logintest()
	{
		
		homepage=login.login(pro.getProperty("username"), pro.getProperty("password"));
		
	}
	
	@AfterMethod
	public void afterdown()
	{
		driver.quit();
	}
}
