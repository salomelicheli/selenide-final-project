package ge.tbc.itacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HotelReservationPage {
    public SelenideElement
            bookingInfoForm = $("section[class*='user-details']"),
            firstNameField = $("#firstname"),
            lastNameField = $("#lastname"),
            emailField = $("#email"),
            countryDropdown = $("#cc1"),
            numberField = $("#phone"),
            errorMessage = $("#bp_form_email_msg"),
            nextButton = $("button[data-popover-content-id='bp-submit-popover']"),
            addressField = $("#address1"),
            cityField = $("#city");
}
