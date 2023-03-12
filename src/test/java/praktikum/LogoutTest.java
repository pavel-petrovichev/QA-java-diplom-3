package praktikum;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.config.Config;

@Story("Logout")
public class LogoutTest extends StellarBurgersTest {

    @Before
    public void before() {
        createAccount();
        login();
        driver.get(Config.ACCOUNT_PROFILE_PAGE_URL);
    }

    @Test
    @DisplayName("logout")
    public void logout() {
        accountProfilePage.clickLogoutButton();

        loginPage.waitForLoginButton();
    }
}