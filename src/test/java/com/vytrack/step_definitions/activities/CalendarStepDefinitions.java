package com.vytrack.step_definitions.activities;

import com.vytrack.pages.activities.CalendarEventPage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Wait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CalendarStepDefinitions extends CalendarEventPage{

    CalendarEventPage calendarEventPage= new CalendarEventPage();
    Actions actions=new Actions(Driver.getDriver());
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);

    @When("user navigate to activities then calendar events")
    public void user_navigate_to_activities_then_calendar_events() {
        calendarEventPage.navigateTo("Activities","Calendar Events");
    }

    @Given("user hover on three dots")
    public void user_hover_on_three_dots() {
        wait.until(ExpectedConditions.visibilityOf(calendarEventPage.getThreeDots().get(1)));
        actions.moveToElement(calendarEventPage.getThreeDots().get(1)).build().perform();
    }

    @Then("Verify that “view”, “edit” and “delete” options are available")
    public void verify_that_view_edit_and_delete_options_are_available() {
        for (WebElement each : calendarEventPage.getThreedotMenu()) {
            Assert.assertTrue(each.isDisplayed());
        }
    }
    @Given("user click on Click on Grid Options button")
    public void user_click_on_Click_on_Grid_Options_button() {
        BrowserUtilities.waitForPageToLoad(10);
        calendarEventPage.clickGridSettings();
    }
    @Given("user deselect all options except Title")
    public void user_deselect_all_options_except_Title() {
        BrowserUtilities.waitForPageToLoad(5);
        calendarEventPage.deselectAllOptionsInGrid();
    }
    @Then("user should verify that Title column still displayed")
    public void user_should_verify_that_Title_column_still_displayed() {
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals(calendarEventPage.getTableHeaderName(),"TITLE");
    }

    @Given("user should click on Create Calendar Event button")
    public void user_should_click_on_Create_Calendar_Event_button() {
        calendarEventPage.clickOnCreateCalendarEventBtn();
    }

    @Given("user should expand Save And Close menu")
    public void user_should_expand_Save_And_Close_menu() {
        calendarEventPage.clickExpandSaveAndClose();
    }

    @Then("user should Verify that all saving options are available")
    public void user_should_Verify_that_all_saving_options_are_available() {
        List<String> expected=new ArrayList<>(Arrays.asList("Save and Close","Save and New","Save"));
        for (int i = 0; i <expected.size() ; i++) {
            Assert.assertTrue(calendarEventPage.getSaveAndCloseOptions().get(i).equalsIgnoreCase(expected.get(i)));
        }

    }

    @Given("user should click on Cancel button")
    public void user_should_click_on_Cancel_button() {
        calendarEventPage.clickOnCancelBtn();
    }

    @Then("user should verify all calendar events subtitle is displayed")
    public void user_should_verify_all_calendar_events_subtitle_is_displayed() {
        Wait.wait(3);
        Assert.assertEquals(calendarEventPage.getCalendarSubTitle(),"All Calendar Events");
    }

    @Then("user should verify that difference between end and start time is one hour")
    public void user_should_verify_that_difference_between_end_and_start_time_is_one_hour() {
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals(calendarEventPage.getTimeDifferences(),1);
    }

    @Given("user should select nine pm time as a start time")
    public void user_should_select_nine_pm_time_as_a_start_time() {
        BrowserUtilities.waitForPageToLoad(5);
        calendarEventPage.selectTime_1();
    }

    @Then("Verify that end time is equals to ten PM")
    public void verify_that_end_time_is_equals_to_ten_PM() {
        BrowserUtilities.waitForPageToLoad(5);
        Assert.assertEquals(calendarEventPage.getTime2(),"10:00 PM");
    }

    @Then("user should be able to select all day event check box")
    public void user_should_be_able_to_select_all_day_event_check_box() {
        BrowserUtilities.waitForPageToLoad(5);
        calendarEventPage.clickOnAllDayEvent();
    }

    @Then("user should be able to verify all day event check box")
    public void user_should_be_able_to_verify_all_day_event_check_box() {
        BrowserUtilities.waitForPageToLoad(5);
        Assert.assertTrue(calendarEventPage.allDay.isSelected());
    }

    @Then("user should be able to verify start and end time boxes are not displayed")
    public void user_should_be_able_to_verify_start_and_end_time_boxes_are_not_displayed() {
        Assert.assertFalse(calendarEventPage.isTimesAreDisplayed());
    }

    @Then("user should be able to verify start and end date boxes are displayed")
    public void user_should_be_able_to_verify_start_and_end_date_boxes_are_displayed() {
        Assert.assertTrue(calendarEventPage.isDatesAreDisplayed());
    }

    @Then("user should be able to select Repeat checkbox")
    public void user_should_be_able_to_select_Repeat_checkbox() {
        calendarEventPage.clickOnRepeatBtn();
    }

    @Then("user should be able to verify Repeat checkbox is selected")
    public void user_should_be_able_to_verify_Repeat_checkbox_is_selected() {
        Assert.assertTrue(calendarEventPage.repeatBtn.isSelected());
    }

    @Then("user should be able to verify Daily checkbox is selected by default following options are available in Repeat dropdown")
    public void user_should_be_able_to_verify_Daily_checkbox_is_selected_by_default_following_options_are_available_in_Repeat_dropdown() {
        Assert.assertEquals(calendarEventPage.getDefaultOption(),"Daily");
        Assert.assertNotEquals(calendarEventPage.getAllDropdown(),null);
    }

    @Then("verify that Repeat Every button is selected")
    public void verify_that_Repeat_Every_button_is_selected() {
        Assert.assertTrue(calendarEventPage.repeatEveryRadio.isSelected());
    }

    @Then("Verify that “Never” radio button is selected as an “Ends” option")
    public void verify_that_Never_radio_button_is_selected_as_an_Ends_option() {
        Assert.assertTrue(calendarEventPage.endsRadio.isSelected());
    }

    @Then("Verify that following message as a summary is displayed “Summary Daily every one day”")
    public void verify_that_following_message_as_a_summary_is_displayed_Summary_Daily_every_one_day() {
        Assert.assertTrue(calendarEventPage.messageUnderSummary.getText().contains("Daily every 1 day"));
    }

    @Then("Select After ten occurrences as an Ends option")
    public void select_After_ten_occurrences_as_an_Ends_option() {
        calendarEventPage.clickAfterAndEnterValue("10");
    }

    @Then("Verify that following message as a summary is displayed Summary Daily every one day, end after ten occurrences")
    public void verify_that_following_message_as_a_summary_is_displayed_Summary_Daily_every_one_day_end_after_ten_occurrences() {
        Assert.assertTrue(calendarEventPage.messageUnderSummary.getText().contains("Daily every 1 day, end after 10 occurrences"));
    }

    @Then("user should be able to select Select By Nov {int}, {int} as an Ends option")
    public void user_should_be_able_to_select_Select_By_Nov_as_an_Ends_option(Integer int1,Integer int2) {
        calendarEventPage.repeatBy.click();
        calendarEventPage.repeatChooseDate.sendKeys("Nov 21, 2021", Keys.ENTER);
    }

    @Then("user should be able to Verify that following message as a summary is displayed Summary Daily every {int} day, end by Nov {int}, {int}")
    public void user_should_be_able_to_Verify_that_following_message_as_a_summary_is_displayed_Summary_Daily_every_day_end_by_Nov(Integer int1,Integer int2,Integer int3) {
        Assert.assertTrue(calendarEventPage.messageUnderSummary.getText().contains("Daily every 1 day, end by Nov 21, 2021"));
    }

    @Then("user should be able to select weekly options as a repeat option")
    public void user_should_be_able_to_select_weekly_options_as_a_repeat_option() {
        Select repeatsDropdown = new Select(repeatDaily);
        repeatsDropdown.selectByVisibleText("Weekly");
    }

    @Then("user should be able to select Select Monday and Friday options as a Repeat On options")
    public void user_should_be_able_to_select_Select_Monday_and_Friday_options_as_a_Repeat_On_options() {
        calendarEventPage.Monday.click();
        calendarEventPage.Friday.click();
    }

    @Then("user should be able to Verify that Monday and Friday options are selected")
    public void user_should_be_able_to_Verify_that_Monday_and_Friday_options_are_selected() {
        Assert.assertTrue(calendarEventPage.Monday.isSelected()&&calendarEventPage.Friday.isSelected());
    }

    @Then("user should be able to Verify that following message as a summary is displayed Summary Weekly every {int} week on Monday, Friday")
    public void user_should_be_able_to_Verify_that_following_message_as_a_summary_is_displayed_Summary_Weekly_every_week_on_Monday_Friday(Integer int1) {
        Assert.assertTrue(calendarEventPage.messageUnderSummary.getText().contains("Weekly every 1 week on Monday, Friday"));
    }
}
