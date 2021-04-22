package pl.sowinski.Dao;

import pl.sowinski.config.DbUtil;
import pl.sowinski.domain.Deliveries;
import pl.sowinski.domain.Suppliers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SuppliersDao {

    private static final String CREATE_SUPPLIERS = "INSERT INTO suppliers(name) VALUES (?)";
    private static final String ALL_SUPPLIERS = "SELECT * FROM suppliers";
    private static final String DELETE = "DELETE FROM suppliers WHERE id=?";


    public Suppliers create(Suppliers suppliers) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SUPPLIERS, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, suppliers.getName());
            int result = preparedStatement.executeUpdate();
            if (result != 1) {
                throw new RuntimeException("RuntimeException" + result);
            }
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.first()) {
                    suppliers.setId(resultSet.getInt(1));
                    return suppliers;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Suppliers> readAll() {
        List<Suppliers> suppliersList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ALL_SUPPLIERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Suppliers suppliers = new Suppliers();
                suppliers.setId(resultSet.getInt("id"));
                suppliers.setName(resultSet.getString("name"));
                suppliersList.add(suppliers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliersList;
    }

    public Suppliers delete(int suppliersId) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, suppliersId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
}
