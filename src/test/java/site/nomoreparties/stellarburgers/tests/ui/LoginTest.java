package site.nomoreparties.stellarburgers.tests.ui;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.tests.ui.config.Config;

@Story("Авторизация")
public class LoginTest extends StellarBurgersTest {

    @Before
    public void before() {
        createAccount(name, email, password);
        openMainPage();
    }

    @Test
    @DisplayName("По кнопке на главной старнице")
    public void mainPageButton() {
        mainPage.clickEnterAccountButton();

        loginPage.fillIn(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForCheckoutButton();
    }

    @Test
    @DisplayName("По ссылке в 'Личный кабинет'")
    public void accountLink() {
        mainPage.clickAccountLink();

        loginPage.waitForLoginButton();
        loginPage.fillIn(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForCheckoutButton();
    }

    @Test
    @DisplayName("Регистрация и авторизация нового пользователя")
    public void registrationPage() {
        mainPage.clickEnterAccountButton();
        loginPage.clickRegistrationLink();
        registrationPage.clickLoginLink();

        loginPage.fillIn(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForCheckoutButton();
    }

    @Test
    @DisplayName("Со страницы восстановления пароля")
    public void recoveryPage() {
        mainPage.clickEnterAccountButton();
        loginPage.clickPasswordRecoveryLink();
        forgotPasswordPage.clickLoginLink();

        loginPage.fillIn(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForCheckoutButton();
    }
}