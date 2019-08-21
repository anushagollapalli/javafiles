package testmeutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Drivers {
	public static WebDriver getDriver(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome")) {
			
		
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\training_h2a.06.15\\Downloads\\SeleniumBroDrivers\\SeleniumBroDrivers\\chromedriver.exe");
		return new ChromeDriver();
		}
		
		
	
	else if(browser.equalsIgnoreCase("ff")) {
		System.setProperty("webdriver.gecko.driver","C:\\\\Users\\\\training_h2a.06.15\\\\Downloads\\\\SeleniumBroDrivers\\\\SeleniumBroDrivers\\\\geckodriver.exe");
	return new FirefoxDriver();
	}
	
	else if(browser.equalsIgnoreCase("ie"))
	{
		System.setProperty("webdriver.ie.driver","C:\\\\Users\\\\training_h2a.06.15\\\\Downloads\\\\SeleniumBroDrivers\\\\SeleniumBroDrivers\\\\iedriver.exe");

		return new InternetExplorerDriver();
	}
	else
	{
		
	
			return null;
		}
		
	}}

