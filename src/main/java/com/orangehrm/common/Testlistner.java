package com.orangehrm.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.internal.InvokedMethod;

public class Testlistner implements IInvokedMethodListener {

	
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		if (arg0.isTestMethod())
			WebDriverFactory.DR.quit();
			//WebDriverFactory.DR.manage().window().maximize();
	}

	
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		if (arg0.isTestMethod()) {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Browser\\chromedriver.exe");
			WebDriverFactory.DR = new ChromeDriver();
			WebDriverFactory.DR.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			WebDriverFactory.DR.get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login"); // Navigate to
																								// URL
			//WebDriverFactory.DR.manage().window().maximize();
			WebDriverFactory.DR.manage().window().maximize();
		}
	}

}
