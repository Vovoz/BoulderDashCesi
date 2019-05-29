package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final class DBConnection {

    private static DBConnection INSTANCE = null;

    private Connection connection;

    private DBConnection() {
        this.open();
    }

    public static synchronized DBConnection getInstance() {
        if (DBConnection.INSTANCE == null) {
            DBConnection.INSTANCE = new DBConnection();
        }

        return DBConnection.INSTANCE;
    }

    private Boolean open() {
        final DBProperties dbProperties = new DBProperties();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(dbProperties.getUrl(),dbProperties.getLogin(), dbProperties.getPassword());
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
