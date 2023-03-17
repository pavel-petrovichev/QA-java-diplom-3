package site.nomoreparties.stellarburgers.tests.ui;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.tests.ui.config.Config;

@Story("Ссылки на конструктор бургера")
public class LinksToConstructorTest extends StellarBurgersTest {

    @Before
    public void before() {
        createAccount(name, email, password);
        login(email, password);
        openProfilePage();
    }

    @Test
    @DisplayName("Переход со страницы профиля")
    public void constructorLinkFromAccountPage() {
        accountProfilePage.clickConstructorLink();
        mainPage.waitForConstructorHeader();
    }

    @Test
    @DisplayName("Переход по нажатию на логотип приложения")
    public void logoToConstructorFromAccountPage() {
        accountProfilePage.clickLogo();
        mainPage.waitForConstructorHeader();
    }
}