package com.orangehrm.page;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.common.WebDriverFactory;

public class AdminPage {

	@FindBy(id = "btnAdd")
		WebElement elmAdd;	
	@FindBy(xpath="//select[@id='searchSystemUser_userType']//option")
		List<WebElement> elmuserRoleDropDown;	
	@FindBy (xpath="//a[text()='kirannew']//parent::td[@class='left']//following-sibling::td[contains(@class,'')]//following-sibling::td[text()='kirann manikk gaikwadd']")
		WebElement elmWTValue;
	
	public AdminPage() {
		PageFactory.initElements(WebDriverFactory.DR, this);
	}
	
	public AddUserPage naviateToAddUserPage()
	{
		elmAdd.click();
		return new AddUserPage();
	}
	
	public AdminPage userRoleDropDown()
	{
		for(WebElement str:elmuserRoleDropDown)
		{
			String str1=str.getText();
			if (str1.equals("Al") || str1.equals("Admin") ||str1.equals("ESS"))
			{
				System.out.println(str1);
			}
			else {
				System.out.println("UserRole DropDown doesn't match");
				assertEquals("Failuer", str1);
			}
		}
		return this;
		
	}
	
	public AdminPage adminWebTableverify()
	{
		System.out.println(elmWTValue.getText());
		return this;
		
	}

}
