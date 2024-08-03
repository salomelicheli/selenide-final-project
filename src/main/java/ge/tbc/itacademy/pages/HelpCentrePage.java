package ge.tbc.itacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class HelpCentrePage {
    public SelenideElement
            helpCentreTag = $("div[data-testid='web-shell-global-alert']"),
            continueButton = $(byTagAndText("span", "Continue without an account"));
}
