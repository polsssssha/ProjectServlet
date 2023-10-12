package db;

import com.mysql.cj.jdbc.MysqlDataSource;
import model.UserModel;
import java.sql.*;
import java.util.*;

public class UserRepository {
    private final MysqlDataSource dataSource = new DataSource().getDataSource();

    public List<UserModel> getAllUsers(){
        try(Connection conn = dataSource.getConnection();
            Statement statement = conn.createStatement()){
            ArrayList<UserModel> users = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT login, password, email FROM users");
            while (resultSet.next()){
                users.add(new UserModel(resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email")));
            }
            if (users.isEmpty())
                return Collections.emptyList();
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addUser(UserModel user) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO users(`login`, `password`, `email`) VALUES(?,?,?)")) {
            statement.setObject(1, user.getLogin());
            statement.setObject(2, user.getPassword());
            statement.setObject(3, user.getEmail());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}