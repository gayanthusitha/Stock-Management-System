package Contraller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseContraller {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/i_store";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    private Connection connection;
    private static DatabaseContraller instance;
    
    public DatabaseContraller(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Database Connected...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static DatabaseContraller getInstance(){
        if (instance == null){
            instance = new DatabaseContraller();
        }
        return instance;
    }
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
