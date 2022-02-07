import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

 public class WrongLoginTest {
    private WebDriver webDrv;

    @BeforeTest
    public void setUp() {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        webDrv = new FirefoxDriver();
        webDrv.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterTest
    public void tearDown() {

        webDrv.quit();
    }


     @DataProvider(name = "wrongLogin")
     public static Object[][] readCvsloginFile() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/wrongpass"))) {
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size() ; i++){
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;

        }}

        @Test(dataProvider = "wrongLogin")
            public void wronglogin (String userName, String password) {

            webDrv.get("https://www.saucedemo.com/");
            WebDriverWait wait = new WebDriverWait(webDrv, Duration.ofSeconds(6));

            WebElement userNameInput = webDrv.findElement(By.id ("user-name"));
             userNameInput.sendKeys(userName);

             WebElement passwordInput = webDrv.findElement(By.cssSelector("[placeholder=Password]"));
             passwordInput.sendKeys(password);


             WebElement logInBtn = webDrv.findElement(By.name("login-button"));
            wait.until(ExpectedConditions.elementToBeClickable(logInBtn));
              logInBtn.click();

              WebElement errorBtn = webDrv.findElement(By.className("error-button"));
                 Assert.assertTrue(errorBtn.isDisplayed());
        }}