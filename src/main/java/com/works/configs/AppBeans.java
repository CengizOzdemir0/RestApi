package com.works.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppBeans {
    // şifre crtpt oluşturma
    @Bean
    public PasswordEncoder encoder(){
        System.out.println("Encoder call");
        return new BCryptPasswordEncoder();
    }
}
