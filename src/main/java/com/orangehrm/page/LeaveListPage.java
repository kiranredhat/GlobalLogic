package com.orangehrm.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.common.WebDriverFactory;

public class LeaveListPage {

	//@FindBy(id = "calFromDate")
	//WebElement elmFromDate;
	
	//@FindBy(id = "calToDate")
	//WebElement elmToDate;
	
	@FindBy(id = "leaveList_chkSearchFilter_checkboxgroup_allcheck")
	WebElement elmAllCheckBox;
	
	@FindBy(id = "leaveList_txtEmployee_empName")
	WebElement elmEmployee;
	
		@FindBy(id = "leaveList_cmbSubunit")
	WebElement elmSubUnit;
	
		@FindBy(id = "btnSearch")
		WebElement elmSearch;
	public LeaveListPage() {
		PageFactory.initElements(WebDriverFactory.DR, this);

}

public LeaveListPage verifyLeaveListSearch () {
	//elmFromDate.sendKeys("2019-01-01");
	//elmToDate.sendKeys("2019-12-31");
	elmAllCheckBox.click();
	
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	elmEmployee.sendKeys("k g");
	
	Select urllist = new Select(elmSubUnit);
	urllist.selectByIndex(0);
	
	elmSearch.click();
	return this;
}
}
