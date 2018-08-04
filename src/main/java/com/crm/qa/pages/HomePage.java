package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//td[@class='headertext' and @align='left']/font[@color='#64AB23']")
	
	WebElement userName_label;
	
	@FindBy(xpath="//a[@title='Contacts']")
	
	WebElement contacts_link;
	
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement new_contacts_link;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement Deals_link;
	
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement Task_link;
	
	
	//intializing page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
public String VerifyHomePageTitle() {
return driver.getTitle();
}

public boolean VerifycorrectUserName() {
	return userName_label.isDisplayed();
}
public ContactsPage ClickOnContacts() {
	contacts_link.click();
	return new ContactsPage();
}
	public DealPage ClickOnDealsPage() {
		Deals_link.click();
		return new DealPage();
	}
	public TasksPage ClickOnTaskssPage() {
		Deals_link.click();
		return new TasksPage();
	}
	
	public void ClickOnNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement( contacts_link).build().perform();
		 new_contacts_link.click();
		 
	}
}




