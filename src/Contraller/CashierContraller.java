package Contraller;

import Model.Product; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CashierContraller {
    
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
}
