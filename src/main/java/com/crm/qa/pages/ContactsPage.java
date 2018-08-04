package com.crm.qa.pages;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')] ")
	WebElement contacts_label;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	//intializing the pageobjects
		public ContactsPage() {
		
					PageFactory.initElements(driver,this);
		}
		
		public boolean VerifyContactsLabel() {
			return contacts_label.isDisplayed();
		}
		
		public void selectContactsByValue(int num) {
			driver.findElement(By.xpath("//input[@name='contact_id' and @value='"+num+"']")).click();


}
		public void CreateNewContact(String title,String ftname,String ltname, String comp) {
			Select select=new Select(driver.findElement(By.name("title")));
					select.selectByVisibleText(title);
					firstName.sendKeys(ftname);
					lastName.sendKeys(ltname);
					company.sendKeys(comp);
					saveBtn.click();
					
		}
}
