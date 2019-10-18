package com.orangehrm.page;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.common.BrokenLinks;
import com.orangehrm.common.WebDriverFactory;
public class LoginPage {
	@FindBy (id="txtUsername") WebElement elmUserName;
	@FindBy (id="txtPassword") WebElement elmPassword;
	@FindBy (id="btnLogin") WebElement elmLogin;
	@FindBy (xpath="//img[@alt='LinkedIn OrangeHRM group']") WebElement elmLinkin;
	@FindBy (xpath="//img[@alt='OrangeHRM on Facebook']") WebElement elmFacebook;
	@FindBy (xpath="//img[@alt='OrangeHRM on twitter']") WebElement elmTwitter;
	@FindBy (xpath="//img[@alt='OrangeHRM on youtube']") WebElement elmYouTube;
	@FindBy (tagName="a") List<WebElement> elmUrl;
	
	private WebDriverWait wt;
	public LoginPage() {
PageFactory.initElements(WebDriverFactory.DR, this); //PageFactory.initElements method is use to initialize elements of the page.
wt=new WebDriverWait(WebDriverFactory.DR, 20);
}
	
	public LoginPage isPageLoaded()
	{
		wt.until(ExpectedConditions.visibilityOf(elmUserName));
		wt.until(ExpectedConditions.visibilityOf(elmPassword));
		wt.until(ExpectedConditions.visibilityOf(elmLogin));
		return this;		
	}
	
	public LoginPage verifyAllLinks() {
		elmLinkin.click();
		elmFacebook.click();
		elmTwitter.click();
		elmYouTube.click();
		WebDriver dr=WebDriverFactory.DR;
		Set<String> windowhandles=dr.getWindowHandles();
		String mywindowHandles=dr.getWindowHandle();
		Iterator <String> itr=windowhandles.iterator();
		while(itr.hasNext())
		{
			String values=itr.next();
			if(!mywindowHandles.contains(values))
			{
				dr.switchTo().window(values);
				String title=dr.getTitle();
				if(title.contains("OrangeHRM Inc - YouTube")) {assertEquals(title, "OrangeHRM Inc - YouTube");}
					
				if(title.contains("OrangeHRM Inc. (@orangehrm) | Twitter")) {assertEquals(title, "OrangeHRM Inc. (@orangehrm) | Twitter");}				
					
				if(title.contains("OrangeHRM - World's Most Popular Opensource HRIS - Home | Facebook")) {	assertEquals(title, "OrangeHRM - World's Most Popular Opensource HRIS - Home | Facebook");}			
					
				if(title.contains("LinkedIn")) {assertEquals(title, "LinkedIn");}	
				else
				{
					
				}
			}		
		}
		dr.switchTo().window(mywindowHandles);
		System.out.println(dr.getTitle());
		return this.isPageLoaded();
	}
	
	public HomePage loginSuccess(String strUserName, String strPassword) {
		elmUserName.sendKeys(strUserName);
		elmPassword.sendKeys(strPassword);
		elmLogin.click();		
		return new HomePage().verifywelcomelink();
	}
	
	public LoginPage loginInvalid(String strUserName, String strPassword) {
		elmUserName.sendKeys(strUserName);
		elmPassword.sendKeys(strPassword);
		elmLogin.click();		
		return this.isPageLoaded();
	}
	
	public LoginPage brokenLinksVerify() throws MalformedURLException, IOException {
		BrokenLinks.brokenLinkVerify(elmUrl);
		return this;
}
}
