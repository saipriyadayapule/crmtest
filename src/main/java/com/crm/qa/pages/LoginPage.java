package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	//pagefactory-OR
	
	

	@FindBy(name="username")
	WebElement username; 
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login_button;
	
	@FindBy(xpath="//button[contains(text,'Sign Up']")
	WebElement signup_button;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	//intializing the pageobjects
	public LoginPage() {
	
				PageFactory.initElements(driver,this);
	}

	
	
	
	//Actions 
public String  validateLoginPageTitle() {
	return driver.getTitle();
}

public boolean validatecrmimage() {
	return crmlogo.isDisplayed();
}

public HomePage login(String un, String pwd) {
	
	username.sendKeys(un);
	password.sendKeys(pwd);
	login_button.submit();
	return new HomePage();
}
}


