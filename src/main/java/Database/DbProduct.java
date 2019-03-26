package Database;

import Webshop.Product;

import java.sql.*;
import java.util.ArrayList;

public class DbProduct
{
    DbConnection con = new DbConnection();

    public void insertProduct(Product product) {

        String sql = "INSERT INTO products(name, price) VALUES(?,?)";

        System.out.println("insertProduct");
        try (Connection conn = this.con.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Product> getProducts()
    {
        String sql = "SELECT productID, name, price FROM products";
        ArrayList<Product> products = new ArrayList<>();

        try (Connection conn = this.con.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("name") +  "\t" +
                        rs.getInt("price"));
                Product product = new Product(rs.getString("name"), rs.getInt("price"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
}
