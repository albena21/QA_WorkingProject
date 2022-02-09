package FinalTests;

import Base.TestUtil;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends TestUtil {
   @Test
   public void AddToCartItems() {
        LoginPage loginPage = new LoginPage(webDrv);
        ProductsPage productsPage = loginPage.login
                ("standard_user", "secret_sauce");
        productsPage.addToCartByProductName("backpack");
        productsPage.addToCartByProductName("onesie");
        productsPage.addToCartByProductName("fleece-jacket");

        Assert.assertEquals(productsPage.getNumbersInTheCart(), 3, "we added items");
    }
}
