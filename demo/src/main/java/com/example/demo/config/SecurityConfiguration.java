package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Permitir acceso a la ruta de autenticación
        http.csrf().disable();
    }
}
