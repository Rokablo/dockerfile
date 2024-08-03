package com.example.demo.config;

public abstract class WebSecurityConfigurerAdapter {
    protected abstract void configure(HttpSecurity http) throws Exception;
}
