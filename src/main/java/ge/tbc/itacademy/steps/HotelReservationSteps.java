package ge.tbc.itacademy.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.itacademy.pages.HotelReservationPage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.text;

public class HotelReservationSteps {

    SoftAssert sfa;
    HotelReservationPage reservationPage = new HotelReservationPage();

    public HotelReservationSteps(SoftAssert sfa) {
        this.sfa = sfa;
    }

    @Step("Validate booking form appearance")
    public HotelReservationSteps validateBookingForm() {
        reservationPage.bookingInfoForm.should(Condition.appear);
        return this;
    }

    @Step("Fill first name field with: {0}")
    public HotelReservationSteps fillFirstNameField(String firstName) {
        reservationPage.firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("Fill last name field with: {0}")
    public HotelReservationSteps fillLastNameField(String lastName) {
        reservationPage.lastNameField.sendKeys(lastName);
        return this;
    }

    @Step("Fill email field with: {0}")
    public HotelReservationSteps fillEmailField(String email) {
        reservationPage.emailField.sendKeys(email);
        return this;
    }

    @Step("Fill phone number field with: {0}")
    public HotelReservationSteps fillNumberField(String phoneNumber) {
        reservationPage.numberField.sendKeys(phoneNumber);
        return this;
    }

    @Step("Get Users Number")
    public String getInputNumber() {
        return reservationPage.numberField.getValue();
    }

    @Step("Validate that error has appeared")
    public void validateErrorAppearance(boolean isValid, String errorMark) {
        if(!isValid) {
            String borderColor = reservationPage.numberField.getCssValue("border-color");
            sfa.assertEquals(borderColor, errorMark);
        }
    }

    @Step("Select country: {0}")
    public HotelReservationSteps selectCountry(String country) {
        Select select = new Select(reservationPage.countryDropdown);
        select.selectByVisibleText(country);
        return this;
    }

    @Step("Validate error message: {0}")
    public HotelReservationSteps validateErrorMessage(String message) {
        reservationPage.errorMessage.should(Condition.appear).shouldHave(text(message));
        return this;
    }

    @Step("Clear email input field")
    public HotelReservationSteps clearEmailInput() {
        reservationPage.emailField.clear();
        return this;
    }

    @Step("Click on next button")
    public void clickOnNextButton() {
        reservationPage.nextButton.click();
    }

    @Step("Fill address field with: {0}")
    public HotelReservationSteps fillAddressField(String address) {
        if (reservationPage.addressField.isDisplayed()) {
            reservationPage.addressField.sendKeys(address);
        }
        return this;
    }

    @Step("Fill city field with: {0}")
    public HotelReservationSteps fillCityField(String city) {
        if (reservationPage.cityField.isDisplayed()) {
            reservationPage.cityField.sendKeys(city);
        }
        return this;
    }
}
