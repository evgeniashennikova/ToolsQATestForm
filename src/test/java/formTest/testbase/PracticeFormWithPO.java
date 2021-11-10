package formTest.testbase;

import org.junit.jupiter.api.Test;

public class PracticeFormWithPO extends TestBase {


    @Test
    void studentsForm() {

        registrationsPage.openPage().
                typeNameStudent().
                typeLastName().
                typeUserEmail().
                typeGender().
                typeUserNumber().
                typeDateOfBirth().
                typeSubjects().
                typeHobbies().
                typeUploadPicture().
                typeAddress().
                typeState().
                typeCity().
                typeSubmit();

        modalWindowPage.checkHeader().
                checkResultsValue().
                closeModalWindow();

    }

}
