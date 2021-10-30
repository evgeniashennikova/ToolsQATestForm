package formTest;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void studentsForm() {

        String nameStudent = "Student1";
        String lastName = "Ivanov";
        String userEmail = "Student1@example.com";
        String gender = "Male";
        String userNumber = "8920000000";
        String dateOfBirth = "05 Oct 2000";
        String specName = "Hindi";
        String shortSpecName = specName.substring(0, specName.length() - 1);
        String subjectsContainerXpath = "//div[@id='subjectsContainer']";
        String specNameXpath = String.format("//div[text()='%s']", specName);
        String specialization = subjectsContainerXpath + specNameXpath;
        String hobbies = "Sports";
        String image = "src/test/resources/cat.jpg";
        String imageName = "cat.jpg";
        String address = "SPb";
        String state = "NCR";
        String city = "Noida";


        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(nameStudent);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "A");
        $("#dateOfBirthInput").sendKeys(dateOfBirth + Keys.ENTER);
        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys(shortSpecName);
        $x(specialization).click();
        $(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(new File(image));
        $("#currentAddress").setValue(address);
        $("#state").scrollTo();
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").
                shouldHave(text(nameStudent)).
                shouldHave(text(lastName)).
                shouldHave(text(userEmail)).
                shouldHave(text(gender)).
                shouldHave(text(userNumber)).
                shouldHave(text("05 October,2000")).
                shouldHave(text(specName)).
                shouldHave(text(hobbies)).
                shouldHave(text(imageName)).
                shouldHave(text(address)).
                shouldHave(text(state)).
                shouldHave(text(city));
        $("#closeLargeModal").shouldBe();
    }
}
