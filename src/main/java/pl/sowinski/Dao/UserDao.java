package pl.sowinski.Dao;

import org.mindrot.jbcrypt.BCrypt;
import pl.sowinski.config.DbUtil;
import pl.sowinski.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private static final String CREATE_USER = "INSERT INTO user(username, password, email, date) VALUES (?,?,?,?)";
    private static final String CHECK_BY_EMAIL = "SELECT * FROM user WHERE username=?";


    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User create(User user) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, hashPassword(user.getPassword()));
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setObject(4, user.getLocalDateTime());
            int result = preparedStatement.executeUpdate();
            if (result != 1) {
                throw new RuntimeException("RuntimeException" + result);
            }
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.first()) {
                    user.setId(resultSet.getInt(1));
                    return user;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User login(String userName, String userPassword) {
        User user = new User();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BY_EMAIL)) {
            preparedStatement.setString(1, userName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setLocalDateTime(resultSet.getTimestamp("date").toLocalDateTime());
                }
                if (BCrypt.checkpw(userPassword, user.getPassword())) {
                    return user;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
