package com.example.stationeryApplication.controller;


import com.example.stationeryApplication.model.BillModel;
import com.example.stationeryApplication.repository.BillRepository;
import com.example.stationeryApplication.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class billController {

    @Autowired
    BillService billServiceObject;

    @PostMapping("/addBill")
    public String addBill(@RequestBody BillModel billModelObject){
        billServiceObject.addBill(billModelObject);
                return "Bill Added";
    }
    @GetMapping("/displayBill")
    public List<BillModel> displayBill(){
        return billServiceObject.display();
    }
}
