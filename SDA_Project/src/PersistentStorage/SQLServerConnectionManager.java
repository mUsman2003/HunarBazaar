package PersistentStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnectionManager {

    // Connection string for SQL Server
    private static final String CONNECTION_STRING =
            "jdbc:sqlserver://IRTAZA-KHAN\\SQLEXPRESS:1433;" +
            "Database=SDA_Project;encrypt=false;trustServerCertificate=true;integratedSecurity=true;";

    /**
     * Get a connection to the SQL Server database.
     * 
     * @return Connection object
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STRING);
    }
}

