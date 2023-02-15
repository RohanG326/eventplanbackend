package com.nighthawk.spring_portfolio.mvc.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
This class has an instance of Java Persistence API (JPA)
-- @Autowired annotation. Allows Spring to resolve and inject collaborating beans into our bean.
-- Spring Data JPA will generate a proxy instance
-- Below are some CRUD methods that we can use with our database
*/
@Service
@Transactional
public class ActivitiesDetailsService {  // "implements" ties ModelRepo to Spring Security
    // Encapsulate many object into a single Bean (Activities, Roles, and Scrum)
    @Autowired  // Inject ActivitiesJpaRepository
    public ActivitiesJpaRepository activitiesJpaRepository;

    /* UserDetailsService Overrides and maps Activities & Roles POJO into Spring Security */

    /* Activities Section */

    public  List<Activities>listAll() {
        return activitiesJpaRepository.findAllByOrderByEventAsc();
    }

    // custom query to find match to name or email
    public  List<Activities>list(String event) {
        return activitiesJpaRepository.findByEventIgnoreCase(event);
    }

    // custom query to find anything containing term in name or email ignoring case
    public  List<Activities>listLike(String term) {
        return activitiesJpaRepository.findByEventIgnoreCase(term);
    }

    public void save(Activities activities) {
        activitiesJpaRepository.save(activities);
    }

    public Activities get(long id) {
        return (activitiesJpaRepository.findById(id).isPresent())
                ? activitiesJpaRepository.findById(id).get()
                : null;
    }

    public Activities getByEvent(String event) {
        return (activitiesJpaRepository.findByEvent(event));
    }

    public void delete(long id) {
        activitiesJpaRepository.deleteById(id);
    }

    
}




