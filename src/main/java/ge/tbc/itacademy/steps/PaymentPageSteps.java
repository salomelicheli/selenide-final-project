package ge.tbc.itacademy.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.itacademy.pages.PaymentPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.switchTo;

public class PaymentPageSteps {
    PaymentPage paymentPage = new PaymentPage();

    @Step("Validate payment page is visible")
    public PaymentPageSteps validatePaymentPage() {
        paymentPage.paymentSection.should(Condition.appear);
        return this;
    }

    @Step("Switch to payment frame")
    public PaymentPageSteps switchToPaymentFrame() {
        paymentPage.paymentFrame.should(Condition.appear);
        switchTo().frame(paymentPage.paymentFrame);
        return this;
    }

    @Step("Validate card holder's name is: {0}")
    public void validateCardHoldersName(String fullName) {
        Assert.assertEquals(paymentPage.cardHolderNameField.getValue(), fullName);
    }
}
