package util;

import java.sql.SQLException;

import static daos.CityDAO.findLatitudeByName;
import static daos.CityDAO.findLongitudeByName;

public class DistanceUtil {
    public static double getDistance(String city1, String city2) throws SQLException {
        double lat1 = findLatitudeByName(city1).get();
        double lat2 = findLatitudeByName(city2).get();

        double lon1 = findLongitudeByName(city1).get();
        double lon2 = findLongitudeByName(city2).get();

        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        double r = 6371;

        return (c * r);
    }
}
