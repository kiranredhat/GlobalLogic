package com.orangehrm.common;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.orangehrm.page.LoginPage;

public class BrokenLinks {
	public static String strUrl;
	public static String response;
	public static void brokenLinkVerify(List<WebElement> elmUrl) throws MalformedURLException, IOException {
		for (WebElement url:elmUrl)
		{
			System.out.println(url.getAttribute("href"));
			if(url.getAttribute("href")!=null && ! url.getAttribute("href").contains("javascript"))
			{
				strUrl=url.getAttribute("href");
				HttpURLConnection   connection = (HttpURLConnection)(new URL(strUrl).openConnection());
				connection.connect();
				response=connection.getResponseMessage();
					if(response.equals("Found") || response.equals("Moved Permanently"))
						{
							System.out.println("Got the response as a Found/ Moved Permanently");
						}
					else {
						assertEquals("Found / Move Permanently", response);
						}
							
					
				connection.disconnect();
				System.out.println(strUrl+"--->"+response);

			}
			else
			{
				System.out.println("This is the invalid urls" +response);
			}
		}
	}
}
