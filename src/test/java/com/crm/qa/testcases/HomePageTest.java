package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;




public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		}
	
	@Test(priority=1)
	public void VerifyHomePageTitleTest() {
		String homePageTitle=homePage.VerifyHomePageTitle();
Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not found");
	}
	
	@Test(priority=2)
	public void VerifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.VerifycorrectUserName());
	}
	@Test(priority=3)
	public void VerifyClickOnContactsTest() {
	testUtil.switchToFrame();
	contactsPage=homePage.ClickOnContacts();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
