package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import dto.CSVObject;

public class Parsing {
    public static List<CSVObject> parseCSV(String filePath) {
        List<CSVObject> csvObjects = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            csvReader.readNext();
            while ((nextLine = csvReader.readNext()) != null) {
                CSVObject csvObject = new CSVObject();
                csvObject.setRank(Integer.parseInt(nextLine[0]));
                csvObject.setName(nextLine[1]);
                csvObject.setNetworth(Float.parseFloat(nextLine[2]));
                csvObject.setAge(Integer.parseInt(nextLine[3]));
                csvObject.setCountry(nextLine[4]);
                csvObject.setSource(nextLine[5]);
                csvObject.setIndustry(nextLine[6]);
                csvObjects.add(csvObject);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return csvObjects;
    }
}
