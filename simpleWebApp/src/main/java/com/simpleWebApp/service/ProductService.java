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
