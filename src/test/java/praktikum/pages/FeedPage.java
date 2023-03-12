package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.config.Config.DEFAULT_WAIT_TIME_SECONDS;

public class FeedPage extends Page {

    private final By accountLinkLocator = By.xpath(".//p[text()='Личный Кабинет']");

    public FeedPage(WebDriver driver) {
        super(driver);
    }

    public void clickAccountLink() {
        waitForAccountLinkLocator();
        clickElement(accountLinkLocator);
    }

    public void waitForAccountLinkLocator() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(accountLinkLocator));
    }
}
