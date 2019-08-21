package testmeapp.tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testmeutility.Drivers;

public class Onlineshoppingtest {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

	 @AfterTest
	  public void endReportAfterTest() {
		 extent.flush();
	 }
	 @Test
	  public void getResultAfterMethod(ITestResult result) throws IOException {

		 if(result.getStatus()==ITestResult.FAILURE)
	    	{
	    		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"- Test case failed",ExtentColor.RED));
	    		TakesScreenshot sht=(TakesScreenshot)driver;
	    		File src=sht.getScreenshotAs(OutputType.FILE);
	    		String path=System.getProperty("user.dir"+"/extent-reports/snapshots/"+result.getName()+".png");
	    		System.out.println(path);
	    		FileUtils.copyFile(src,new File(path));
	    		logger.addScreenCaptureFromPath(path,result.getName());
	    		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+"- Test case failed",ExtentColor.RED));
	    	}
	    	else if(result.getStatus()==ITestResult.SKIP)
	    	{
	    		logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"- Test case skipped",ExtentColor.ORANGE));
	    	}}
	 @Test
	  public void startReportBeforeTest() {
			htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports/"+new SimpleDateFormat("hh-mm-ss-dd-MM-yyyy").format(new Date())+".html");
			extent=new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "GFT NextGen Testing");
			extent.setSystemInfo("Environment", "Selenium automation Testing");
			extent.setSystemInfo("User Name", "ANU");
			htmlReporter.config().setDocumentTitle("Selenium Testing");
			htmlReporter.config().setReportName("Final Report");
			htmlReporter.config().setTheme(Theme.STANDARD);
		 
	 }

	 @Test(priority=3)
	  public void testCart() throws Exception {
			 //by categories
			// driver.findElement(By .xpath("//*[@id=\"menu3\"]/li[2]/a/span")).click();
			// driver.findElement(By .xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span")).click();
			// Thread.sleep(2000);
			// driver.findElement(By .xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span")).click();
			 
			 
			 
			 
			
			 
			 
			driver.findElement(By .name("products")).click();
			 driver.findElement(By .name("products")).sendKeys("Headphone");
			 driver.findElement(By .xpath("/html/body/div[1]/form/input")).click();
			 driver.findElement(By .xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
			 
			 driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
			  driver.findElement(By .xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
			  Thread.sleep(2000);
			String z =driver.findElement(By .xpath("//*[@id=\"cart\"]/tbody/tr/td[1]/div/div/h4")).getText();
			String X="Headphone";
			Assert.assertEquals(z,X);
			logger=extent.createTest("testcart");
			logger.log(Status.PASS,MarkupHelper.createLabel("Test case passed is testcart",ExtentColor.GREEN));
		 }
		
  @Test(priority=2)
  public void testLogin() {
	 
	  driver.findElement(By .name("userName")).sendKeys("lalitha");
	   driver.findElement(By .name("password")).sendKeys("password123");
	   driver.findElement(By .xpath(  "/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	   logger=extent.createTest("testLogin");
	   String a=driver.findElement(By .linkText("SignOut")).getText();
	   String b="SignOut";
	   Assert.assertEquals(a, b);

		logger.log(Status.PASS,MarkupHelper.createLabel("Test case passed is testLogin",ExtentColor.GREEN));
  }
  

  @Test(priority=4)
  public void testPayment() throws InterruptedException {
	  driver.findElement(By .xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
		Thread.sleep(2000);
			driver.findElement(By .xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
	driver.findElement(By .xpath("//*[@id=\"btn\"]")).click();
			driver.findElement(By .name("username")).sendKeys("123456");
			driver.findElement(By .name("password")).sendKeys("Pass@456");
			driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[3]/input")).click();
			driver.findElement(By .name("transpwd")).sendKeys("Trans@456");
			driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[2]/input")).click();
			
			driver.findElement(By .xpath("/html/body/header/div/div/ul/b/a[2]")).click();
			
			
			logger=extent.createTest("test payment");
			String s=driver.findElement(By .xpath("/html/body/b/section/div/div/div/div[2]/p")).getText();
			String s1="Your order has been confirmed";
			Assert.assertEquals(s,s1);
			logger.log(Status.PASS,MarkupHelper.createLabel("Test case passed is test payment",ExtentColor.GREEN));
			
		  }
	  
  @Test(priority=1)
  public void testRegistration() {
	  
	  driver=Drivers.getDriver("Chrome");
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
	  Actions a=new Actions(driver);
	  driver.findElement(By .name("userName")).sendKeys("fh234g234dcccv");
	  a.sendKeys(Keys.ENTER).perform();
	  String s1=driver.findElement(By .xpath("//*[@id=\"err\"]")).getText();
	  System.out.println(s1);
	  

	  
	  driver.findElement(By .name("firstName")).sendKeys("gollapalli");
	  driver.findElement(By .name("lastName")).sendKeys("anu");
	  driver.findElement(By .name("password")).sendKeys("passkey");
	  driver.findElement(By .name("confirmPassword")).sendKeys("passkey");
	  driver.findElement(By .xpath("//*[@id=\"gender\"]")).click();
		 
	  driver.findElement(By .name("emailAddress")).sendKeys("anu@gmail.com");
	  driver.findElement(By .name("mobileNumber")).sendKeys("9999999999");
	  driver.findElement(By .name("dob")).sendKeys("08/02/1998");
	   driver.findElement(By .name("address")).sendKeys("hyderabaad");
	   driver.findElement(By .name("answer")).sendKeys("warangal");
	   driver.findElement(By .xpath("/html/body/main/div/div/form/fieldset/div/div[13]/div/input[1]")).click();
	   logger=extent.createTest("Testregistration");
		//Assert.assertTrue(true);
		logger.log(Status.PASS,MarkupHelper.createLabel("Test case passed is Testregistration",ExtentColor.GREEN));
	   

  }

}