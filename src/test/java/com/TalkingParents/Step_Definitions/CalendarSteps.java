package com.TalkingParents.Step_Definitions;

import com.TalkingParents.Pages.BasePage;
import com.TalkingParents.Pages.CalendarPage;
import com.TalkingParents.Pages.DashboardPage;
import com.TalkingParents.Pages.LoginPage;
import com.TalkingParents.Utilities.BrowserUtils;
import com.TalkingParents.Utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CalendarSteps extends BasePage {

    public CalendarSteps(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    CalendarPage calendarPage = new CalendarPage();


    @When("the user clicks the Sign In button")
    public void the_user_clicks_the_sign_in_button() {
        BrowserUtils.waitForClickablility(signInButton, 10).click();
    }
    @When("the user logs in as {string}")
    public void the_user_logs_in_as(String role) {
        loginPage.loginAsRole(role);
    }

    @And("the user navigates to the Shared Calendar")
    public void the_user_navigates_to_the_shared_calendar() {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.scrollToElement(dashboardPage.sharedCalendarLink);
        BrowserUtils.waitForClickablility(dashboardPage.sharedCalendarLink, 3).click();
        BrowserUtils.waitForVisibility(calendarPage.newEventButton, 3);
    }


    @When("the user creates a new event titled {string}")
    public void the_user_creates_a_new_event_titled(String eventTitle) {
        BrowserUtils.waitForClickablility(calendarPage.newEventButton, 5).click();
        calendarPage.eventTitleInput.sendKeys(eventTitle);
        calendarPage.eventDetailsInput.sendKeys("Automated test details");
        BrowserUtils.safeClick(calendarPage.startDateInput);
        calendarPage.startDateInput.sendKeys(Keys.ENTER);
        BrowserUtils.safeClick(calendarPage.endDateInput);
        calendarPage.endDateInput.sendKeys(Keys.ENTER);
        String start = LocalTime.now().plusMinutes(5).format(DateTimeFormatter.ofPattern("hh:mm a"));
        String end = LocalTime.now().plusMinutes(35).format(DateTimeFormatter.ofPattern("hh:mm a"));
        BrowserUtils.safeClick(calendarPage.startTimeInput);
        calendarPage.startTimeInput.sendKeys(start, Keys.ENTER);
        BrowserUtils.safeClick(calendarPage.endTimeInput);
        calendarPage.endTimeInput.sendKeys(end, Keys.ENTER);
        BrowserUtils.safeClick(calendarPage.createEventButton);
    }



    @Then("the event should appear in Parent A's calendar")
    public void the_event_should_appear_in_parent_a_calendar() {
        BrowserUtils.waitFor(2);
        boolean found = BrowserUtils.isEventPresent("Parent-Teacher Conference", calendarPage.allEventTitles);
        Assert.assertTrue("Event not found in Parent A's calendar", found);
    }

    @Then("the user should see a notification for {string}")
    public void the_user_should_see_a_notification_for(String eventTitle) {
        BrowserUtils.waitForVisibility(calendarPage.notificationBell, 10);
        BrowserUtils.waitForNotificationBadgeToUpdate(calendarPage.notificationBell, 10); // <-- NEW
        BrowserUtils.safeClick(calendarPage.notificationBell);
        BrowserUtils.waitForVisibility(calendarPage.notificationDropdown, 5);
        String notificationText = calendarPage.firstNotificationMessage.getText();
        Assert.assertTrue("Notification does not contain expected event title",
                notificationText.toLowerCase().contains("new event"));
    }

    @And("the event titled {string} should appear in Parent B's calendar")
    public void the_event_titled_should_appear_in_parent_b_calendar(String expectedTitle) {
        BrowserUtils.waitFor(2);
        boolean found = BrowserUtils.isEventPresent(expectedTitle, calendarPage.allEventTitles);
        Assert.assertTrue("Event not visible in Parent B's calendar!", found);
    }


}
