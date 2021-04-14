package pl.sowinski.Dao;

import pl.sowinski.config.DbUtil;
import pl.sowinski.domain.Deliveries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveriesDao {

    private static final String CREATE = "INSERT INTO deliveries(date, start, end, packaging, description, user_id, suppliers_id) VALUES (?,?,?,?,?,?,?)";
    private static final String ALL_LIST = "SELECT * FROM deliveries";
    private static final String EDIT = "";
    private static final String DELETE = "";

public Deliveries create (Deliveries deliveries){
    try(Connection connection = DbUtil.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
        preparedStatement.setString(1,deliveries.getDate());
        preparedStatement.setString(2,deliveries.getStart());
        preparedStatement.setString(3,deliveries.getEnd());
        preparedStatement.setInt(4,deliveries.getPackaging());
        preparedStatement.setString(5,deliveries.getDescription());
        preparedStatement.setInt(6,deliveries.getUserId());
        preparedStatement.setInt(7,deliveries.getSuppliersId());
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
}

