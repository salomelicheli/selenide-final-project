package ge.tbc.itacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AppleLoginWindow {
    public SelenideElement
            appleId = $("#account_name_text_field"),
            windowTitle = $("h1[class*='title']");
}
