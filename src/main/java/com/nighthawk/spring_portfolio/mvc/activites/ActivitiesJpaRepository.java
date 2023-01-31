package com.nighthawk.spring_portfolio.mvc.activites;

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

    // JPA query, findBy does JPA magic with "Name", "Containing", "Or", "Email", "IgnoreCase"
    List<Activities> findByEventContainingIgnoreCase(String event);
    /* Custom JPA query articles, there are articles that show custom SQL as well
       https://springframework.guru/spring-data-jpa-query/
       https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
     */

    // Custom JPA query
    @Query(
            value = "SELECT * FROM Activities p WHERE p.event LIKE ?1",
            nativeQuery = true)
    List<Activities> findByLikeTermNative(String term);
    /*
        https://www.baeldung.com/spring-data-jpa-query
     */
}