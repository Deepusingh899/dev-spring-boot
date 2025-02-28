package com.learn2code.springboot.sprngMVC.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john= User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("Employee")
                .build();
        UserDetails marry= User.builder()
                .username("marry")
                .password("{noop}test123")
                .roles("Employee","Manager")
                .build();
        UserDetails susan= User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("Employee","Manager","Admin")
                .build();
        return new InMemoryUserDetailsManager(john,marry,susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest().authenticated()
        ).formLogin(form ->
                form
                        .loginPage("/showLoginForm")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
        )
                .logout(logout -> logout.permitAll()
                );
        return http.build();
    }
}
