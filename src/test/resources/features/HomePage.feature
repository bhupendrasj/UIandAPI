Feature: Home Page Loading

Scenario: User successfully loads the home page
  Given the user navigates to the home page URL
  When the page loads completely
  Then the page title should be "Home Page"
  And the main header should be visible
  And the footer should be displayed
