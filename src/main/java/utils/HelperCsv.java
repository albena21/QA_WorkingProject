package utils;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;

public class HelperCsv {
    public static Object[][] ReadCsvLoginFile(String filename) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader(filename))){
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i <csvData.size() ; i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
    }

    public void ReadConfig() throws IOException {
        try (FileInputStream configFile = new FileInputStream("filepath")){
            Properties config = new Properties();
            config.load(configFile);
            String url = config.getProperty("Propname");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
