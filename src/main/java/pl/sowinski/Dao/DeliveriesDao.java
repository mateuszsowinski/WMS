package pl.sowinski.Dao;

public class DeliveriesDao {

    private static final String CREATE = "INSERT INTO deliveries(date, start, end, packaging, description, user_id, suppliers_id) VALUES (?,?,?,?,?,?,?)";
    private static final String ALL_LIST = "SELECT * FROM deliveries";
    private static final String EDIT = "";
    private static final String DELETE = "";


}
