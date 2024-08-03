package ge.tbc.itacademy.listeners;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class CustomTestListener implements ITestListener {
    private  static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            takingScreenshot();
            logText(getTestMethodName(result) + " screenshot has been taken");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takingScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
        return Files.toByteArray(screenshot);
    }

    @Attachment(value = "Stacktrace", type = "text/plain")
    public static String logText(String message) {
        return message;
    }
}
