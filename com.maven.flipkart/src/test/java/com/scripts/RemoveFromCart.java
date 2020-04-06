package com.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.genericlib.Base;
import com.genericlib.CommonUtils;
import com.pom.Home;
import com.pom.Login;
import com.pom.Product;

public class RemoveFromCart extends Base{
		
@Test
public void removeCart() throws InterruptedException {
		
	Home hm=PageFactory.initElements(driver, Home.class);
	Product pro=PageFactory.initElements(driver, Product.class);
	
	Thread.sleep(3000);
	
	/*To click on cart icon*/
	hm.getCartIcon().click();
	
	Thread.sleep(3000);
	
	/*Verfication of the cart page*/
	String expCartPage="Shopping Cart | Flipkart.com".replaceAll(" ", "");
	String actCartPage=driver.getTitle().replaceAll(" ", "");
	
	Assert.assertEquals(actCartPage, expCartPage);
	
	Reporter.log("Cart page is displayed", true);
	try
	{
	/*To click on remove button*/
	pro.getRemoveButton().click();
	
	Thread.sleep(3000);
	
	/*To click on Remove button of the popup*/
	pro.getPopupRemoveButton().click();
	
	Reporter.log("Item is removed from the cart", true);
	}
	catch(Exception e){
		Reporter.log("The cart is empty", true);
	}
}
}
