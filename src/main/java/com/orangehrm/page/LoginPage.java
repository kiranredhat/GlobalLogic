package com.orangehrm.page;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
		List<String> ls=new ArrayList<String>();
		while(itr.hasNext())
		{
			String values=itr.next();
			if(!mywindowHandles.contains(values))
			{
				dr.switchTo().window(values);
				String title=dr.getTitle();
				if(title.equals("OrangeHRM Inc - YouTube") || title.equals("OrangeHRM Inc. (@orangehrm) | Twitter") || title.equals("OrangeHRM - World's Most Popular Opensource HRIS - Home | Facebook")|| title.equals("LinkedIn"))
				{  
					System.out.println("Success: " +title);
				}
				else
				{
					assertEquals("Title match failed", title);
				}							
			}		
		}
		
		dr.switchTo().window(mywindowHandles);
		System.out.println(dr.getTitle());
		return this.isPageLoaded();
	}
	
	public HomePage loginSuccessDP(String strUserName, String strPassword) {
		elmUserName.sendKeys(strUserName);
		elmPassword.sendKeys(strPassword);
		elmLogin.click();		
		return new HomePage().verifywelcomelink();
	}
	
	public HomePage loginSuccess()
	{
		elmUserName.sendKeys("kiran");
		elmPassword.sendKeys("kiran");
		elmLogin.click();		
		return new HomePage().isPageLoaded();
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
	
	public LoginPage verifyFieldsLength() {
//		Selenium 3
		System.out.println("===========================Selenium 3================================================");

		Dimension loginButtonDim=elmLogin.getSize();
		System.out.println(loginButtonDim.getHeight());
		System.out.println(loginButtonDim.getWidth());	
		
		Point p=elmLogin.getLocation();
		System.out.println(p.getX());
		System.out.println(p.getY());
		
//		Selenium 4
		System.out.println("===========================Selenium 4================================================");
		Rectangle loginButtonRec=elmLogin.getRect();	
		System.out.println("VerifyLoginButtons");
		Assert.assertEquals(loginButtonRec.getHeight(), 26);
		Assert.assertEquals(loginButtonRec.getWidth(), 94);
		Assert.assertEquals(loginButtonRec.getX(), 632);
		Assert.assertEquals(loginButtonRec.getY(), 427);		
		return this.isPageLoaded();
}
	

	public LoginPage test() {
		elmUserName.sendKeys("test");
		elmPassword.sendKeys("test");
		elmLogin.click();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.isPageLoaded();
	}
}
