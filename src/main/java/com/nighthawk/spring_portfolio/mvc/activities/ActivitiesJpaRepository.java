package com.nighthawk.spring_portfolio.mvc.activities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
Extends the JpaRepository interface from Spring Data JPA.
-- Java Persistent API (JPA) - Hibernate: map, store, update and retrieve database
-- JpaRepository defines standard CRUD methods
-- Via JPA the developer can retrieve database from relational databases to Java objects and vice versa.
 */
public interface ActivitiesJpaRepository extends JpaRepository<Activities, Long> {
    Activities findByEvent(String event);
    List<Activities> findAllByOrderByEventAsc();
    List<Activities> findByEventIgnoreCase(String event);
    
    @Query(
            value = "SELECT * FROM Activities p WHERE p.event LIKE ?1",
            nativeQuery = true)
    List<Activities> findByLikeTermNative(String term);


}