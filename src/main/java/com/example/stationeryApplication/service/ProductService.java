package com.example.stationeryApplication.service;


import com.example.stationeryApplication.model.Product;
import com.example.stationeryApplication.repository.Productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    Productrepository productRepositoryObject;

    public void addProduct(Product productObject) {
        productRepositoryObject.save(productObject);
    }

    public List<Product> display() {
        return productRepositoryObject.findAll();
    }

    public Optional<Product> displayById(int id) {
        return productRepositoryObject.findById(id);
    }

    public String deleteAll() {
        productRepositoryObject.deleteAll();
        return "All records is Deleted";
    }

    public String deleteById(int id) {
        productRepositoryObject.deleteById(id);
        return "Record Deleted";
    }

    public String update(int id, Product productobject) {
        if (productRepositoryObject.findById(id) != null) {
            productRepositoryObject.deleteById(id);
            productRepositoryObject.save(productobject);
            return "updated";
        }
        return "Id not exist in Database";
    }
}


