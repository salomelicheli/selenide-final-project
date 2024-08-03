package ge.tbc.itacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {
    public SelenideElement
            paymentSection = $("div.payment-section"),
            paymentFrame = $("iframe[title='Payment']"),
            cardHolderNameField = $("input[name='name']");
}
