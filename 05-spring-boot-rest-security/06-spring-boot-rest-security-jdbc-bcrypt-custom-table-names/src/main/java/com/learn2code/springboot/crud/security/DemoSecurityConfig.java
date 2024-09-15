package com.learn2code.springboot.crud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define a query to retrive a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pwd,active from members where user_id=?");

        // Define a Query to retrieve a authorities/roles by a username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?"
        );
        return jdbcUserDetailsManager;
    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
////        UserDetails john= User.builder()
////                .username("John")
////                .password("{noop}test123")
////                .roles("EMPLOYEE")
////                .build();
////        UserDetails mary= User.builder()
////                .username("Mary")
////                .password("{noop}test123")
////                .roles("EMPLOYEE","MANAGER")
////                .build();
////        UserDetails susan= User.builder()
////                .username("Susan")
////                .password("{noop}test123")
////                .roles("EMPLOYEE","MANAGER","ADMIN")
////                .build();
//
//        return new InMemoryUserDetailsManager(john,mary,susan);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());

        //Disable Cross site Request Forgery
        // In general not required for stateless REST APIs that use POST,PUT,DELETE,GET and/or PATCH
        http.csrf(csrf->csrf.disable());

        return http.build();
    }
}
