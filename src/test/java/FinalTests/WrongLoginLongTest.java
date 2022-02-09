package FinalTests;

import Base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import java.io.*;
import java.time.Duration;
import java.util.List;

 public class WrongLoginLongTest extends TestUtil {
     @DataProvider(name = "WrongLogin")
     public static Object[][] readCvsloginFileW() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader
                (new FileReader("src/test/resources/WrongLogin"))) {
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size() ; i++){
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }}

        @Test(dataProvider = "WrongLogin")
            public void WrongLogin(String userName, String password) {

         WebDriverWait wait = new WebDriverWait(webDrv, Duration.ofSeconds(6));

            WebElement userNameInput = webDrv.findElement(By.id ("user-name"));
             userNameInput.clear();
             userNameInput.sendKeys(userName);

             WebElement passwordInput = webDrv.findElement(By.cssSelector("[placeholder=Password]"));
             passwordInput.clear();
             passwordInput.sendKeys(password);


             WebElement logInBtn = webDrv.findElement(By.name("login-button"));
            wait.until(ExpectedConditions.elementToBeClickable(logInBtn));
              logInBtn.click();

              WebElement errorBtn = webDrv.findElement(By.className("error-button"));
                 Assert.assertTrue(errorBtn.isDisplayed());
        }}