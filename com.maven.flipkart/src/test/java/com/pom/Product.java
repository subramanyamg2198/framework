package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product {
@FindBy(xpath="//a[text()='Puma Icon IDP Sneakers For Men']/../../../..//div[text()='Remove']")
private WebElement removeButton;

@FindBy(xpath="//div[text()='Cancel']/following-sibling::div")
private WebElement popupRemoveButton;

@FindBy(xpath="//div[text()='6 GB & Above']/preceding-sibling::div")
private WebElement filterCheckBox;

@FindBy(xpath="(//div[text()='6 GB & Above'])[2]")
private WebElement textOfFilter;

@FindBy(xpath="//span[text()='Filters']/ancestor::section//div[@class='_3UZZGt']")
private WebElement verificationOfFilter;

@FindBy(xpath="//span[text()='Filters']/../../..//div[text()='✕']")
private WebElement closeFilterButton;

@FindBy(xpath="//span[text()='Filters']/../..//span[text()='Clear all']")
private WebElement clearAllFiltersButton;

public WebElement getRemoveButton() {
	return removeButton;
}

public WebElement getPopupRemoveButton() {
	return popupRemoveButton;
}

public WebElement getFilterCheckBox() {
	return filterCheckBox;
}

public WebElement getVerificationOfFilter() {
	return verificationOfFilter;
}

public WebElement getTextOfFilter() {
	return textOfFilter;
}

public WebElement getCloseFilterButton() {
	return closeFilterButton;
}

public WebElement getClearAllFiltersButton() {
	return clearAllFiltersButton;
}


}
