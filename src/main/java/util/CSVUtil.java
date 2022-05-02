package util;

import daos.CityDAO;
import daos.ContinentDAO;
import daos.CountryDAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static database.Database.getConnection;

public class CSVUtil {

    public static void insertCSVInDatabase(String csvFilePath) throws SQLException{
        Connection conn = getConnection();
        CountryDAO countryDAO = new CountryDAO();
        CityDAO cityDAO = new CityDAO();
        ContinentDAO continentDAO = new ContinentDAO();

        try {
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;
            lineReader.readLine();
            while((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                countryDAO.create(data[0], data[5], data[4]);
                cityDAO.create(data[1], data[0], true, Double.valueOf(data[3]), Double.valueOf(data[2]));
            }
            lineReader.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
