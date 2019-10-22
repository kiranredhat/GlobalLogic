package com.orangehrm.test;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.orangehrm.common.BaseSelenium;
import com.orangehrm.common.Testlistner;
import com.orangehrm.common.WebDriverFactory;
import com.orangehrm.page.AddEmployeePage;
import com.orangehrm.page.AddEmployeePage;
import com.orangehrm.page.LoginPage;


public class LoginTest extends BaseSelenium {
	
//To verify login with valid credentials
@Test (priority=1, dataProvider=("excelDataProvider"))
public void verifyLoginSuccessfull(String strUserName, String strPassword) 
{
	LoginPage lp=new LoginPage();
	lp.loginSuccessDP(strUserName, strPassword);
	}

//To verify login with Invalid credentials
@Test (priority=2, dataProvider=("excelDataProvider"))
public void verifyLoginInvalidData(String strUserName, String strPassword) {
	LoginPage lp1=new LoginPage();
	lp1.loginInvalid(strUserName, strPassword);
	}

//To verify broken links
@Test (priority=3)
public void verifyBrokenLinks() throws MalformedURLException, IOException {
	LoginPage lp=new LoginPage();
	lp.brokenLinksVerify();
	}
 
//To verify Social Media Link
@Test (priority=3)
public void verifySocialMedialink()
{
	LoginPage lp=new LoginPage();
	lp.verifyAllLinks();
}

@Test
public void verifyFieldsLength()
{
	LoginPage lp=new LoginPage();
	lp.verifyFieldsLength();			
}

@Test
public void takeScreenShot()
{
	LoginPage lp=new LoginPage();
//	lp.takeScreenshot();
}
@Test
public void test()
{
	LoginPage lp=new LoginPage();
	lp.test();
}

}