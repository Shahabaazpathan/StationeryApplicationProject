package com.example.stationeryApplication.repository;


import com.example.stationeryApplication.model.BillModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BillRepository extends JpaRepository<BillModel, Integer> {
}
