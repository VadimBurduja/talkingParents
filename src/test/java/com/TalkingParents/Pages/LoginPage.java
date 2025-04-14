package com.TalkingParents.Pages;

import com.TalkingParents.Utilities.BrowserUtils;
import com.TalkingParents.Utilities.ConfigurationReader;
import com.TalkingParents.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    public void login(String username, String password) {
        BrowserUtils.waitForVisibility(usernameField, 10).sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void loginAsRole(String userRole) {


        String email = "", password = "";

        switch (userRole) {
            case "Parent A":
                email = ConfigurationReader.getProperty("parent1Email");
                password = ConfigurationReader.getProperty("parent1Password");
                break;
            case "Parent B":
                email = ConfigurationReader.getProperty("parent2Email");
                password = ConfigurationReader.getProperty("parent2Password");
                break;
            default:
                throw new RuntimeException("Invalid user role: " + userRole);
        }

        BrowserUtils.waitForVisibility(usernameField, 10);
        login(email, password);
    }

}
