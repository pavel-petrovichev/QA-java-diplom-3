package praktikum;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.config.Config;

@Story("Login")
public class LoginTest extends StellarBurgersTest {

    @Before
    public void before() {
        createAccount();
        driver.get(Config.MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("login button at the main page")
    public void mainPageButton() {
        mainPage.clickEnterAccountButton();

        loginPage.fillIn(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForCheckoutButton();
    }

    @Test
    @DisplayName("account link")
    public void accountLink() {
        mainPage.clickAccountLink();

        loginPage.waitForLoginButton();
        loginPage.fillIn(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForCheckoutButton();
    }

    @Test
    @DisplayName("registration form")
    public void registrationPage() {
        mainPage.clickEnterAccountButton();
        loginPage.clickRegistrationLink();
        registrationPage.clickLoginLink();

        loginPage.fillIn(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForCheckoutButton();
    }

    @Test
    @DisplayName("password recovery page")
    public void recoveryPage() {
        mainPage.clickEnterAccountButton();
        loginPage.clickPasswordRecoveryLink();
        forgotPasswordPage.clickLoginLink();

        loginPage.fillIn(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForCheckoutButton();
    }
}