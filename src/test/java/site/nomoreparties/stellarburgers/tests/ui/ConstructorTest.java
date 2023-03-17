package site.nomoreparties.stellarburgers.tests.ui;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.tests.ui.config.Config;

import static org.assertj.core.api.Assertions.assertThat;

@Story("Конструктор бургера")
public class ConstructorTest extends StellarBurgersTest {

    @Before
    public void before() {
        createAccount(name, email, password);
        login(email, password);
        driver.get(Config.MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Вкладка 'Булки'")
    public void bunsTab() {
        Assertions.assertThat(mainPage.bunsHeaderY())
                .isNotEqualTo(mainPage.menuContainerY());

        mainPage.clickBunsTab();

        mainPage.verifyScrolledToBuns();
    }

    @Test
    @DisplayName("Вкладка 'Соусы'")
    public void saucesTab() {
        Assertions.assertThat(mainPage.saucesHeaderY())
                .isNotEqualTo(mainPage.menuContainerY());

        mainPage.clickSaucesTab();

        mainPage.verifyScrolledToSauces();
    }

    @Test
    @DisplayName("Вкладка 'Начинки'")
    public void fillingsTab() {
        Assertions.assertThat(mainPage.fillingsHeaderY())
                .isNotEqualTo(mainPage.menuContainerY());

        mainPage.clickFillingsTab();

        mainPage.verifyScrolledToFillings();
    }
}