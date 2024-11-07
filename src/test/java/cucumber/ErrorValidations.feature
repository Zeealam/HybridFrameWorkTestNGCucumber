
@tag
Feature: Error Validation
  I want to use this template for my feature file
  
 

  @ErrorValidation
  Scenario Outline: Login Error Message
    Given I landed on Ecommerve Page
    When Logged in with emailid <emailid> and password <password>
    Then "Incorrect email or password.": message is displayed
  

    Examples: 
      | emailid                 | password       | 
      | zeeshan.alam7@gmail.com | Bangalore2016  | 
