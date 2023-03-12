package praktikum.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class Config {
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String LOGIN_PAGE_URL = MAIN_PAGE_URL + "/login";
    public static final String FEED_PAGE_URL = MAIN_PAGE_URL + "/feed";
    public static final String ACCOUNT_PROFILE_PAGE_URL = MAIN_PAGE_URL + "/account";
    public static final int DEFAULT_WAIT_TIME_SECONDS = 10;

    private static final String DEFAULT_BROWSER = "chrome";

    public static WebDriver webDriver() {
        String driverProperty = System.getProperty("browser");
        if (driverProperty == null) {
            driverProperty = DEFAULT_BROWSER;
        }
        switch (driverProperty.toLowerCase()) {
            case "firefox":
                return new FirefoxDriver();
            case "yandex": {
                System.setProperty(
                        "webdriver.chrome.driver",
                        System.getProperty("user.home") + File.separator + ".webdriver/yandexdriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setBinary(
                        System.getProperty("user.home") + File.separator
                                + "AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
                return new ChromeDriver(chromeOptions);
            }
            case "chrome":
                return new ChromeDriver();
            default:
                throw new RuntimeException(String.format(
                        "Unknown driver: %s. Choose 'yandex', 'chrome' or 'firefox",
                        driverProperty));
        }
    }
}
