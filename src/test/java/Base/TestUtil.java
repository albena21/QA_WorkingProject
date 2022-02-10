package Base;

import Driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {

    protected WebDriver webDrv;
    private String applicationUrl, browser;
    private int implicitWaitSeconds;

    @BeforeMethod
    public void setUp(){
        setupBrowserDriver();
        loadInitialPage();
    }
    private void loadInitialPage() {
        webDrv.get(applicationUrl);
    }
    @AfterMethod
    public void tearDown(){
        webDrv.quit();
    }
    private void setupBrowserDriver(){
        try{
            FileInputStream configFile = new
                    FileInputStream("src/test/resources/configfile");
            Properties config = new Properties();
            config.load(configFile);
            applicationUrl = config.getProperty("url");
            implicitWaitSeconds = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("targetBrowser");
            System.out.println("web test");
        }   catch (IOException e){
            System.out.println(e);
        }

        switch (browser){
            case "chrome":
                webDrv = DriverFactory.getChromeDriver(implicitWaitSeconds);
                break;
            case "firefox":
                webDrv = DriverFactory.getFireFoxDriver(implicitWaitSeconds);
                break;
        }
    }
}
