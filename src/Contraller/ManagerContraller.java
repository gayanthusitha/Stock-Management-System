package Contraller;

import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ManagerContraller {
    
    // Add a new product to the database
    public boolean addProduct(String productName, String productPrice, String productQty, String productCategory){
        try{
            Connection connection = DatabaseContraller.getInstance().getConnection();
            
            // Query to insert a new product
            String query = "INSERT INTO product (product_name, product_price, product_qty, product_category) VALUES ( ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            // Set the parameters
            preparedStatement.setString(1, productName);
            preparedStatement.setString(2, productPrice);
            preparedStatement.setString(3, productQty);
            preparedStatement.setString(4, productCategory);
            
            // Execute the SQL query
            int rowsAffected = preparedStatement.executeUpdate();
            
            preparedStatement.close();
            return rowsAffected > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    // View product Details
    public List<Product> viewProductDetails() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = DatabaseContraller.getInstance().getConnection();

            // SQL query to select all products
            String query = "SELECT * FROM product";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                double productPrice = resultSet.getDouble("product_price");
                int productQty = resultSet.getInt("product_qty");
                String productCategory = resultSet.getString("product_category");

                // Create a Product object and add it to the list
                Product product = new Product(productId, productName, productPrice, productQty, productCategory){
                    
                };
                products.add(product);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    
    // Search Product Data
    public List<Product> searchProduct(String key) {
        List<Product> searchResults = new ArrayList<>();
        
        try {
            Connection connection = DatabaseContraller.getInstance().getConnection();

            // SQL query to search
            String query = "SELECT product_id, product_name, product_price, product_qty, product_category FROM product "
                    + "WHERE product_name LIKE ? OR product_price LIKE ? OR product_category LIKE ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");
            preparedStatement.setString(3, "%" + key + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                double productPrice = resultSet.getDouble("product_price");
                String productCategory = resultSet.getString("product_category");
                int productQty = resultSet.getInt("product_qty");

                // Create a Product object and add it to the search results
                Product product = new Product(productId, productName, productPrice, productQty, productCategory) {
                };
                searchResults.add(product);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchResults;
    }
    
    // Update Product Details
    public boolean updateCurrentProduct(int productId, String productName, double productPrice, int productQty, String productCategory) {
        try {
            Connection connection = DatabaseContraller.getInstance().getConnection();

            // SQL statement to update the product information
            String updateQuery = "UPDATE product SET product_name = ?, product_price = ?, product_qty = ?, product_category = ? WHERE product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            // Set the parameters
            preparedStatement.setString(1, productName);
            preparedStatement.setDouble(2, productPrice);
            preparedStatement.setInt(3, productQty);
            preparedStatement.setString(4, productCategory);
            preparedStatement.setInt(5, productId);

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();

            // Check if the product was updated successfully and return a boolean value
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Remove Product from Database  
    public boolean removeProductFromDatabase(int productId){
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
            String removeProductSQL = "DELETE FROM product WHERE product_id = ?";
            removeProductStatement = connection.prepareStatement(removeProductSQL);
            removeProductStatement.setInt(1, productId);
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
