package com.vytrack.pages.activities;

import com.vytrack.pages.PageBase;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.DateTimeUtilities;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CalendarEventPage extends PageBase {

    @FindBy(xpath = "//table/tbody//td[9]")
    private List<WebElement> threeDots;

    @FindBy(xpath = "//div[@id='bottom-anchor']/following-sibling::ul//a")
    private List<WebElement> threedotMenu;

    @FindBy(css = "a[class='btn main-group btn-primary pull-right ']")
    private WebElement createCalendarBtn;

    @FindBy(xpath = "//a[@href='#']//i[@class='fa-cog hide-text']")
    private WebElement gridBtn;

    @FindBy(xpath = "//thead[@class='grid-header']//th[2]")
    private WebElement tableHeaderName;

    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']//span")
    private WebElement expandOfSaveAndClose;

    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']/following-sibling::ul/li")
    private List<WebElement> SaveAndCloseOptions;

    @FindBy(xpath = "//a[@title='Cancel']")
    private WebElement cancelBtn;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement time1;
    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement time2;

    @FindBy(name = "oro_calendar_event_form[allDay]")
    public WebElement allDay;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[1]")
    private WebElement startDate;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[2]")
    private WebElement endDate;

    @FindBy(xpath = "//input[@data-name=\"recurrence-repeat\"]")
    public WebElement repeatBtn;

    @FindBy(xpath = "//label[@class='fields-row']//input[@type='radio'and @checked='checked']")
    public WebElement repeatEveryRadio;

    @FindBy(xpath = "//span[contains(text(),'Never')]/..//input")
    public WebElement endsRadio;

    @FindBy(xpath = "//div[@class=\"control-group recurrence-summary alert-info\"]")
    public WebElement messageUnderSummary;

    @FindBy(xpath = "//span[contains(text(),'After')]/..//input[@type='radio']")
    public WebElement afterRadio;

    @FindBy(xpath = "//span[contains(text(),'After')]/..//input[@type='text']")
    public WebElement afterText;

    @FindBy(xpath = "//span[contains(text(),'By')]/..//input")
    public WebElement repeatBy;

    @FindBy(xpath = "//span[text()='By']/../..//div//input[2]")
    public WebElement repeatChooseDate;
    @FindBy(xpath = "//select[@data-name=\"recurrence-repeats\"]")
    public WebElement repeatDaily;

    @FindBy(xpath = "//span[text()='M']/..//input")
    public WebElement Monday;

    @FindBy(xpath = "//span[text()='F']/..//input")
    public WebElement Friday;
    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement subtitle;

    @FindBy(css = "ul[class='ui-timepicker-list']>li")
    private List<WebElement> startTimeMenu;

    public void navigateTo(String tabName,String moduleName)
    {
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'"+tabName+"')]";
        String moduleXpath = "//span[@class='title title-level-2' and text() = '"+moduleName+"']";
        WebElement tabElement = Driver.getDriver().findElement(By.xpath(tabNameXpath));
        WebElement moduleElement= Driver.getDriver().findElement(By.xpath(moduleXpath));
        Actions actions = new Actions(Driver.getDriver());
        Wait.wait(5);
        actions.moveToElement(tabElement).pause(1000).click(moduleElement).build().perform();
        Wait.wait(5);


    }
    public List<WebElement> getThreedotMenu() {
        return threedotMenu;
    }

    public List<WebElement> getThreeDots() {
        return threeDots;
    }


    public Boolean isIconVisible(String icon){
        return driver.findElement(By.xpath("//li[@class='launcher-item']//a[@title='"+icon+"']")).isDisplayed();
    }

    public void deselectAllOptionsInGrid(){
        List<WebElement> allNames = driver.findElements(By.xpath("//tbody[@class='ui-sortable']//tr"));
        List<WebElement> allClick = driver.findElements(By.xpath("//tbody[@class='ui-sortable']//tr//td[3]//input"));

        for (int i = 0; i <allNames.size() ; i++) {
            if ((!allNames.get(i).getText().equals("Title"))&&allClick.get(i).isSelected()){
                allClick.get(i).click(); // un_click it
            }
        }
    }

    public List<String> getSaveAndCloseOptions(){
        return BrowserUtilities.getTextFromWebElements(SaveAndCloseOptions);
    }

    public void clickExpandSaveAndClose(){
        wait.until(ExpectedConditions.elementToBeClickable(expandOfSaveAndClose));
        expandOfSaveAndClose.click();
    }


    public void clickGridSettings(){
        wait.until(ExpectedConditions.elementToBeClickable(gridBtn));
        gridBtn.click();
    }

    public String getTableHeaderName(){
        return tableHeaderName.getText();
    }

    public void clickOnCreateCalendarEventBtn(){
        wait.until(ExpectedConditions.visibilityOf(createCalendarBtn));
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarBtn));
        createCalendarBtn.click();
    }

    public void getNameOfTheDropdown(){
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(5);
        driver.findElement(By.xpath("(//div[@class='controls']//input[@type='text'])[3]")).sendKeys("sadasad");
        BrowserUtilities.wait(1);
        List<WebElement> allDropdownElements = driver.findElements(By.xpath("//li//button[@type='submit']"));
//        return BrowserUtilities.getTextFromWebElements(allDropdownElements);
        allDropdownElements.forEach(each-> System.out.println(each.getText().trim()));
    }

    public void clickOnCancelBtn(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(cancelBtn));
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));
        cancelBtn.click();
    }
    public boolean isAllCalendarEventsDisplayed(){
        return driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).isDisplayed();
    }
    public String getCalendarSubTitle(){
        wait.until(ExpectedConditions.visibilityOf(subtitle));
        return subtitle.getText().trim();
    }

    public long getTimeDifferences(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(time1));
        String time1Full = time1.getAttribute("value");
        String time2Full = time2.getAttribute("value");
        return DateTimeUtilities.getTimeDifference(time1Full, time2Full, "h:m a");
    }

    public void selectTime(String time){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(time1));
        time1.clear();
        time1.sendKeys(time, Keys.ENTER);
    }

    public void selectTime_1() {
        wait.until(ExpectedConditions.visibilityOf(time1));
        time1.click();
        for (WebElement startTimeMenu : startTimeMenu) {
            if (startTimeMenu.getText().equals("9:00 PM"))
                startTimeMenu.click();
        }
    }
    public String getTime1(){
        return time1.getAttribute("value");
    }
    public String getTime2(){
        return time2.getAttribute("value");
    }

    public void clickOnAllDayEvent(){
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
        allDay.click();
        BrowserUtilities.wait(2);
    }

    public boolean isTimesAreDisplayed(){
        return time1.isDisplayed()&&time2.isDisplayed();
    }

    public boolean isDatesAreDisplayed(){
        return  startDate.isDisplayed()&&endDate.isDisplayed();
    }

    public void clickOnRepeatBtn(){
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
        repeatBtn.click();
        BrowserUtilities.wait(2);
    }

    public String getDefaultOption(){
        Select a = new Select(driver.findElement(By.xpath("//select[@data-name=\"recurrence-repeats\"]")));
        return a.getFirstSelectedOption().getText();
    }

    public List<String> getAllDropdown(){
        Select a = new Select(driver.findElement(By.xpath("//select[@data-name=\"recurrence-repeats\"]")));
        return BrowserUtilities.getTextFromWebElements(a.getOptions());
    }

    public void clickAfterAndEnterValue(String str){
        afterRadio.click();
        afterText.sendKeys(str,Keys.ENTER);
    }

}
