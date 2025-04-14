package com.TalkingParents.Pages;

import com.TalkingParents.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarPage {

    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='New event']/parent::button")
    public WebElement newEventButton;

    @FindBy(xpath = "//button[contains(text(), 'Continue')]")
    public WebElement continueButton;

    @FindBy(css = "div.day .event span")
    public List<WebElement> allEventTitles;


    // Bell icon (notification trigger)
    @FindBy(css = ".calendar-notification button")
    public WebElement notificationBell;

    @FindBy(css = ".notification.menu-dropdown")
    public WebElement notificationDropdown;

    @FindBy(xpath = "//div[@class='notification-content font-size-1']/span[1]")
    public WebElement firstNotificationMessage;

    @FindBy(id = "subject")
    public WebElement eventTitleInput;

    @FindBy(id = "notes")
    public WebElement eventDetailsInput;

    @FindBy(id = "dp-input-startTime")
    public WebElement startTimeInput;

    @FindBy(id = "dp-input-endTime")
    public WebElement endTimeInput;

    @FindBy(xpath = "//button[span[text()='Create event']]")
    public WebElement createEventButton;

    @FindBy(css = "#dp-input-startDate")
    public WebElement startDateInput;

    @FindBy(css = "#dp-input-endDate")
    public WebElement endDateInput;

}
