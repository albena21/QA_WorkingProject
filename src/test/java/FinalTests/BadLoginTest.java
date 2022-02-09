package FinalTests;

import Base.TestUtil;
import Pages.LoginPage;
import Pages.ProductsPage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BadLoginTest extends TestUtil {
    @DataProvider(name = "wrongLogin")
    public static Object[][] readCvsloginFile() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader
                (new FileReader("src/test/resources/wrongpass"))) {
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size() ; i++){
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }}
    @Test(dataProvider = "wrongLogin")
    public void wronglogin (String userName, String password){
    LoginPage loginPage = new LoginPage(webDrv);
        ProductsPage productsPage = loginPage.login(userName, password);

        WebElement errorBtn = webDrv.findElement(By.className("error-button"));
        Assert.assertTrue(errorBtn.isDisplayed());
}}
