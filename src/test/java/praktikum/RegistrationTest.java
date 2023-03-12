package praktikum;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import org.junit.Before;
import org.junit.Test;
import praktikum.config.Config;

@Story("Registration")
public class RegistrationTest extends StellarBurgersTest {

    @Before
    public void before() {
        driver.get(Config.MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("register new user")
    public void registration() {
        mainPage.clickEnterAccountButton();
        loginPage.clickRegistrationLink();

        registrationPage.waitForRegistrationButton();
        registrationPage.fillIn(name, email, password);
        registrationPage.clickRegistrationButton();

        loginPage.waitForLoginButton();
        loginPage.fillIn(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForCheckoutButton();
    }

    @Test
    @Tag("field-presence")
    @DisplayName("mandatory field: invalid password")
    public void invalidPassword() {
        password = "srag5";

        mainPage.clickEnterAccountButton();
        loginPage.clickRegistrationLink();

        registrationPage.waitForRegistrationButton();
        registrationPage.scrollToNameField();
        registrationPage.fillIn(name, email, password);
        registrationPage.clickRegistrationButton();
        registrationPage.waitForInvalidPasswordError();
    }

    @Test
    @Tag("field-presence")
    @DisplayName("mandatory field: valid password")
    public void validPassword() {
        password = "srag56";

        mainPage.clickEnterAccountButton();
        loginPage.clickRegistrationLink();

        registrationPage.waitForRegistrationButton();
        registrationPage.scrollToNameField();
        registrationPage.fillIn(name, email, password);
        registrationPage.clickRegistrationButton();

        loginPage.waitForLoginButton();
    }
}