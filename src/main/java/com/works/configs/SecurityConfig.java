package com.works.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // spring security sınıfı pom dosysına eklendiğinde eğer bu yapı olmazsa erişim olmaz

    //Sql -> Rule
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }


    //Rule -> Mapping
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable().formLogin().disable();
    }


}
