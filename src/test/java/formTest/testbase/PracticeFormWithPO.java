package formTest.testbase;

import formTest.pages.ComponentCalendar;
import formTest.pages.ModalWindowPage;
import formTest.pages.RegistrationsPage;
import org.junit.jupiter.api.Test;

import static formTest.testbase.TestData.*;

public class PracticeFormWithPO extends TestBase {

    RegistrationsPage registrationsPage = new RegistrationsPage();
    ModalWindowPage modalWindowPage = new ModalWindowPage();
    ComponentCalendar componentCalendar = new ComponentCalendar();


    @Test
    void studentsForm() {

        registrationsPage
                .openPage()
                .typeNameStudent()
                .typeLastName()
                .typeUserEmail()
                .typeGender()
                .typeUserNumber();

        componentCalendar.dateSelection();

        registrationsPage
                .typeSubjects()
                .typeHobbies()
                .typeUploadPicture()
                .typeAddress()
                .typeState()
                .typeCity()
                .typeSubmit();

        modalWindowPage.checkHeader()
                .checkResultsValue("Student Name", nameStudent + "\t" + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", gender)
                .checkResultsValue("Mobile", userNumber)
                .checkResultsValue("Date of Birth", dateOfBirth)
                .checkResultsValue("Subjects", specName)
                .checkResultsValue("Hobbies", hobbies)
                .checkResultsValue("Picture", imageName)
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", state + "\t" + city)
                .closeModalWindow();

    }

}
