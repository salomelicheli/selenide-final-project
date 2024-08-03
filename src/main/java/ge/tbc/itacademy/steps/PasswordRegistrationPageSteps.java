package ge.tbc.itacademy.steps;

import ge.tbc.itacademy.pages.PasswordRegistrationPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.appear;

public class PasswordRegistrationPageSteps {
    PasswordRegistrationPage registrationPage = new PasswordRegistrationPage();

    @Step("Validate registration form is visible")
    public PasswordRegistrationPageSteps validateRegistrationForm() {
        registrationPage.registrationForm.should(appear);
        return this;
    }

    @Step("Fill password field with value: {0}")
    public PasswordRegistrationPageSteps fillPasswordField(String password) {
        registrationPage.passwordFields.get(0).sendKeys(password);
        return this;
    }

    @Step("Repeat password field with value: {0}")
    public PasswordRegistrationPageSteps repeatPassword(String password) {
        registrationPage.passwordFields.get(1).sendKeys(password);
        return this;
    }

    @Step("Validate mismatch error message: {0}")
    public void validateMismatchError(String message) {
        registrationPage.errorMessage.should(appear);
        Assert.assertEquals(registrationPage.errorMessage.getText(), message);
    }

    @Step("Validate unstable password error message: {0}")
    public void validateUnstablePassError(String message) {
        registrationPage.newPasswordError.should(appear);
        Assert.assertEquals(registrationPage.newPasswordError.getText(), message);
    }

    @Step("Click on Submit button")
    public PasswordRegistrationPageSteps clickSubmitButton() {
        registrationPage.createAccountBtn.click();
        return this;
    }
}
