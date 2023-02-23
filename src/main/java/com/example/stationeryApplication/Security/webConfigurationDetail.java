package com.example.stationeryApplication.Security;


import com.example.stationeryApplication.service.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class webConfigurationDetail extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsService userDetailsServiceObject;


    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsServiceObject);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.cors().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/addProduct").hasAuthority("ADMIN")
                .antMatchers("/addOrder").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/displayAll").hasAnyAuthority("ADMIN", "USER", "VIEWERS")
                .antMatchers("/displayById/{id}").hasAnyAuthority("ADMIN", "USER", "VIEWERS")
                .antMatchers("/deleteAll").hasAuthority("ADMIN")
                .antMatchers("/deleteById/{id}").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/update/{id}").hasAuthority("ADMIN")
                .anyRequest().authenticated().and().httpBasic();
    }
}
