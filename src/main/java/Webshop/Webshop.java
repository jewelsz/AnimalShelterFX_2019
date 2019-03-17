package Webshop;

import java.util.ArrayList;

public class Webshop
{
    ArrayList<Product> products = new ArrayList<>();

    public void newProduct(String name, int price)
    {
        Product p = new Product(name, price);
        this.products.add(p);
    }
}
