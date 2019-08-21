package testmeapp.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testmeutility.Drivers;

public class scenario5 {
	WebDriver driver;
  @Test
  public void testcart() {
	  driver=Drivers.getDriver("Chrome");
	  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	  
  }
}
