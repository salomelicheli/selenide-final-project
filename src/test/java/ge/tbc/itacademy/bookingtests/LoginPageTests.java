package ge.tbc.itacademy.bookingtests;

import ge.tbc.itacademy.configurations.Config;
import ge.tbc.itacademy.data.ConstantData;
import ge.tbc.itacademy.data.ProblematicUserData;
import ge.tbc.itacademy.steps.AppleLoginWindowSteps;
import ge.tbc.itacademy.steps.LoginPageSteps;
import ge.tbc.itacademy.steps.PasswordRegistrationPageSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static ge.tbc.itacademy.data.ConstantData.*;
import static ge.tbc.itacademy.util.HelperFunctions.randomUserEmail;

@Epic("Booking.com functional tests")
@Feature("Login Tests")
public class LoginPageTests extends Config {
    LoginPageSteps loginSteps;
    PasswordRegistrationPageSteps registrationSteps;
    AppleLoginWindowSteps appleLogin;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        loginSteps = new LoginPageSteps();
        registrationSteps = new PasswordRegistrationPageSteps();
        appleLogin = new AppleLoginWindowSteps();
    }

    @BeforeMethod(alwaysRun = true)
    public void navigateToLoginPage() {
        common.waitForLoading()
                .clickSignIn();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Story("Invalid login attempts")
    @Description("Test to verify error message when using a wrong email format")
    public void wrongFormatEmailTest() {
        loginSteps.validateLoginPage()
                .fillEmailField(ConstantData.WRONG_EMAIL)
                .clickContinueButton()
                .validateErrorMessage(WRONG_EMAIL_FORMAT_ERR);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.MINOR)
    @Story("Password mismatch during registration")
    @Description("Test to verify error message when passwords do not match during registration")
    public void mismatchPasswordTest() {
        loginSteps.validateLoginPage()
                .fillEmailField(randomUserEmail())
                .clickContinueButton();
        registrationSteps.validateRegistrationForm()
                .fillPasswordField(PASSWORD)
                .repeatPassword(REPEATED_PASSWORD)
                .clickSubmitButton()
                .validateMismatchError(MISMATCH_PASSWORD_ERROR);
    }

    @Test(dataProvider = "fakePassData", dataProviderClass = ProblematicUserData.class, priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Story("Unstable password error handling")
    @Description("Test to verify error messages for various unstable passwords during registration")
    public void unstablePasswordTest(String pass, String errorMessage) {
        loginSteps.validateLoginPage()
                .fillEmailField(randomUserEmail())
                .clickContinueButton();
        registrationSteps.validateRegistrationForm()
                .fillPasswordField(pass)
                .repeatPassword(pass)
                .clickSubmitButton()
                .validateUnstablePassError(errorMessage);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Story("Apple login window validation")
    @Description("Test to validate the Apple login window")
    public void windowTest() {
        loginSteps.clickOnAppleButton();
        common.switchToAnotherWindow();
        appleLogin.validateEmailField()
                .validateTitle(TITLE);
    }
}
