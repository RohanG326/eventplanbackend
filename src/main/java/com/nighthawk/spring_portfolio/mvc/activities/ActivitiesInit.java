package com.nighthawk.spring_portfolio.mvc.activities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class ActivitiesInit {

    @Autowired
    private ActivitiesJpaRepository repository;

    @Bean
    CommandLineRunner activities() {
        return args -> {
            List<Activities> test = repository.findAllByOrderByEventAsc();
            if(test.size()==0){
                repository.save(new Activities("golfing", "Feb 7th", "dave", "fun golf day", "thousand oaks golf club"));
            }
        };
        
    }
}
