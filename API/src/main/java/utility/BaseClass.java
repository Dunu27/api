package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import utility.externalFileUtility.ExcelUtility;
import utility.externalFileUtility.JdbcUtility;
import utility.externalFileUtility.PropertyUtility;
import utility.javaUtility.RandomNumberUtility;
import utility.seleniumutility.WebDriverUtility;

public class BaseClass {
public WebDriver driver;
public ExcelUtility excelUtility=new ExcelUtility();
public JdbcUtility jdbcUtility=new JdbcUtility();
public RandomNumberUtility randomNumberUtility=new RandomNumberUtility();
public WebDriverUtility webDriverUtility =new WebDriverUtility();
public PropertyUtility propertyUtility=new PropertyUtility();

@BeforeSuite
public void connectToDb() {
	jdbcUtility.registerDriverAndCreateStatement();
}
@BeforeClass
public void launchBrowser() {
	String browser=propertyUtility.getPropertyData("browser");
	String url=propertyUtility.getPropertyData("url");
	if(browser.equalsIgnoreCase("chrome"))
		driver=new ChromeDriver();
	else if(browser.equalsIgnoreCase("firefox"))
		driver=new FirefoxDriver();
	else if(browser.equalsIgnoreCase("edge"))
		driver=new EdgeDriver();
}


}
