package com.crm.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Testutil;

public class ContactPageTest extends Testbase {
	LoginPage loginpage;
	HomePage homepage;
	Testutil testutil;
	ContactPage contactpage;
	String  SheetName= "Contacts";
	

	public ContactPageTest() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		testutil=new Testutil();
		loginpage=new LoginPage();
		contactpage=new ContactPage();
		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		testutil.switchToFrame();
		//testutil.switchToFrame();
		homepage.clickOnNewContactLink();
		
		
	
		
		
		
	}
	
	
	
	@Test(priority=1)
	public void verifyContactLabelTest()
	{
		contactpage=homepage.clickOnContactlink();
		Assert.assertTrue(contactpage.verifyContactLabel(), "Contact labal is not matched");
		
	}
	
@DataProvider
public Object[][] getCrmTestData()
{
	Object data[][]=Testutil.getTestData("Contacts");
	return data;

}


@Test(priority=2, dataProvider="getCrmTestData")
public void validateCreateNewContact(String firstname, String lastname, String companyname)
	{
		contactpage.createNewContact(firstname, lastname, companyname);;
	}
	

	
	@AfterMethod
	public void teardown()
	{
		
		driver.quit();
		
	}
}
