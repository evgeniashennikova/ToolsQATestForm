package formTest.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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

    private Faker faker = new Faker(new Locale("en"));
    private String nameStudent = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String userEmail = faker.internet().emailAddress();
    private String gender = "Male";
    private String userNumber = faker.phoneNumber().subscriberNumber(10);

    private String specName = "Hindi";
    private String shortSpecName = specName.substring(0, specName.length() - 1);
    private String subjectsContainerXpath = "//div[@id='subjectsContainer']";
    private String specNameXpath = String.format("//div[text()='%s']", specName);
    private String specialization = subjectsContainerXpath + specNameXpath;

    private String hobbies = "Sports";
    private String image = "src/test/resources/cat.jpg";
    private String address = faker.address().streetAddress();
    private String state = "NCR";
    private String city = "Noida";


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

    public String getNameStudent() {
        return nameStudentSelector.getValue();
    }

    public String getLastName() {
        return lastNameSelector.getValue();
    }

    public String getUserEmail() {
        return userEmailSelector.getValue();
    }

    public String getUserNumber() {
        return userNumberSelector.getValue();
    }

    public String getAddress() {
        return addressSelector.getValue();
    }
}