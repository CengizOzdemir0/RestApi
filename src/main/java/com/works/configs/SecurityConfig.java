package com.works.configs;

import com.works.services.AdminDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // spring security sınıfı pom dosysına eklendiğinde eğer bu yapı olmazsa erişim olmaz

    final AdminDetailService adminDetailService;
    final PasswordEncoder encoder;

    //Sql -> Rule
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // spring tarafından beklenen formata çevrildi.
        auth.userDetailsService(adminDetailService).passwordEncoder(encoder);
    }

    //Rule -> Mapping
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http basic ile autotacion istemek demek
        // andMatcher kurallar demek hangi mapping hangi kuralı olacak demek
        //** herşey demek
        http.httpBasic()
                .and().authorizeHttpRequests()
                .antMatchers("/product/**").hasRole("product")
                .antMatchers("/note/**").hasRole("note")
                .and().
                csrf().disable().formLogin().disable();

        // h2 console enable
        http.headers().frameOptions().disable();
    }


}
