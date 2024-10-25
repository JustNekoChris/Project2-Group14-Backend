package com.project2.group14.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig {
   @Bean
   public WebMvcConfigurer corsConfigurer() {
       return new WebMvcConfigurer() {
           @Override
           public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**")
                       .allowedOrigins("http://localhost:3000")  // Allow requests from frontend
                       .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                       .allowCredentials(true);
           }
       };
   }
}
