package com.example.stationeryApplication.repository;

import com.example.stationeryApplication.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Integer> {

    List<OrderModel> findByOrderno(int orderno);
}
