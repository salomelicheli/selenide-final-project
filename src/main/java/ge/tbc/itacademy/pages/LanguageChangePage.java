package ge.tbc.itacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LanguageChangePage {
    public SelenideElement getLng = $x("//button[@data-testid='selection-item']//span[text() = 'Français']");
}
