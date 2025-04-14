package com.TalkingParents.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    // Common methods and properties for all pages
    @FindBy(id = "tp-login")
    public WebElement signInButton;

}
