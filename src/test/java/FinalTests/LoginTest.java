package FinalTests;

import Base.TestUtil;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class LoginTest extends TestUtil {

    @Test
    public void logIn() {
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