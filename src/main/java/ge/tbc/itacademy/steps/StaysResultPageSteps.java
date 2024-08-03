package ge.tbc.itacademy.steps;

import ge.tbc.itacademy.data.LocationData;
import ge.tbc.itacademy.pages.StaysResultPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selectors.byTagName;
import static ge.tbc.itacademy.util.HelperFunctions.*;
import static org.apache.commons.lang.StringUtils.substringBeforeLast;
import static org.apache.commons.lang3.StringUtils.substringAfterLast;

public class StaysResultPageSteps {
    StaysResultPage staysPage = new StaysResultPage();
    LocationData location = new LocationData();
    SoftAssert sfa;

    public StaysResultPageSteps(SoftAssert sfa) {
        this.sfa = sfa;
    }

    @Step("Check that offer locations contain: {0}")
    public StaysResultPageSteps checkThatOfferLocationsAreCorrect(String expectedLocation, String assertionError) {
        staysPage.hotelOffers.forEach(x -> sfa.assertTrue(x.getText().contains(expectedLocation), assertionError));
        return this;
    }

    @Step("Validate that property ratings are correct")
    public StaysResultPageSteps validateThatPropertyRatingAreCorrect(int rating) {
        staysPage.hotelRatings.forEach(x -> sfa.assertEquals(x.$$(byTagName("span")).size(), rating));
        return this;
    }

    @Step("Check that prices are sorted in ascending order")
    public void checkThatPricesAreSorted() {
        int size = staysPage.prices.size() - 1;
        for (int i = 0; i < size; i++) {
            double currentHotelPrice = extractValueFromElement(staysPage.prices.get(i));
            double nextHotelPrice = extractValueFromElement(staysPage.prices.get(i + 1));
            Assert.assertTrue(nextHotelPrice >= currentHotelPrice);
        }
    }

    @Step("Validate correct distance information")
    public StaysResultPageSteps validateCorrectDistance(int minDistance) {
        staysPage.distanceInfo
                .filterBy(matchText("[^\\d.]")).forEach(x -> sfa.assertTrue(convertToKilometers(x.getText()) <= minDistance));
        return this;
    }

    @Step("Click on hotel availability button")
    public void clickOnHotelAvailabilityButton() {
        staysPage.hotelAvailabilityButton.click();
    }

    @Step("Set hotel name")
    public StaysResultPageSteps setHotelName() {
        location.setHotelName(staysPage.hotelOffer.getText());
        return this;
    }

    @Step("Get hotel name")
    public String getHotelName() {
        return location.getHotelName();
    }

    @Step("Validate hotel review scores are at least {0}")
    public StaysResultPageSteps validateHotelReviewScores(double expectedLowestReviewScore) {
        staysPage.hotelReviewScores.forEach(x ->
                sfa.assertTrue(Double.parseDouble(substringAfterLast(x.innerText(), " ")) >= expectedLowestReviewScore));
        return this;
    }
}
