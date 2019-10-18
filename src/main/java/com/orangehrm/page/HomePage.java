package com.orangehrm.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orangehrm.common.WebDriverFactory;

public class HomePage {
	
	@FindBy(id = "welcome")
	WebElement elmWelcomelink;
	
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement elmviewAdminModule;
	
	@FindBy(id = "menu_pim_viewPimModule")
	WebElement elmviewPIMModule;

	@FindBy(id = "menu_leave_viewLeaveModule")
	WebElement elmviewLeaveModule;
	//label[text()='Username']
	
	@FindBy(xpath="//label[text()='Username']")
	WebElement elmUsernameLabel;
	
	private WebDriverWait wt;
	public HomePage() {
		PageFactory.initElements(WebDriverFactory.DR, this);
		wt=new WebDriverWait(WebDriverFactory.DR, 20);
}
	
	public HomePage verifywelcomelink() {
		wt.until(ExpectedConditions.visibilityOf(elmWelcomelink));
		wt.until(ExpectedConditions.visibilityOf(elmviewAdminModule));
		wt.until(ExpectedConditions.visibilityOf(elmviewPIMModule));		
		return this;
	}
		public AdminPage navigateToAdminPage () {
		elmviewAdminModule.click();
		return new AdminPage();
	}
		public PIMPage navigateToPIMPage () {
			elmviewPIMModule.click();
			return new PIMPage();
		}

		public LeavePage navigateToLeavePage () {
			elmviewLeaveModule.click();
			return new LeavePage();
		}
		
		public HomePage isPageLoaded() {			
			wt.until(ExpectedConditions.visibilityOf(elmWelcomelink));
			return this;
		}
}
