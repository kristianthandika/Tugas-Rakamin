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

public class logout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("user sudah login")
    public void user_sudah_login_() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
    @When("user akses sidebar menu")
    public void sidebar() {
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
    }
    @And("user klik tombol Logout")
    public void logout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }
    @Then("User berhasil logout")
    public void berhasil_logout() {
        String berhasil = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(berhasil,"Swag Labs");
        driver.close();
    }
}
