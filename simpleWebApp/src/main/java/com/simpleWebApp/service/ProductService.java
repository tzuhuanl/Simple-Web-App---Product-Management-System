package com.simpleWebApp.service;


import com.simpleWebApp.model.Product;
import com.simpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> productList = new ArrayList<>(Arrays.asList(
//            new Product(101, "Iphone", 50000),
//            new Product(102, "Canon Camera", 70000),
//            new Product(103, "SHure Mic", 10000)));

    public List<Product> getProductList(){

        return repo.findAll();
    }

    public Product getProductById(int id){
        return repo.findById(id).orElse(new Product());
    }

    public void addProduct(Product product){
        repo.save(product);
    }

    public void updateProduct(Product product){
        repo.save(product);
    }

    public void deleteProduct(int id){
        repo.deleteById(id);
    }


}
