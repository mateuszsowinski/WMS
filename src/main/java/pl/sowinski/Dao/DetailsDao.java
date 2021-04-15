package pl.sowinski.Dao;

import pl.sowinski.config.DbUtil;
import pl.sowinski.domain.Deliveries;
import pl.sowinski.domain.Details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DetailsDao {

    private static final String DETAILS = "SELECT deliveries.date, deliveries.start, deliveries.end, deliveries.packaging, deliveries.description, deliveries.localdatetime, suppliers.name, u.username FROM deliveries JOIN suppliers on deliveries.suppliers_id = suppliers.id JOIN user u on deliveries.user_id = u.id ORDER BY deliveries.date DESC";

    public Map<Date, List<Details>> detailsMap(){
        Map<Date, List<Details>> stringListMap = new HashMap<>();
        try(Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DETAILS)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    Date date= resultSet.getDate("date");
                    if(!stringListMap.containsKey(date)){
                        stringListMap.put(date, new ArrayList<Details>());
                    }
                    Details details = new Details();
                    details.setDate(resultSet.getDate("date"));
                    details.setStart(resultSet.getString("start"));
                    details.setEnd(resultSet.getString("end"));
                    details.setPackaging(resultSet.getInt("packaging"));
                    details.setDescription(resultSet.getString("description"));
                    details.setLocalDateTime(resultSet.getTimestamp("localdatetime").toLocalDateTime());
                    details.setName(resultSet.getString("name"));
                    details.setUsername(resultSet.getString("username"));
                    stringListMap.get(date).add(details);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringListMap;
    }

}
