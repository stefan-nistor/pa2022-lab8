import daos.ContinentDAO;
import daos.CountryDAO;
import database.Database;

import javax.xml.crypto.Data;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            var continents = new ContinentDAO();
            continents.create("Europe");
//            Database.getConnection().commit();

            var countries = new CountryDAO();
            Long europeId = continents.findByName("Europe").get().getId();
            System.out.println("EuropeId:" + europeId);

            countries.create("Romania", "Europe");
            countries.create("Ukraine", "Europe");
//            Database.getConnection().commit();

            Database.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
