package formTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void studentsForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Student1");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Student1@example.com");
        $("[for=gender-radio-1]").click(); //Почему не срабатывает через selectRadio("Male")
        $("#userNumber").setValue("8920000000");
        $("#subjectsContainer").click();  //как выбрать значение из выпадающего списка?
        $("[for=hobbies-checkbox-1]").click();
        // $("uploadPicture").UploadFile();  как вставить файл в папку resources? и как потом файл вставить на сайте?
        $("#currentAddress").setValue("SPb");
        $(".css-tlfecz-indicatorContainer").click(); // клик делает. Как дальше в выпадающем окне выбрать значение?
         //       find(text("NCR"));
        $("#city").click(); // Нужно ли перед этим проверить, что поле активно? Если в первом поле нет значения, то второе поле не активно.
        //затем нужно выбрать значение из выпадающего списка
        $("#submit").click();


    }

}
