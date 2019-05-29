package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Dao {

    private final static String url = "jdbc:mysql://http://207.154.250.162/phpmyadmin/db_structure.php?server=1&db=boulderdash&token=f6095a84188882f141cf0e872d395775";

    private final static String user = "root";

    private final static String passwd = "password";

    private static Connection connection = null;
    private static Dao dao = null;

    private Dao() {
        try {
            connection = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            System.err.println("IL FAUT VERIFIER LES PARAMETRES DE CONNEXION");
            e.printStackTrace();
        }
    }

    public static Dao getInstance() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    new Dao();
                }
            }
        }
        return dao;
    }

    public Connection getConnection() {
        return connection;
    }
}