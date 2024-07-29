package org.example.arapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class ArAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArAppApplication.class, args);
    }

}
