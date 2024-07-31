package org.example.demoviewc04.service.product;

import org.example.demoviewc04.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService {
    private static List<Product> products;
    static {
        products = new ArrayList<>();
        products.add(new Product(0, "But thien long", 5000));
        products.add(new Product(1, "Bang", 25000));
        products.add(new Product(2, "Phan", 10000));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(int index, Product product) {
        products.set(index, product);
    }
}
