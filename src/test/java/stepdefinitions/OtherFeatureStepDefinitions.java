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

public class OtherFeatureStepDefinitions {

    private WebDriver driver;

    @Given("I am logged in")
    public void iAmLoggedIn() {
        // Set path to the ChromeDriver executable (You should set the path to your ChromeDriver executable)
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeOptions and WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Optional: Maximize the browser window

        driver = new ChromeDriver(options);

        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");

        // Find the username and password fields and enter valid credentials
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @When("I add a product to the cart")
    public void iAddProductToCart() {
        WebElement saucelabsbackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        saucelabsbackpack.click();
    }

    @Then("I should see the product in the cart")
    public void iShouldSeeProductInCart() {
        WebElement cartproduct = driver.findElement(By.id("shopping_cart_container"));
        cartproduct.click();

        WebElement checkoutbtn = driver.findElement(By.id("checkout"));
        assertTrue(checkoutbtn.isDisplayed());

        driver.quit();
    }

    @And("I have products in the cart")
    public void iHaveProductInCart() {
        WebElement saucelabsbackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        saucelabsbackpack.click();

        WebElement cartproduct = driver.findElement(By.id("shopping_cart_container"));
        cartproduct.click();

    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        WebElement checkoutbtn = driver.findElement(By.id("checkout"));
        checkoutbtn.click();

    }

    @And("I enter shipping information")
    public void iEnterShippingInformation() {

        WebElement firstnameField = driver.findElement(By.id("first-name"));
        WebElement lastnameField = driver.findElement(By.id("last-name"));
        WebElement zippostalcodeField = driver.findElement(By.id("postal-code"));

        firstnameField.sendKeys("soeb");
        lastnameField.sendKeys("gokil");
        zippostalcodeField.sendKeys("16814874187");

        WebElement continuebtn = driver.findElement(By.id("continue"));
        continuebtn.click();

    }

    @And("I complete the purchase")
    public void iCompleteThePurchase() {

        WebElement checkoutsum = driver.findElement(By.id("checkout_summary_container"));
        assertTrue(checkoutsum.isDisplayed());

        WebElement finishbtn = driver.findElement(By.id("finish"));
        finishbtn.click();

    }

    @Then("I should see the order confirmation")
    public void iShouldSeeOrderConfirmation() {

        WebElement checkoutcomplete = driver.findElement(By.id("checkout_complete_container"));
        assertTrue(checkoutcomplete.isDisplayed());

        WebElement backtoproductbtn = driver.findElement(By.id("back-to-products"));
        backtoproductbtn.click();

        driver.quit();
    }

}
