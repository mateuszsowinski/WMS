package pl.sowinski.Dao;

import pl.sowinski.config.DbUtil;
import pl.sowinski.domain.Deliveries;
import pl.sowinski.domain.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusDao {

    private static final String CREATE = "INSERT INTO status (status, dateStatus, userId, deliveryId) VALUES (?,?,?,?)";

    public Status create (Status status){
        try(Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1,status.getStatus());
            preparedStatement.setObject(2,status.getDateStatus());
            preparedStatement.setInt(3,status.getUserId());
            preparedStatement.setInt(4,status.getDeliveryId());
            int result = preparedStatement.executeUpdate();
            if(result !=1){
                throw new RuntimeException("RuntimeException" + result);
            }
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                if(resultSet.first()){
                    status.setId(resultSet.getInt(1));
                    return status;
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
