package Database;

import Models.Cat;

import java.sql.*;
import java.util.Properties;

public class DbConnection implements AutoCloseable
{

    //XAMPP openen

    // static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/";
    private final String DATABASE_NAME;
    private static final String USERNAME = "jowelle";
    private static final String PASSWORD = "admin";
    private static final String MAX_POOL = "250";

    private Connection connection;
    private Properties properties;

    private static final String insertSQL = "INSERT INTO animals(name, animalType, price) values(?, ?, ?) ";

    public DbConnection(String databaseName) {
        DATABASE_NAME = databaseName;
    }

    private Properties getProperties() {
        if (properties == null)
        {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    public Connection connect() {
        try
        {
            Class.forName(DATABASE_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL + DATABASE_NAME, getProperties());
        } catch (ClassNotFoundException | SQLException e)
        {
            // Java 7+
            e.printStackTrace();
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null)
        {
            try
            {
                connection.close();
                connection = null;
            } catch (SQLException e)
            {
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

    protected PreparedStatement getStatement(String stmt) {
        try
        {

            return this.connection.prepareStatement(stmt, Statement.RETURN_GENERATED_KEYS);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    protected ResultSet executeQuery(PreparedStatement stmt) {
        try
        {
            return stmt.executeQuery();
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    protected int executeUpdate(PreparedStatement stmt) {
        try
        {
            return stmt.executeUpdate();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    /*
    public void insertCat(Cat cat) {
        if (cat != null)
        {
            try (PreparedStatement ps = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, (cat.getName()));
                ps.setString(2, "Cat");
                ps.setInt(3, cat.price);

                int numRowsAffected = ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys())
                {
                    if (rs.next())
                    {
                        cat.setId(rs.getInt(1));
                    }
                } catch (SQLException s)
                {
                    s.printStackTrace();
                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    */
}
