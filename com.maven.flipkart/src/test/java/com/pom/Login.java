package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
@FindBy(xpath="(//input[@type='text'])[2]")
private WebElement emailTextField;

@FindBy(xpath="//input[@type='password']")
private WebElement passwordTextField;

@FindBy(xpath="(//button[@type='submit'])[2]")
private WebElement loginButton;

public WebElement getEmailTextField() {
	return emailTextField;
}

public WebElement getPasswordTextField() {
	return passwordTextField;
}

public WebElement getLoginButton() {
	return loginButton;
}


}
