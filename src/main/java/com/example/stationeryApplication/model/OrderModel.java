package com.example.stationeryApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderModel {



    @Id
    private int orderId;

    private int orderno;

    private String name;

    private String deliveryAddress;

    private Long contactNumber;

    private int oquantity;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="productId")
    private Product productobj;
}
