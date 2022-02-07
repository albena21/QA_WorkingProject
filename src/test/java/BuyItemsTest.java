import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BuyItemsTest {

    private WebDriver webDrv;

    @BeforeTest
    public void setUp(){
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        webDrv = new FirefoxDriver();
    }
    @AfterTest
    public void tearDown(){

        webDrv.quit();
    }
    @Test
    public void CheckOut() {
        webDrv.get("https://www.saucedemo.com/");
        WebElement userNameInput = webDrv.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = webDrv.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");

        WebElement logInBtn = webDrv.findElement(By.name("login-button"));
        logInBtn.click();

        WebElement addtocart = webDrv.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        addtocart.click();

        WebElement addcart = webDrv.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addcart.click();

        WebElement cart = webDrv.findElement(By.id("shopping_cart_container"));
        cart.click();

        WebElement checkout = webDrv.findElement(By.id("checkout"));
        checkout.click();

        WebElement FirstName = webDrv.findElement(By.id("first-name"));
        FirstName.sendKeys("First");

        WebElement LastName = webDrv.findElement(By.id("last-name"));
        LastName.sendKeys("Second");

        WebElement ZipCode = webDrv.findElement(By.id("postal-code"));
        ZipCode.sendKeys("1000");

        WebElement continu = webDrv.findElement(By.name("continue"));
        continu.click();

        WebElement Finish = webDrv.findElement(By.id("finish"));
        Finish.click();

        WebElement BackButon = webDrv.findElement(By.id("back-to-products"));

        Assert.assertTrue(BackButon.isDisplayed());
    }
}
