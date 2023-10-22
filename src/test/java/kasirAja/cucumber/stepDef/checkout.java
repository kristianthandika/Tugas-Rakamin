package kasirAja.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User login")
    public void user_berhasil_login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }
    @Given("User akses halaman chart")
    public void halaman_chart() {
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
    }
    @When("user klik tombol checkout")
    public void klik_tombol_checkout() {
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }
    @And("user menginputkan data")
    public void user_menginputkan_data() {
        driver.findElement(By.id("first-name")).sendKeys("Kristian");
        driver.findElement(By.id("last-name")).sendKeys("Dika");
        driver.findElement(By.id("postal-code")).sendKeys("41316");
    }

    @And("user klik tombol continue")
    public void user_klik_tombol_continue() {
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        String overviewAssert = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")).getText();
        Assert.assertEquals(overviewAssert,"Checkout: Overview");
    }

    @Then("user klik tombol finish")
    public void user_klik_tombol_finish() {
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
        String finishAssert = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2")).getText();
        Assert.assertEquals(finishAssert,"Thank you for your order!");
        driver.close();
    }
}
