package ge.tbc.itacademy.bookingtests;

import ge.tbc.itacademy.configurations.Config;
import ge.tbc.itacademy.data.BookingData;
import ge.tbc.itacademy.data.ConstantData;
import ge.tbc.itacademy.steps.*;
import ge.tbc.itacademy.steps.commonsteps.DatePickerSectionSteps;
import ge.tbc.itacademy.steps.commonsteps.PhoneFormatDetectionApiSteps;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static ge.tbc.itacademy.data.ConstantData.*;
import static ge.tbc.itacademy.util.HelperFunctions.randomUserEmail;

@Epic("Booking.com functional tests")
@Feature("Stays Page Tests")
@Test(groups = "common tests")
public class StaysPageTests extends Config {
    LandingPageSteps landingSteps;
    DatePickerSectionSteps datesSteps;
    FiltersElementsContainersSteps filtersSteps;
    StaysResultPageSteps resultPageSteps;
    HotelPageSteps hotelPageSteps;
    HotelReservationSteps reservationForm;
    PaymentPageSteps paymentSteps;
    OccupancyConfigContainerSteps occupancyConfigSteps;
    PhoneFormatDetectionApiSteps numberFormatDetect;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        landingSteps = new LandingPageSteps();
        datesSteps = new DatePickerSectionSteps(sfa);
        filtersSteps = new FiltersElementsContainersSteps();
        hotelPageSteps = new HotelPageSteps();
        reservationForm = new HotelReservationSteps(sfa);
        paymentSteps = new PaymentPageSteps();
        occupancyConfigSteps = new OccupancyConfigContainerSteps();
        resultPageSteps = new StaysResultPageSteps(sfa);
        numberFormatDetect = new PhoneFormatDetectionApiSteps();
    }

    @BeforeMethod(alwaysRun = true)
    public void searchStaysPage() {
        common.waitForLoading();
        landingSteps.fillInDestination(ConstantData.DESIRED_DESTINATION)
                .chooseResult();
        datesSteps.moveOnFlexibleTab()
                .chooseStayDuration(STAY_DURATION)
                .selectMonth(1)
                .clickSelectButton();
        common.clickOnSearchButton()
                .waitForLoading();
    }

    @Test(priority = 1, description = "sorting, review score, property review test")
    @Severity(SeverityLevel.MINOR)
    @Story("Filtering stays by various criteria")
    @Description("Test to verify filtering stays on the Stays Page by price, review score, and property rating")
    public void StaysPageFilterTest() {
        filtersSteps.clickOnSortingTab()
                .sortingAccordingToPrice()
                .checkReviewScore()
                .checkPropertyRating()
                .waitForTheFilterToLoad();
        resultPageSteps
                .checkThatOfferLocationsAreCorrect(ConstantData.DESIRED_DESTINATION, ASSERT_ERROR)
                .validateThatPropertyRatingAreCorrect(HELPER)
                .validateHotelReviewScores(EXPECTED_LOWEST_SCORE)
                .checkThatPricesAreSorted();
    }

    @Test(priority = 2, description = "distance validation and share link to clipboard")
    @Severity(SeverityLevel.NORMAL)
    @Story("Validating distance filter and share functionality")
    @Description("Test to check distance filter and sharing hotel link functionality")
    public void DistanceFilterAndShareFunctional() {
        filtersSteps.checkDistanceFilter();
        resultPageSteps.validateCorrectDistance(HELPER)
                .setHotelName()
                .clickOnHotelAvailabilityButton();
        common.switchToAnotherWindow()
                .waitForLoading();
        hotelPageSteps.clickOnShareButton()
                .clickOnCopyLink();
        String link = common.copiedUrl();
        common.closeWindow()
                .openUrl(link);
        common.waitForLoading();
        hotelPageSteps.validateHotelName(resultPageSteps.getHotelName());
    }

    @Test(priority = 3, description = "Hotel reservation test")
    @Severity(SeverityLevel.NORMAL)
    @Story("Booking a hotel and verifying reservation steps")
    @Description("Test to book a hotel, verify reservation form and payment process")
    public void hotelReservationTest() {
        filtersSteps.checkOnlinePayment();
        resultPageSteps.setHotelName()
                .clickOnHotelAvailabilityButton();
        common.switchToAnotherWindow();
        hotelPageSteps.validateHotelName(resultPageSteps.getHotelName())
                .clickOnReservationButton()
                .reserveHotel()
                .waitForReservationToLoad()
                .clickOnReserveButton();
        reservationForm.validateBookingForm()
                .fillFirstNameField(BookingData.FIRST_NAME)
                .fillLastNameField(BookingData.LAST_NAME)
                .fillEmailField(ConstantData.WRONG_EMAIL)
                .fillNumberField(BookingData.WRONG_FORMAT_PHONE_NUMBER)
                .fillAddressField(BookingData.ADDRESS)
                .fillCityField(BookingData.CITY)
                .selectCountry(BookingData.COUNTRY)
                .validateErrorMessage(ConstantData.ERROR_MESSAGE)
                .clearEmailInput()
                .fillEmailField(randomUserEmail());
        numberFormatDetect.getPropertie();
        Response response = numberFormatDetect
                .getNumberResponse(reservationForm.getInputNumber());
        boolean isValid = numberFormatDetect.getResult(response);
        reservationForm.validateErrorAppearance(isValid, ERROR_BORDER_COLOR);
        reservationForm
                .clickOnNextButton();
        paymentSteps.validatePaymentPage()
                .switchToPaymentFrame()
                .validateCardHoldersName(BookingData.getFullName());
    }
}
