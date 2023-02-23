package com.example.stationeryApplication.service;

import com.example.stationeryApplication.Security.CustomUserDetails;
import com.example.stationeryApplication.model.User;
import com.example.stationeryApplication.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private Userrepository userrepositoryObject;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userrepositoryObject.findByName(userName);
        return new CustomUserDetails(user);
    }
}

