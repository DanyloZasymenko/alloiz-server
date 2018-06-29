package com.alloiz.alloizserver.model;

import javax.persistence.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
public class Worker extends GeneralName<Worker> {

    private String surname;
    private String image;


    @ManyToMany(cascade = {CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST})
    @JoinTable(name = "worker_specialization",
            joinColumns = @JoinColumn(name = "worker_id"),
            inverseJoinColumns = @JoinColumn(name = "incumbency_id"))
    private List<Incumbency> incumbencies;

    public Worker() {
    }

    public List<Incumbency> getIncumbencies() {
        return incumbencies;
    }

    public Worker setIncumbencies(
            List<Incumbency> incumbencies) {
        this.incumbencies = incumbencies;
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Worker setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Worker setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Worker setImage(String image) {
        this.image = image;
        return this;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "surname='" + surname + '\'' +
                ", image='" + image + '\'' +
                ", incumbency=" + incumbencies.stream().map(Incumbency::getName).collect(toList()) +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                "} " + super.toString();
    }
}
