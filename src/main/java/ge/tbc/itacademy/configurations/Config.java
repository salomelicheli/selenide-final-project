package ge.tbc.itacademy.configurations;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import ge.tbc.itacademy.listeners.CustomTestListener;
import ge.tbc.itacademy.steps.commonsteps.CommonSteps;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.File;

import static ge.tbc.itacademy.data.ConstantData.BOOKING_URL;

@Listeners(CustomTestListener.class)
public class Config {
    protected SoftAssert sfa;
    protected CommonSteps common;
    @BeforeClass(alwaysRun = true)
    public void AbeforeClass() {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src/main/resources/custom_extension.crx"));
        String secretKey = System.getenv("SECRET_TOKEN");
        if(secretKey != null) {
            options.addArguments(
                    "--headless=new",
                    "--no-sandbox",
                    "--disable-dev-shm-usage",
                    "--disable-infobars",
                    "--disable-gpu",
                    "--allow-insecure-localhost",
                    "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36",
                    "--disable-blink-features=AutomationControlled",
                    "--disable-animations");
        }
        options.addArguments("start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        common = new CommonSteps();
        sfa = new SoftAssert();
    }

    @BeforeMethod(alwaysRun = true)
    public void AsetUp(){
        common.openUrl(BOOKING_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        Selenide.closeWebDriver();
        sfa.assertAll();
    }
}
