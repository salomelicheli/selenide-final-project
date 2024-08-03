package ge.tbc.itacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class StaysResultPage {
    public ElementsCollection
            hotelOffers = $$("span[data-testid='address']"),
            hotelRatings = $$(byAttribute("data-testid", "rating-stars")),
            prices = $$(byAttribute("data-testid", "price-and-discounted-price")),
            distanceInfo = $$(byAttribute("data-testid", "distance")),
            hotelReviewScores = $$x("//div[@data-testid='review-score']/div[1]"),
            allDeals = $$x("//div[@data-testid=\"property-card\"]");
    public SelenideElement
            hotelOffer = $(byAttribute("data-testid", "title")),
            hotelAvailabilityButton = $("div[aria-label='Property'] a[data-testid='availability-cta-btn']"),
            header = $("#hotel_header"),
            nightAmountContainer = $x("//div[@data-testid=\"price-for-x-nights\"]");
}
