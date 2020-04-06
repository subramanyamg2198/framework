package com.genericlib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.pom.Home;
import com.pom.Login;

public class Base {
	public static WebDriver listnerdriver=null;
	public WebDriver driver=null;
	public String p1="C:\\Users\\subbu\\Desktop\\corejava\\com.maven.flipkart\\src\\test\\java\\com\\testdata\\commondata.properties";
	public FileUtils fl=new FileUtils();
	Login lg=null;
	Home hm=null;
	CommonUtils cu=null;
@BeforeClass
public void browserLaunch() {
	
	/*To launch the browser*/
	if(fl.getPropertyKeyValue(p1,"browser").equals("chrome")) {
		driver=new ChromeDriver();
		listnerdriver=driver;
	}		
	
	Reporter.log("Chrome browser is launched", true);
	
	/*To aximize the browser*/
	driver.manage().window().maximize();
	
	Reporter.log("Window is maximized", true);
	
	/*Tp enter the url*/
	driver.get(fl.getPropertyKeyValue(p1, "url"));
	
	Reporter.log("URL is entered", true);
}

@BeforeMethod
public void login() throws InterruptedException {
	Login lg=PageFactory.initElements(driver,Login.class);
	
	/*To enter the email id*/
	lg.getEmailTextField().sendKeys(fl.getPropertyKeyValue(p1,"mobilenumber"));
	
	/*To enter the password*/
	lg.getPasswordTextField().sendKeys(fl.getPropertyKeyValue(p1,"password"),Keys.ENTER);
	
	Thread.sleep(3000);
	
	/*Verification of Home page*/
	String expLoginPage="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!".replaceAll(" ", "");
	String actLoginPage=driver.getTitle().replaceAll(" ", "");
	
	Assert.assertEquals(actLoginPage, expLoginPage);
	
	Reporter.log("Successfully logged in", true);
}

@AfterMethod
public void logout() {
	try {
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	/*To mouse hover on the profile icon*/
	Actions act=new Actions(driver);
	act.moveToElement(hm.getProfileIcon()).perform();
	
	try {
		Thread.sleep(3000);
	} 
	catch (InterruptedException e) {
		e.printStackTrace();
	}
	/*To click the logout button*/
	hm.getLogoutButton().click();
	
	Reporter.log("Successfully loged out", true);
	}
	catch(Exception e) {
		Reporter.log("Null pointer exception", true);
	}
	
}

@AfterClass
public void closeBrowser() {
	
	/*To close the browser*/
	driver.quit();
	Reporter.log("Browser window is closed successfully", true);
}
}
