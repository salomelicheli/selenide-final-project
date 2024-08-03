package ge.tbc.itacademy.steps;

import ge.tbc.itacademy.pages.LanguageChangePage;
import io.qameta.allure.Step;

import static ge.tbc.itacademy.util.HelperFunctions.clickElementUsingJSExecutor;

public class LanguageChangePageSteps {
    LanguageChangePage languageChange = new LanguageChangePage();

    @Step("Select language")
    public void selectLanguage() {
        clickElementUsingJSExecutor(languageChange.getLng);
    }
}
