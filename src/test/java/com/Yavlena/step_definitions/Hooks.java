package com.Yavlena.step_definitions;

import com.Yavlena.utilities.BrowserUtils;
import com.Yavlena.utilities.ConfigurationReader;
import com.Yavlena.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

/*
In this class we will be able to create "pre" and "post" condition
for ALL the SCENARIOS and even STEPS.
 */
public class Hooks {

    @Before
    public void setupMethod(){

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }



    @After
    public void teardownMethod(Scenario scenario){

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }



        BrowserUtils.sleep(2);
        Driver.closeDriver();

    }






}