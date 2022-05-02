package daos;

import database.Database;
import entities.City;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Optional;

import static database.Database.closeConnection;
import static database.Database.getConnection;

public class CityDAO {
    public void create(String name, String country, boolean isCapital, Double lon, Double lat) throws SQLException {
        Connection conn = getConnection();
        try (PreparedStatement pstms = conn.prepareStatement(
                "INSERT INTO public.cities (name, country, capital, longitude, latitude) values (?, ?, ?, ?, ?)"
        )) {
            pstms.setString(1, name);
            pstms.setString(2, country);
            pstms.setBoolean(3, isCapital);
            pstms.setDouble(4, lon);
            pstms.setDouble(5, lat);
            pstms.executeUpdate();
        }
        closeConnection();
    }

    public Optional<City> findById(Long id) throws SQLException {
        Connection con = Database.getConnection();
        City city = new City();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM public.cities WHERE id=" + id
             )
        ) {
            while (rs.next()) {
                city.setId(rs.getLong("id"));
                city.setName(rs.getString("name"));
                city.setCapital(rs.getBoolean("capital"));
                city.setCountry(rs.getString("country"));
                city.setLatitude(rs.getDouble("latitude"));
                city.setLongitude(rs.getDouble("longitude"));
            }
        }
        closeConnection();
        return Optional.of(city);
    }

    public Optional<City> findByName(String name) throws SQLException {
        Connection con = getConnection();
        City city = new City();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM public.cities WHERE name='" + name + "'"
             )) {

            while (rs.next()) {
                city.setId(rs.getLong("id"));
                city.setName(rs.getString("name"));
                city.setCapital(rs.getBoolean("capital"));
                city.setCountry(rs.getString("country"));
                city.setLatitude(rs.getDouble("latitude"));
                city.setLongitude(rs.getDouble("longitude"));
            }
        }
        closeConnection();
        return Optional.of(city);
    }

    public static Optional<Double> findLongitudeByName(String name) throws SQLException {
        Connection con = getConnection();
        double retVal = 0D;
        try (
                Statement stmt = con.createStatement();
                var rs = stmt.executeQuery("SELECT longitude FROM public.cities WHERE name='" + name + "'");
        ) {
            while (rs.next()) {
                retVal = rs.getDouble("longitude");
            }
        }
        return Optional.of(retVal);
    }

    public static Optional<Double> findLatitudeByName(String name) throws SQLException {
        Connection con = getConnection();
        double retVal = 0D;
        try (
                Statement stmt = con.createStatement();
                var rs = stmt.executeQuery("SELECT latitude FROM public.cities WHERE name='" + name + "'");
        ) {
            while (rs.next()) {
                retVal = rs.getDouble("latitude");
            }
        }
        return Optional.of(retVal);
    }

}
