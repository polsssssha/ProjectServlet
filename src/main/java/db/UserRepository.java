package db;

import model.UserModel;
import java.sql.*;
import java.util.*;
import java.sql.DriverManager;

public class DBHandler {
    private final DataSource dataSource = new DataSource();


/*
    public List<UserModel> getAllUsers(){
        try(Statement statement = this.connection.createStatement()){
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
        } catch (SQLException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void addUser(UserModel user) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO users(`login`, `password`, `email`) VALUES(?,?,?)")) {
            statement.setObject(1, user.getLogin());
            statement.setObject(2, user.getPassword());
            statement.setObject(3, user.getEmail());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    public static void main(String[] args) {
        DataSource dataSource1 = new DataSource();
        dataSource1.getDataSource();
    }
}