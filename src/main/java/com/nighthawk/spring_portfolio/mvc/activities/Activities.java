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


@Entity
@TypeDef(name = "json", typeClass = JsonType.class)
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // email, password, roles are key attributes to login and authentication
    @NotEmpty
    @Size(min = 5)
    @Column(unique = true)
    public String event;

    @NotEmpty
    @Size(min = 5)
    @Column(unique = true)
    public String date;

    @NotEmpty
    @Size(min = 5)
    @Column(unique = true)
    public String contact;

    @NotEmpty
    @Size(min = 5)
    @Column(unique = true)
    public String description;

    @NotEmpty
    @Size(min = 5)
    @Column(unique = true)
    public String location;

    public Activities (String event, String date, String contact, String description, String location) {
        this.event = event;
        this.date = date;
        this.contact = contact;
        this.description = description;
        this.location = location;
    }
    public String getEvent() {
        return event;
    }
    public String setEvent(String newEvent) {
        this.event = newEvent;
    }
    public String getDate() {
        return date;
    }
    public String setDate(String newDate) {
        this.date = newDate;
    }
    public String getContact() {
        return contact;
    }
    public String setContact(String newContact) {
        this.contact = newContact;
    }
    public String getDescription() {
        return description;
    }
    public String setDescription(String newDescription) {
        this.description = newDescription;
    }
    public String getLocation() {
        return location;
    }
    public String setLocation(String newLocation) {
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
    public static Activities[] init() {

        // basics of class construction
        Activities p1 = new Activities();
        p1.setEvent("Golfing");
        p1.setDate("Feb 7th");
        p1.setContact("Dave");
        p1.setDescription("fun golf day");
        p1.setLocation("thousand oaks golf club");
        // adding Note to notes collection

        Activities p2 = new Activities();
        p2.setEvent("Alexander Graham Bell");
        p2.setEmail("lexb@gmail.com");
        p2.setPassword("123LexB!");
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("01-01-1845");
            p2.setDob(d);
        } catch (Exception e) {
        }

        Activities p3 = new Activities();
        p3.setEvent("Nikola Tesla");
        p3.setEmail("niko@gmail.com");
        p3.setPassword("123Niko!");
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("01-01-1850");
            p3.setDob(d);
        } catch (Exception e) {
        }

        Activities p4 = new Activities();
        p4.setEvent("Madam Currie");
        p4.setEmail("madam@gmail.com");
        p4.setPassword("123Madam!");
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("01-01-1860");
            p4.setDob(d);
        } catch (Exception e) {
        }

        Activities p5 = new Activities();
        p5.setEvent("John Mortensen");
        p5.setEmail("jm1021@gmail.com");
        p5.setPassword("123Qwerty!");
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("10-21-1959");
            p5.setDob(d);
        } catch (Exception e) {
        }

        // Array definition and data initialization
        Activities activities[] = {p1, p2, p3, p4, p5};
        return(activities);
    }

    public static void main(String[] args) {
        // obtain Activities from initializer
        Activities activities[] = init();

        // iterate using "enhanced for loop"
        for( Activities person : activities) {
            System.out.println(person);  // print object
        }
    }

}
}
