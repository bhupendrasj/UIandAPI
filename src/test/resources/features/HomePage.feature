Feature: User Registration and Account Deletion

  Scenario: User successfully registers and deletes their account
    Given the user launches the browser
    And navigates to url "http://automationexercise.com"
    Then the page title should be "Automation Exercise"
    When the user clicks on " Signup / Login" button
    Then verify "New User Signup!" is visible
    And the user enters "name" name and "Test" email address
    When the user clicks on "Signup" button
    Then verify "Enter Account Information" is visible
    And the user fills details: "Mr" Title, "Krishna" Name, "Krishn@11" Password, "1-January-2000" Date of birth
    And selects checkbox "Sign up for our newsletter!"
    And selects checkbox "Receive special offers from our partners!"
    And fills details: "Krishna" First name, "Yadav" Last name, "Gopi" Company, "Banaras" Address, "Vasudev Nagar" Address2, "India" Country, "Utter Pradesh" State, "Pune" City, "123456" Zipcode, "1234567890" Mobile Number
    When the user clicks on "Create Account" button
    Then verify "Account Created!" is visible
    And the user clicks on "Continue" button
    Then verify "Logged in as nameKrishna" is visible
    When the user clicks on " Delete Account" button
    Then verify "Account Deleted!" is visible
    And the user clicks on "Continue" button

    Scenario: User Fetch a list of users with pagination
      Given the user sets URL
      And the user updates the header
      When the user triggers the GET API
      Then the status code should be 200 OK
      And the user prints the response