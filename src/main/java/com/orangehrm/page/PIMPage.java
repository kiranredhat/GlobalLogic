package com.orangehrm.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.common.WebDriverFactory;

public class PIMPage {

	@FindBy(id = "menu_pim_viewPimModule")
	WebElement elmviewPIMModule;
	@FindBy(id = "btnAdd")
	WebElement elmAdd;
	
	public PIMPage() {
		PageFactory.initElements(WebDriverFactory.DR, this);

}

public AddEmployeePage navigateToAddEmployeePage () {
	elmviewPIMModule.click();
	elmAdd.click();
	return new AddEmployeePage();
}
}
