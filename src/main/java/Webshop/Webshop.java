package Webshop;

import Database.DbConnection;
import Database.DbProduct;

import java.util.ArrayList;
import java.util.List;

public class Webshop
{
    ArrayList<Product> products = new ArrayList<>();
    DbProduct connection = new DbProduct();

    public void newProduct(String name, int price)
    {
        Product p = new Product(name, price);
        this.products.add(p);
        connection.insertProduct(p);
    }

    public List<Product> getProducts()
    {
        return connection.getProducts();
    }
}
