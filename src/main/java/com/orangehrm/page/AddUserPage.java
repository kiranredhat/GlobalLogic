package com.orangehrm.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.common.WebDriverFactory;

public class AddUserPage {

	@FindBy(id = "systemUser_userType")
	WebElement usrRole;
	@FindBy(id = "systemUser_employeeName_empName")
	WebElement elmEmpName;
	@FindBy(id = "systemUser_userName")
	WebElement elmUserName;
	@FindBy(id = "systemUser_password")
	WebElement elmPasswd;
	@FindBy(id = "systemUser_confirmPassword")
	WebElement elmConfirmPasswd;
	@FindBy(id = "btnSave")
	WebElement elmSave;

	public AddUserPage() {
		PageFactory.initElements(WebDriverFactory.DR, this);

	}

	public AdminPage addUser() {
		Select urllist = new Select(usrRole);
		urllist.selectByIndex(0);
		elmEmpName.sendKeys("kirann manikk gaikwadd"+ System.currentTimeMillis());
		elmUserName.sendKeys("kirann");
		elmPasswd.sendKeys("admin123");
		elmConfirmPasswd.sendKeys("admin123");
		elmSave.click();
		return new AdminPage();
	}
}
