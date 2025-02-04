Feature: Log in to Swag Labs

  @Login
  Scenario Outline: Login with valid credentials
    Given the user navigates to the Swag Labs login page
    When the user enters the username "<Username>" into the username textbox
    And enters the password "<Password>" into the password textbox
    And clicks on the login button
    Then the user is navigated to the inventory page
    Examples:
      | Username                | Password     |
      | standard_user           | secret_sauce |
#      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  @Login @LockedOut
  Scenario: Login with valid, revoked credentials
    Given the user navigates to the Swag Labs login page
    When the user enters the username "locked_out_user" into the username textbox
    And enters the password "secret_sauce" into the password textbox
    And clicks on the login button
    Then the user sees the login failure message "Epic sadface: Sorry, this user has been locked out."