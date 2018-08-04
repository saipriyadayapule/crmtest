package com.crm.qa.testcases;


import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage=new LoginPage();
		
		
		}
	
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		
	String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Free CRM software in the cloud powers sales and customer service" );
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		
	 boolean flag=loginPage. validatecrmimage();
	 Assert.assertTrue(flag);
	}
	 
	 
	 @Test(priority=3)
	 public void loginTest() {
	 
		 
		 homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		 
	 
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}

		
	


