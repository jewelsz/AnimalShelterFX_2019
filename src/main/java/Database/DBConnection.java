package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection implements AutoCloseable {
    // static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/";
    private final String DATABASE_NAME;
    private static final String USERNAME = "jowelle";
    private static final String PASSWORD = "admin";
    private static final String MAX_POOL = "250";

    private Connection connection;
    private Properties properties;

    public DbConnection(String databaseName) {
        DATABASE_NAME = databaseName;
    }

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    public Connection connect() {
        try {
            Class.forName(DATABASE_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL + DATABASE_NAME, getProperties());
        } catch (ClassNotFoundException | SQLException e) {
            // Java 7+
            e.printStackTrace();
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() throws Exception {
        disconnect();
        if (connection != null)
            throw new Exception("The connection has not been closed successfully!");
    }
}
