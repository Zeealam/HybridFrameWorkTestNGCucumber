
@tag
Feature: Puchase the order from Ecommerce
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerve Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with emailid <emailid> and password <password>
    When I add product <productName> to cart
    And Checkout<productName> and submit the order
    Then "THANKYOU FOR THE ORDER.": message is displayed on confirmationPage	

    Examples: 
      | emailid                 | password       | productName     |
      | zeeshan.alam7@gmail.com | Bangalore2016@ | ZARA COAT 3     |
      | anshika@gmail.com       | Iamking@000    | ADIDAS ORIGINAL |
