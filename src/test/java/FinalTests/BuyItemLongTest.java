package FinalTests;

import Base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.*;
import java.util.List;

public class BuyItemLongTest extends TestUtil {
    @DataProvider(name = "DataBuyer")
    public static Object[][] readCvsloginFileW() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/DataBuyer"))) {
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size() ; i++){
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }}

    @Test(dataProvider = "DataBuyer")

 void CheckOut(String name, String FamilyName, String postcode) {

        WebElement userNameInput = webDrv.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = webDrv.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");

        WebElement logInBtn = webDrv.findElement(By.name("login-button"));
        logInBtn.click();

        WebElement AddToCart = webDrv.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        AddToCart.click();

        WebElement AddCart = webDrv.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        AddCart.click();

        WebElement cart = webDrv.findElement(By.id("shopping_cart_container"));
        cart.click();

        WebElement checkout = webDrv.findElement(By.id("checkout"));
        checkout.click();

        WebElement FirstNameInput = webDrv.findElement(By.id("first-name"));
        FirstNameInput.sendKeys(name);

        WebElement LastNameInput = webDrv.findElement(By.id("last-name"));
        LastNameInput.sendKeys(FamilyName);

        WebElement ZipCodeInput = webDrv.findElement(By.id("postal-code"));
        ZipCodeInput.sendKeys(postcode);

        WebElement Continu = webDrv.findElement(By.name("continue"));
        Continu.click();

        WebElement Finish = webDrv.findElement(By.id("finish"));
        Finish.click();

        WebElement BackButon = webDrv.findElement(By.id("back-to-products"));

        Assert.assertTrue(BackButon.isDisplayed());
    }
}
