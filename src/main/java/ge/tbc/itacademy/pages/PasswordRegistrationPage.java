package ge.tbc.itacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PasswordRegistrationPage {
    public ElementsCollection
            passwordFields = $$("input[type='password']");
    public SelenideElement
            errorMessage = $("#confirmed_password-note"),
            registrationForm = $("form.nw-register"),
            createAccountBtn = $("button[type='submit']"),
            newPasswordError = $("#new_password-note");
}
