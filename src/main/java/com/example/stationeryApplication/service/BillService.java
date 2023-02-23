package com.example.stationeryApplication.service;

import com.example.stationeryApplication.model.BillModel;
import com.example.stationeryApplication.model.OrderModel;
import com.example.stationeryApplication.repository.BillRepository;
import com.example.stationeryApplication.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    BillRepository billRepositoryObject;
    @Autowired
    OrderRepository orderRepositoryObj;
    public void addBill(BillModel billModelObject){
        int orderno=billModelObject.getOrderModelObj().getOrderno();
        List<OrderModel> lobj= orderRepositoryObj.findByOrderno(orderno);
        long amount=0;
        for(int i=0;i<lobj.size();i++){
            amount+=lobj.get(i).getProductobj().getPrice()*lobj.get(i).getOquantity();
        }
//        billobj.setOrderproductobj(orderno);
        billModelObject.setBillAmount(amount);

        billRepositoryObject.save(billModelObject);
    }

    public List<BillModel> display(){
        return billRepositoryObject.findAll();
    }


}
