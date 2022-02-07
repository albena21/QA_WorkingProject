import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoginTest {
    private WebDriver webDrv;

    @BeforeTest
    public void setUp() {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        webDrv = new FirefoxDriver();
    }

    public void tearDown() {
        webDrv.quit();
    }


    @Test
    public void logIn() {
        webDrv.get("https://www.saucedemo.com/");
        WebElement userNameInput = webDrv.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = webDrv.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");

        WebElement logInBtn = webDrv.findElement(By.name("login-button"));
        logInBtn.click();

        WebElement productMainLabel = webDrv.findElement(By.xpath("//span[text()='Products']"));

        Assert.assertTrue(productMainLabel.isDisplayed());
    }
}