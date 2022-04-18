package daos;

import database.Database;
import entities.Continent;

import java.sql.*;
import java.util.Optional;

import static database.Database.getConnection;

public class ContinentDAO {

    public void create(String name) throws SQLException {
        Connection conn = getConnection();
        try (PreparedStatement pstms = conn.prepareStatement(
                "INSERT INTO public.continents (name) values (?)"
        )) {
            pstms.setString(1, name);
            pstms.executeUpdate();
        }
    }

    public Optional<Continent> findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        Continent continent = new Continent();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM public.continents WHERE name='"+name+"'"
             )) {

            while (rs.next()) {
                continent.setId(rs.getLong("id"));
                continent.setName(rs.getString("name"));
            }
        }
        return Optional.ofNullable(continent);
    }

    public Optional<Continent> findById(Long id) throws SQLException {
        Connection con = Database.getConnection();
        Continent continent = new Continent();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM public.continents WHERE id=" + id
             )) {
            while (rs.next()) {
                continent.setId(rs.getLong("id"));
                continent.setName(rs.getString("name"));
            }
        }
        return Optional.ofNullable(continent);
    }

}
