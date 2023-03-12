package praktikum;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.config.Config;

@Story("Links to Constructor")
public class LinksToConstructorTest extends StellarBurgersTest {

    @Before
    public void before() {
        createAccount();
        login();
        driver.get(Config.ACCOUNT_PROFILE_PAGE_URL);
    }

    @Test
    @DisplayName("constructor link from account page")
    public void constructorLinkFromAccountPage() {
        accountProfilePage.clickConstructorLink();
        mainPage.waitForConstructorHeader();
    }

    @Test
    @DisplayName("logo to constructor from account page")
    public void logoToConstructorFromAccountPage() {
        accountProfilePage.clickLogo();
        mainPage.waitForConstructorHeader();
    }
}