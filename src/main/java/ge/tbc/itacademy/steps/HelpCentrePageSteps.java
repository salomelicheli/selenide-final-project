package ge.tbc.itacademy.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.itacademy.pages.HelpCentrePage;
import io.qameta.allure.Step;

public class HelpCentrePageSteps {
    HelpCentrePage helpCentre = new HelpCentrePage();

    @Step("validate that help centre page appears")
    public HelpCentrePageSteps validateHelpCentrePage() {
        helpCentre.helpCentreTag.should(Condition.appear);
        return this;
    }

    @Step("testing continuing without email")
    public void continueWithoutEmail() {
        helpCentre.continueButton.click();
    }
}
