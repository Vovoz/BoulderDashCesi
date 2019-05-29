package dao;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

public class testco {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                String BDD = "boulderdash";
                String url = "jdbc:mysql:http://207.154.250.162/phpmyadmin/db_structure.php?server=1&db=boulderdash&token=f6095a84188882f141cf0e872d395775";
                String user ="root";
                String passwd = "password";

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, user, passwd);
                    System.out.println("Connecter");
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Erreur");
                    System.exit(0);
                }
            }
        });
    }
}
