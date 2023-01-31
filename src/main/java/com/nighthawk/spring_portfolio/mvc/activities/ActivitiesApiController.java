package com.nighthawk.spring_portfolio.mvc.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/activities")
public class ActivitiesApiController {
    /*
    #### RESTful API ####
    Resource: https://spring.io/guides/gs/rest-service/
    */

    // Autowired enables Control to connect POJO Object through JPA
    @Autowired
    private ActivitiesJpaRepository repository;

    /*
    GET List of People
     */
    @GetMapping("/")
    public ResponseEntity<List<Activities>> getActivities() {
        return new ResponseEntity<>( repository.findAllByOrderByEventAsc(), HttpStatus.OK);
    }

    /*
    GET individual Activities using ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Activities> getActivities(@PathVariable long id) {
        Optional<Activities> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Activities activity = optional.get();  // value from findByID
            return new ResponseEntity<>(activity, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);       
    }

    /*
    DELETE individual Person using ID
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Activities> deleteActivities(@PathVariable long id) {
        Optional<Activities> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Activities activity = optional.get();  // value from findByID
            repository.deleteById(id);  // value from findByID
            return new ResponseEntity<>(activity, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
    }

    /*
    POST Aa record by Requesting Parameters from URI
     */
    @PostMapping( "/post")
    public ResponseEntity<Object> postActivities(@RequestParam("event") String event,
                                             @RequestParam("date") String date,
                                             @RequestParam("contact") String contact,
                                             @RequestParam("description") String description,
                                             @RequestParam("location") String location) {
        Activities activity = new Activities(event, date, contact, description, location);
        repository.save(activity);
        return new ResponseEntity<>(event +" is created successfully", HttpStatus.CREATED);
    }

    /*
    The personSearch API looks across database for partial match to term (k,v) passed by RequestEntity body
     */
    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> personSearch(@RequestBody final Map<String,String> map) {
        // extract term from RequestEntity
        String term = (String) map.get("term");

        // JPA query to filter on term
        List<Activities> list = repository.findByEventContainingIgnoreCase(term);

        // return resulting list and status, error checking should be added
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /*
    The personStats API adds stats by Date to Person table 
    */
    
    @GetMapping("/toString/{id}")
    public String activityToString(@PathVariable long id) {
        Optional<Activities> optional = repository.findById(id);
        if (optional.isPresent()) {
            Activities activity = optional.get();
            String toStringOutput = activity.toString();
            return toStringOutput;
        }
        return "No activity exists";
    }
}

