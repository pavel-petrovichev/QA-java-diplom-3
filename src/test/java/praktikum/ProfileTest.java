package praktikum;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.config.Config;

import static org.assertj.core.api.Assertions.assertThat;

@Story("Profile")
public class ProfileTest extends StellarBurgersTest {

    @Before
    public void before() {
        createAccount();
        login();
    }

    @Test
    @DisplayName("profile link from main page")
    public void profileLinkFromMain() {
        mainPage.clickAccountLink();

        String name = accountProfilePage.waitForName();

        assertThat(name).isEqualTo(this.name);
    }

    @Test
    @DisplayName("profile link from feed")
    public void profileLinkFromFeed() {
        driver.get(Config.FEED_PAGE_URL);
        feedPage.clickAccountLink();

        String name = accountProfilePage.waitForName();

        assertThat(name).isEqualTo(this.name);
    }

    @Test
    @DisplayName("profile link from profile page")
    public void profileLinkFromProfile() {
        driver.get(Config.FEED_PAGE_URL);
        accountProfilePage.clickAccountLink();

        String name = accountProfilePage.waitForName();

        assertThat(name).isEqualTo(this.name);
    }
}