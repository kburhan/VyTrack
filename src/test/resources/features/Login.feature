Feature: Login
  As a user, I want to be able to login with username and password

  Background:
    Given user is on the landing page

  @Landing_Login
  Scenario Outline: Login as <username>
      Given user logs in as a "<username>"
      Then user should verify "<title>" is displayed
      Examples:
      |username|title|
      |sales manager|Dashboard|
      |store manager|Dashboard|
      |driver       |Dashboard|


