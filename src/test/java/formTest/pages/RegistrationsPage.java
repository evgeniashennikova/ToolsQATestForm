package formTest.pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static formTest.testbase.TestData.*;

public class RegistrationsPage {

    private final String NAME_FORM = "Student Registration Form";
    private SelenideElement
            nameFormSelector = $("#app").$(".practice-form-wrapper"),
            nameStudentSelector = $("#firstName"),
            lastNameSelector = $("#lastName"),
            userEmailSelector = $("#userEmail"),
            genderSelector = $("#genterWrapper"),
            userNumberSelector = $("#userNumber"),
            dateOfBirthInputSelector = $("#dateOfBirthInput"),
            dateOfBirthMonthSelector = $(".react-datepicker__month-select"),
            dateOfBirthYearSelector = $(".react-datepicker__year-select"),
            dateOfBirthDaySelector = $(".react-datepicker__day--005:not(.react-datepicker__day--outside-month)"),
            subjectsInputSelector = $("#subjectsInput"),
            hobbiesSelector = $("#hobbiesWrapper"),
            uploadPictureSelector = $("#uploadPicture"),
            addressSelector = $("#currentAddress"),
            stateSelector = $("#state"),
            stateCitySelector = $("#stateCity-wrapper"),
            citySelector = $("#city"),
            submitSelector = $("#submit");

    public RegistrationsPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        nameFormSelector.shouldHave(text(NAME_FORM));
        return this;
    }

    public RegistrationsPage typeNameStudent() {
        nameStudentSelector.setValue(nameStudent);
        return this;
    }

    public RegistrationsPage typeLastName() {
        lastNameSelector.setValue(lastName);
        return this;
    }

    public RegistrationsPage typeUserEmail() {
        userEmailSelector.setValue(userEmail);
        return this;
    }

    public RegistrationsPage typeGender() {
        genderSelector.$(byText(gender)).click();
        return this;
    }

    public RegistrationsPage typeUserNumber() {
        userNumberSelector.setValue(userNumber);
        return this;
    }

    public RegistrationsPage typeDateOfBirth() {
        dateOfBirthInputSelector.click();
        dateOfBirthMonthSelector.selectOption("October");
        dateOfBirthYearSelector.selectOption("2000");
        dateOfBirthDaySelector.click();
        return this;
    }

    public RegistrationsPage typeSubjects() {
        subjectsInputSelector.click();
        subjectsInputSelector.sendKeys(shortSpecName);
        $x(specialization).click();
        return this;
    }

    public RegistrationsPage typeHobbies() {
        hobbiesSelector.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationsPage typeUploadPicture() {
        uploadPictureSelector.uploadFile(new File(image));
        return this;
    }

    public RegistrationsPage typeAddress() {
        addressSelector.setValue(address);
        return this;
    }

    public RegistrationsPage typeState() {
        stateSelector.scrollTo().click();
        stateCitySelector.$(byText(state)).click();
        return this;
    }

    public RegistrationsPage typeCity() {
        citySelector.click();
        stateCitySelector.$(byText(city)).click();
        return this;
    }

    public RegistrationsPage typeSubmit() {
        submitSelector.click();
        return this;
    }
}