package com.orangehrm.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.common.WebDriverFactory;

public class AddEmployeePage {

	@FindBy(id = "firstName")
	WebElement elmfirstName;
	@FindBy(id = "lastName")
	WebElement elmlastName;
	@FindBy(id = "btnSave")
	WebElement elmSave;

	public AddEmployeePage() {
		PageFactory.initElements(WebDriverFactory.DR, this);

	}

	public EmployeeListPage addEmployee() {
		elmfirstName.sendKeys("k");
		elmlastName.sendKeys("g");
		elmSave.click();
		return new EmployeeListPage();
	}
}
