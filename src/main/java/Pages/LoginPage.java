package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver webDrv;

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(css = "[placeholder=Password]")
    private WebElement passwordInput;

    @FindBy(name = "login-button")
    private WebElement loginBtn;

    public LoginPage(WebDriver webDrv){
        this.webDrv = webDrv;
        PageFactory.initElements(webDrv, this);
    }

    public ProductsPage login(String userName, String password){
        userNameInput.clear();
        userNameInput.sendKeys(userName);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();

        return new ProductsPage(webDrv);
    }
}
