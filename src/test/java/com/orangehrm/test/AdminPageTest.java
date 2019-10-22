package com.orangehrm.test;
import org.testng.annotations.Test;
import com.orangehrm.common.BaseSelenium;
import com.orangehrm.page.LoginPage;

public class AdminPageTest extends BaseSelenium{
	
	@Test
	public void verifyDropDown()
	{
		LoginPage lp=new LoginPage();
		lp.loginSuccess()
			.navigateToAdminPage()
				.userRoleDropDown();
	}

	@Test
	public void verifyWebTables()
	{
		LoginPage lp=new LoginPage();
		lp.loginSuccess()
			.navigateToAdminPage()
				.adminWebTableverify();
	}
}
