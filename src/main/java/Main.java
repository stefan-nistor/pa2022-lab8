import daos.CityDAO;
import daos.ContinentDAO;
import daos.CountryDAO;
import database.Database;
import util.CSVUtil;

import java.sql.SQLException;

import static database.Database.createConnection;
import static util.DistanceUtil.getDistance;

public class Main {

    public static final String CSV_FILE_PATH = "src/main/resources/concap.csv";
    public static void main(String[] args) throws SQLException {
        createConnection();
//        try {
//            var continents = new ContinentDAO();
//            var city = new CityDAO();
//            var countries = new CountryDAO();
//
//            continents.create("Europe");
//            countries.create("Romania", "Europe", 40);
//            countries.create("Ukraine", "Europe", 56);
//            city.create("Bucharest", "Romania", true, 44.42, 26.10);
//
//
//            Long europeId = continents.findByName("Europe").get().getId();
//            System.out.println("Europe Id: " + europeId);
//
//            System.out.printf(city.findByName("Bucharest").get().toString());
//            Database.getConnection().close();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

//        CSVUtil.insertCSVInDatabase(CSV_FILE_PATH);

        System.out.println(getDistance("Jerusalem", "Yaren"));

    }
}
