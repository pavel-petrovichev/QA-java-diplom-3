package site.nomoreparties.stellarburgers.tests.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static site.nomoreparties.stellarburgers.tests.ui.config.Config.DEFAULT_WAIT_TIME_SECONDS;

public class ForgotPasswordPage extends Page {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    private final By loginLinkLocator = By.xpath(".//a[text() = 'Войти']");

    @Step("Нажатие ссылки 'Войти'")
    public void clickLoginLink() {
        waitForLoginLink();
        driver.findElement(loginLinkLocator)
                .click();
    }

    public void waitForLoginLink() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(loginLinkLocator));
    }
}
