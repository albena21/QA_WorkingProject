package Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class DriverFactory {
    public static WebDriver getChromeDriver(long implicitWaitSeconds) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDrv = new ChromeDriver();
        webDrv.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
        return webDrv;
    }

    public static WebDriver getFireFoxDriver(long implicitWaitSeconds){
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDrv = new FirefoxDriver();
        webDrv.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
        return webDrv;
    }
}
