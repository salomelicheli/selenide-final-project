package ge.tbc.itacademy.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.itacademy.pages.BookingDetailsPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class BookingDetailsPageSteps {
    BookingDetailsPage bookingDetails = new BookingDetailsPage();

    @Step("Fill confirmation number field with wrong data: {0}")
    public BookingDetailsPageSteps fillConfirmationNumberField(String number) {
        bookingDetails.confirmationNumberField.sendKeys(number);
        return this;
    }
    @Step("Fill zip code field with wrong data: {0}")
    public BookingDetailsPageSteps fillZipCodeField(String pinCode) {
        bookingDetails.pinCode.sendKeys(pinCode);
        return this;
    }

    @Step("click on a submit button to continue")
    public BookingDetailsPageSteps clickContinueButton() {
        bookingDetails.continueButton.click();
        return this;
    }

    @Step("Validate that error message is: {0}")
    public void validateErrorMessage(String errorMessage) {
        bookingDetails.errorMessage.should(Condition.appear).shouldHave(text(errorMessage));
    }
}
