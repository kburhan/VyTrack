package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {

    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(id = "remember_me")
    private WebElement rememberMe;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    private WebElement warningMessage;



  public LoginPage()

  {//what is the page class ? this
      PageFactory.initElements(Driver.getDriver(),this);
  }

  public String getWarningMessage()
  {
      return warningMessage.getText();
  }


  //Login Method #1
    //login as specific user
  public void login (String username,String passsword, boolean ifRemember) {

      this.username.sendKeys(username);
      this.password.sendKeys(passsword);
      if (ifRemember) {
          rememberMe.click();
      }
      login.click();
  }

  //Login Method #2 using properties file.
    //login as default user stated in properties file
  public void login()
  {
      username.sendKeys(ConfigurationReader.getProperty("store_manager"));
      password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
      BrowserUtilities.waitForPageToLoad(10);
  }

  public void login(String username){
      switch (username) {
          case "sales manager":
              login(ConfigurationReader.getProperty("sales_manager"), ConfigurationReader.getProperty("password"), false);
              break;
          case "store manager":
              login(ConfigurationReader.getProperty("store_manager"), ConfigurationReader.getProperty("password"), false);
              break;
          case "driver":
              login(ConfigurationReader.getProperty("driver"), ConfigurationReader.getProperty("password"), false);
              break;
      }
  }

}


