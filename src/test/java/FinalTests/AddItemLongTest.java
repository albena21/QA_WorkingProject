package FinalTests;

import Base.TestUtil;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

 public class AddItemLongTest extends TestUtil {

    @Test
    public void AddItemToCart(){
        WebElement userNameInput = webDrv.findElement(By.id ("user-name"));
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = webDrv.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");

        WebElement logInBtn = webDrv.findElement(By.name("login-button"));
        logInBtn.click();

        WebElement AddToCart = webDrv.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket"));
        AddToCart.click();

        WebElement AddCart = webDrv.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        AddCart.click();

        WebElement RemoveLabel = webDrv.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));

        Assert.assertTrue(RemoveLabel.isDisplayed());
}}
