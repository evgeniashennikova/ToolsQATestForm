package formTest.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowPage extends RegistrationsPage {

    private final String NAME_MODAL_WINDOW = "Thanks for submitting the form";
    private SelenideElement
            modalContentSelector = $(".modal-content"),
            tableResultsSelector = $(".table-responsive"),
            closeModalWindowSelector = $("#closeLargeModal");


    public ModalWindowPage checkHeader() {
        modalContentSelector.shouldHave(text(NAME_MODAL_WINDOW));
        return this;
    }

    public ModalWindowPage checkResultsValue() {

        String nameStudentActual = getNameStudent();
        String lastNameActual = getLastName();
        String userEmailActual = getUserEmail();
        String gender = "Male";
        String userNumberActual = getUserNumber();
        String dateOfBirth = "05 October,2000";
        String specName = "Hindi";
        String hobbies = "Sports";
        String imageName = "cat.jpg";
        String addressActual = getAddress();
        String state = "NCR";
        String city = "Noida";

        tableResultsSelector.
                shouldHave(text(nameStudentActual + " " + lastNameActual)).
                shouldHave(text(userEmailActual)).
                shouldHave(text(gender)).
                shouldHave(text(userNumberActual)).
                shouldHave(text(dateOfBirth)).
                shouldHave(text(specName)).
                shouldHave(text(hobbies)).
                shouldHave(text(imageName)).
                shouldHave(text(addressActual)).
                shouldHave(text(state)).
                shouldHave(text(city));
        return this;
    }

    public ModalWindowPage closeModalWindow() {
        closeModalWindowSelector.click();
        return this;

    }
}
