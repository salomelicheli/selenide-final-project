package ge.tbc.itacademy.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.itacademy.pages.HotelPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.interactable;

public class HotelPageSteps {
    HotelPage hotelPage = new HotelPage();

    @Step("Validate that hotel name is: {0}")
    public HotelPageSteps validateHotelName(String hotelName) {
        hotelPage.hotelTitle.should(Condition.appear);
        Assert.assertEquals(hotelPage.hotelTitle.getText(), hotelName);
        return this;
    }

    @Step("Reserve hotel")
    public HotelPageSteps reserveHotel() {
        hotelPage.reservationButton.should(Condition.appear).click();
        return this;
    }

    @Step("Click on reservation button")
    public HotelPageSteps clickOnReservationButton() {
        hotelPage.reserveButton.click();
        return this;
    }

    @Step("Wait for reservation to load")
    public HotelPageSteps waitForReservationToLoad() {
        hotelPage.hotelInfo.should(Condition.appear);
        return this;
    }

    @Step("Click on reserve button")
    public void clickOnReserveButton() {
        hotelPage.illReserveButton.shouldBe(clickable, interactable).click();
    }

    @Step("Click on share button")
    public HotelPageSteps clickOnShareButton() {
        hotelPage.shareButton.should(Condition.appear).click();
        return this;
    }

    @Step("Click on copy link")
    public void clickOnCopyLink() {
        hotelPage.copyLink.click();
    }
}
