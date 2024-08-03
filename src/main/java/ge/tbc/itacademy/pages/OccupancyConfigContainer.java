package ge.tbc.itacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OccupancyConfigContainer {
    public SelenideElement
            groupAdults = $("#group_adults"),
            groupChildren = $("#group_children"),
            roomsInfo = $("#no_rooms");
    public ElementsCollection
            adultOccupancyButtons = groupAdults.parent().$$("button[type='button']"),
            childOccupancyButtons = groupChildren.parent().$$("button[type='button']"),
            roomButtons = roomsInfo.parent().$$("button[type='button']"),
            ageSelectDropDown = $$("select[name='age']");
}
