package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before()
    public void setup() {
        Driver.getDriver().manage().window().maximize();
        System.out.println("Test Setup");
    }


    @After()
    public void teardown(){

        System.out.println("Test Clean Up");
        Driver.closeDriver();
    }
}
