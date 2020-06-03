Feature: Calendar Event
  As a store_manager, I want to be able to login with username and password

  Background:
    Given user is on the landing page
    When user logs in as a store manager
    And user navigate to activities then calendar events


  @Test_Case_1
  Scenario: Login as a Store Manager and verify three dot icons are available
    Given user hover on three dots
    Then Verify that “view”, “edit” and “delete” options are available

  @Test_Case_2
  Scenario: Login as a Store Manager and Verify that Title column still displayed
    Given user click on Click on Grid Options button
    When user deselect all options except Title
    Then user should verify that Title column still displayed

  @Test_Case_3
  Scenario: Login as a Store Manager and all save options are available
    Given user should click on Create Calendar Event button
    And user should expand Save And Close menu
    Then user should Verify that all saving options are available

  @Test_Case_4
  Scenario: Login as a Store Manager and verify all calendar events subtitle is displayed
    Given user should click on Create Calendar Event button
    And user should click on Cancel button
    Then user should verify all calendar events subtitle is displayed

  @Test_Case_5
  Scenario: Login as a Store Manager and Verify that difference between end and start time is exactly 1 hour
    Given user should click on Create Calendar Event button
    Then user should verify that difference between end and start time is one hour

  @Test_Case_6
  Scenario: Login as a Store Manager and Verify that end time is equals to 10:00 PM
    Given user should click on Create Calendar Event button
    And user should select nine pm time as a start time
    Then Verify that end time is equals to ten PM

  @Test_Case_7
  Scenario: Login as a Store Manager and select All Day Event checkbox then Verify start and time/date
    Given user should click on Create Calendar Event button
    Then user should be able to select all day event check box
    And user should be able to verify all day event check box
    Then user should be able to verify start and end time boxes are not displayed
    And user should be able to verify start and end date boxes are displayed

  @Test_Case_8
  Scenario: Login as a Store Manager then select Repeat checkbox and verify then verify that daily is selected by default and following options are available in Repeats drop-down
    Given user should click on Create Calendar Event button
    Then user should be able to select Repeat checkbox
    And user should be able to verify Repeat checkbox is selected
    And user should be able to verify Daily checkbox is selected by default following options are available in Repeat dropdown

  @Test_Case_9
  Scenario: Login as a Store Manager then select Repeat checkbox then verify then verify that Repeat Every button is selected and Verify that “Never” radio button is selected as “Ends” option Then Verify that following message as a summary is displayed “Summary Daily every one day”
    Given user should click on Create Calendar Event button
    Then user should be able to select Repeat checkbox
    And verify that Repeat Every button is selected
    And Verify that “Never” radio button is selected as an “Ends” option
    Then Verify that following message as a summary is displayed “Summary Daily every one day”

  @Test_Case_10
  Scenario: Login as a Store Manager then select Repeat checkbox then Verify that following message as a summary is displayed Summary Daily every one day, end after ten occurrences
    Given user should click on Create Calendar Event button
    Then user should be able to select Repeat checkbox
    Then Select After ten occurrences as an Ends option
    Then Verify that following message as a summary is displayed Summary Daily every one day, end after ten occurrences

  @Test_Case_11
  Scenario: Login as a Store Manager then select Repeat checkbox then Select By Nov 18, 2021 as an Ends option then Verify that following message as a summary is displayed Summary Daily every 1 day, end by Nov 18, 2021
    Given user should click on Create Calendar Event button
    Then user should be able to select Repeat checkbox
    Then user should be able to select Select By Nov 18, 2021 as an Ends option
    And user should be able to Verify that following message as a summary is displayed Summary Daily every 1 day, end by Nov 18, 2021

  @Test_Case_12
  Scenario: Login as a Store Manager then select Repeat checkbox then do the rest
    Given user should click on Create Calendar Event button
    Then user should be able to select Repeat checkbox
    And user should be able to select weekly options as a repeat option
    Then user should be able to select Select Monday and Friday options as a Repeat On options
    Then user should be able to Verify that Monday and Friday options are selected
    Then user should be able to Verify that following message as a summary is displayed Summary Weekly every 1 week on Monday, Friday