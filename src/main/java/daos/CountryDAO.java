package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static database.Database.getConnection;

public class CountryDAO {

    public void create(String name, String continent) throws SQLException {
        Connection conn = getConnection();
        try (PreparedStatement pstms = conn.prepareStatement(
                "INSERT INTO public.countries (name, continent) values (?, ?)"
        )) {
            pstms.setString(1, name);
            pstms.setString(2, continent);
            pstms.executeUpdate();
        }
    }

}
