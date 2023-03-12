package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.config.Config.DEFAULT_WAIT_TIME_SECONDS;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By registrationLinkLocator = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By passwordRecoveryLinkLocator = By.xpath(".//a[text()='Восстановить пароль']");

    private final By loginButtonLocator = By.xpath(".//*[text() = 'Войти']");

    private final By emailLocator = By.xpath(".//label[text()='Email']/../input");
    private final By passwordLocator = By.xpath(".//label[text()='Пароль']/../input");


    public void clickRegistrationLink() {
        waitForRegistrationLink();
        driver.findElement(registrationLinkLocator)
                .click();
    }

    public void clickPasswordRecoveryLink() {
        waitForPasswordRecoveryLink();
        driver.findElement(passwordRecoveryLinkLocator)
                .click();
    }

    public void fillIn(String email, String password) {
        waitForLoginButton();
        fillInEmail(email);
        fillInPassword(password);
    }

    private void fillInEmail(String email) {
        driver.findElement(emailLocator)
                .sendKeys(email);
    }

    private void fillInPassword(String password) {
        driver.findElement(passwordLocator)
                .sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator)
                .click();
    }

    public void waitForRegistrationLink() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(registrationLinkLocator));
    }

    public void waitForPasswordRecoveryLink() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(passwordRecoveryLinkLocator));
    }

    public void waitForLoginButton() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
    }
}
