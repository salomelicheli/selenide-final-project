package ge.tbc.itacademy.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.itacademy.pages.LandingPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class LandingPageSteps {
    LandingPage landingPage = new LandingPage();

    @Step("Fill in destination: {0}")
    public LandingPageSteps fillInDestination(String destination) {
        landingPage.destinationInputField.sendKeys(destination);
        landingPage.searchAutocompleteResults.get(0).shouldHave(text(destination));
        return this;
    }

    @Step("Validate error appearance")
    public LandingPageSteps validateErrorApparition() {
        landingPage.error_alert.should(Condition.appear);
        return this;
    }

    @Step("Validate error message: {0}")
    public void validateErrorMessage(String errorMessage) {
        landingPage.error_alert.shouldHave(text(errorMessage));
    }

    @Step("Choose result at index {0} with place {1}")
    public void chooseResult(){
        landingPage.searchAutocompleteResults.get(0).shouldBe(interactable, visible).click();
    }

    @Step("Click on occupancy tab")
    public void clickOnOccupancyTab(){
        landingPage.occupancyTab.click();
    }

    public String getDescriptionText() {
        return landingPage.descriptionTitle.getText();
    }

}
