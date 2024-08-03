package ge.tbc.itacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class BookingDetailsPage {
    public SelenideElement
            confirmationNumberField = $("#confirmationNumber"),
            pinCode = $("#pinCode"),
            continueButton = $(byTagAndText("span", "Continue")),
            errorMessage = $("div[role='alert'] p");
}
