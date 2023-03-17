package site.nomoreparties.stellarburgers.tests.ui;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.tests.ui.config.Config;

import static org.assertj.core.api.Assertions.assertThat;

@Story("Профиль пользователя")
public class ProfileTest extends StellarBurgersTest {

    @Before
    public void before() {
        createAccount(name, email, password);
        login(email, password);
    }

    @Test
    @DisplayName("Переход в профиль с главной страницы")
    public void profileLinkFromMain() {
        mainPage.clickAccountLink();

        String name = accountProfilePage.waitForName();

        assertThat(name).isEqualTo(this.name);
    }

    @Test
    @DisplayName("Переход в профиль из ленты заказов")
    public void profileLinkFromFeed() {
        openFeedPage();
        feedPage.clickAccountLink();

        String name = accountProfilePage.waitForName();

        assertThat(name).isEqualTo(this.name);
    }

    @Test
    @DisplayName("Переход в профиль со страницы профиля")
    public void profileLinkFromProfile() {
        openProfilePage();
        accountProfilePage.clickAccountLink();

        String name = accountProfilePage.waitForName();

        assertThat(name).isEqualTo(this.name);
    }
}