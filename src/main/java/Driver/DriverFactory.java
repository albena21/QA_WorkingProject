package Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DriverFactory {
    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDrv = new ChromeDriver();
        return webDrv;
    }

    public static WebDriver getFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDrv = new FirefoxDriver();
        return null;
    }
}
