package com.crm.qa.Testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Testutil;

public class HomePageTest extends Testbase {
	LoginPage loginpage;
	HomePage homepage;
	Testutil testutil;
	ContactPage contactpage;
	DealsPage dealpage;
	
	public HomePageTest()
	{
		super();
		// TODO Auto-generated constructor stub
	}	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testutil=new Testutil();
		loginpage=new LoginPage();
		contactpage=new ContactPage();
		dealpage=new DealsPage();
		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		//testutil.switchToFrame();
		
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTest()
	{	
		String homepagetitle=homepage.verifyHomePagetitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Homepage title is not matched");	
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() 
	{
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyusername());
		
	}
	
	@Test(priority=3)
	public void verfiyContactsLinktest() 
	{
		
	   testutil.switchToFrame();
	   contactpage=homepage.clickOnContactlink();
		
		
	}

	@Test(priority=3)
	public void verifyDealLinkTest()
	{
		
		testutil.switchToFrame();
		dealpage=homepage.clickOnDealLink();
		
		
	}

	
	@AfterMethod
	public void teardown()
	{
		
		driver.quit();
		
	}
}
