package dd_testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;


public class LoginTest extends Page {

	
	public static String GlobalUsername;
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("LoginTest")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
			
		}
		
		
	}
	
	@Test(dataProvider="getData")
	public void doLogin(String username,String password) throws IOException{
		
		logs.debug("Inside Login Test");
		System.out.println("Started the Test");
		findElement("username").sendKeys(username);
		System.out.println("Entered USername");
		findElement("password").sendKeys(password);
		System.out.println("Entered Password");
		findElement("login").click();
		System.out.println("Clicked Login");
		TestUtil.CaptureScreenshot();
		GlobalUsername = username;
		
	
	}
	
	
	@DataProvider
	public static Object[][] getData(){
		
		return TestUtil.getData("LoginTest");
		
		
		
	}
	
	
	
	
}
