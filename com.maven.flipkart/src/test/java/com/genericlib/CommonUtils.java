package com.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonUtils {
public void mouse(WebDriver driver,WebElement ele) {
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
}
}
