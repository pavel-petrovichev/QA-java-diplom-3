package site.nomoreparties.stellarburgers.tests.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.tests.ui.config.Config;

import java.time.Duration;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By registrationLinkLocator = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By passwordRecoveryLinkLocator = By.xpath(".//a[text()='Восстановить пароль']");

    private final By loginButtonLocator = By.xpath(".//*[text() = 'Войти']");

    private final By emailLocator = By.xpath(".//label[text()='Email']/../input");
    private final By passwordLocator = By.xpath(".//label[text()='Пароль']/../input");

    @Step("Нажатие ссылки 'Зарегистрироваться'")
    public void clickRegistrationLink() {
        waitForRegistrationLink();
        driver.findElement(registrationLinkLocator)
                .click();
    }

    @Step("Нажатие ссылки 'Восстановить пароль'")
    public void clickPasswordRecoveryLink() {
        waitForPasswordRecoveryLink();
        driver.findElement(passwordRecoveryLinkLocator)
                .click();
    }

    @Step("Заполнение формы входа")
    public void fillIn(String email, String password) {
        waitForLoginButton();
        fillInEmail(email);
        fillInPassword(password);
    }

    @Step("Заполнение поля 'Email'")
    private void fillInEmail(String email) {
        driver.findElement(emailLocator)
                .sendKeys(email);
    }

    @Step("Заполнение поля 'Пароль")
    private void fillInPassword(String password) {
        driver.findElement(passwordLocator)
                .sendKeys(password);
    }

    @Step("Нажатие кнопки 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButtonLocator)
                .click();
    }

    public void waitForRegistrationLink() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(Config.DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(registrationLinkLocator));
    }

    public void waitForPasswordRecoveryLink() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(Config.DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(passwordRecoveryLinkLocator));
    }

    public void waitForLoginButton() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(Config.DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
    }
}
