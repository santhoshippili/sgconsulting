Feature: Application Management

  Background: Navigating to the Application Management
    Given I open the browser and navigate to MDC

  @sanity
  Scenario: User has to Login Successfully
    And I give valid "anand@consentsonline.com" and "Col-123"
    When I click on SignIn button
    Then I should be on the Home Page


#  Scenario Outline: Testing all combinations of invalid User Names and invalid password
#    And I give invalid combinations of Username and Password
#      | UserName   | Password   |
#      | <username> | <password> |
#    When I click on SignIn button
#    Examples:
#      | username                 | password |
#      | anand@consentsonline.com | 11111    |
#      |                          | Col-123  |
#      | anand@consentsonline     | Col-123  |

  @regression
  Scenario Outline: Testing All combinations
    And I give invalid combinations of Username and Password with condition and Submit
      | <Username> | <Password> | <Condition> | <Message> |
    Examples:
      | Username                 | Password | Condition        | Message                                      |
      | anand@consentsonline.com | 11111    | Invalid Password | Invalid email or password, Please try again. |
      |                          | Col-123  | Blank Username   |                                              |
      | anand@consentsonline     | Col-123  | Invalid Email    |                                              |




