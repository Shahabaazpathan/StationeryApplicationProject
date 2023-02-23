package com.example.stationeryApplication.controller;

import com.example.stationeryApplication.model.Product;
import com.example.stationeryApplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class productController {


    @Autowired
    ProductService productServiceObject;

    @GetMapping("/")
    public String home() {
        return "Welcome To Gmart Stationery";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {
        productServiceObject.addProduct(product);
        return " Product Added";
    }

    @GetMapping("/displayAllProduct")
    public List<Product> displayProduct() {
        return productServiceObject.display();
    }

    @GetMapping("/displayProductById/{id}")
    public Optional<Product> displayById(@PathVariable int id) {
        return productServiceObject.displayById(id);
    }

    @DeleteMapping("/deleteAllProduct")
    public String deleteAll() {
        return productServiceObject.deleteAll();
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable int id) {
        return productServiceObject.deleteById(id);
    }
    @PutMapping("/updateById/{id}")
    public String updateById(@PathVariable int id,@RequestBody Product product ) {
        return productServiceObject.update(id, product);
    }
}



