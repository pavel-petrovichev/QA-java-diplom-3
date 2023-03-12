package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.config.Config.DEFAULT_WAIT_TIME_SECONDS;

public class RegistrationPage extends Page {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final By loginLinkLocator = By.xpath(".//a[text()='Войти']");

    private final By registerButtonLocator = By.xpath(".//*[text() = 'Зарегистрироваться']");

    private final By nameLocator = By.xpath(".//label[text()='Имя']/../input");
    private final By emailLocator = By.xpath(".//label[text()='Email']/../input");
    private final By passwordLocator = By.xpath(".//label[text()='Пароль']/../input");

    private final By invalidPasswordErrorLocator = By.xpath(".//p[text()='Некорректный пароль']");

    public void fillIn(String name, String email, String password) {
        fillInName(name);
        fillInEmail(email);
        fillInPassword(password);
    }

    public void fillInName(String name) {
        driver.findElement(nameLocator)
                .sendKeys(name);
    }

    public void fillInEmail(String email) {
        driver.findElement(emailLocator)
                .sendKeys(email);
    }

    public void fillInPassword(String password) {
        driver.findElement(passwordLocator)
                .sendKeys(password);
    }

    public void scrollToNameField() {
        js.executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(nameLocator));
    }

    public void clickLoginLink() {
        waitForLoginLink();
        driver.findElement(loginLinkLocator)
                .click();
    }

    public void clickRegistrationButton() {
        waitForRegistrationButton();
        driver.findElement(registerButtonLocator)
                .click();
    }

    public void waitForLoginLink() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(loginLinkLocator));
    }

    public void waitForRegistrationButton() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(registerButtonLocator));
    }

    public void waitForInvalidPasswordError() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(invalidPasswordErrorLocator));
    }
}
