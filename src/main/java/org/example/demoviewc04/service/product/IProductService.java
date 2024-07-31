package org.example.demoviewc04.service.product;

import org.example.demoviewc04.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);
    void update(int index, Product product);
}
