package pl.sowinski.Dao;

import pl.sowinski.config.DbUtil;
import pl.sowinski.domain.Deliveries;
import pl.sowinski.domain.Suppliers;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DeliveriesDao {

    private static final String CREATE = "INSERT INTO deliveries(date, start, end, packaging, description, user_id, suppliers_id, localdatetime) VALUES (?,?,?,?,?,?,?,?)";
    private static final String ALL_LIST = "SELECT * FROM deliveries";
    private static final String EDIT = "";
    private static final String DELETE = "";

public Deliveries create (Deliveries deliveries){
    try(Connection connection = DbUtil.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
        preparedStatement.setObject(1,deliveries.getDate());
        preparedStatement.setString(2,deliveries.getStart());
        preparedStatement.setString(3,deliveries.getEnd());
        preparedStatement.setInt(4,deliveries.getPackaging());
        preparedStatement.setString(5,deliveries.getDescription());
        preparedStatement.setInt(6,deliveries.getUserId());
        preparedStatement.setInt(7,deliveries.getSuppliersId());
        preparedStatement.setObject(8,deliveries.getLocalDateTime());
        int result = preparedStatement.executeUpdate();
        if(result !=1){
            throw new RuntimeException("RuntimeException" + result);
        }
        try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){
            if(resultSet.first()){
                deliveries.setId(resultSet.getInt(1));
                return deliveries;
            }else{
                throw new RuntimeException("Generated key was not found");
            }

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

public List<Deliveries> readAll(){
    List<Deliveries> deliveriesList = new ArrayList<>();
    try(Connection connection = DbUtil.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(ALL_LIST);
        ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Deliveries deliveries = new Deliveries();
                deliveries.setId(resultSet.getInt("id"));
                deliveries.setDate(resultSet.getDate("date"));
                deliveries.setStart(resultSet.getString("start"));
                deliveries.setEnd(resultSet.getString("end"));
                deliveries.setPackaging(resultSet.getInt("packaging"));
                deliveries.setDescription(resultSet.getString("description"));
                deliveries.setUserId(resultSet.getInt("user_id"));
                deliveries.setSuppliersId(resultSet.getInt("suppliers_id"));
                deliveries.setLocalDateTime(resultSet.getTimestamp("localdatetime").toLocalDateTime());
                deliveriesList.add(deliveries);
            }
        } catch (SQLException e) {
        e.printStackTrace();
    }
    return deliveriesList;
}



}

