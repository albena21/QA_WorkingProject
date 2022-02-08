package FinalTests;

import Base.TestUtil;
import Pages.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import java.io.*;
import java.util.List;
import org.testng.Assert;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

    public class AutoTest extends TestUtil {
     @DataProvider(name = "DataBuyer")
        public static Object[][] readCvsloginFile() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader
                ("src/test/resources/databuyer"))) {
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
    }

    @Test(dataProvider = "DataBuyer")
      public void AutoLogInAddItemandbuy(String name, String familyname, String postcode) {

            LoginPage loginPage = new LoginPage(webDrv);
            ProductsPage productsPage = loginPage.login
                    ("standard_user", "secret_sauce");
            productsPage.addToCartByProductName("backpack");
            productsPage.addToCartByProductName("onesie");

            Assert.assertEquals(productsPage.getNumbersInTheCart(), 2, "we added items");

            WebElement cart = webDrv.findElement(By.id("shopping_cart_container"));
            cart.click();

            WebElement checkout = webDrv.findElement(By.id("checkout"));
            checkout.click();

            WebElement FirstNameInput = webDrv.findElement(By.id("first-name"));
            FirstNameInput.sendKeys(name);

            WebElement LastNameInput = webDrv.findElement(By.id("last-name"));
            LastNameInput.sendKeys(familyname);

            WebElement ZipCodeInput = webDrv.findElement(By.id("postal-code"));
            ZipCodeInput.sendKeys(postcode);

            WebElement continu = webDrv.findElement(By.name("continue"));
            continu.click();

            WebElement Finish = webDrv.findElement(By.id("finish"));
            Finish.click();

            WebElement BackButon = webDrv.findElement(By.id("back-to-products"));

            Assert.assertTrue(BackButon.isDisplayed());
        }

    }

