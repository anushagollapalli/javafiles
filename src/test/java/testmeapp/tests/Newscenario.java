package testmeapp.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testmeutility.Drivers;

public class Newscenario {
	WebDriver driver;
	 
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

@BeforeTest
	 public void startReportBeforeTest()
	  {
	     htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports/"+new SimpleDateFormat("hh-mm-ss-dd-MM-yyyy").format(new Date())+".html");
		 extent=new ExtentReports();
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Host Name", "GFT NextGen Testing");
		 extent.setSystemInfo("Environment", "Selenium automation Testing");
		 extent.setSystemInfo("User Name", "anu");
		 htmlReporter.config().setDocumentTitle("Selenium Testing");
		 htmlReporter.config().setReportName("Test Me App Report");
		 htmlReporter.config().setTheme(Theme.STANDARD);
		 driver=Drivers.getDriver("Chrome"); 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		 //driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	  }  

 @Test(priority=1)
	  public void testRegistration() throws Exception 
       {
	     logger=extent.createTest("testregistration");
		 //signup
		 driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
		 driver.findElement(By .name("userName")).sendKeys("anushaaa");
		 Actions a=new Actions(driver);
		 a.sendKeys(Keys.TAB).perform();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		 String actual="Available";
		 String expected=driver.findElement(By .xpath("//*[@id=\"err\"]")).getText();
		 System.out.println(expected);
		 a.sendKeys(Keys.ENTER).perform();
		 Assert.assertEquals(expected,actual);
		 driver.findElement(By .name("firstName")).sendKeys("gollapalli");
		 driver.findElement(By .name("lastName")).sendKeys("anusri");
		 driver.findElement(By .name("password")).sendKeys("passkey");
		 driver.findElement(By .name("confirmPassword")).sendKeys("passkey");
		 driver.findElement(By .xpath("//*[@id=\"gender\"]")).click();
		 driver.findElement(By .name("emailAddress")).sendKeys("anush.1998@gmail.com");
		 driver.findElement(By .name("mobileNumber")).sendKeys("9059983395");
	     driver.findElement(By .name("dob")).sendKeys("08/02/1998");
	     driver.findElement(By .name("address")).sendKeys("Hyderabad");
	     Select s=new Select(driver.findElement(By .name("securityQuestion")));
	     s.selectByValue("411010");
	       driver.findElement(By .name("answer")).sendKeys("warangal");
	     driver.findElement(By .name("Submit")).click(); 
		 logger.log(Status.PASS,MarkupHelper.createLabel("Testregistration is passed",ExtentColor.GREEN));
	   }
	 
 @Test(priority=2)
	  public void testLogin() 
       {
	      logger=extent.createTest("testlogin");
		  driver.findElement(By .name("userName")).sendKeys("lalitha");
		  driver.findElement(By .name("password")).sendKeys("password123");
		  driver.findElement(By .name("Login")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		  String expected=driver.findElement(By .linkText("SignOut")).getText();
		  System.out.println(expected);
		  String actual="SignOut";
		  Assert.assertEquals(expected,actual);
	      logger.log(Status.PASS,MarkupHelper.createLabel("Testlogin is passed",ExtentColor.GREEN));	
	   }
	  
 @Test(priority=3)
	  public void testCart() throws Exception 
       {
	      logger=extent.createTest("testcart");
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      driver.findElement(By .xpath("//*[@id=\"menu3\"]/li[2]/a/span")).click();
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      driver.findElement(By .xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span")).click();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(By .xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span")).click();
		  //addtocart
		  driver.findElement(By .xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		  //cart
		  driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
		  //verification
		  String expected=driver.findElement(By .xpath("//*[@id=\"cart\"]/tbody/tr/td[1]/div/div/h4")).getText();
		  String actual="Headphone";
		  Assert.assertEquals(expected,actual);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //checkout
		  driver.findElement(By .xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
		  logger.log(Status.PASS,MarkupHelper.createLabel("Testpayment is passed",ExtentColor.GREEN));
	   }
	  
 @Test(priority=4)
    public void testPayment() throws Exception
     {
	   logger=extent.createTest("testpayment");
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   //proceedtopay
	   driver.findElement(By .xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   //click on andhrabank
	   driver.findElement(By .xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
	   //click on continue
	   driver.findElement(By .xpath("//*[@id=\"btn\"]")).click();
	   //username
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[1]")).click();
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[1]")).sendKeys("123456");
	   //password
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).click();
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).sendKeys("Pass@456");
	   //login
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[3]/input")).click();
	   //transactionpassword
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input")).click();
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input")).sendKeys("Trans@456");
	   //paynow
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[2]/input")).click();
	   String expected=driver.findElement(By .xpath("/html/body/b/section/div/div/div/div[2]/p")).getText();
	   String actual="Your orer has been confirmed";
	   Assert.assertEquals(expected,actual);
	   logger.log(Status.PASS,MarkupHelper.createLabel("Testpayment is passed",ExtentColor.GREEN)); 
	 }

 @AfterMethod
     public void getResultAfterMethod(ITestResult result) throws IOException 
      {
       if(result.getStatus()==ITestResult.FAILURE)
	   {
		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"- Test case failed",ExtentColor.RED));
		File f=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File("C:\\Users\\training_h2a.06.15\\Desktop\\Testing\\failedscrshot.jpg"));
		logger.addScreenCaptureFromPath("C:\\Users\\training_h2a.06.15\\Desktop\\Testing\\failedscrshot.jpg",result.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+"- Test case failed",ExtentColor.RED));
	   }
	   else if(result.getStatus()==ITestResult.SKIP)
	   {
		logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"- Test case skipped",ExtentColor.ORANGE));
	   }
      }

 @AfterTest
   public void endReportAfterTest() 
    {
     extent.flush();
    }
  
}