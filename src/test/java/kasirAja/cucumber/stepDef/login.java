package kasirAja.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("login page")
    public void login_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }

    @When("input valid username")
    public void input_valid_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("input valid password")
    public void input_valid_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Kemudian user klik tombol login")
    public void kemudian_user_klik_tombol_login() {
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User berhasil login masuk ke dashboard")
    public void user_berhasil_login_masuk_ke_dashboard() {
        String berhasil = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(berhasil,"Swag Labs");
        driver.close();
    }

    @And("input password invalid")
    public void input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("secret_saucee");
    }

    @Then("Tampil error message")
    public void user_gagal_login() {
        String ErrorLogin = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(ErrorLogin,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

}
