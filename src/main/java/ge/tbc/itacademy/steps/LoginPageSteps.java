package ge.tbc.itacademy.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.itacademy.pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();

    @Step("Validate login page")
    public LoginPageSteps validateLoginPage() {
        loginPage.emailAddressField.should(Condition.appear);
        return this;
    }

    @Step("Fill email field with: {email}")
    public LoginPageSteps fillEmailField(String email) {
        loginPage.emailAddressField.sendKeys(email);
        return this;
    }

    @Step("Click continue button")
    public LoginPageSteps clickContinueButton() {
        loginPage.submitButton.click();
        return this;
    }

    @Step("Validate error message: {errorMessage}")
    public void validateErrorMessage(String errorMessage) {
        loginPage.errorMessage.should(Condition.appear);
        Assert.assertEquals(loginPage.errorMessage.getText(), errorMessage);
    }

    @Step("Click on Apple button")
    public void clickOnAppleButton() {
        loginPage.appleWindow.click();
    }
}
