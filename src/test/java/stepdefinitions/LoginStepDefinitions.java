package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.assertTrue;

public class LoginStepDefinitions {
    private WebDriver driver;

    @Given("I am on the login page")
    public void iAmOnLoginPage() {
        // Set path to the ChromeDriver executable (You should set the path to your ChromeDriver executable)
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeOptions and WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Optional: Maximize the browser window

        driver = new ChromeDriver(options);

        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        // Find the username and password fields and enter valid credentials
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
    }

    @When("I enter invalid credentials")
    public void iEnterInValidCredentials() {
        // Find the username and password fields and enter valid credentials
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("asdasdasd");
        passwordField.sendKeys("qweqweqwe");
    }

    @And("I click the login button")
    public void iClickLoginButton() {
        // Find and click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        // Verify successful login by checking for a specific element on the next page
        WebElement productLabel = driver.findElement(By.id("shopping_cart_container"));
        assertTrue(productLabel.isDisplayed());

        // Close the browser after the test is complete
        driver.quit();
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        // Verify successful login by checking for a specific element on the next page
        WebElement errormsg1 = driver.findElement(By.className("error-button"));
        assertTrue(errormsg1.isDisplayed());

        // Close the browser after the test is complete
        driver.quit();
    }
}
