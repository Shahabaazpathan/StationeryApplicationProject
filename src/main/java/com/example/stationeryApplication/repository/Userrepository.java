package com.example.stationeryApplication.repository;

import com.example.stationeryApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
