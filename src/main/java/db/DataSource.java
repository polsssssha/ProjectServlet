package db;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private final String dbName = "servlet";
    private final String name = "localhost";
    private final int port = 3306;
    private final String user = "root";
    private final String password = "D.43215g.";

    public MysqlDataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName(dbName);
        dataSource.setServerName(name);
        dataSource.setPort(port);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

}
