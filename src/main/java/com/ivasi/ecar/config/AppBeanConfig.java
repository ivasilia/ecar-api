package com.ivasi.ecar.config;

import com.ivasi.ecar.routes.gmaps.GoogleMapsHandler;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppBeanConfig {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public CustomSuccessHandler authSuccessHandler(){
//        return new CustomSuccessHandler();
//    }
//
    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }

//    @Bean
//    public GoogleMapsHandler mapsHandler() {
//        return new GoogleMapsHandler();
//    }

}
