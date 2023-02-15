package com.nighthawk.spring_portfolio.mvc.activities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonType;

import lombok.NonNull;



@Entity
@TypeDef(name = "json", typeClass = JsonType.class)
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // email, password, roles are key attributes to login and authentication
    @NotEmpty
    @Size(min = 5, max = 30)
    public String event;

    @NonNull
    @Size(min = 5, max = 30)
    public String date;

    @NonNull
    @Size(min = 5, max = 30)
    public String contact;

    @NonNull
    @Size(min = 5, max = 30)
    public String description;

    @NonNull
    @Size(min = 5, max = 30)
    public String location;

    public Activities(String event, String date, String contact, String description, String location) {
        this.event = event;
        this.date = date;
        this.contact = contact;
        this.description = description;
        this.location = location;
    }
    public String getEvent() {
        return event;
    }
    public void setEvent(String newEvent) {
        this.event = newEvent;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String newDate) {
        this.date = newDate;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String newContact) {
        this.contact = newContact;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String newLocation) {
        this.location = newLocation;
    }
    public String toString() {
        return "Activities [id=" + id + ", event=" + event + ", date=" + date + ", contact=" + contact + ", description=" + description
                + ", location=" + location + "]";
    }
    // public static void main(String[] args) {
    //     Activities test = new Activities("golfing", "Feb 7th", "dave", "fun golf day", "thousand oaks golf club");
    //     System.out.println(test.toString());
    // }

    public Activities() {
    }

    
    public static Activities[] init() {

        // basics of class construction
        Activities p1 = new Activities();
        p1.setEvent("Golfing");
        p1.setDate("Feb 7th");
        p1.setContact("Davesss");
        p1.setDescription("fun golf day");
        p1.setLocation("thousand oaks golf club");

        Activities p2 = new Activities();
        p2.setEvent("Golfing2");
        p2.setDate("Feb 14th");
        p2.setContact("Dave2ss");
        p2.setDescription("fun golf day2");
        p2.setLocation("thousand oaks golf club2");
        // adding Note to notes collection
        // Array definition and data initialization
        Activities activities[] = {p1, p2};
        return(activities);
    }

    public static void main(String[] args) {
        // obtain Activities from initializer
        Activities activities[] = init();

        // iterate using "enhanced for loop"
        for( Activities test : activities) {
            System.out.println(test);  // print object
        }
    }
}



