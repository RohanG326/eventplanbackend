package com.nighthawk.spring_portfolio.mvc.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Built using article: https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html
// or similar: https://asbnotebook.com/2020/04/11/spring-boot-thymeleaf-form-validation-example/
@Controller
@RequestMapping("/mvc/activities")
public class ActivitiesViewController {
    // Autowired enables Control to connect HTML and POJO Object to database easily for CRUD
    @Autowired
    private ActivitiesDetailsService repository;

    @GetMapping("/read")
    public String activities(Model model) {
        List<Activities> list = repository.listAll();
        model.addAttribute("list", list);
        return "activities/read";
    }

    /*  The HTML template Forms and ActivitiesForm attributes are bound
        @return - template for activities form
        @param - Activities Class
    */
    @GetMapping("/create")
    public String activitiesAdd(Activities activities) {
        return "activities/create";
    }

    /* Gathers the attributes filled out in the form, tests for and retrieves validation error
    @param - Activities object with @Valid
    @param - BindingResult object
     */
    @PostMapping("/create")
    public String activitiesSave(@Valid Activities activities, BindingResult bindingResult) {
        // Validation of Decorated ActivitiesForm attributes
        if (bindingResult.hasErrors()) {
            return "activities/create";
        }
        repository.save(activities);
        // Redirect to next step
        return "redirect:/mvc/activities/read";
    }

    @GetMapping("/update/{id}")
    public String activitiesUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("activities", repository.get(id));
        return "activities/update";
    }

    @PostMapping("/update")
    public String activitiesUpdateSave(@Valid Activities activities, BindingResult bindingResult) {
        // Validation of Decorated ActivitiesForm attributes
        if (bindingResult.hasErrors()) {
            return "activities/update";
        }
        repository.save(activities);

        // Redirect to next step
        return "redirect:/mvc/activities/read";
    }

    @GetMapping("/delete/{id}")
    public String activitiesDelete(@PathVariable("id") long id) {
        repository.delete(id);
        return "redirect:/mvc/activities/read";
    }

    @GetMapping("/search")
    public String activities() {
        return "activities/search";
    }

}