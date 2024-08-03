package ge.tbc.itacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement
            emailAddressField = $("#username"),
            submitButton = $("button[type='submit']"),
            errorMessage = $("#username-note"),
            appleWindow = $("a[title='Sign in with Apple']");
}
