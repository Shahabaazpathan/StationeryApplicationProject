package com.example.stationeryApplication.service;


import com.example.stationeryApplication.model.OrderModel;
import com.example.stationeryApplication.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepositoryObject;

    public void addOrder(OrderModel orderModelObject) {
        orderRepositoryObject.save(orderModelObject);
    }

    public List<OrderModel> display() {
        return orderRepositoryObject.findAll();


    }
}
