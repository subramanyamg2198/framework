package com.scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.genericlib.Base;
import com.pom.Home;


public class ViewTheProduct extends Base{
	@Test
	public void viewTheProduct() throws InterruptedException
	{
		WebDriverWait w=new WebDriverWait(driver, 10); 
		Home hm=PageFactory.initElements(driver, Home.class);
		
		Thread.sleep(3000);
		
		/*to enter value of the product to be searched*/
		hm.getSearchTextBox().sendKeys(fl.getPropertyKeyValue(p1, "product"),Keys.ENTER);
		
		Thread.sleep(3000);
		
		w.until(ExpectedConditions.titleContains("Mobiles - Buy Products Online at Best Price in India - All Categories | Flipkart.com"));
		/*verification of the product page*/
		String expProductPage="Mobiles - Buy Products Online at Best Price in India - All Categories | Flipkart.com".replaceAll(" ", "");
		String actProductPage=driver.getTitle().replaceAll(" ", "");
		
		Assert.assertEquals(actProductPage, expProductPage);
		
		Reporter.log("Product page is displayed", true);
	}
}