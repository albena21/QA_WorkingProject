package FinalTests;

import Base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.*;
import Pages.*;
import java.util.List;

public class WrongLoginShortTest extends TestUtil {
    @DataProvider(name = "WrongLogin")
    public static Object[][] readCvsloginFile() throws IOException, CsvException {
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
    public void WrongLogin(String userName, String password){
    LoginPage loginPage = new LoginPage(webDrv);
        loginPage.login(userName, password);

        WebElement errorBtn = webDrv.findElement(By.className("error-button"));
        Assert.assertTrue(errorBtn.isDisplayed());
}}
