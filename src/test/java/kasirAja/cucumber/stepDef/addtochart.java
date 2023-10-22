package kasirAja.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class addtochart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user berhasil login")
    public void user_berhasil_masuk_ke_dashboard() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user akses halaman product")
    public void halaman_product() {
        String product = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")).getText();
        Assert.assertEquals(product,"Products");
    }

    @And("user klik tombol add to chart")
    public void add_product() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("barang berhasil masuk keranjang")
    public void chart() {
        String product = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).getText();
        Assert.assertEquals(product,"1");
        driver.close();
    }
}
