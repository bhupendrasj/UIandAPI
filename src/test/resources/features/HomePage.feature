Feature: User Registration and Account Deletion

  Scenario: User successfully registers and deletes their account
    Given the user launches the browser
    And navigates to url "http://automationexercise.com"
    Then the page title should be "Automation Exercise"
    When the user clicks on "Signup / Login" button
    Then verify "New User Signup!" is visible
    And the user enters "name" name and "abcdefghijklmnop@xyz.com" email address
    When the user clicks on "Signup" button
    Then verify "ENTER ACCOUNT INFORMATION" is visible
    And the user fills details: "" Title, "" Name, "" Email, "" Password, "" Date of birth
    And selects checkbox "Sign up for our newsletter!"
    And selects checkbox "Receive special offers from our partners!"
    And fills details: "" First name, "" Last name, "" Company, "" Address, "" Address2, "" Country, "" State, "" City, "" Zipcode, "" Mobile Number
    When the user clicks on "Create Account" button
    Then verify "ACCOUNT CREATED!" is visible
    And the user clicks on "Continue" button
    Then verify "Logged in as username" is visible
    When the user clicks on "Delete Account" button
    Then verify "ACCOUNT DELETED!" is visible
    And the user clicks on "Continue" button
