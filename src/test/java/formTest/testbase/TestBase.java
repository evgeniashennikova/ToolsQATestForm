package formTest.testbase;

import com.codeborne.selenide.Configuration;
import formTest.pages.ModalWindowPage;
import formTest.pages.RegistrationsPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationsPage registrationsPage = new RegistrationsPage();
    ModalWindowPage modalWindowPage = new ModalWindowPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

}
