package utils;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class HelperCsv {
    public static Object[][] readCsvFile(String filename) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader(filename))){
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i <csvData.size() ; i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
    }

    public void readConfig() throws IOException {
        try (FileInputStream configFile = new FileInputStream("filepath")){
            Properties config = new Properties();
            config.load(configFile);
            String url = config.getProperty("Propname");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
