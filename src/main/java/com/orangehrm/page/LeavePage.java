package com.orangehrm.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.common.WebDriverFactory;

public class LeavePage {

	@FindBy(id = "menu_leave_viewLeaveList")
	WebElement elmviewLeaveListPage;
	
	
	public LeavePage() {
		PageFactory.initElements(WebDriverFactory.DR, this);

}

public LeaveListPage navigateToViewLeaveListPage () {
	elmviewLeaveListPage.click();
	return new LeaveListPage ();
}
}
