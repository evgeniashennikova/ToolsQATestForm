package formTest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static formTest.testbase.TestData.*;

public class ComponentCalendar extends RegistrationsPage {

    private SelenideElement
            dateOfBirthInputSelector = $("#dateOfBirthInput"),
            dateOfBirthMonthSelector = $(".react-datepicker__month-select"),
            dateOfBirthYearSelector = $(".react-datepicker__year-select"),
            dateOfBirthDaySelector = $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)");

    public ComponentCalendar dateSelection() {
        dateOfBirthInputSelector.click();
        dateOfBirthMonthSelector.selectOption(month);
        dateOfBirthYearSelector.selectOption(year);
        dateOfBirthDaySelector.click();
        return this;
    }
}
