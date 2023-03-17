package site.nomoreparties.stellarburgers.tests.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

abstract class Page {

    protected final WebDriver driver;
    protected final JavascriptExecutor js;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    protected void clickElement(By locator) {
        try {
            driver.findElement(locator)
                    .click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript(
                    "arguments[0].click();",
                    driver.findElement(locator));
        }
    }
}
