package com.example.stationeryApplication.controller;


import com.example.stationeryApplication.model.OrderModel;
import com.example.stationeryApplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class orderController {

    @Autowired
    OrderService orderServiceObject;


    @PostMapping("/addOrder")
    public String addOrder(@RequestBody OrderModel orderModelObject) {
        orderServiceObject.addOrder(orderModelObject);
        return "Order Placed Successfully";
    }

    @GetMapping("/displayAllOrders")
    public List<OrderModel> displayOrder(){
        return orderServiceObject.display();

    }


}
