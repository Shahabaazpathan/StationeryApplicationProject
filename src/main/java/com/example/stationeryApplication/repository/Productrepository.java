package com.example.stationeryApplication.repository;

import com.example.stationeryApplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productrepository extends JpaRepository<Product, Integer> {
}
