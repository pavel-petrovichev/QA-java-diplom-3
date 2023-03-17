package site.nomoreparties.stellarburgers.tests.ui;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.tests.ui.config.Config;

@Story("Выход из приложения")
public class LogoutTest extends StellarBurgersTest {

    @Before
    public void before() {
        createAccount(name, email, password);
        login(email, password);
        openProfilePage();
    }

    @Test
    @DisplayName("Выход со страницы профиля")
    public void logout() {
        accountProfilePage.clickLogoutButton();

        loginPage.waitForLoginButton();
    }
}