package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.config.Config.DEFAULT_WAIT_TIME_SECONDS;

public class ForgotPasswordPage extends Page {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    private final By loginLinkLocator = By.xpath(".//a[text() = 'Войти']");

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
