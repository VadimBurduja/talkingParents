Feature: Shared Calendar Event Management and Login
@ui
  Scenario: Parent A logs in and creates a shared calendar event
    When the user clicks the Sign In button
    And the user logs in as "Parent A"
    And the user navigates to the Shared Calendar
    And the user creates a new event titled "Parent-Teacher Conference"
    Then the event should appear in Parent A's calendar

@test @ui
Scenario: Parent B logs in and sees the notification
  When the user clicks the Sign In button
  And the user logs in as "Parent B"
  And the user navigates to the Shared Calendar
  Then the user should see a notification for "Parent-Teacher Conference"
    And the event titled "New Event!" should appear in Parent B's calendar

