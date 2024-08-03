package ge.tbc.itacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class FiltersElementsContainer {
    private static final SelenideElement Container = $("#bodyconstraint");
    public SelenideElement
            propertyRating = $("input[aria-label*='3 stars']"),
            sortingElement = $(byAttribute("data-testid","sorters-dropdown-trigger")),
            sortByPrice = $x("//span[text()='Price (lowest first)']"),
            propertyRatingLabel = $("label[data-testid*='filter:class']"),
            distanceFilterLabel = $("label[data-testid*='filter:distance']"),
            onlinePaymentFilter = Container.$("[data-filters-group=pmt] [data-testid=filters-group-label-container]"),
            onlinePaymentLabel = $("label[data-testid='filter:pmt=101']"),
            reviewScoreFilter =Container.$("div[data-filters-item='review_score:review_score=90'] input"),
            priceSlider = $x("//div[@data-testid=\"filters-group\"]"),
            minimumPrice = priceSlider.$x(".//input[@aria-label=\"Min.\"]"),
            maximumPrice = priceSlider.$x(".//input[@aria-label=\"Max.\"]"),
            minimumSliderDot= priceSlider.$x(".//div[@role=\"none\"][1]"),
            maximumSliderDot = priceSlider.$x(".//div[@role=\"none\"][2]"),
            loader = $x("//div[@data-testid=\"skeleton-loader\"]");
    public ElementsCollection distanceFromCentre =
            Container.$$("div[data-filters-group='distance'] div[data-filters-item*=distance] label");
}
