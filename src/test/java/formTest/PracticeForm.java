package formTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void studentsForm() {

        String specName = "Biology";
        String shortSpecName = specName.substring(0,specName.length()-1);
        String subjectsContainerXpath = "//div[@id='subjectsContainer']";
        String specNameXpath = String.format("//div[text()='%s']",specName);
        String specialization = subjectsContainerXpath+specNameXpath;

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Student1");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Student1@example.com");
        $("[for=gender-radio-1]").click(); //Почему не срабатывает через selectRadio("Male")
        $("#userNumber").setValue("8920000000");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "A");
        $("#dateOfBirthInput").sendKeys("05 Oct 2000" + Keys.ENTER);
        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys(shortSpecName);
        $x(specialization).click();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/cat.jpg"));
        $("#currentAddress").setValue("SPb");
        $("#state").scrollTo();
        $("#state").click();
        $x("//div[@id='state']//div[text()='Uttar Pradesh']").shouldBe(Condition.visible).click();
        $("#city").click();
        $x("//div[@id='city']//div[text()='Agra']").click();
        $("#submit").click();


    }

}
