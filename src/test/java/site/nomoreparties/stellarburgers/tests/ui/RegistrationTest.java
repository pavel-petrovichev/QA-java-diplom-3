package site.nomoreparties.stellarburgers.tests.ui;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.tests.ui.config.Config;

@Story("Регистрация пользователя")
public class RegistrationTest extends StellarBurgersTest {

    @Before
    public void before() {
        driver.get(Config.MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Регистрация нового пользователя")
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
    @DisplayName("Обязательное поле: пароль; некорректное значение")
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
    @DisplayName("Обязательное поле: пароль; корректное значение")
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