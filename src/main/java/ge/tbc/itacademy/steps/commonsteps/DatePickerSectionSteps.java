package ge.tbc.itacademy.steps.commonsteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.itacademy.pages.commonpages.DatePickerSection;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;

public class DatePickerSectionSteps {
    DatePickerSection dates = new DatePickerSection();
    SoftAssert sfa;

    public DatePickerSectionSteps(SoftAssert sfa) {
        this.sfa = sfa;
    }

    @Step("Check if the calendar is visible")
    public DatePickerSectionSteps checkingCalendarVisibility() {
        dates.calendarTab.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click on the calendar date picker")
    public DatePickerSectionSteps clickCalendar() {
        dates.datePicker.click();
        return this;
    }

    @Step("Move to the flexible tab")
    public DatePickerSectionSteps moveOnFlexibleTab() {
        dates.flexibleTab.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Choose stay duration: {duration}")
    public DatePickerSectionSteps chooseStayDuration(String duration) {
        dates.chooseDuration(duration).click();
        return this;
    }

    @Step("Select month by index: {index}")
    public DatePickerSectionSteps selectMonth(int index) {
        dates.monthSelectionButtons.get(index).click();
        return this;
    }

    @Step("Validate that the first month displayed is the current month")
    public void validateFirstMonth() {
        LocalDate date = LocalDate.now();
        String getMonth = date.getMonth().toString().toLowerCase().substring(0, 3);
        String month = dates.months.get(0).getText().toLowerCase().substring(0, 3);
        sfa.assertEquals(getMonth, month);
    }

    @Step("Validate that only one duration option is checked at a time")
    public DatePickerSectionSteps validateOneCheckedAtTime() {
        int checkedCount = 0;
        for (SelenideElement radioButton : dates.radioButtons) {
            if ("true".equals(radioButton.getAttribute("checked"))) {
                checkedCount++;
            }
        }
        sfa.assertEquals(checkedCount, 1);
        return this;
    }

    @Step("Click the select button")
    public void clickSelectButton() {
        dates.selectDateBtn.shouldBe(Condition.clickable).click();
    }
}
