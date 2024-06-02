package Model;

import Contraller.DatabaseContraller;
import View.CashierForm;
import View.ManagerForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class User extends DatabaseContraller{
    private int userid;
    private String name, password;
    private String account_type;
    
    public User(int userId, String name, String password ,String account_type) {
        this.userid = userId;
        this.name = name;
        this.password = password;
        this.account_type = account_type;
    }
    public int getUserId(){
        return userid;
    }
    public String getUserName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getAccountType(){
        return account_type;
    }
    
    // Authenticate username and password
    public static User authenticateUser(String username, String password) {
        User authenticatedUser = null;
        String UserType = null;
        try {
            Connection connection = DatabaseContraller.getInstance().getConnection();

            String query = "SELECT * FROM user WHERE user_name = ? AND user_password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String role = resultSet.getString("account_type");

                if (role.equals("Manager")) {
                    ManagerForm dab = new ManagerForm();
                    UserType = "manager";
                    dab.setVisible(true);
                } else if (role.equals("Cashier")) {
                    CashierForm dab1 = new CashierForm();
                    UserType = "cashier";
                    dab1.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "USER NOT FOUND");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authenticatedUser;
    }
}
