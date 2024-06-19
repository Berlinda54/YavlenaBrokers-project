package com.Yavlena.pages;

import com.Yavlena.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchBrokerPage {


    public SearchBrokerPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='MuiCardContent-root mui-style-q8glis']/a /h6")
    public List<WebElement> brokersName;

    @FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6 mui-style-crk47i']")
    public WebElement brokerName;

    @FindBy(id = "broker-keyword")
    public WebElement searchBar;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textDarkBlue MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textDarkBlue MuiButton-sizeMedium MuiButton-textSizeMedium mui-style-mc33y5']")
    public WebElement details;

    @FindBy(xpath="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium mui-style-pslrw1']")
    public WebElement understood;

    @FindBy(partialLinkText = "properties")
    public WebElement properties;

    @FindBy(xpath="//span[@class='MuiTypography-root MuiTypography-textSmallRegular mui-style-14x3no9']")
    public WebElement address;

    @FindBy(xpath="//div[@class='MuiStack-root mui-style-1o9h2dc']")
    public WebElement phoneNumber;

    @FindBy(xpath="//div[@class='MuiStack-root mui-style-1o9h2dc']/a")
    public List<WebElement> phoneNumbers;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textDarkBlue MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textDarkBlue MuiButton-sizeMedium MuiButton-textSizeMedium mui-style-mc33y5']")
    public WebElement closeDetails;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement clearSearchBar;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    public List<WebElement> brokerCard;
}
