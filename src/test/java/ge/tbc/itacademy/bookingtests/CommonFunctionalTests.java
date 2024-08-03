package ge.tbc.itacademy.bookingtests;

import ge.tbc.itacademy.configurations.Config;
import ge.tbc.itacademy.data.ConstantData;
import ge.tbc.itacademy.steps.*;
import ge.tbc.itacademy.steps.commonsteps.DatePickerSectionSteps;
import ge.tbc.itacademy.steps.commonsteps.LanguageDetectApiSteps;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.itacademy.data.ConstantData.*;

@Epic("Booking.com functional tests")
public class CommonFunctionalTests extends Config {
    HelpCentrePageSteps helpCentre;
    BookingDetailsPageSteps bookingDetails;
    LandingPageSteps landingSteps;
    OccupancyConfigContainerSteps occupancyConfigSteps;
    DatePickerSectionSteps datesSteps;
    LanguageChangePageSteps changeLanguage;
    LanguageDetectApiSteps apiSteps;
    StaysResultPageSteps staysSteps;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        helpCentre = new HelpCentrePageSteps();
        bookingDetails = new BookingDetailsPageSteps();
        landingSteps = new LandingPageSteps();
        occupancyConfigSteps = new OccupancyConfigContainerSteps();
        apiSteps = new LanguageDetectApiSteps();
        changeLanguage = new LanguageChangePageSteps();
        staysSteps = new StaysResultPageSteps(sfa);
        datesSteps = new DatePickerSectionSteps(sfa);
    }

    @Test(priority = 1, description = "Help centre error test")
    @Severity(SeverityLevel.NORMAL)
    @Story("Help Centre Error Validation")
    @Description("Test to validate the error message displayed when invalid booking details are provided in the Help Centre.")
    public void HelpCentreErrorTest() {
        common.mainPageLoad()
                .clickCustomerServiceButton();
        helpCentre.validateHelpCentrePage()
                .continueWithoutEmail();
        bookingDetails.fillConfirmationNumberField(CONFIRMATION_NUMBER)
                .fillZipCodeField(ZIP_CODE)
                .clickContinueButton()
                .validateErrorMessage(BOOKING_ERROR_MESSAGE);
    }

    @Test(description = "language change functional test", priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Story("Language Change Functionality")
    @Description("Test to validate the functionality of language change and ensure the detected language code is correct.")
    public void LanguageChangeTest() {
        common.mainPageLoad()
                .clickLanguageChangeBtn();
        changeLanguage.selectLanguage();
        apiSteps.getPropertie();
        Response response = apiSteps
                .getLanguageResponse(landingSteps.getDescriptionText());
        apiSteps.checkStatusCode(response);
        String jsonBody = response.asString();
        String languageCode = apiSteps.codeOfLanguage(jsonBody);
        Assert.assertEquals(languageCode, LANGUAGE_CODE);
    }

    @Test(priority = 3, description = "Stay page search functional tests")
    @Severity(SeverityLevel.NORMAL)
    @Story("Stays Page Search Functionality")
    @Description("Test to validate the search functionality on the Stays page, including calendar and occupancy settings.")
    public void StaysPageSearchFunctionalTest() {
        common.mainPageLoad();
        datesSteps.clickCalendar()
                .checkingCalendarVisibility()
                .moveOnFlexibleTab()
                .chooseStayDuration(ConstantData.STAY_DURATION)
                .chooseStayDuration(ConstantData.MONTH_STAY_DURATION)
                .validateOneCheckedAtTime()
                .validateFirstMonth();
        landingSteps.clickOnOccupancyTab();
        occupancyConfigSteps.setDefaults()
                .checkGroupAdultButtonFunctional()
                .checkGroupChildrenButtonFunctional()
                .checkRoomButtonFunctional()
                .validateNumberOfAdults()
                .validateNumberOfChildren()
                .validateNumberOfRooms()
                .clickGrpChildrenBtnNTimes(8)
                .checkAgeSelectDropdownNumber();
        common.clickOnSearchButton();
        landingSteps.validateErrorApparition()
                .validateErrorMessage(ConstantData.SEARCH_ERROR_MESSAGE);
    }
}
