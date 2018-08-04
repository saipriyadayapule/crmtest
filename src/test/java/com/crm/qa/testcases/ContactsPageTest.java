package com.crm.qa.testcases;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//import com.crm.qa.util.TestDataForContacts;
import com.crm.qa.util.TestUtil;




public class ContactsPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="contacts";
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.ClickOnContacts();
		}
	
	@Test(priority=1)
	public void VerifyContactsPageLabelTest() {
		boolean flags=contactsPage.VerifyContactsLabel();
		Assert.assertTrue(flags,"contact label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByValue(52292986);
	}
	@Test(priority=3)
	
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByValue(52292988);
		contactsPage.selectContactsByValue(52297450);
	}
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void ValidateCreateNewContactTest(String title,String firstName, String lastName,String company) {
		homePage.ClickOnNewContactLink();
		contactsPage.CreateNewContact(title,firstName,lastName,company);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
