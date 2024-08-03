package ge.tbc.itacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class LandingPage {
    public SelenideElement
            destinationInputField = $(byAttribute("name", "ss")),
            occupancyTab = $(byAttribute("data-testid", "occupancy-config")),
            error_alert = $("div[data-testid='searchbox-alert'] div"),
            descriptionTitle = $("p[data-testid='herobanner-subtitile']");
    public ElementsCollection
            searchAutocompleteResults = $$x("//li[contains(@id, 'autocomplete-result')]//div[@data-testid]//div//div[1]");
}