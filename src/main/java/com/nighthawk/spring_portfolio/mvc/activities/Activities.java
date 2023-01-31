package com.nighthawk.spring_portfolio.mvc.activities;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    private Map<String, Map<String, Object>> stats = new HashMap<>();

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
    public String getDate() {
        return date;
    }
    public String getContact() {
        return contact;
    }
    public String getDescription() {
        return description;
    }
    public String getLocation() {
        return location;
    }
    public String toString() {
        return "Activities [id=" + id + ", event=" + event + ", date=" + date + ", contact=" + contact + ", description=" + description
                + ", location=" + location + "]";
    }
    public static void main(String[] args) {
        Activities test = new Activities("golfing", "Feb 7th", "dave", "fun golf day", "thousand oaks golf club");
        System.out.println(test.toString());
    }
}
