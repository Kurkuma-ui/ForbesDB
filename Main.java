import java.util.List;

import dto.CSVObject;
import utils.DBConnector;
import utils.Parsing;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/Forbes.csv";
        List<CSVObject> csvObjects = Parsing.parseCSV(filePath);

        DBConnector.createDatabase();
        for (CSVObject csvObject : csvObjects) {
            DBConnector.writeToDB(csvObject);
        }
    }
}