package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    protected WebDriver webDrv;
    private static final String ADD_TO_CARD_LOCATOR = "//button[@id='add-to-cart-sauce-labs-%s']";

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartBtn;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartImage;

    public ProductsPage(WebDriver webDrv){
        this.webDrv = webDrv;
        PageFactory.initElements(webDrv, this);
    }

    public void addToCartByProductName(String productName){
        String xpathOfItemToBeAdded = String.format(ADD_TO_CARD_LOCATOR, productName);
        WebElement addToCartBtn = webDrv.findElement(By.xpath(xpathOfItemToBeAdded));
        addToCartBtn.click();
    }

    public int getNumbersInTheCart(){
        return Integer.parseInt(shoppingCartImage.getText());
    }
}
