package com.scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.Base;
import com.pom.Home;
import com.pom.Product;

import takescreenshot.EventListner;
@Listeners(EventListner.class)
public class AddFilters extends Base{
@Test
	public void addFilters() throws InterruptedException
	{
	Home hm=PageFactory.initElements(driver, Home.class);
	Product pro=PageFactory.initElements(driver, Product.class);
	
	Thread.sleep(3000);
	
	/*to enter value of the product to be searched*/
	hm.getSearchTextBox().sendKeys(fl.getPropertyKeyValue(p1, "product"),Keys.ENTER);
	
	Thread.sleep(3000);
	
	/*verification of the product page*/
	String actProductPage="Mobiles - Buy Products Online at Best Price in India - All Categories | Flipkart.com".replaceAll(" ", "");
	String expProductPage=driver.getTitle().replaceAll(" ", "");
	
	Assert.assertEquals(actProductPage, expProductPage);
	
	Reporter.log("Product page is displayed", true);
	
	Thread.sleep(3000);
	
	/*To apply the filter*/
	pro.getFilterCheckBox().click();
	Reporter.log("filter checkbox is clicked",true);
	
	Thread.sleep(3000);
	
	/*Verfication of the filter applied*/
	String expFilter=pro.getTextOfFilter().getText().replaceAll(" ", "");
	String actFilter=pro.getVerificationOfFilter().getText().replaceAll(" ", "");
	
	Assert.assertEquals(actFilter, expFilter);
	
	Reporter.log("The correct filter is applied", true);
	}
	}