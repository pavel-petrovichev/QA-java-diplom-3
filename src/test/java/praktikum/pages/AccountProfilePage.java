package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.config.Config.DEFAULT_WAIT_TIME_SECONDS;

public class AccountProfilePage extends Page {

    private final By constructorLinkLocator = By.xpath(".//p[text()='Конструктор']");
    private final By accountLinkLocator = By.xpath(".//p[text()='Личный Кабинет']");
    private final By logoLocator = By.xpath(".//nav//div[contains(@class, 'logo')]/a[@href='/']");

    private final By nameLocator = By.xpath(".//label[text()='Имя']/../input");

    private final By logoutButtonLocator = By.xpath(".//button[text()='Выход']");

    public AccountProfilePage(WebDriver driver) {
        super(driver);
    }

    public void clickConstructorLink() {
        waitForConstructorLink();
        clickElement(constructorLinkLocator);
    }

    public void clickLogo() {
        waitForLogo();
        clickElement(logoLocator);
    }

    public void clickAccountLink() {
        waitForAccountLink();
        clickElement(accountLinkLocator);
    }

    public void clickLogoutButton() {
        waitForLogoutButton();
        clickElement(logoutButtonLocator);
    }

    public void waitForConstructorLink() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(constructorLinkLocator));
    }

    private void waitForLogo() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(logoLocator));
    }

    public void waitForAccountLink() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(accountLinkLocator));
    }

    public String waitForName() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(nameLocator));
        return driver.findElement(nameLocator)
                .getDomAttribute("value");
    }

    private void waitForLogoutButton() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(logoutButtonLocator));
    }
}
