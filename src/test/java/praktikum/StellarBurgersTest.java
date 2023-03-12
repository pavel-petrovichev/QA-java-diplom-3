package praktikum;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ValidatableResponse;
import org.apache.http.params.CoreConnectionPNames;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import praktikum.config.Config;
import praktikum.model.CreateUserRequestVO;
import praktikum.model.LoginRequestVO;
import praktikum.model.LoginResponseVO;
import praktikum.pages.*;

import java.util.Locale;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

@Epic("QA Java Diploma 3")
@Feature("Stellar Burger UI")
public abstract class StellarBurgersTest {

    protected WebDriver driver = Config.webDriver();

    protected MainPage mainPage = new MainPage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected RegistrationPage registrationPage = new RegistrationPage(driver);
    protected ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
    protected AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
    protected FeedPage feedPage = new FeedPage(driver);

    protected RestAssuredConfig config;
    protected Faker faker;

    protected String email;
    protected String password;
    protected String name;

    @Before
    public void setup() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/api";
        RestAssured.port = 443;
        config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(CoreConnectionPNames.SO_TIMEOUT, 10_000));

        faker = new Faker(Locale.ENGLISH);
        Internet internet = faker.internet();
        email = internet.emailAddress();
        password = internet.password();
        name = faker.name().name();
        System.out.printf("user email: %s; password: %s; name: %s\n",
                email, password, name);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @After
    public void deleteAccount() {
        deleteAccount(email, password);
    }

    protected void login() {
        driver.get(Config.LOGIN_PAGE_URL);

        loginPage.fillIn(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForCheckoutButton();
    }

    protected void createAccount() {
        given()
                .body(CreateUserRequestVO.builder()
                        .email(email)
                        .password(password)
                        .name(name)
                        .build())
                .contentType(JSON)
                .log().method().log().uri().log().body()
                .when()
                .post("/auth/register")
                .then()
                .log().status().log().body()
                .statusCode(SC_OK);
    }

    protected void deleteAccount(String email, String password) {
        String accessToken = loginViaApi(email, password);
        if (accessToken != null) {
            System.out.printf("deleting user: %s\n", email);
            deleteUserViaApi(accessToken);
        } else {
            System.out.println("no user deleted");
        }
    }

    private String loginViaApi(String email, String password) {
        ValidatableResponse validatableResponse = given()
                .config(config)
                .contentType(JSON)
                .log().method().log().uri().log().body().log().headers()
                .when()
                .body(LoginRequestVO.builder()
                        .email(email)
                        .password(password)
                        .build())
                .post("/auth/login")
                .then()
                .log().status().log().body();
        if (validatableResponse.extract().statusCode() == SC_OK) {
            return validatableResponse.extract().body().as(LoginResponseVO.class)
                    .getAccessToken();
        }
        return null;
    }

    private void deleteUserViaApi(String accessToken) {
        given()
                .config(config)
                .contentType(JSON)
                .log().method().log().uri().log().body().log().headers()
                .when()
                .header("Authorization", accessToken)
                .delete("/auth/user")
                .then()
                .log().status().log().body()
                .statusCode(SC_ACCEPTED)
                .body("success", equalTo(true),
                        "message", equalTo("User successfully removed"));
    }
}
