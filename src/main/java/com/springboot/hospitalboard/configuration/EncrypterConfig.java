package com.springboot.hospitalboard.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EncrypterConfig {

    public BCryptPasswordEncoder encoder(){

        return new BCryptPasswordEncoder();
    }
}
