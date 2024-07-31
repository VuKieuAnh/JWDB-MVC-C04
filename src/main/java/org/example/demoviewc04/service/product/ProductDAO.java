package org.example.demoviewc04.service.product;

import org.example.demoviewc04.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDAO implements IProductService {

    private static Connection getConnection() {
        Connection connection = null;
        String user = "root";
        String password = "123456@Abc";
        String url = "jdbc:mysql://localhost:3306/democ04jdbc";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Ket noi thanh cong");
        } catch (SQLException e) {
            System.out.println("Loi ket noi");
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public List<Product> findAll() {
        Connection connection = getConnection();
        String getAllProductsSQL = "SELECT * FROM product";
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAllProductsSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Product product = new Product(id, name, price);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        Connection connection = getConnection();
        String getProductByIdSQL = "SELECT * FROM product WHERE id =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getProductByIdSQL);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement.toString());
//            excuteQuery -> tra ve ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                double productPrice = resultSet.getDouble("price");
                Product product = new Product(productId, productName, productPrice);
                return product;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Product save(Product product) {
        try(Connection  connection = getConnection()) {

        }

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(int index, Product product) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE product SET name = ?, price = ? WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, index);
            System.out.println(preparedStatement.toString());
//            tra ve so nguyen, so ban ghi bi tac dong den
            int a = preparedStatement.executeUpdate();
            System.out.println(a);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
