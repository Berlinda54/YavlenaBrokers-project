package com.Yavlena.step_definitions;

import com.Yavlena.pages.SearchBrokerPage;
import com.Yavlena.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchBrokerStepDef {

    SearchBrokerPage searchBrokerPage = new SearchBrokerPage();

    List<String> allBrokersName;
    List<String> allPhoneNumbers;
    String selectedBrokerName;

    @Given("user is on the broker search page")
    public void user_is_on_the_broker_search_page() {
        // Click on the understood button to proceed to the broker search page
        searchBrokerPage.understood.click();
    }

    @When("user gets the name of a broker")
    public void user_gets_the_name_of_a_broker() {
        allBrokersName = new ArrayList<>();

        // Collect all broker names from the search results
        for (WebElement each : searchBrokerPage.brokersName) {
            allBrokersName.add(each.getText());
        }

        // Select a random broker name
        Random random = new Random();
        selectedBrokerName = allBrokersName.get(random.nextInt(allBrokersName.size()));
    }

    @And("searches that name of the broker")
    public void user_searches_that_name_of_the_broker() {
        // Enter the selected broker name into the search bar
        searchBrokerPage.searchBar.sendKeys(selectedBrokerName);
    }

    @Then("the searched broker should be the only one displayed")
    public void the_searched_broker_should_be_the_only_one_displayed() {
        // Wait for a brief moment to allow search results to load
        BrowserUtils.sleep(1);

        // Get the name of the displayed broker
        String actualBrokerName = searchBrokerPage.brokerName.getText();

        // Assert that the displayed broker name matches the selected broker name
        Assert.assertEquals(selectedBrokerName, actualBrokerName);

        // Assert that only one broker card is displayed
        int size = searchBrokerPage.brokerCard.size();
        Assert.assertEquals("The number of the card displayed should be only 1", 1, size);
    }

    @And("user should see brokers address, phone numbers and number of properties")
    public void user_should_see_brokers_address_phone_numbers_and_number_of_properties() {
        // Click to view broker details
        searchBrokerPage.details.click();

        // Verify that the address, phone numbers, and number of properties are displayed
        Assert.assertTrue(searchBrokerPage.address.isDisplayed());
        Assert.assertTrue(searchBrokerPage.properties.isDisplayed());
        Assert.assertTrue(searchBrokerPage.phoneNumber.isDisplayed());

        // Collect all phone numbers displayed for the broker
        allPhoneNumbers = new ArrayList<>();
        for (WebElement each : searchBrokerPage.phoneNumbers) {
            allPhoneNumbers.add(each.getText());
        }

        // Assert that the number of phone numbers is either 1 or 2
        int phoneNumberSize = allPhoneNumbers.size();
        Assert.assertTrue("The size of the phone numbers list should be 1 or 2", phoneNumberSize == 1 || phoneNumberSize == 2);

        // Close the broker details and clear the search bar for the next test
        searchBrokerPage.closeDetails.click();
        searchBrokerPage.clearSearchBar.click();
    }
}