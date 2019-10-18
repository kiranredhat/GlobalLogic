package com.orangehrm.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.common.WebDriverFactory;

public class AdminPage {

	@FindBy(id = "btnAdd")
	WebElement elmAdd;

	public AdminPage() {
		PageFactory.initElements(WebDriverFactory.DR, this);
	}
	
	public AddUserPage naviateToAddUserPage()
	{
		elmAdd.click();
		return new AddUserPage();
	}

}
