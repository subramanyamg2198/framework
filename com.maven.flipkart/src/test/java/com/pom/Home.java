package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
 @FindBy(xpath="//div[text()='Subramanya']")
 private WebElement profileIcon;
 
 @FindBy(xpath="//div[text()='Logout']")
 private WebElement logoutButton;
 
 @FindBy (xpath="//input[@name='q']")
 private WebElement searchTextBox;
 
 @FindBy(xpath="//span[text()='Cart']")
 private WebElement cartIcon;

public WebElement getProfileIcon() {
	return profileIcon;
}

public WebElement getLogoutButton() {
	return logoutButton;
}

public WebElement getSearchTextBox() {
	return searchTextBox;
}

public WebElement getCartIcon() {
	return cartIcon;
}
 
}