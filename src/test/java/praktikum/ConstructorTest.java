package praktikum;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.config.Config;

import static org.assertj.core.api.Assertions.assertThat;

@Story("Constructor")
public class ConstructorTest extends StellarBurgersTest {

    @Before
    public void before() {
        createAccount();
        login();
        driver.get(Config.MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("buns tab")
    public void bunsTab() {
        assertThat(mainPage.bunsHeaderY())
                .isNotEqualTo(mainPage.menuContainerY());

        mainPage.clickBunsTab();

        mainPage.verifyScrolledToBuns();
    }

    @Test
    @DisplayName("sauces tab")
    public void saucesTab() {
        assertThat(mainPage.saucesHeaderY())
                .isNotEqualTo(mainPage.menuContainerY());

        mainPage.clickSaucesTab();

        mainPage.verifyScrolledToSauces();
    }

    @Test
    @DisplayName("fillings tab")
    public void fillingsTab() {
        assertThat(mainPage.fillingsHeaderY())
                .isNotEqualTo(mainPage.menuContainerY());

        mainPage.clickFillingsTab();

        mainPage.verifyScrolledToFillings();
    }
}