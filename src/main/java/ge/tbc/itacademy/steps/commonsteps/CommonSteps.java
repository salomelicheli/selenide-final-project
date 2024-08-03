package ge.tbc.itacademy.steps.commonsteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ge.tbc.itacademy.pages.commonpages.CommonElements;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.interactable;
import static ge.tbc.itacademy.util.HelperFunctions.clickElementUsingJSExecutor;

public class CommonSteps {
    CommonElements commonElements = new CommonElements();

    @Step("Click on the search button")
    public CommonSteps clickOnSearchButton() {
        commonElements.searchButton.click();
        return this;
    }

    @Step("Wait for the page to load")
    public CommonSteps waitForLoading() {
        commonElements.signInButton.should(Condition.appear);
        return this;
    }

    public CommonSteps mainPageLoad() {
        commonElements.mainPage.shouldBe(interactable);
        return this;
    }

    @Step("Click on the customer service button")
    public void clickCustomerServiceButton() {
        commonElements.helpCenterButton.click();
    }

    @Step("Click on the sign-in button")
    public void clickSignIn() {
        commonElements.signInButton.click();
    }

    @Step("Click on the language change button")
    public void clickLanguageChangeBtn() {
        clickElementUsingJSExecutor(commonElements.languagePicker);
    }

    @Step("Switch to another window")
    public CommonSteps switchToAnotherWindow() {
        Selenide.switchTo().window(1);
        return this;
    }

    @Step("Open URL: {url}")
    public void openUrl(String url) {
        Selenide.open(url);
    }

    @Step("Get copied URL from clipboard")
    public String copiedUrl() {
        return Selenide.clipboard().getText();
    }

    @Step("Close the current window")
    public CommonSteps closeWindow() {
        Selenide.closeWindow();
        return this;
    }

    @Step("Navigate to Flights page")
    public CommonSteps navigateToFlightsPage() {
        commonElements.flights.click();
        return this;
    }

    @Step("Navigate to Car Rentals page")
    public void navigateToCarRentalsPage() {
        commonElements.carRentals.click();
    }
}
