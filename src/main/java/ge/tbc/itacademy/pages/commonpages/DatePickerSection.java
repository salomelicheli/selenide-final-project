package ge.tbc.itacademy.pages.commonpages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.*;

public class DatePickerSection {
    public SelenideElement
            datePicker = $(byAttribute("data-testid", "searchbox-dates-container")),
            calendarTab = $("button[aria-controls*='calendar']"),
            flexibleTab = $(byAttribute("aria-controls","flexible-searchboxdatepicker")),
            selectDateBtn = $x("//span[contains(text(), 'Select dates')]/parent::button");
    public ElementsCollection
            radioButtons = $$("div[data-testid='flexible-dates-day'] input"),
            monthSelectionButtons = $$("label[data-testid='flexible-dates-month']"),
            months = $$("label[data-testid='flexible-dates-month'] span span + span");

    public SelenideElement chooseDuration(String duration) {
        return $x("//div[@data-testid='flexible-dates-day']//div[text()='" + duration + "']");
    }
}
