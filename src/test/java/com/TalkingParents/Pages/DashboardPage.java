package com.TalkingParents.Pages;

import com.TalkingParents.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // Shared Calendar navigation locators
    @FindBy(xpath = "//span[text()='Secure Messaging']/ancestor::a")
    public WebElement secureMessagingLink;

    @FindBy(xpath = "//span[contains(text(),'Accountable Calling')]/ancestor::a")
    public WebElement accountableCallingLink;

    @FindBy(xpath = "//span[text()='Shared Calendar']/ancestor::a")
    public WebElement sharedCalendarLink;

    @FindBy(xpath = "//span[contains(text(),'Accountable Payments')]/ancestor::a")
    public WebElement accountablePaymentsLink;

    @FindBy(xpath = "//span[text()='Info Library']/ancestor::a")
    public WebElement infoLibraryLink;

    @FindBy(xpath = "//span[text()='Unalterable Records']/ancestor::a")
    public WebElement unalterableRecordsLink;

    @FindBy(xpath = "//span[text()='Personal Journal']/ancestor::a")
    public WebElement personalJournalLink;

    @FindBy(xpath = "//span[text()='Vault File Storage']/ancestor::a")
    public WebElement vaultStorageLink;

    @FindBy(xpath = "//span[text()='Account Settings']/ancestor::a")
    public WebElement accountSettingsLink;

    @FindBy(xpath = "//span[text()='Help Center']/ancestor::a")
    public WebElement helpCenterLink;

    @FindBy(xpath = "//span[text()='Contact Us']/ancestor::a")
    public WebElement contactUsLink;

    @FindBy(xpath = "//span[text()='Sign Out']/ancestor::button")
    public WebElement signOutButton;

    @FindBy(css = ".nav-user .user-initials")
    public WebElement userInitials;

    @FindBy(css = ".nav-user strong")
    public WebElement userFullName;

    @FindBy(css = ".nav-user .ellipsis")
    public WebElement userEmail;

    @FindBy(css = ".nav-user .pill.plan-type")
    public WebElement userPlanType;

    @FindBy(css = "div.loading")
    public WebElement loadingOverlay;

}
