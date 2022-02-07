package FinalTests;

import Base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddingItemsTest extends TestUtil {

    @Test
    public void AddItemtoCart(){
        WebElement userNameInput = webDrv.findElement(By.id ("user-name"));
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = webDrv.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");

        WebElement logInBtn = webDrv.findElement(By.name("login-button"));
        logInBtn.click();

        WebElement addtocart = webDrv.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket"));
        addtocart.click();

        WebElement addcart = webDrv.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        addcart.click();

        WebElement RemoveLabel = webDrv.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));

        Assert.assertTrue(RemoveLabel.isDisplayed());
}}
