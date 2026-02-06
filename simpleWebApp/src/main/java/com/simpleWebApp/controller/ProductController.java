package com.simpleWebApp.controller;

import com.simpleWebApp.model.Product;
import com.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){
        System.out.println("Someone printed the whole list of products.");
        return service.getProductList();
    }

    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        System.out.println("Someone printed the No. " + prodId + " product.");
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        System.out.println("Someone added a product.");
        service.addProduct(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        System.out.println("Someone updated updated a product.");
        service.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        System.out.println("Someone deleted a product.");
        service.deleteProduct(id);
    }

}
