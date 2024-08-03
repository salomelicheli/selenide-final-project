package ge.tbc.itacademy.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.itacademy.pages.AppleLoginWindow;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class AppleLoginWindowSteps {
    AppleLoginWindow appleLogin = new AppleLoginWindow();
    @Step("Validate that Apple ID login page opens")
    public AppleLoginWindowSteps validateEmailField() {
        appleLogin.appleId.should(Condition.appear);
        return this;
    }
    @Step("Validate window title: {title}")
    public void validateTitle(String title) {
        appleLogin.windowTitle.shouldHave(text(title));
    }
}
