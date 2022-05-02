package daos;

import database.Database;
import entities.Country;

import java.sql.*;
import java.util.Optional;

import static database.Database.*;

public class CountryDAO {

    public void create(String name, String continent, String code) throws SQLException {
        Connection conn = getConnection();
        try (PreparedStatement pstms = conn.prepareStatement(
                "INSERT INTO public.countries (name, continent, code) values (?, ?, ?)"
        )) {
            pstms.setString(1, name);
            pstms.setString(2, continent);
            pstms.setString(3, code);
            pstms.executeUpdate();
        }
        closeConnection();
    }

    public Optional<Country> findById(Long id) throws SQLException {
        Connection con = Database.getConnection();
        Country country = new Country();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM public.countries WHERE id=" + id
             )
        ) {
            while (rs.next()) {
                country.setId(rs.getLong("id"));
                country.setName(rs.getString("name"));
                country.setCode(rs.getString("code"));
                country.setContinent(rs.getString("continent"));
            }
        }
        closeConnection();
        return Optional.of(country);
    }

    public Optional<Country> findByName(String name) throws SQLException {
        Connection con = getConnection();
        Country country = new Country();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM public.continents WHERE name='" + name + "'"
             )) {

            while (rs.next()) {
                country.setId(rs.getLong("id"));
                country.setName(rs.getString("name"));
                country.setCode(rs.getString(   "code"));
                country.setContinent(rs.getString("continent"));
            }
        }
        closeConnection();
        return Optional.of(country);
    }
}
