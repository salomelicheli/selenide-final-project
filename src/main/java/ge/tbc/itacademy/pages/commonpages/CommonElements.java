package ge.tbc.itacademy.pages.commonpages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CommonElements {
    public SelenideElement
            flights = $(byText("Flights")),
            searchButton = $("button[type='submit']"),
            signInButton = $("a[data-testid='header-sign-in-button']"),
            helpCenterButton = $(byAttribute("data-testid", "header-help-center")),
            languagePicker = $(byAttribute("data-testid", "header-language-picker-trigger")),
            carRentals = $(byText("Car rentals")),
            mainPage = $("div[role=main]");
}
