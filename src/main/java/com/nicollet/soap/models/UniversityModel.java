package com.nicollet.soap.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "universities")
public class UniversityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(groups = Update.class)
    @Column(name = "id")
    private Long id;

    @NotNull(groups = Create.class)
    @Column(name = "name")
    private String name;

    @NotNull(groups = Create.class)
    @Column(name = "location")
    private String location;

    @Column(name = "yearFounded")
    private int yearFounded;


    public UniversityModel(String name, String location, int yearFounded) {
        this.name = name;
        this.location = location;
        this.yearFounded = yearFounded;
    }

    public UniversityModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public interface Update{}

    public interface Create{}

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", yearFounded='" + yearFounded + '\'' +
                '}';
    }
}

