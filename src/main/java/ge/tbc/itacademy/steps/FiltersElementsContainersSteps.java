package ge.tbc.itacademy.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.itacademy.pages.FiltersElementsContainer;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.interactable;

public class FiltersElementsContainersSteps {
    FiltersElementsContainer elements = new FiltersElementsContainer();

    @Step("Check Property Rating")
    public FiltersElementsContainersSteps checkPropertyRating() {
        elements.propertyRating.click();
        return this;
    }

    @Step("Wait For The Filter To Load")
    public void waitForTheFilterToLoad() {
        elements.propertyRatingLabel.should(Condition.appear);
    }

    @Step("Click on a filters dropdown")
    public FiltersElementsContainersSteps clickOnSortingTab() {
        elements.sortingElement.click();
        return this;
    }

    @Step("Sorting prices from low to high")
    public FiltersElementsContainersSteps sortingAccordingToPrice() {
        elements.sortByPrice.click();
        return this;
    }

    @Step("Clicking on distance filter")
    public void checkDistanceFilter() {
        elements.distanceFromCentre.get(1).click();
        elements.distanceFilterLabel.should(Condition.appear);
    }

    @Step("Checking online payment filter")
    public void checkOnlinePayment() {
        elements.onlinePaymentFilter.shouldBe(interactable).click();
        elements.onlinePaymentLabel.should(Condition.appear);
    }

    @Step("Check Review Score")
    public FiltersElementsContainersSteps checkReviewScore() {
        elements.reviewScoreFilter.click();
        return this;
    }
}
