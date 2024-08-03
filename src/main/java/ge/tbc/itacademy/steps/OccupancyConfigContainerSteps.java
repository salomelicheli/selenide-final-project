package ge.tbc.itacademy.steps;

import ge.tbc.itacademy.pages.OccupancyConfigContainer;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.value;
import static ge.tbc.itacademy.util.HelperFunctions.clickElementUsingJSExecutor;

public class OccupancyConfigContainerSteps {
    private int defaultNumberOfAdults;
    private int defaultNumberOfChildren;
    private int defaultNumberOfRooms;
    private int ageDropdowns;
    OccupancyConfigContainer occupancy = new OccupancyConfigContainer();

    @Step("Set default values")
    public OccupancyConfigContainerSteps setDefaults() {
        defaultNumberOfChildren = Integer.parseInt(occupancy.groupChildren.getValue());
        defaultNumberOfAdults = Integer.parseInt(occupancy.groupAdults.getValue());
        defaultNumberOfRooms = Integer.parseInt(occupancy.roomsInfo.getValue());
        return this;
    }

    @Step("Validate number of children")
    public OccupancyConfigContainerSteps validateNumberOfChildren() {
        occupancy.groupChildren.shouldHave(value("0"));
        return this;
    }

    @Step("Validate number of adults")
    public OccupancyConfigContainerSteps validateNumberOfAdults() {
        occupancy.groupAdults.shouldHave(value("1"));
        return this;
    }

    @Step("Validate number of rooms")
    public OccupancyConfigContainerSteps validateNumberOfRooms() {
        occupancy.roomsInfo.shouldHave(value("1"));
        return this;
    }

    @Step("Check functionality of children button")
    public OccupancyConfigContainerSteps checkGroupChildrenButtonFunctional() {
        defaultNumberOfChildren++;
        for (int i = 1; i <= defaultNumberOfChildren; i++) {
            clickElementUsingJSExecutor(occupancy.childOccupancyButtons.get(0));
        }
        return this;
    }

    @Step("Check functionality of adult button")
    public OccupancyConfigContainerSteps checkGroupAdultButtonFunctional() {
        defaultNumberOfAdults++;
        for (int i = 1; i <= defaultNumberOfAdults; i++) {
            clickElementUsingJSExecutor(occupancy.adultOccupancyButtons.get(0));
        }
        return this;
    }

    @Step("Check functionality of room button")
    public OccupancyConfigContainerSteps checkRoomButtonFunctional() {
        defaultNumberOfRooms++;
        for (int i = 1; i <= defaultNumberOfRooms; i++) {
            clickElementUsingJSExecutor(occupancy.roomButtons.get(0));
        }
        return this;
    }

    @Step("Click children button {clicks} times")
    public OccupancyConfigContainerSteps clickGrpChildrenBtnNTimes(int clicks) {
        for (int i = 1; i <= clicks; i++) {
            clickElementUsingJSExecutor(occupancy.childOccupancyButtons.get(1));
            ageDropdowns++;
        }
        return this;
    }

    @Step("Check number of age select dropdowns")
    public void checkAgeSelectDropdownNumber() {
        Assert.assertEquals(occupancy.ageSelectDropDown.size(), ageDropdowns);
    }
}
