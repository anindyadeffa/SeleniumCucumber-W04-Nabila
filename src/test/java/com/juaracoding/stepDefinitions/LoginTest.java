package com.juaracoding.stepDefinitions;

import com.juaracoding.pages.InventoryPage;
import com.juaracoding.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    // TCC.SD.001
    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
    }

    @When("I enter a valid username and password")
    public void i_enter_a_valid_username_and_password(){
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
    }

    @When("I enter a invalid username and password")
    public void i_enter_a_invalid_username_and_password(){
        loginPage.inputUsername("test_user");
        loginPage.inputPassword("test_password");
    }

    @When("I click the login button")
    public void i_clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to inventory page")
    public void i_should_be_redirected_to_inventory_page(){
        inventoryPage = new InventoryPage(driver);
        assert inventoryPage.isOnProductPage();
    }

    @Then("Adds one product to the cart")
    public void add_product_to_cart() {
        inventoryPage.addProductToCart();
        driver.quit();
    }

    @Then("I see message invalid credentials")
    public void i_see_message_invalid_credentials(){
        assert loginPage.isErrorDisplayed();
        driver.quit();
    }

}
