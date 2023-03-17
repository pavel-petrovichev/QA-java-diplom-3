package site.nomoreparties.stellarburgers.tests.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.tests.ui.config.Config;

import java.time.Duration;

public class FeedPage extends Page {

    private final By accountLinkLocator = By.xpath(".//p[text()='Личный Кабинет']");

    public FeedPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие ссылки 'Личный кабинет'")
    public void clickAccountLink() {
        waitForAccountLinkLocator();
        clickElement(accountLinkLocator);
    }

    public void waitForAccountLinkLocator() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(Config.DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(accountLinkLocator));
    }
}
