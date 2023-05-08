package utility.seleniumutility;


import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
private WebDriver driver=null;
/**
 * This generic method will open the browser with the given url
 * @param browserName
 * @param url
 * @param s
 * @return
 */
public WebDriver openBrowser(String browserName,@Optional String s) {
	switch(browserName)
	{
	case "chrome":
	{
		
		if(s.equalsIgnoreCase("option")) {

			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable notifications");
			 driver=new ChromeDriver(option);
			 break;
		}
		else {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 break;
			
			
		}
		 
	}
	case "firefox":{
		if(s.equalsIgnoreCase("option")) {

			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--disable-notifications");
			 driver=new FirefoxDriver(options);
			 break;
			 }
		else {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 break;
		
			
		}
	}

	case "edge":{
		if(s.equalsIgnoreCase("option")) {
			EdgeOptions options=new EdgeOptions();
			 driver=new EdgeDriver(options);
			 break;
		
		
	}
		else {
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 break;
		
		}
			
		}
	
}
	return driver;
}
public void enterUrl( WebDriver driver,String url) {
	driver.get(url);
}
/**
 * This  method will disable the notification in the browser
 * @param browserName
 * @return
 */
@Deprecated
	public WebDriver openBrowserDisableNotification(String browserName) {
		switch(browserName)
		{
		case "chrome":
		{
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable notifications");
			 driver=new ChromeDriver(option);
			 break;
		}
		case "firefox":{
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--disable-notifications");
			 driver=new FirefoxDriver(options);
			 break;
		}

		case "edge":{
			EdgeOptions options=new EdgeOptions();
			 driver=new EdgeDriver(options);
			 break;
		}
		}
		return driver;
	}

/**
 * This genric method will maximize the browser
 */
public void maximizeBrowser() {
	driver.manage().window().maximize();
}
/**
 * This genric method will close the browser
 */
public void closeBrowser() {
	driver.close();
}
/**
 * This generic method will fetch the current url
 */
public void getUrl() {
	driver.getCurrentUrl();
}
/**
 * This generic method will fetch the title of the window
 * @return 
 */
public String getWindowtitle() {
	return driver.getTitle();
	
}
/**
 * This generic method will navigate the web page to specified url
 * @param url
 */
public void navigateToUrl(String url) {
	driver.navigate().to(url);
}
/**
 * This generic method will click on back button
 */
public void back() {
	driver.navigate().back();
	
}
/**
 * This generic method will click on forward button
 */
public void forward() {
	driver.navigate().forward();
}
/**
 * This generic method will refresh the web page
 */
public void refresh() {
	driver.navigate().refresh();
}
public List<String> brokenLinks() {
	List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	List<String> urls=new ArrayList<String>();
	List<String>brokenUrl=new ArrayList<String>();
	for(WebElement link:allLinks) {
		String url=link.getAttribute("href");
		urls.add(url);
	}
	
	for(String u:urls) {
		try {
			URL uRl=new URL(u);
			URLConnection urlConnection=uRl.openConnection();
			HttpURLConnection httpURLConnection=(HttpURLConnection)urlConnection;	
			int statusCode=	httpURLConnection.getResponseCode();
			String message=httpURLConnection.getResponseMessage();
			if(statusCode!=200) {
				brokenUrl.add(u+message);
			}
		}
			
		 catch (Exception e) {
			brokenUrl.add(u);
		}
	}
	return brokenUrl;
}


}
