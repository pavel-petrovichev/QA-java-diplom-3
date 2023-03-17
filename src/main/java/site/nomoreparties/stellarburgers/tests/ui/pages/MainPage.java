package site.nomoreparties.stellarburgers.tests.ui.pages;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.tests.ui.config.Config;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.IntSupplier;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By accountLinkLocator = By.xpath(".//p[text()='Личный Кабинет']");

    private final By enterAccountButtonLocator = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private final By checkoutButtonLocator = By.xpath(".//button[text() = 'Оформить заказ']");

    private final By constructorHeader = By.xpath(".//h1[text()='Соберите бургер']");

    private final By menuContainerLocator = By.xpath(".//h2[text()='Булки']/..");
    private final By bunsButtonLocator = By.xpath(".//span[text()='Булки']/..");
    private final By saucesButtonLocator = By.xpath(".//span[text()='Соусы']/..");
    private final By fillingsButtonLocator = By.xpath(".//span[text()='Начинки']/..");
    private final By bunsHeaderLocator = By.xpath(".//h2[text()='Булки']");
    private final By saucesHeaderLocator = By.xpath(".//h2[text()='Соусы']");
    private final By fillingsHeaderLocator = By.xpath(".//h2[text()='Начинки']");

    @Step("Нажатие ссылки 'Личный кабинет'")
    public void clickAccountLink() {
        waitForAccountLinkLocator();
        clickElement(accountLinkLocator);
    }

    @Step("Нажатие кнопки 'Войти в аккаунт'")
    public void clickEnterAccountButton() {
        waitForEnterAccountButton();
        clickElement(enterAccountButtonLocator);
    }

    @Step("Выбор раздела 'Булки'")
    public void clickBunsTab() {
        waitForBunsTab();
        clickElement(bunsButtonLocator);
    }

    @Step("Выбор раздела 'Соусы'")
    public void clickSaucesTab() {
        waitForSaucesTab();
        clickElement(saucesButtonLocator);
    }

    @Step("Выбор раздела 'Начинки'")
    public void clickFillingsTab() {
        waitForFillingsTab();
        clickElement(fillingsButtonLocator);
    }

    public int bunsHeaderY() {
        return driver.findElement(bunsHeaderLocator)
                .getLocation()
                .getY();
    }

    public int saucesHeaderY() {
        return driver.findElement(saucesHeaderLocator)
                .getLocation()
                .getY();
    }

    public int fillingsHeaderY() {
        return driver.findElement(fillingsHeaderLocator)
                .getLocation()
                .getY();
    }

    public int menuContainerY() {
        return driver.findElement(menuContainerLocator)
                .getLocation()
                .getY();
    }

    private void waitForEnterAccountButton() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(Config.DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(enterAccountButtonLocator));
    }

    public void waitForCheckoutButton() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(Config.DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(checkoutButtonLocator));
    }

    public void waitForAccountLinkLocator() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(Config.DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(accountLinkLocator));
    }

    public void waitForConstructorHeader() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(Config.DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(constructorHeader));
    }

    private void waitForBunsTab() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(Config.DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(bunsButtonLocator));
    }

    private void waitForSaucesTab() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(Config.DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(saucesButtonLocator));
    }

    private void waitForFillingsTab() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(Config.DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(fillingsButtonLocator));
    }

    @Step("Проверка прокрутки к разделу 'Булки'")
    public void verifyScrolledToBuns() {
        verifyScrolled(
                this::menuContainerY,
                this::bunsHeaderY,
                "menu was not scrolled to Sauces");
    }

    @Step("Проверка прокрутки к разделу 'Соусы'")
    public void verifyScrolledToSauces() {
        verifyScrolled(
                this::menuContainerY,
                this::saucesHeaderY,
                "menu was not scrolled to Sauces");
    }

    @Step("Проверка прокрутки к разделу 'Начинки'")
    public void verifyScrolledToFillings() {
        verifyScrolled(
                this::menuContainerY,
                this::fillingsHeaderY,
                "menu was not scrolled to Fillings");
    }

    @SneakyThrows
    private void verifyScrolled(
            IntSupplier menuPosition,
            IntSupplier itemPosition,
            String failMessage) {
        for (int i = 0; i < 10; i++) {
            int menu = menuPosition.getAsInt();
            int item = itemPosition.getAsInt();
            if (menu != item) {
                TimeUnit.MILLISECONDS.sleep(500);
                continue;
            }
            return;
        }
        int menu = menuPosition.getAsInt();
        int item = itemPosition.getAsInt();
        assertThat(menu)
                .withFailMessage(failMessage)
                .isEqualTo(item);
    }
}
