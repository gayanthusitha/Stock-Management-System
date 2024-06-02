package Contraller;

import Model.User; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageUserContraller {
    
    // Add a new user to the database
    public boolean addUser(String username, String password, String account_Type){
        try{
            Connection connection = DatabaseContraller.getInstance().getConnection();
            
            // Query to insert a new product
            String query = "INSERT INTO user (user_name, user_password, account_type) VALUES ( ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            // Set the parameters
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, account_Type);
            
            // Execute the SQL query
            int rowsAffected = preparedStatement.executeUpdate();
            
            preparedStatement.close();
            return rowsAffected > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    // View User Details
    public List<User> viewUserDetails() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = DatabaseContraller.getInstance().getConnection();

            // SQL query to select all users
            String query = "SELECT * FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                String userPassword = resultSet.getString("user_password");
                String account_Type = resultSet.getString("account_type");

                // Create a User object and add it to the list
                User user = new User(userId, userName, userPassword, account_Type){
                    
                };
                users.add(user);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    
    // Search User Data
    public List<User> searchUser(String key) {
        List<User> searchResults = new ArrayList<>();
        
        try {
            Connection connection = DatabaseContraller.getInstance().getConnection();

            // SQL query to search
            String query = "SELECT user_id, user_name, user_password, account_type FROM user "
                    + "WHERE user_id LIKE ? OR user_name LIKE ? OR user_password LIKE ? OR account_type LIKE ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");
            preparedStatement.setString(3, "%" + key + "%");
            preparedStatement.setString(4, "%" + key + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                String userPassword = resultSet.getString("user_password");
                String account_Type = resultSet.getString("account_type");

                // Create a user object and add it to the search results
                User user = new User(userId, userName, userPassword, account_Type) {
                };
                searchResults.add(user);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchResults;
    }
    
    // Update User Details
    public boolean updateCurrentUser(int userId, String userName, String userPassword, String account_Type) {
        try {
            Connection connection = DatabaseContraller.getInstance().getConnection();

            // SQL statement to update the user information
            String updateQuery = "UPDATE user SET user_name = ?, user_password = ?, account_type = ? WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            // Set the parameters
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPassword);
            preparedStatement.setString(3, account_Type);
            preparedStatement.setInt(4, userId);

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();

            // Check if the user was updated successfully and return a boolean value
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Remove User from Database  
    public boolean removeUserFromDatabase(int userId){
        //Variables for connection
        Connection connection = null;
        PreparedStatement removeProductStatement = null;
        PreparedStatement removeSalesStatement = null;
        
        try {
            //Get Database Connction
            connection = DatabaseContraller.getInstance().getConnection();
            // Disable auto-commit to ensure transaction consistency
            connection.setAutoCommit(false);
            // Prepare a SQL statement to delete the product
            String removeProductSQL = "DELETE FROM user WHERE user_id = ?";
            removeProductStatement = connection.prepareStatement(removeProductSQL);
            removeProductStatement.setInt(1, userId);
            // Delete the product
            removeProductStatement.executeUpdate();
            // Commit the transaction
            connection.commit();
            return true; // Deletion was successful
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
